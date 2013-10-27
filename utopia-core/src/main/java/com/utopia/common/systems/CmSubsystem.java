package com.utopia.common.systems;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;

import com.utopia.core.model.annotations.LookupConfiguration;

/**
 * CmSubsystem entity.
 * 
 * @author Mehdi
 */
@Entity
@Table(name = "CM_SUBSYSTEM",  uniqueConstraints = { @UniqueConstraint(columnNames = { "NAME" }) })
@TableGenerator(name = "SubSystemSequenceGenerator", 
		table = "CO_SEQUENCE", pkColumnName = "TABLENAME", valueColumnName = "CURRENTID", pkColumnValue = "CM_SUBSYSTEM")
	@LookupConfiguration(displayColumns={"abbreviation","name"})	
public class CmSubsystem extends AbstractCmSubsystem implements
		java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 5486310416090249009L;

	/** default constructor */
	public CmSubsystem() {
	}

	

}
