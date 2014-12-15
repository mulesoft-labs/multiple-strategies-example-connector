/**
 * (c) 2003-2014 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.strategiesexample;

import org.mule.api.annotations.ConnectionStrategy;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.param.Default;
import org.mule.modules.strategiesexample.strategy.StrategyCommonInterface;

/**
 * Anypoint Connector
 *
 * @author MuleSoft, Inc.
 */
@Connector(name="strategies-example", schemaVersion="1.0", friendlyName="StrategiesExample")
public class StrategiesExampleConnector
{
    /**
     * Configurable
     */
    @Configurable
    @Default("value")
    private String myProperty;

    @ConnectionStrategy
    StrategyCommonInterface connectionStrategy;

    /**
     * Custom processor
     *
     * {@sample.xml ../../../doc/strategies-example-connector.xml.sample strategies-example:my-processor}
     *
     * @param content Content to be processed
     * @return Some string
     */
    @Processor
    public String myProcessor(String content) {
        /*
         * MESSAGE PROCESSOR CODE GOES HERE
         */
        return content;
    }

    /**
     * Set property
     *
     * @param myProperty My property
     */
    public void setMyProperty(String myProperty) {
        this.myProperty = myProperty;
    }

    /**
     * Get property
     */
    public String getMyProperty() {
        return this.myProperty;
    }

    public StrategyCommonInterface getConnectionStrategy() {
        return connectionStrategy;
    }

    public void setConnectionStrategy(StrategyCommonInterface connectionStrategy) {
        this.connectionStrategy = connectionStrategy;
    }

}