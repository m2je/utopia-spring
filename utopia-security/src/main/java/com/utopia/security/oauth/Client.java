package com.utopia.security.oauth;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.ClientDetails;

import com.utopia.core.security.model.CoApplication;

public class Client implements ClientDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3039113289905837972L;
	private CoApplication application;
	private Map<String,Object>additionalInformations;
	private List<GrantedAuthority> authorities;
	private HashSet<String>resourceIds;
	public Client(CoApplication application){
		this(application, null);
	}
	public Client(CoApplication application,Map<String,Object>additionalInformations){
		this.application=application;
		this.authorities=AuthorityUtils.createAuthorityList("USER_ROLE","client_credentials");
		this.resourceIds=new HashSet<String>();
	}
	@Override
	public Integer getAccessTokenValiditySeconds() {
		return application.getTokenValidity();
	}

	@Override
	public Map<String, Object> getAdditionalInformation() {
		return additionalInformations;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		HashSet<String>result=new HashSet<String>();
		for(GrantedAuthority auth: getAuthorities()){
			result.add(auth.getAuthority());
		}
		return result;
	}

	@Override
	public String getClientId() {
		return application.getName();
	}

	@Override
	public String getClientSecret() {
		return application.getSecretKey();
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {
		return application.getTokenValidity();
	}

	@Override
	public Set<String> getRegisteredRedirectUri() {
		return null;
	}

	@Override
	public Set<String> getResourceIds() {
		
		return resourceIds;
	}

	@Override
	public Set<String> getScope() {
		return application.getScope()!=null?
				new HashSet<String>(Arrays.asList(application.getScope().split(","))):null;
	}

	@Override
	public boolean isScoped() {
		
		return application.getScope()!=null;
	}

	@Override
	public boolean isSecretRequired() {
		return application.getSecretKey()!=null;
	}

}
