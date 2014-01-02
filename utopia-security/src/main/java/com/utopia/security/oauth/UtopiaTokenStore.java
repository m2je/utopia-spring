package com.utopia.security.oauth;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.DefaultOAuth2RefreshToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.common.util.SerializationUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;

import com.utopia.core.security.dao.CoAppRefreshTokenDAO;
import com.utopia.core.security.dao.CoApplicationDAO;
import com.utopia.core.security.dao.CoUserAppTokenDAO;
import com.utopia.core.security.model.CoAppRefreshToken;
import com.utopia.core.security.model.CoApplication;
import com.utopia.core.security.model.CoUser;
import com.utopia.core.security.model.CoUserAppToken;
import com.utopia.core.util.TimeService;

public class UtopiaTokenStore implements TokenStore {

	@Resource
	private CoUserAppTokenDAO coUserAppTokenDAO;
	
	@Resource
	private CoApplicationDAO applicationDAO;
	
	@Resource
	private CoAppRefreshTokenDAO coAppRefreshTokenDAO;
	
	@Resource
	private TimeService timeService;
	
//********************************************************************************************************************************************
	@Override
	public OAuth2Authentication readAuthentication(OAuth2AccessToken token) {
		return readAuthentication(token.getValue());
	}
//********************************************************************************************************************************************
	@Override
	public OAuth2Authentication readAuthentication(String token) {
		CoUserAppToken result= coUserAppTokenDAO.findByToken(token);
		return result==null?null:deserializeAuthentication(result.getAuthentication());
	}
//********************************************************************************************************************************************
	@Override
	public void storeAccessToken(OAuth2AccessToken token,
			OAuth2Authentication authentication) {
		
		CoUserAppToken ptoken=new CoUserAppToken();
		CoUser user=new CoUser();
		user.setCoUserId(getUserId(authentication));
		ptoken.setCoUser(user);
		ptoken.setCoApplication(getApplication(authentication));
		ptoken.setToken(token.getValue());
		ptoken.setRefreshToken(token.getRefreshToken().getValue());
		ptoken.setValidTo(token.getExpiration());
		ptoken.setAuthentication(serializeAuthentication(authentication));
		Date currentDate=timeService.getDBTime();
		ptoken.setCreated(currentDate);
		ptoken.setUpdated(currentDate);
		Calendar validTo= Calendar.getInstance();
		validTo.setTime(currentDate);
		
//		ptoken.setValidTo(validTo);
		coUserAppTokenDAO.save(ptoken);
	}	
//********************************************************************************************************************************************
	@Override
	public OAuth2AccessToken readAccessToken(String tokenValue) {
		return convertCoApplicationToken2OAuth2AccessToken(coUserAppTokenDAO.findByToken(tokenValue));
	}
//********************************************************************************************************************************************
	@Override
	public void removeAccessToken(OAuth2AccessToken token) {
		coUserAppTokenDAO.deleteToken(token.getValue());
	}
//********************************************************************************************************************************************
	@Override
	public void storeRefreshToken(OAuth2RefreshToken refreshToken,
			OAuth2Authentication authentication) {
		CoAppRefreshToken refToken=new CoAppRefreshToken();
		refToken.setCoApplication( getApplication(authentication));
		CoUser user=new CoUser();
		user.setCoUserId(getUserId(authentication));
		refToken.setCoUser(user);
		refToken.setRefreshToken(refreshToken.getValue());
		coAppRefreshTokenDAO.save(refToken);
	}
//********************************************************************************************************************************************
	@Override
	public OAuth2RefreshToken readRefreshToken(String tokenValue) {
		CoAppRefreshToken token=coAppRefreshTokenDAO.findByToken(tokenValue);
		return token==null?null:new DefaultOAuth2RefreshToken(token.getRefreshToken() );
	}
//********************************************************************************************************************************************
	@Override
	public OAuth2Authentication readAuthenticationForRefreshToken(
			OAuth2RefreshToken token) {
		CoAppRefreshToken refToken=coAppRefreshTokenDAO.findByToken(token.getValue());
		return deserializeAuthentication(refToken.getAuthentication());
	}
//********************************************************************************************************************************************
	@Override
	public void removeRefreshToken(OAuth2RefreshToken token) {
		coAppRefreshTokenDAO.deleteByToken(token.getValue());
		
	}
//********************************************************************************************************************************************
	@Override
	public void removeAccessTokenUsingRefreshToken(
			OAuth2RefreshToken refreshToken) {
		coUserAppTokenDAO.deleteTokenByRefreshToken(refreshToken.getValue());
	}
//********************************************************************************************************************************************
	@Override
	public OAuth2AccessToken getAccessToken(OAuth2Authentication authentication) {
		CoUserAppToken token= coUserAppTokenDAO.findByUserApplication(getUserId(authentication), 
				getApplicationName(authentication));
		return token==null?null:new DefaultOAuth2AccessToken(token.getToken());
	}
//********************************************************************************************************************************************
	@Override
	public Collection<OAuth2AccessToken> findTokensByUserName(String userName) {
		ArrayList<OAuth2AccessToken>result=new ArrayList<OAuth2AccessToken>();
		if(userName.indexOf("@")>0){
			String []usernameAndDomain=userName.split("@");
			if(usernameAndDomain.length==2){
				List<CoUserAppToken>tokens= coUserAppTokenDAO.findTokensForUser(usernameAndDomain[0], usernameAndDomain[1]);
				for(CoUserAppToken token:tokens){
					result.add(convertCoApplicationToken2OAuth2AccessToken(token));	
				}
			}
		}
		return result;
	}
//********************************************************************************************************************************************
	@Override
	public Collection<OAuth2AccessToken> findTokensByClientId(String clientId) {
		ArrayList<OAuth2AccessToken>result=new ArrayList<OAuth2AccessToken>();
		List<CoUserAppToken>tokens= coUserAppTokenDAO.findApplicationTokens(clientId);
		for(CoUserAppToken token:tokens){
			result.add(convertCoApplicationToken2OAuth2AccessToken(token));	
		}
		return result;
	}
//********************************************************************************************************************************************
	protected Long getUserId(OAuth2Authentication authentication){
		return ((UtopiaAuthenticationInfo)authentication.getUserAuthentication()).getUser().getCoUserId();
	}
//********************************************************************************************************************************************
	protected String getApplicationName(OAuth2Authentication authentication){
		return authentication.getAuthorizationRequest().getClientId();
	}
//********************************************************************************************************************************************
	protected CoApplication getApplication(OAuth2Authentication authentication){
		return applicationDAO.findApplicationWithName(getApplicationName(authentication));
	}
//********************************************************************************************************************************************
	protected OAuth2AccessToken convertCoApplicationToken2OAuth2AccessToken(CoUserAppToken appToken){
		if(appToken==null)return null;
		DefaultOAuth2AccessToken result=new DefaultOAuth2AccessToken(appToken.getToken());
		result.setExpiration(appToken.getValidTo());
		DefaultOAuth2RefreshToken refreshToken=new DefaultOAuth2RefreshToken(appToken.getRefreshToken());
		result.setRefreshToken(refreshToken);
		return result;
	}
//********************************************************************************************************************************************
	protected byte[] serializeAuthentication(OAuth2Authentication authentication) {
		return SerializationUtils.serialize(authentication);
	}
//********************************************************************************************************************************************
	protected OAuth2Authentication deserializeAuthentication(byte[] authentication) {
		return SerializationUtils.deserialize(authentication);
	}
}
