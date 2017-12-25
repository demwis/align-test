package com.demwis.tests.gilan.dao;

import com.demwis.tests.gilan.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
