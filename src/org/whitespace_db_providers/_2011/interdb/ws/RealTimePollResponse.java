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

import info.wsdba.peering.entity.RegistrationRecordEnsemble;
import info.wsdba.peering.entity.Version;
import java.util.Calendar;
import java.util.Objects;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.caulfield.wsdba.util.WSDBAReader;
import org.caulfield.wsdba.util.WSDBAWriter;

/**
 * Java class for RealTimePollResponse complex type.
 * <p/>
 * @version 1.2.1
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RealTimePollResponse", propOrder = {
  "requestedTransactionID",
  "command",
  "registrationRecordEnsemble",
  "xsdVersion",
  "nextTransactionID",
  "rtPollStatusCode"
})
public final class RealTimePollResponse {

  /**
   * Echo the value of CurrentTransactionID received in the RealTimePollRequest
   */
  @XmlElement(name = "RequestedTransactionID", required = true)
  protected String requestedTransactionID;
  /**
   * 'wsdPollResponse' is the only allowed value
   */
  @XmlElement(name = "Command", required = true)
  protected String command = "wsdPollResponse";
  /**
   * Records changed since last poll.
   * <p/>
   * For all poll response codes other than SUCCESS (0), no
   * RegistrationRecordEnsemble will be returned.
   * <p/>
   * If the sending WSDB determines that there are no new records and the
   * transactionID requested is not stale, then RegistrationRecordEnsemble will
   * not be sent, and the RT-PollResponseCode will be set to NO_NEW_TALE_TO_TELL
   * (4).
   */
  @XmlElement(name = "RegistrationRecordEnsemble")
  protected String registrationRecordEnsemble;
  /**
   * Version of xsd in this response. Must match the version of xsd requested.
   * e.g. 1.2.3
   * <p/>
   * Defaults to '1.2'
   */
  @XmlElement(name = "XsdVersion", required = true)
  protected String xsdVersion = "1.2";
  /**
   * Inserted in RealTimePollResponse when an RR Ensemble is not sent in
   * response to a RealTimePollRequest due to No New Records. Used by client as
   * RequestedTransactionID in the next RealTimePollRequest.
   */
  @XmlElement(name = "NextTransactionID")
  protected String nextTransactionID;
  /**
   * An enumeration of status codes defined as follows: <ul> <li>0 =
   * Success</li> <li>1 = TransactionID stale, recover from file</li> <li>2 =
   * Bad Request</li> <li>3 = Requested version not supported</li> <li>4 = No
   * New Records, (no RegistrationRecordEnsemble present)</li> <li>5 = Server
   * Error</li></ul>
   */
  @XmlElement(name = "RT-PollStatusCode")
  protected int rtPollStatusCode;

  public RealTimePollResponse() {
  }

  /**
   * Simple constructor.
   * <p/>
   * Sets the requestedTransactionID AND the nextTransactionID to match the
   * request. Sets EPollStatusCode.ERROR.
   * <p/>
   * If using this constructor you MUST update the next transaction ID and
   * PollStatusCode.
   * <p/>
   * @param request
   */
  public RealTimePollResponse(RealTimePollRequest request) {
    this.requestedTransactionID = request.requestedTransactionID;
    setNextTransactionID(request.getRequestedTransactionID());
    setRTPollStatusCode(EPollStatusCode.ERROR);
  }

  /**
   * Simple constructor.
   * <p/>
   * Sets EPollStatusCode.SUCCESS and the nextTransactionID to the current
   * system time stamp.
   * <p/>
   * @param requestedTransactionID
   */
  public RealTimePollResponse(String requestedTransactionID, int pollInterval) {
    this.requestedTransactionID = requestedTransactionID;
    setNextTransactionID(Calendar.getInstance().getTimeInMillis());
    setRTPollStatusCode(EPollStatusCode.SUCCESS);
  }

  /**
   * A fully qualified constructor.
   * <p/>
   * Sets the RegistrationRecordEnsemble response and EPollStatusCode.SUCCESS.
   * <p/>
   * This constructor is suitable to be sent to the client without further
   * modification.
   * <p/>
   * @param requestedTransactionID     the client requestedTransactionID
   *                                   provided by the client and echoed back
   * @param nextTransactionID          the next transactionID provided to the
   *                                   client
   * @param registrationRecordEnsemble the responding RegistrationRecordEnsemble
   */
  public RealTimePollResponse(String requestedTransactionID, String nextTransactionID, String registrationRecordEnsemble) {
    this.requestedTransactionID = requestedTransactionID;
    this.nextTransactionID = nextTransactionID;
    this.registrationRecordEnsemble = registrationRecordEnsemble;
    setRTPollStatusCode(EPollStatusCode.SUCCESS);
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
   * Gets the value of the registrationRecordEnsemble property.
   * <p/>
   * @return possible object is {@link String }
   */
  public String getRegistrationRecordEnsembleString() {
    return registrationRecordEnsemble;
  }

  /**
   * Gets the value of the registrationRecordEnsemble property. This method does
   * NOT validate the Ensemble cryptographic signature.
   * <p/>
   * @return possible object is {@link String }
   * <p/>
   */
  public RegistrationRecordEnsemble getRegistrationRecordEnsemble() throws Exception {
    if (registrationRecordEnsemble != null) {
      return WSDBAReader.parse(registrationRecordEnsemble);
    } else {
      return null;
    }
  }

  /**
   * Sets the value of the registrationRecordEnsemble property.
   * <p/>
   * @param value allowed object is {@link String }
   * <p/>
   */
  public void setRegistrationRecordEnsemble(String value) {
    this.registrationRecordEnsemble = value;
  }

  /**
   * Sets the value of the registrationRecordEnsemble property. This method
   * marshals the input RRE but does NOT sign it.
   * <p/>
   * @param ensemble A fully qualified RegistrationRecordEnsemble implementation
   * <p/>
   */
  public void setRegistrationRecordEnsemble(RegistrationRecordEnsemble ensemble) throws JAXBException {
    this.registrationRecordEnsemble = WSDBAWriter.marshal(ensemble);
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
  }

  /**
   * Gets the value of the nextTransactionID property.
   * <p/>
   * @return possible object is {@link String }
   * <p/>
   */
  public String getNextTransactionID() {
    return nextTransactionID;
  }

  /**
   * Sets the value of the nextTransactionID property.
   * <p/>
   * @param value allowed object is {@link String }
   * <p/>
   */
  public void setNextTransactionID(String value) {
    this.nextTransactionID = value;
  }

  /**
   * Sets the value of the nextTransactionID property as a Long.
   * <p/>
   * @param value a long number - expect Date.milliseconds
   */
  public void setNextTransactionID(long value) {
    this.nextTransactionID = String.valueOf(value);
  }

  /**
   * Gets the value of the rtPollStatusCode property.
   * <p/>
   * If the sending WSDB Administrator cannot support the requested version, it
   * returns the RT- PollStatusCode = 3.
   */
  public EPollStatusCode getRTPollStatusCode() {
    return EPollStatusCode.findByCode(rtPollStatusCode);
  }

  /**
   * Sets the value of the rtPollStatusCode property.
   */
  public final void setRTPollStatusCode(EPollStatusCode value) {
    this.rtPollStatusCode = value.getStatusCode();
  }//</editor-fold>

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 29 * hash + Objects.hashCode(this.requestedTransactionID);
    hash = 29 * hash + Objects.hashCode(this.command);
    hash = 29 * hash + Objects.hashCode(this.registrationRecordEnsemble);
    hash = 29 * hash + Objects.hashCode(this.xsdVersion);
    hash = 29 * hash + Objects.hashCode(this.nextTransactionID);
    hash = 29 * hash + this.rtPollStatusCode;
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
    final RealTimePollResponse other = (RealTimePollResponse) obj;
    if (this.hashCode() != obj.hashCode()) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    try {
      return "RealTimePollResponse"
        + " requestedTransactionID [" + requestedTransactionID
        + "] command [" + command
        + "] nextTransactionID [" + nextTransactionID
        + "] rtPollStatusCode [" + getRTPollStatusCode()
        + "] xsdVersion [" + xsdVersion
        + "]\n registrationRecordEnsemble [" + getRegistrationRecordEnsemble()
        + ']';
    } catch (Exception ex) {
      return "RealTimePollResponse"
        + " requestedTransactionID [" + requestedTransactionID
        + "] command [" + command
        + "] nextTransactionID [" + nextTransactionID
        + "] rtPollStatusCode [" + getRTPollStatusCode()
        + "] xsdVersion [" + xsdVersion
        + "]\n registrationRecordEnsemble [" + registrationRecordEnsemble + ']';
    }
  }
}
