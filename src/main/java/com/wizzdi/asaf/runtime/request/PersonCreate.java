package com.wizzdi.asaf.runtime.request;

import java.time.OffsetDateTime;

/** Object Used to Create Person */
public class PersonCreate {

  private String address;

  private OffsetDateTime birthDate;

  /**
   * @return address
   */
  public String getAddress() {
    return this.address;
  }

  /**
   * @param address address to set
   * @return PersonCreate
   */
  public <T extends PersonCreate> T setAddress(String address) {
    this.address = address;
    return (T) this;
  }

  /**
   * @return birthDate
   */
  public OffsetDateTime getBirthDate() {
    return this.birthDate;
  }

  /**
   * @param birthDate birthDate to set
   * @return PersonCreate
   */
  public <T extends PersonCreate> T setBirthDate(OffsetDateTime birthDate) {
    this.birthDate = birthDate;
    return (T) this;
  }
}
