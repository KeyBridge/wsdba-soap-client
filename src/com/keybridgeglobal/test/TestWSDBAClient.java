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

import info.wsdba.peering.soap.client.WSDBAClient_SOAP;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;
import org.whitespace_db_providers._2011.interdb.ws.RealTimePollResponse;

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
 * @author Jesse Caulfield
 */
public class TestWSDBAClient {

  /**
   * Main. This method prints all output to the console.
   * <p/>
   * @param args
   */
  public static void main(String[] args) throws URISyntaxException {
    /**
     * Print proof of life.
     */
    System.out.println("DEBUG TestWSDBAClient");
    /**
     * Call the SOAP Client with the designated end point.
     * <p/>
     */
    String endPointKeyBridgeTest = "https://localhost:8181/WSpaces_WS_SVC/WSDBASoapService";
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.HOUR, -1);
    String transactionKeyBridge = String.valueOf(cal.getTimeInMillis());

    RealTimePollResponse response = WSDBAClient_SOAP.realTimePoll(new URI(endPointKeyBridgeTest), transactionKeyBridge);
    /**
     * Print the response.
     */
    System.out.println("\n\nTestWSDBAClient Response: " + response + "\n\n");
  }
}
