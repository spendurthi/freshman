package com.fgtway.logging;

import org.slf4j.Logger;

public class Logging {
	public static void log(Logger logger,int level,String... message){
		if (level==0){
			for(String msg:message){
				System.out.println(msg);
			}
		}else if (level==1){
			for(String msg:message){
				logger.trace(msg);
			}
		}else if (level==2){
			for(String msg:message){
				logger.debug(msg);
			}
		}else if (level==3){
			for(String msg:message){
				logger.info(msg);
			}
		}else if (level==4){
			for(String msg:message){
				logger.warn(msg);
			}
		}else if (level==5){
			for(String msg:message){
				logger.error(msg);
			}
		}		
	}
}
