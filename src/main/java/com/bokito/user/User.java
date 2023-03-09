package com.bokito.user;

import com.bokito.role.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.EAGER;


@Entity
@Data // Gives Getters and Setters
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String usenrame;
    private String password;
    @ManyToMany(fetch =EAGER)
    private List<Role> roles= new ArrayList<>();
}
