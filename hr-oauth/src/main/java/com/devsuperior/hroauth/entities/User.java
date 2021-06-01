package com.devsuperior.hroauth.entities;

import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User implements Serializable {

    @EqualsAndHashCode.Include
    private Long id;

    private String name;


    private String email;

    private String password;

    @Setter(AccessLevel.NONE)
    private Set<Role> roles = new HashSet<>();

}
