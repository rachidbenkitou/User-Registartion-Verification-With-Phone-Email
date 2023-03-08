package com.bokito.verification.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;
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
    private Collection<Role> roles= new ArrayList<>();
}
