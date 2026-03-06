package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity;

import com.lemondeperdu.Le.Monde.Perdu.metier.model.Periodes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Types;
import java.util.List;

@Entity
@Table(name="dinosaures")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DinosaureEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "uuid2")
    @Column(name = "id")
    String id;

    String nom;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "id_types")
    TypesEntity typesEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "id_periode")
    PeriodesEntity periodesEntity;

    String taille;

    String poid;

    String description;

    @Column(length = 500)
    String url;


}
