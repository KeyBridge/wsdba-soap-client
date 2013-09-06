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
package info.wsdba.peering.soap.client.keybridge;

import info.wsdba.peering.soap.ObjectFactory;
import info.wsdba.peering.soap.RealTimePollRequest;
import info.wsdba.peering.soap.RealTimePollResponse;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.2.6-1b01 Generated
 * source version: 2.2
 * <p/>
 */
@WebService(name = "WSDBASoapService", targetNamespace = "http://www.keybridgeglobal.com/peering/wsdba")
@XmlSeeAlso({ObjectFactory.class})
public interface WSDBASoapService {

  /**
   * The WSDBA query.
   * <p/>
   * @param realTimePollRequest a RealTimePollRequest instance
   * @return returns java.lang.String XML encoded RealTimePollResponse
   */
  @WebMethod(operationName = "RealTimePoll", action = "http://www.whitespace-db-providers.org/2011//InterDB/ws/RealTimePoll")
  @ResponseWrapper(localName = "RealTimePollResponse", targetNamespace = "http://www.whitespace-db-providers.org/2011//InterDB/ws/RealTimePoll")
  public RealTimePollResponse realTimePoll(@WebParam(name = "RealTimePollRequest") RealTimePollRequest realTimePollRequest);
}
