package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity;


import com.lemondeperdu.Le.Monde.Perdu.metier.model.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "uuid2")
    @Column(name = "id_user")
    private String idUser;

    private String email;

    private String pseudo;

    private String genre;

    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;


}
