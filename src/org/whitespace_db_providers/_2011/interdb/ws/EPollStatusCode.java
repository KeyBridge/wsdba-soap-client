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

import javax.xml.bind.annotation.XmlEnum;

/**
 * Enumerated list of Registration Objects.
 * <p/>
 * @author Jesse Caulfield
 */
@XmlEnum
public enum EPollStatusCode {

  /**
   * 0: Success. Yay!
   */
  SUCCESS(0, "Success"),
  /**
   * 1: TransactionID stale, recover from file.
   * <p/>
   * If a poll request is made more than 72 hours after the previous request AND
   * new records have been added to the database, the response code will be 1.
   */
  STALE(1, "TransactionID stale, recover from file"),
  /**
   * 2: Bad Request. Huh?
   */
  BAD_REQUEST(2, "Bad Request"),
  /**
   * 3: Requested version not supported.
   * <p/>
   * If the sending WSDB Administrator cannot support the requested version, it
   * returns the RT- PollStatusCode = 3.
   */
  NOT_SUPPORTED(3, "Requested version not supported"),
  /**
   * 4: No New Records.
   * <p/>
   * If the sending WSDB determines that there are no new records and the
   * transactionID requested is not stale, then RegistrationRecordEnsemble will
   * not be sent, and the RT-PollResponseCode will be set to 4.
   */
  NO_NEW_TALE_TO_TELL(4, "No New Records"),
  /**
   * 5: Server Error. Oops!
   */
  ERROR(5, "Server Error"),;
  /**
   * The numerical code representing this poll status.
   */
  private int statusCode;
  /**
   * A human-readable description.
   */
  private String description;

  private EPollStatusCode(int statusCode, String description) {
    this.statusCode = statusCode;
    this.description = description;
  }

  /**
   * @return The numerical code representing this poll status.
   */
  public int getStatusCode() {
    return statusCode;
  }

  /**
   * @return A human-readable description.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Find a EPollStatusCode by its numerical identifier.
   * <p/>
   * @param code the integer code (0-5)
   * @return the corresponding EPollStatusCode, null if no match.
   */
  public static EPollStatusCode findByCode(int code) {
    for (EPollStatusCode pollStatusCode : EPollStatusCode.values()) {
      if (pollStatusCode.getStatusCode() == code) {
        return pollStatusCode;
      }
    }
    return null;
  }
}
