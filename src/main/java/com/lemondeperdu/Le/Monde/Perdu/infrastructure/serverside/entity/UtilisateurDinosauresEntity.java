package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="utilisateur_dinosaure")
public class UtilisateurDinosauresEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_user")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name="id_dino")
    private DinosaureEntity dinosaures;
}
