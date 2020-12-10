package org.itstep.services;

import org.itstep.entities.Role;
import org.itstep.entities.User;
import org.itstep.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UsersService implements UserDetailsService {
    private final PasswordEncoder pswdEncoder;

    private final UsersRepository usersRepos;

    public UsersService(UsersRepository usersRepos, @Lazy PasswordEncoder pswdEncoder) {
        this.usersRepos = usersRepos;
        this.pswdEncoder = pswdEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return usersRepos.findUserByUsername(s);
    }

    public void registrationUser(User user) {

        String hash = pswdEncoder.encode(user.getPassword());
        user.setPassword(hash);
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        usersRepos.save(user);
    }
}
