package com.utopia.security.oauth;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import com.utopia.core.security.model.CoUserAppToken;

public class UtopiaOauth2Authentication extends OAuth2Authentication {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6946018959356954149L;

	public CoUserAppToken token;
	public UtopiaOauth2Authentication(
			AuthorizationRequest authorizationRequest,
			Authentication userAuthentication,CoUserAppToken token) {
		super(authorizationRequest, userAuthentication);
	}
	
	public CoUserAppToken getToken() {
		return token;
	}
	
	public void setToken(CoUserAppToken token) {
		this.token = token;
	}

	
}
