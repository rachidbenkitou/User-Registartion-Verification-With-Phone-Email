package com.bokito.user.service;

import com.bokito.role.Role;
import com.bokito.role.RoleRepository;
import com.bokito.user.User;
import com.bokito.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
//@AllArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private RoleRepository roleRepo;
    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to the database", user.getName());
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        User user= userRepo.findByUsenrame(username);
        Role role= roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user {}", username);
        return userRepo.findByUsenrame(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users {}");
        return userRepo.findAll();
    }
    @Override
    public void deletUsers(){
        userRepo.deleteAll();
    }
    @Override
    public void deleteRoles(){
        roleRepo.deleteAll();
    }
}