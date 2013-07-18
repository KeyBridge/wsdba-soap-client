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
package com.keybridgeglobal.test;

import info.wsdba.peering.entity.Version;
import info.wsdba.peering.soap.RealTimePollRequest;
import info.wsdba.peering.soap.RealTimePollResponse;
import info.wsdba.peering.soap.client.keybridge.Peering;
import info.wsdba.peering.soap.client.keybridge.WSDBASoapService;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Test SOAP Client to query the Key Bridge Peering Service supporting the WSBDA
 * data specification.
 * <p/>
 * The Key Bridge peering service implements username authentication with
 * symmetric keys for integrity and confidentiality protection.
 * <p/>
 * Configuration:
 * <p/>
 * 1) Username and Password: Prior to accessing the SOAP service you you must
 * first update the file 'WSDBASoapService.xml', located in the META-INF
 * directory, and enter your Key Bridge issued username and password in the
 * sc:CallbackHandler "usernameHandler" and "passwordHandler" elements near
 * lines 50 and 51 of that file.
 * <p/>
 * 2) Security Credentials: Java METRO also requires a JKS TrustStore to
 * establish an SSL connection. Other languages may have different requirements.
 * A sample TrustStore named 'keystore.jks' is provided for you in the root
 * source 'src' directory. Move this file to your desired location (e.g. a
 * temporary directory) and update the 'WSDBASoapService.xml' file
 * 'sc:TrustStore' entry near line 53 to point to the keystore.jks file location
 * that you moved on to your local file system.
 * <p/>
 * @author jesse
 */
public class TestWSDBAClient {

  /**
   * Main. This method prints all output to the console.
   * <p/>
   * @param args
   */
  public static void main(String[] args) {
    /**
     * Print proof of life.
     */
    System.out.println("DEBUG TestWSDBAClient");
    /**
     * Initialize the Request.
     */
    RealTimePollRequest realTimePollRequest = new RealTimePollRequest();
    /**
     * Key Bridge requires poll requests to be spaced at least 4 minutes apart.
     * Set the RequestedTransactionID to four minutes ago.
     */
    realTimePollRequest.setRequestedTransactionID(String.valueOf(Calendar.getInstance().getTimeInMillis() - 5 * 60 * 1000));
    /**
     * Key Bridge only supports Version 1.2.0
     */
    realTimePollRequest.setXsdVersion(Version.V12);
    /**
     * The Spec. only supports the command value 'wsdPoll'.
     */
    realTimePollRequest.setCommand("wsdPoll");
    /**
     * Call the SOAP Service wrapper method below to get a Response.
     */
    RealTimePollResponse response = callPeeringService(realTimePollRequest);
    /**
     * Print the response.
     */
    System.out.println("TestWSDBAClient Response: " + response);
  }

  /**
   * Internal method to call the Key Bridge WSDBA Peering Service.
   * <p/>
   * This method wraps the actual HTTP SOAP call in a try/catch to assist with
   * error tracking and program debugging.
   * <p/>
   * @param realTimePollRequest the request
   * @return the response
   */
  private static RealTimePollResponse callPeeringService(RealTimePollRequest realTimePollRequest) {
    /**
     * Initialize the Peering Service.
     */
    Peering service = new Peering();
    /**
     * Open the Peering service port.
     */
    WSDBASoapService port = service.getWSpacesWSService();
    /**
     * Call the Service + Port realTimePoll method.
     */
    try {
      return port.realTimePoll(realTimePollRequest);
    } catch (Exception e) {
      System.err.println("ERROR: callPeeringService caught exception: " + e.getMessage());
      Logger.getLogger(TestWSDBAClient.class.getName()).log(Level.SEVERE, null, e);
      return null;
    }
  }
}
