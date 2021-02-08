package com.ba.jwt.auth;

import com.ba.jwt.dto.Users;
import com.ba.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class UserDetailService implements UserDetailsService {

    private Map<String,String> users= new HashMap<>();

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users=userRepository.findByUsername(username);
        if(users== null){
            throw new UsernameNotFoundException(username);
        }
        return new User(users.getUsername(), bCryptPasswordEncoder.encode(users.getPassword()), Collections.emptyList());
    }
}
