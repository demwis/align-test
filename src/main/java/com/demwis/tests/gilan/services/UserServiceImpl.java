package com.demwis.tests.gilan.services;

import com.demwis.tests.gilan.dao.UserAuthorityRepository;
import com.demwis.tests.gilan.dao.UserRepository;
import com.demwis.tests.gilan.model.User;
import com.demwis.tests.gilan.model.UserDetailsWrapper;
import one.util.streamex.StreamEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserAuthorityRepository userAuthorityRepository;

    public UserServiceImpl(@Autowired UserRepository userRepository,
                           @Autowired UserAuthorityRepository userAuthorityRepository) {
        this.userRepository = userRepository;
        this.userAuthorityRepository = userAuthorityRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findById(username)
                .map(user -> new UserDetailsWrapper(user, loadUserAuthorities(user)))
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User wasn't found by name %s", username)));
    }

    private Collection<? extends GrantedAuthority> loadUserAuthorities(User user) {
        return StreamEx.of(userAuthorityRepository.findAllByUserId(user.getId()))
                .map(it -> new SimpleGrantedAuthority(it.getAuthorityId()))
                .toList();
    }
}
