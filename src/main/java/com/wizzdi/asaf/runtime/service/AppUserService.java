package com.wizzdi.asaf.runtime.service;

import com.wizzdi.asaf.runtime.data.AppUserRepository;
import com.wizzdi.asaf.runtime.model.AppUser;
import com.wizzdi.asaf.runtime.model.AppUser_;
import com.wizzdi.asaf.runtime.request.AppUserCreate;
import com.wizzdi.asaf.runtime.request.AppUserFilter;
import com.wizzdi.asaf.runtime.request.AppUserUpdate;
import com.wizzdi.asaf.runtime.response.PaginationResponse;
import com.wizzdi.asaf.runtime.security.UserSecurityContext;
import jakarta.persistence.metamodel.SingularAttribute;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class AppUserService {

  @Autowired private AppUserRepository repository;

  @Autowired private PasswordEncoder passwordEncoder;

  /**
   * @param appUserCreate Object Used to Create AppUser
   * @param securityContext
   * @return created AppUser
   */
  public AppUser createAppUser(AppUserCreate appUserCreate, UserSecurityContext securityContext) {
    AppUser appUser = createAppUserNoMerge(appUserCreate, securityContext);
    this.repository.merge(appUser);
    return appUser;
  }

  /**
   * @param appUserCreate Object Used to Create AppUser
   * @param securityContext
   * @return created AppUser unmerged
   */
  public AppUser createAppUserNoMerge(
      AppUserCreate appUserCreate, UserSecurityContext securityContext) {
    AppUser appUser = new AppUser();
    appUser.setId(UUID.randomUUID().toString());
    updateAppUserNoMerge(appUser, appUserCreate);

    return appUser;
  }

  /**
   * @param appUserCreate Object Used to Create AppUser
   * @param appUser
   * @return if appUser was updated
   */
  public boolean updateAppUserNoMerge(AppUser appUser, AppUserCreate appUserCreate) {
    boolean update = false;

    if (appUserCreate.getRoles() != null
        && (!appUserCreate.getRoles().equals(appUser.getRoles()))) {
      appUser.setRoles(appUserCreate.getRoles());
      update = true;
    }

    if (appUserCreate.getPassword() != null
        && (!passwordEncoder.matches(appUserCreate.getPassword(), appUser.getPassword()))) {
      appUser.setPassword(passwordEncoder.encode(appUserCreate.getPassword()));
      update = true;
    }

    if (appUserCreate.getUsername() != null
        && (!appUserCreate.getUsername().equals(appUser.getUsername()))) {
      appUser.setUsername(appUserCreate.getUsername());
      update = true;
    }

    return update;
  }

  /**
   * @param appUserUpdate
   * @param securityContext
   * @return appUser
   */
  public AppUser updateAppUser(AppUserUpdate appUserUpdate, UserSecurityContext securityContext) {
    AppUser appUser = appUserUpdate.getAppUser();
    if (updateAppUserNoMerge(appUser, appUserUpdate)) {
      this.repository.merge(appUser);
    }
    return appUser;
  }

  /**
   * @param appUserFilter Object Used to List AppUser
   * @param securityContext
   * @return PaginationResponse<AppUser> containing paging information for AppUser
   */
  public PaginationResponse<AppUser> getAllAppUsers(
      AppUserFilter appUserFilter, UserSecurityContext securityContext) {
    List<AppUser> list = listAllAppUsers(appUserFilter, securityContext);
    long count = this.repository.countAllAppUsers(appUserFilter, securityContext);
    return new PaginationResponse<>(list, appUserFilter.getPageSize(), count);
  }

  /**
   * @param appUserFilter Object Used to List AppUser
   * @param securityContext
   * @return List of AppUser
   */
  public List<AppUser> listAllAppUsers(
      AppUserFilter appUserFilter, UserSecurityContext securityContext) {
    return this.repository.listAllAppUsers(appUserFilter, securityContext);
  }

  public AppUser deleteAppUser(String id, UserSecurityContext securityContext) {
    AppUser appUser =
        this.repository.getByIdOrNull(AppUser.class, AppUser_.id, id, securityContext);
    ;
    if (appUser == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "AppUser not found");
    }

    this.repository.remove(appUser);

    return appUser;
  }

  public <T, I> List<T> listByIds(
      Class<T> c,
      SingularAttribute<? super T, I> idField,
      Set<I> ids,
      UserSecurityContext securityContext) {
    return repository.listByIds(c, idField, ids, securityContext);
  }

  public <T, I> T getByIdOrNull(
      Class<T> c,
      SingularAttribute<? super T, I> idField,
      I id,
      UserSecurityContext securityContext) {
    return repository.getByIdOrNull(c, idField, id, securityContext);
  }

  public <T, I> T getByIdOrNull(Class<T> c, SingularAttribute<? super T, I> idField, I id) {
    return repository.getByIdOrNull(c, idField, id);
  }

  public <T, I> List<T> listByIds(Class<T> c, SingularAttribute<? super T, I> idField, Set<I> ids) {
    return repository.listByIds(c, idField, ids);
  }

  public void merge(java.lang.Object base) {
    this.repository.merge(base);
  }

  public void massMerge(List<?> toMerge) {
    this.repository.massMerge(toMerge);
  }
}
