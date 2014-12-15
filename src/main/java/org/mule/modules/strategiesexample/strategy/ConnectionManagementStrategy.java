package org.mule.modules.strategiesexample.strategy;

import org.mule.api.ConnectionException;
import org.mule.api.annotations.Connect;
import org.mule.api.annotations.ConnectionIdentifier;
import org.mule.api.annotations.Disconnect;
import org.mule.api.annotations.TestConnectivity;
import org.mule.api.annotations.ValidateConnection;
import org.mule.api.annotations.components.ConnectionManagement;
import org.mule.api.annotations.display.Password;
import org.mule.api.annotations.param.ConnectionKey;
import org.mule.modules.strategiesexample.MyDummyService;

@ConnectionManagement(friendlyName = "Connection Management type Strategy", configElementName="config-type")
public class ConnectionManagementStrategy implements StrategyCommonInterface {
	
	MyDummyService service;
	
	public ConnectionManagementStrategy(){
		service = new MyDummyService();
	}
	
	@TestConnectivity
    @Connect
    public void connect(@ConnectionKey String username, @Password String password)
        throws ConnectionException {
    	Boolean result = service.connectService(username, password);
    	if(result == false){
    		throw new ConnectionException(null, "Invalid Username or password", "Please review Username or Password values");
    	}
    }

    @Disconnect
    public void disconnect() {
    	service.disconnectService();
    }

    @ValidateConnection
    public boolean isConnected() {
        return service.connectionStatus();
    }

    @ConnectionIdentifier
    public String connectionId() {
        return "001";
    }

	@Override
	public MyDummyService getService() {
		return service;
	}
   

}
