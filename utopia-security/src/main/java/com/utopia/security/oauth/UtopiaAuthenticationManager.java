package com.utopia.security.oauth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class UtopiaAuthenticationManager implements AuthenticationManager{

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		authentication.getCredentials();
		return null;
	}

    public boolean isEraseCredentialsAfterAuthentication() {
        return false;
    }


}
