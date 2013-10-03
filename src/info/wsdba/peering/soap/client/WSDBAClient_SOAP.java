/**
 * Copyright (C) Key Bridge Global LLC and/or its affiliates.
 * <p/>
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * <p/>
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * <p/>
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package info.wsdba.peering.soap.client;

import java.net.URI;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import org.whitespace_db_providers._2011.interdb.ws.RealTimePollRequest;
import org.whitespace_db_providers._2011.interdb.ws.RealTimePollResponse;
import org.whitespace_db_providers._2011.interdb.ws.WSpacesWSPT;
import org.whitespace_db_providers._2011.interdb.ws.WSpacesWSSVC;

/**
 * A wrapper class to access WSDBA SOAP services.
 * <p/>
 * This class manipulates the SOAP port binding provider to update and set the
 * service end point to the indicated end point address.
 * <p/>
 * @author Jesse Caulfield
 */
public class WSDBAClient_SOAP {

  /**
   * Query the indicated EndPointAddress with the input RealTimePollRequest
   * message.
   * <p/>
   * @param endpointAddress The registrar SOAP Address Location encoded as a
   *                        well-formed URL.
   * @param transactionId   The transaction ID associated with the indicated
   *                        Registrar SOAP Address Location.
   * @return a Poll Response message
   */
  public static RealTimePollResponse realTimePoll(URI endpointAddress, String transactionId, boolean logSoapMessage) {
    /**
     * Null check.
     */
    if (endpointAddress == null || transactionId == null || transactionId.isEmpty()) {
      throw new IllegalArgumentException("ERROR: WSDBAClient_SOAP.realTimePoll called with null parameters.");
    }
    /**
     * Initialize the Peering Service and Port.
     */
    WSpacesWSSVC service = new WSpacesWSSVC();
    WSpacesWSPT port = service.getWSpacesWSService();
    /**
     * Change the endpoint address by updating the request context
     * ENDPOINT_ADDRESS_PROPERTY.
     * <p/>
     * The BindingProvider interface provides access to the protocol binding and
     * associated context objects for request and response message processing.
     * <p/>
     * The ENDPOINT_ADDRESS_PROPERTY is the target service endpoint address. The
     * URI scheme for the endpoint address specification MUST correspond to the
     * protocol/transport binding for the binding in use.
     * <p/>
     * @see <a
     * href="http://docs.oracle.com/javase/7/docs/api/javax/xml/ws/BindingProvider.html">BindingProvider</a>
     */
    BindingProvider bindingProvider = (BindingProvider) port;
    bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointAddress.toString());
    /**
     * OPTIONAL DEBUG: Add the SOAP client LOGGER to the handler chain.
     */
    if (logSoapMessage) {
      List<Handler> handlerChain = bindingProvider.getBinding().getHandlerChain();
      handlerChain.add(new SoapClientLogger());
      bindingProvider.getBinding().setHandlerChain(handlerChain);
    }
    /**
     * Call the Service + Port realTimePoll method inside a try/catch.
     */
    try {
      return port.realTimePoll(new RealTimePollRequest(transactionId));
    } catch (Exception e) {
      /**
       * @TODO: File a bug report on realTimePoll exception..
       */
      System.err.println("ERROR: WSDBASoapClient caught exception: " + e.getMessage());
      Logger.getLogger(WSDBAClient_SOAP.class.getName()).log(Level.SEVERE, null, e);
      return null;
    }
  }
}
