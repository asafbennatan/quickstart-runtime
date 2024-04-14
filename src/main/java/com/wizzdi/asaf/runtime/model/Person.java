package com.wizzdi.asaf.runtime.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.OffsetDateTime;

@Entity
public class Person {

  @Id private String id;

  private String address;

  private OffsetDateTime birthDate;

  /**
   * @return id
   */
  @Id
  public String getId() {
    return this.id;
  }

  /**
   * @param id id to set
   * @return Person
   */
  public <T extends Person> T setId(String id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return address
   */
  public String getAddress() {
    return this.address;
  }

  /**
   * @param address address to set
   * @return Person
   */
  public <T extends Person> T setAddress(String address) {
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
   * @return Person
   */
  public <T extends Person> T setBirthDate(OffsetDateTime birthDate) {
    this.birthDate = birthDate;
    return (T) this;
  }
}
