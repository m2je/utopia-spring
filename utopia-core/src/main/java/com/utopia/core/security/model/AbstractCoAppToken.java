package com.utopia.core.security.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.utopia.core.model.AbstractBasicPersistent;
@MappedSuperclass
public class AbstractCoAppToken extends AbstractBasicPersistent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1254824674663593043L;

	private CoUser coUser;
	private CoApplication coApplication;

	private String refreshToken;

	private byte[] authentication;
	
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_USER_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public CoUser getCoUser() {
		return this.coUser;
	}

	public void setCoUser(CoUser coUser) {
		this.coUser = coUser;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_APPLICATION_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public CoApplication getCoApplication() {
		return this.coApplication;
	}

	public void setCoApplication(CoApplication coApplication) {
		this.coApplication = coApplication;
	}

	@Column(name = "REFRESH_TOKEN")
	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "AUTHENTICATION", unique = false, nullable = true, insertable = true, updatable = true)
	public byte[] getAuthentication() {
		return this.authentication;
	}

	public void setAuthentication(byte[] authentication) {
		this.authentication = authentication;
	}
}
