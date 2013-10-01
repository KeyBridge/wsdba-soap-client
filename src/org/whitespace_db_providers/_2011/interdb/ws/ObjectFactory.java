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
package org.whitespace_db_providers._2011.interdb.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the
 * org.whitespace_db_providers._2011.interdb.ws package. An ObjectFactory allows
 * you to programatically construct new instances of the Java representation for
 * XML content. The Java representation of XML content can consist of schema
 * derived interfaces and classes representing the binding of schema type
 * definitions, element declarations and model groups. Factory methods for each
 * of these are provided in this class.
 * <p/>
 * @author Jesse Caulfield
 */
@XmlRegistry
public class ObjectFactory {

  private final static QName _RealTimePollResponse_QNAME = new QName("http://www.whitespace-db-providers.org/2011//InterDB/ws", "RealTimePollResponse");
  private final static QName _RealTimePollRequest_QNAME = new QName("http://www.whitespace-db-providers.org/2011//InterDB/ws", "RealTimePollRequest");

  /**
   * Create a new ObjectFactory that can be used to create new instances of
   * schema derived classes for package:
   * org.whitespace_db_providers._2011.interdb.ws
   * <p/>
   */
  public ObjectFactory() {
  }

  /**
   * Create an instance of {@link RealTimePollResponse }
   * <p/>
   */
  public RealTimePollResponse createRealTimePollResponse() {
    return new RealTimePollResponse();
  }

  /**
   * Create an instance of {@link RealTimePollRequest }
   * <p/>
   */
  public RealTimePollRequest createRealTimePollRequest() {
    return new RealTimePollRequest();
  }

  /**
   * Create an instance of
   * {@link JAXBElement }{@code <}{@link RealTimePollResponse }{@code >}}
   * <p/>
   */
  @XmlElementDecl(namespace = "http://www.whitespace-db-providers.org/2011//InterDB/ws", name = "RealTimePollResponse")
  public JAXBElement<RealTimePollResponse> createRealTimePollResponse(RealTimePollResponse value) {
    return new JAXBElement<RealTimePollResponse>(_RealTimePollResponse_QNAME, RealTimePollResponse.class, null, value);
  }

  /**
   * Create an instance of
   * {@link JAXBElement }{@code <}{@link RealTimePollRequest }{@code >}}
   * <p/>
   */
  @XmlElementDecl(namespace = "http://www.whitespace-db-providers.org/2011//InterDB/ws", name = "RealTimePollRequest")
  public JAXBElement<RealTimePollRequest> createRealTimePollRequest(RealTimePollRequest value) {
    return new JAXBElement<RealTimePollRequest>(_RealTimePollRequest_QNAME, RealTimePollRequest.class, null, value);
  }
}
