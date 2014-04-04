package com.utopia.security.oauth;

import javax.annotation.Resource;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;

import com.utopia.core.model.CoUser;
import com.utopia.core.security.dao.UserDAO;

public class UtopiaAuthenticationManager implements AuthenticationManager{

	@Resource
	private UserDAO userDAO;
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		Authentication result=null;
		String []usernameAndDomain=((String)authentication.getPrincipal()).split("@");
		CoUser user= userDAO.findByUsername(usernameAndDomain[0],usernameAndDomain[1]);
		if(user!=null&&user.getPassword().equals((String)authentication.getCredentials())){
			result=new UtopiaAuthenticationInfo(user,AuthorityUtils.createAuthorityList("USER_ROLE"),authentication);
			SecurityContextHolder.getContext().setAuthentication(result);
		}
		
		return result;
	}

    public boolean isEraseCredentialsAfterAuthentication() {
        return false;
    }


}
