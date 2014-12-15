package org.mule.modules.strategiesexample;

import org.apache.commons.lang.StringUtils;

public class MyDummyService {
	private Boolean serviceStatus = false;
	
	public Boolean connectService(String username, String password){
		if(StringUtils.equals(username, "username")&&StringUtils.equals(password, "password")){
			serviceStatus = true;
			return true;
		}else{
			return false;
		}
	}
	
	public Boolean disconnectService(){
		serviceStatus = false;
		return true;
	}
	
	public Boolean connectionStatus(){
		return serviceStatus;
	}
	
	public String getUser(String user){
		return user;
	}
}
