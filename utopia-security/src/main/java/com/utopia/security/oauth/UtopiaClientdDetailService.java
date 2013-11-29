package com.utopia.security.oauth;

import javax.annotation.Resource;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

import com.utopia.core.security.dao.CoApplicationDAO;

public class UtopiaClientdDetailService implements ClientDetailsService {

	@Resource
	private CoApplicationDAO applicationDAO;
	@Override
	public ClientDetails loadClientByClientId(String clientId)
			throws ClientRegistrationException {
		Client result=new Client(applicationDAO.findApplicationWithName(clientId));
		return result;
	}

}
