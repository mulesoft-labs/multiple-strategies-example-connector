/**
 * (c) 2003-2014 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.strategiesexample.strategy;

import org.mule.api.annotations.components.Basic;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.param.Default;
import org.mule.modules.strategiesexample.MyDummyService;

/**
 * Basic Connection Strategy
 *
 * @author MuleSoft, Inc.
 */
@Basic(configElementName = "config-type-basic", friendlyName = "Basic type Strategy")
public class ConnectorConnectionStrategy implements StrategyCommonInterface
{
    /**
     * Configurable
     */
    @Configurable
    @Default("value")
    private String myStrategyProperty;

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
     * This method should retrieve a Service
     */
	@Override
	public MyDummyService getService() {
		// TODO Auto-generated method stub
		return null;
	}

}