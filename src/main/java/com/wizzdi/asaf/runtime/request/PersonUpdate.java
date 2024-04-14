package com.wizzdi.asaf.runtime.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.asaf.runtime.model.Person;
import com.wizzdi.asaf.runtime.validation.IdValid;
import com.wizzdi.asaf.runtime.validation.Update;

/** Object Used to Update Person */
@IdValid.List({
  @IdValid(
      targetField = "person",
      field = "id",
      fieldType = Person.class,
      groups = {Update.class})
})
public class PersonUpdate extends PersonCreate {

  private String id;

  @JsonIgnore private Person person;

  /**
   * @return id
   */
  public String getId() {
    return this.id;
  }

  /**
   * @param id id to set
   * @return PersonUpdate
   */
  public <T extends PersonUpdate> T setId(String id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return person
   */
  @JsonIgnore
  public Person getPerson() {
    return this.person;
  }

  /**
   * @param person person to set
   * @return PersonUpdate
   */
  public <T extends PersonUpdate> T setPerson(Person person) {
    this.person = person;
    return (T) this;
  }
}
