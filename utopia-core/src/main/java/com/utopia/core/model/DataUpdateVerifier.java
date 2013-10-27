package com.utopia.core.model;
/**
 * this class is use for monitoring and verifying status changes in workflow
 * @author Mehdi
 *
 */
public interface DataUpdateVerifier {

	public void verify(Object oldValue,Object newValue) throws Exception;
}
