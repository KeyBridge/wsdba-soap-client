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

import info.wsdba.peering.entity.Version;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for RealTimePollRequest complex type.
 * <p/>
 * The real time web service is an interface that provides a set of
 * Insert/Delete/Modify transactions in real time as the database at any
 * Administrator changes.
 * <p/>
 * The basic mechanism is a “fast poll”. Clients of the server poll the server
 * relatively rapidly to ask for updates. Poll intervals between 1 and 1000
 * seconds are allowed, determined by the client.
 * <p/>
 * The server responds with all transactions in the database since the last
 * completed poll.
 * <p/>
 * In the poll, the client provides a “TransactionID” in the request. A new
 * TransactionId is returned in the response, which is used in the next poll.
 * TransactionIds no older than 72 hours are permitted; any poll with a
 * transactionId older than this will generate an error in the poll. Clients who
 * remain off-line for more than 72 hours will need to start with the latest
 * daily file, which contains the transactionId that can be used after loading
 * the file to retrieve all updates since the file was created.
 * <p/>
 * Each client must use the transactionID it receives, either from a file
 * download or a prior transactionId in a subsequent poll. TransactionIds are
 * not (necessarily) the same between clients. TransactionID streams are
 * maintained independently by each WSDB Administrator (server side), and each
 * server may use a different syntax for the transactionID.
 * <p/>
 * @author Jesse Caulfield
 * @version 1.2.1
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RealTimePollRequest", propOrder = {
  "requestedTransactionID",
  "command",
  "xsdVersion"
})
public class RealTimePollRequest {

  /**
   * The value of NextTransactionID which was received in the
   * RegistrationRecordEnsemble of the last valid response to a poll or in a
   * full download via FTP.
   */
  @XmlElement(name = "RequestedTransactionID", required = true)
  protected String requestedTransactionID;
  /**
   * 'wsdPoll' is the only allowed value
   */
  @XmlElement(name = "Command", required = true)
  protected String command = "wsdPoll";
  /**
   * Version of xsd requested. Version of xsd requested, e.g. 1.2.3
   * <p/>
   * Defaults to '1.2'
   */
  @XmlElement(name = "XsdVersion", required = true)
  protected String xsdVersion = "1.2";

  public RealTimePollRequest() {
  }

  public RealTimePollRequest(String requestedTransactionID) {
    this.requestedTransactionID = requestedTransactionID;
  }

  public RealTimePollRequest(long requestedTransactionID) {
    this.requestedTransactionID = String.valueOf(requestedTransactionID);
  }

  //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
  /**
   * Gets the value of the requestedTransactionID property.
   * <p/>
   * @return possible object is {@link String }
   * <p/>
   */
  public String getRequestedTransactionID() {
    return requestedTransactionID;
  }

  /**
   * Sets the value of the requestedTransactionID property.
   * <p/>
   * @param value allowed object is {@link String }
   * <p/>
   */
  public void setRequestedTransactionID(String value) {
    this.requestedTransactionID = value;
  }

  /**
   * Gets the value of the command property.
   * <p/>
   * @return possible object is {@link String }
   * <p/>
   */
  public String getCommand() {
    return command;
  }

  /**
   * Sets the value of the command property.
   * <p/>
   * @param value allowed object is {@link String }
   * <p/>
   */
  public void setCommand(String value) {
    this.command = value;
  }

  /**
   * Gets the value of the xsdVersion property.
   * <p/>
   * @return possible object is {@link String }
   * <p/>
   */
  public Version getXsdVersion() {
    return Version.fromValue(xsdVersion);
  }

  /**
   * Sets the value of the xsdVersion property.
   * <p/>
   * @param version allowed object is {@link String }
   * <p/>
   */
  public void setXsdVersion(Version version) {
    this.xsdVersion = version.value();
  }//</editor-fold>

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 97 * hash + Objects.hashCode(this.requestedTransactionID);
    hash = 97 * hash + Objects.hashCode(this.command);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final RealTimePollRequest other = (RealTimePollRequest) obj;
    if (!Objects.equals(this.requestedTransactionID, other.requestedTransactionID)) {
      return false;
    }
    if (!Objects.equals(this.command, other.command)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "RealTimePollRequest"
      + " requestedTransactionID [" + requestedTransactionID
      + "] command [" + command
      + "] xsdVersion [" + xsdVersion
      + ']';
  }
}
