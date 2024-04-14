package com.wizzdi.asaf.runtime.request;

import jakarta.validation.constraints.Min;
import java.time.OffsetDateTime;
import java.util.Set;

/** Object Used to List Person */
public class PersonFilter {

  private Set<String> address;

  private OffsetDateTime birthDateEnd;

  private OffsetDateTime birthDateStart;

  @Min(value = 0)
  private Integer currentPage;

  private Set<String> id;

  @Min(value = 1)
  private Integer pageSize;

  /**
   * @return address
   */
  public Set<String> getAddress() {
    return this.address;
  }

  /**
   * @param address address to set
   * @return PersonFilter
   */
  public <T extends PersonFilter> T setAddress(Set<String> address) {
    this.address = address;
    return (T) this;
  }

  /**
   * @return birthDateEnd
   */
  public OffsetDateTime getBirthDateEnd() {
    return this.birthDateEnd;
  }

  /**
   * @param birthDateEnd birthDateEnd to set
   * @return PersonFilter
   */
  public <T extends PersonFilter> T setBirthDateEnd(OffsetDateTime birthDateEnd) {
    this.birthDateEnd = birthDateEnd;
    return (T) this;
  }

  /**
   * @return birthDateStart
   */
  public OffsetDateTime getBirthDateStart() {
    return this.birthDateStart;
  }

  /**
   * @param birthDateStart birthDateStart to set
   * @return PersonFilter
   */
  public <T extends PersonFilter> T setBirthDateStart(OffsetDateTime birthDateStart) {
    this.birthDateStart = birthDateStart;
    return (T) this;
  }

  /**
   * @return currentPage
   */
  public Integer getCurrentPage() {
    return this.currentPage;
  }

  /**
   * @param currentPage currentPage to set
   * @return PersonFilter
   */
  public <T extends PersonFilter> T setCurrentPage(Integer currentPage) {
    this.currentPage = currentPage;
    return (T) this;
  }

  /**
   * @return id
   */
  public Set<String> getId() {
    return this.id;
  }

  /**
   * @param id id to set
   * @return PersonFilter
   */
  public <T extends PersonFilter> T setId(Set<String> id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return pageSize
   */
  public Integer getPageSize() {
    return this.pageSize;
  }

  /**
   * @param pageSize pageSize to set
   * @return PersonFilter
   */
  public <T extends PersonFilter> T setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return (T) this;
  }
}
