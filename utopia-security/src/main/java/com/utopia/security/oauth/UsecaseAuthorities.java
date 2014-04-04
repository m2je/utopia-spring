package com.utopia.security.oauth;

import org.springframework.security.core.GrantedAuthority;

import com.utopia.core.security.model.CoUsecase;
/**
 * the authority base on system use cases
 * @author Mehdi
 *
 */
public class UsecaseAuthorities implements GrantedAuthority {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2691910879634176275L;
	private String useCase;
	private Long useCaseId;
	
	public UsecaseAuthorities(CoUsecase useCase){
		this.useCase=useCase.getFullName();
		this.useCaseId=useCase.getId();
	}
	@Override
	public String getAuthority() {
		return useCase;
	}
	public Long getUseCaseId() {
		return useCaseId;
	}
	

}
