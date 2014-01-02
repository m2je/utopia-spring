package com.utopia.core.security.model;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;

/**
 * CoAppRefreshToken
 */
@Entity
@Table(name = "CO_APP_REFRESH_TOKEN", uniqueConstraints = { @UniqueConstraint(columnNames = { "REFRESH_TOKEN" }) })
@TableGenerator(name = "CoAppRefreshTokenGenerator", 
table = "CO_SEQUENCE", pkColumnName = "TABLENAME", valueColumnName = "CURRENTID", pkColumnValue = "CO_APP_REFRESH_TOKEN")
public class CoAppRefreshToken extends AbstractCoAppRefreshToken implements
		java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 1589882079264751246L;

	/** default constructor */
	public CoAppRefreshToken() {
	}

	

}
