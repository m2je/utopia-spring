package com.utopia.core.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

	private Long timeDiff;
    private Long timeDiffCacheStartTime;
    
    @Value(value = "${DB.time.sync.interval:3600}")
    private long timeDiffCacheTimeOut;
    private static Logger logger = Logger.getLogger(TimeService.class.getSimpleName());
    private static DatabseType DBType;
    @PersistenceContext
	protected EntityManager entityManager;

    public long getDatabaseTime() {
        return getDBTime().getTime();
    }

    public Date getDBTime() {
        if (!timeIsUP()) {
            long systemTime = System.currentTimeMillis();
           

            return new Timestamp(systemTime + timeDiff);
        }

        long dbTime = readDBTime().getTime();
        long systemTime = System.currentTimeMillis();

        timeDiffCacheStartTime = systemTime;

        timeDiff = dbTime - systemTime;

        

        return new Timestamp(dbTime);

    }

    private Date readDBTime() {
    	Date result=null;
    	if(DBType==null){
    		for(DatabseType type:DatabseType.values() ){
    			try {
					result=readDBTime(type.timeQuery);
					DBType=type;
					break; 
				} catch (Exception e) {
						logger.warn(e);
				}
    		}
    	}else{
    		try {
				result=readDBTime(DBType.timeQuery);
			} catch (Exception e) {
					logger.warn(e);
			}
    		
    	}
    	result=result==null?Calendar.getInstance().getTime():result;
    	return result;
    }
    private Date readDBTime(String SQL) throws Exception{
        	Query query = entityManager.createNamedQuery(
                    "SELECT CURRENT_TIMESTAMP ");
           return (Date)query.getSingleResult();
    }


    private boolean timeIsUP() {
        if (timeDiff == null || timeDiffCacheStartTime == null) {
            return true;
        }

        long systemTime = System.currentTimeMillis();
        if (logger.isDebugEnabled()) {
            logger.debug("systemTime is " + systemTime +
                    " timeDiffCacheStartTime is " + timeDiffCacheStartTime +
                    " systemTime - timeDiffCacheStartTime is " + (systemTime - timeDiffCacheStartTime) +
                    " timeDiffCacheTimeOut is " + timeDiffCacheTimeOut);
        }

        return (systemTime - timeDiffCacheStartTime) > (timeDiffCacheTimeOut * 1000);

    }
    
}
