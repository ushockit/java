package org.itstep.services;

import org.itstep.entities.Role;
import org.itstep.entities.User;
import org.itstep.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.UUID;

@Service
public class UsersService implements UserDetailsService {
    private final UsersRepository usersRepos;
    private final MailSenderService mailSenderService;

    public UsersService(UsersRepository usersRepos, MailSenderService mailSenderService) {
        this.usersRepos = usersRepos;
        this.mailSenderService = mailSenderService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return usersRepos.findUserByUsername(s);
    }

    public Iterable<User> findAll() {
        return this.usersRepos.findAll();
    }

    public void update(User user) {
        usersRepos.save(user);
    }

    public User findByUsername(String username) {
        return this.usersRepos.findUserByUsername(username);
    }

    public boolean addNewUser(User user) {
        var srchUser = this.loadUserByUsername(user.getUsername());
        if (srchUser == null) {

            user.setActivateCode(UUID.randomUUID().toString());
            user.setActive(true);
            user.setRoles(Collections.singleton(Role.USER));
            usersRepos.save(user);

            //email не пуст
            if (!StringUtils.isEmpty(user.getEmail())) {
                String message = String.format("%s, welcome to .... Please visit link for activate your account: http://localhost:8080/auth/activate/%s",
                        user.getUsername(), user.getActivateCode());
                mailSenderService.send(user.getEmail(), "Hello", message);
            }

            return true;
        }
        return false;
    }

    public User findByActivateCode(String code) {
        return this.usersRepos.findUserByActivateCode(code);
    }

    public boolean activateUser(String code) {
        User user = findByActivateCode(code);

        if (user == null) {
            return false;
        }

        user.setActivateCode(null);
        usersRepos.save(user);
        return true;
    }
}
