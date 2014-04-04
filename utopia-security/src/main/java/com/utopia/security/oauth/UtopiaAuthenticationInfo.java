package com.utopia.security.oauth;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.utopia.core.security.model.CoUser;

public class UtopiaAuthenticationInfo implements Authentication{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8986679846716261685L;

	private CoUser user;
	private Collection<? extends GrantedAuthority> authorities;
	private Authentication details;
	private boolean authenticated=true;
	public UtopiaAuthenticationInfo(CoUser user,Collection<? extends GrantedAuthority> authorities,Authentication details){
		this.user=user;
		this.authorities=authorities;
		this.details=details;
	}
	@Override
	public String getName() {
		return user.getName();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public Object getCredentials() {
		return user.getPassword();
	}

	@Override
	public Object getDetails() {
		return details;
	}

	@Override
	public Object getPrincipal() {
		return details.getPrincipal();
	}

	@Override
	public boolean isAuthenticated() {
		return authenticated;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated)
			throws IllegalArgumentException {
		this.authenticated=isAuthenticated;
		
	}

	public CoUser getUser(){
		return user;
	}
}
