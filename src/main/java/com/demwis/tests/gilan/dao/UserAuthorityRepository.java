package com.demwis.tests.gilan.dao;

import com.demwis.tests.gilan.model.UserAuthority;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserAuthorityRepository extends CrudRepository<UserAuthority, UserAuthority.Pk> {
    List<UserAuthority> findAllByUserId(String userId);
}
