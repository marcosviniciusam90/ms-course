package com.devsuperior.hroauth.entities;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Role implements Serializable {

    private Long id;

    @EqualsAndHashCode.Include
    private String roleName;

}
