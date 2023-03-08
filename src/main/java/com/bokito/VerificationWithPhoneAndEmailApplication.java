package com.bokito;

import com.bokito.role.Role;
import com.bokito.role.RoleRepository;
import com.bokito.user.User;
import com.bokito.user.UserRepository;
import com.bokito.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class VerificationWithPhoneAndEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(VerificationWithPhoneAndEmailApplication.class, args);
    }
    @Bean
    CommandLineRunner run(UserService userService, UserRepository userRepository, RoleRepository roleRepository){
        return args -> {

            userService.deletUsers();
            userService.deleteRoles();

            userService.saveRole(new Role(null,"Role_USER"));
            userService.saveRole(new Role(null,"Role_MANAGER"));
            userService.saveRole(new Role(null,"Role_ADMIN"));
            userService.saveRole(new Role(null,"Role_SUPER_ADMIN"));

            userService.saveUser(new User(null,"Rachid","rachid2024","1234",new ArrayList<>()));
            userService.saveUser(new User(null,"Riduane","rachid202","1234",new ArrayList<>()));
            userService.saveUser(new User(null,"Fatima","rachid20","1234",new ArrayList<>()));
            userService.saveUser(new User(null,"Fozia","rachi","1234",new ArrayList<>()));


            userService.addRoleToUser("rachid2024","Role_SUPER_ADMIN");
            userService.addRoleToUser("rachid2024","Role_ADMIN");

        };
    }

}
