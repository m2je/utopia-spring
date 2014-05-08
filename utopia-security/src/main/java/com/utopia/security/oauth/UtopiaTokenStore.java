package com.utopia.security.oauth;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.DefaultOAuth2RefreshToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.common.util.SerializationUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;

import com.utopia.core.model.AppRefreshToken;
import com.utopia.core.model.Application;
import com.utopia.core.model.User;
import com.utopia.core.model.UserAppToken;
import com.utopia.core.security.dao.AppRefreshTokenDAO;
import com.utopia.core.security.dao.ApplicationDAO;
import com.utopia.core.security.dao.UserAppTokenDAO;
import com.utopia.core.util.TimeService;

public class UtopiaTokenStore implements TokenStore {

	@Value(value = "${accessToken.validity:21600}")
    private long accessTokenValidity;
	
	@Resource
	private UserAppTokenDAO userAppTokenDAO;
	
	@Resource
	private ApplicationDAO applicationDAO;
	
	@Resource
	private AppRefreshTokenDAO appRefreshTokenDAO;
	
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
		UserAppToken result= userAppTokenDAO.findByToken(token);
		return result==null?null:deserializeAuthentication(result.getAuthentication());
	}
//********************************************************************************************************************************************
	@Override
	public void storeAccessToken(OAuth2AccessToken token,
			OAuth2Authentication authentication) {
		
		UserAppToken ptoken=new UserAppToken();
		ptoken.setUser(getUser(authentication));
		ptoken.setApplication(getApplication(authentication));
		ptoken.setToken(token.getValue());
		ptoken.setRefreshToken(token.getRefreshToken().getValue());
		ptoken.setValidTo(token.getExpiration());
		ptoken.setAuthentication(serializeAuthentication(authentication));
		Date currentDate=timeService.getDBTime();
		ptoken.setCreated(currentDate);
		ptoken.setUpdated(currentDate);
		Calendar validTo= Calendar.getInstance();
		validTo.setTime(currentDate);
		userAppTokenDAO.save(ptoken);
	}	
//********************************************************************************************************************************************
	@Override
	public OAuth2AccessToken readAccessToken(String tokenValue) {
		return convertApplicationToken2OAuth2AccessToken(userAppTokenDAO.findByToken(tokenValue));
	}
//********************************************************************************************************************************************
	@Override
	public void removeAccessToken(OAuth2AccessToken token) {
		userAppTokenDAO.deleteToken(token.getValue());
	}
//********************************************************************************************************************************************
	@Override
	public void storeRefreshToken(OAuth2RefreshToken refreshToken,
			OAuth2Authentication authentication) {
		AppRefreshToken refToken=new AppRefreshToken();
		refToken.setApplication( getApplication(authentication));
		refToken.setUser(getUser(authentication));
		refToken.setRefreshToken(refreshToken.getValue());
		refToken.setAuthentication(serializeAuthentication(authentication));
		appRefreshTokenDAO.save(refToken);
	}
//********************************************************************************************************************************************
	@Override
	public OAuth2RefreshToken readRefreshToken(String tokenValue) {
		AppRefreshToken token=appRefreshTokenDAO.findByToken(tokenValue);
		return token==null?null:new DefaultOAuth2RefreshToken(token.getRefreshToken() );
	}
//********************************************************************************************************************************************
	@Override
	public OAuth2Authentication readAuthenticationForRefreshToken(
			OAuth2RefreshToken token) {
		AppRefreshToken refToken=appRefreshTokenDAO.findByToken(token.getValue());
		return deserializeAuthentication(refToken.getAuthentication());
	}
//********************************************************************************************************************************************
	@Override
	public void removeRefreshToken(OAuth2RefreshToken token) {
		appRefreshTokenDAO.deleteByToken(token.getValue());
		
	}
//********************************************************************************************************************************************
	@Override
	public void removeAccessTokenUsingRefreshToken(
			OAuth2RefreshToken refreshToken) {
		userAppTokenDAO.deleteTokenByRefreshToken(refreshToken.getValue());
	}
//********************************************************************************************************************************************
	@Override
	public OAuth2AccessToken getAccessToken(OAuth2Authentication authentication) {
		UserAppToken token= userAppTokenDAO.findByUserApplication(getUserId(authentication), 
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
				List<UserAppToken>tokens= userAppTokenDAO.findTokensForUser(usernameAndDomain[0], usernameAndDomain[1]);
				for(UserAppToken token:tokens){
					result.add(convertApplicationToken2OAuth2AccessToken(token));	
				}
			}
		}
		return result;
	}
//********************************************************************************************************************************************
	@Override
	public Collection<OAuth2AccessToken> findTokensByClientId(String clientId) {
		ArrayList<OAuth2AccessToken>result=new ArrayList<OAuth2AccessToken>();
		List<UserAppToken>tokens= userAppTokenDAO.findApplicationTokens(clientId);
		for(UserAppToken token:tokens){
			result.add(convertApplicationToken2OAuth2AccessToken(token));	
		}
		return result;
	}
//********************************************************************************************************************************************
	protected Long getUserId(OAuth2Authentication authentication){
		return getUser(authentication).getId();
	}
//********************************************************************************************************************************************
	protected User getUser(OAuth2Authentication authentication){
		return ((UtopiaAuthenticationInfo)authentication.getUserAuthentication()).getUser();
	}
//********************************************************************************************************************************************
	protected String getApplicationName(OAuth2Authentication authentication){
		return authentication.getAuthorizationRequest().getClientId();
	}
//********************************************************************************************************************************************
	protected Application getApplication(OAuth2Authentication authentication){
		return applicationDAO.findApplicationWithName(getApplicationName(authentication));
	}
//********************************************************************************************************************************************
	protected OAuth2AccessToken convertApplicationToken2OAuth2AccessToken(UserAppToken appToken){
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
