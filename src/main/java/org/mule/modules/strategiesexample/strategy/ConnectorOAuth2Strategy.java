/**
 * (c) 2003-2014 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.strategiesexample.strategy;

import org.mule.api.ConnectionException;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Connect;
import org.mule.api.annotations.ConnectionIdentifier;
import org.mule.api.annotations.Disconnect;
import org.mule.api.annotations.TestConnectivity;
import org.mule.api.annotations.ValidateConnection;
import org.mule.api.annotations.display.Password;
import org.mule.api.annotations.oauth.OAuth2;
import org.mule.api.annotations.oauth.OAuthAccessToken;
import org.mule.api.annotations.oauth.OAuthConsumerKey;
import org.mule.api.annotations.oauth.OAuthConsumerSecret;
import org.mule.api.annotations.param.ConnectionKey;
import org.mule.api.annotations.param.Default;
import org.mule.modules.strategiesexample.MyDummyService;

/**
 * OAuth2 Connection Strategy
 *
 * @author MuleSoft, Inc.
 */
@OAuth2( configElementName = "config-oauth2", friendlyName="OAuth2 type Strategy", authorizationUrl = "https://api.myconnector.com/uas/oauth/authorize", 
accessTokenUrl = "https://api.myconnector.com/uas/oauth/accessToken", 
accessTokenRegex = "\"access_token\":\"([^&]+?)\"",
expirationRegex = "\"expires_in\":([^&]+?),", 
refreshTokenRegex = "\"refresh_token\":\"([^&]+?)\"" )
public class ConnectorOAuth2Strategy implements StrategyCommonInterface
{
    /**
     * Configurable
     */
    @Configurable
    @Default("value")
    private String myStrategyProperty;

    /**
     * The OAuth access token
     */
    @OAuthAccessToken
    private String accessToken;
    
    /**
     * The OAuth consumer key
     */
    @Configurable
    @OAuthConsumerKey
    private String consumerKey;

    /**
     * The OAuth consumer secret
     */
    @Configurable
    @OAuthConsumerSecret
    private String consumerSecret;

    /**
     * Connect
     *
     * @param username A username
     * @param password A password
     * @throws ConnectionException
     */
    @Connect
    @TestConnectivity
    public void connect(@ConnectionKey String username, @Password String password)
        throws ConnectionException {
        /*
         * CODE FOR ESTABLISHING A CONNECTION GOES IN HERE
         */
    }

    /**
     * Disconnect
     */
    @Disconnect
    public void disconnect() {
        /*
         * CODE FOR CLOSING A CONNECTION GOES IN HERE
         */
    }

    /**
     * Are we connected
     */
    @ValidateConnection
    public boolean isConnected() {
        //TODO: Change it to reflect that we are connected.
        return false;
    }

    /**
     * Are we connected
     */
    @ConnectionIdentifier
    public String connectionId() {
        return "001";
    }

    /**
     * Set strategy property
     *
     * @param myStrategyProperty my strategy property
     */
    public void setMyStrategyProperty(String myStrategyProperty) {
        this.myStrategyProperty = myStrategyProperty;
    }

    /**
     * Get property
     */
    public String getMyStrategyProperty() {
        return this.myStrategyProperty;
    }

    /**
     * Set accessToken
     *
     * @param accessToken
     *            The accessToken
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * Get accessToken
     */
    public String getAccessToken() {
        return this.accessToken;
    }

    /**
     * Set consumerKey
     *
     * @param consumerKey The consumerKey
     */
    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    /**
     * Get consumerKey
     */
    public String getConsumerKey() {
        return this.consumerKey;
    }

    /**
     * Set consumerSecret
     *
     * @param consumerSecret The consumerSecret
     */
    public void setConsumerSecret(String consumerSecret) {
        this.consumerSecret = consumerSecret;
    }

    /**
     * Get consumerSecret
     */
    public String getConsumerSecret() {
        return this.consumerSecret;
    }

	@Override
	public MyDummyService getService() {
		// TODO Auto-generated method stub
		return null;
	}
    
    

}