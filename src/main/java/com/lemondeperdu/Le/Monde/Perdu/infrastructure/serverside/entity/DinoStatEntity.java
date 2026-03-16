package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="stats_battle")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DinoStatEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="id")
        private Long id;

        @ManyToOne
        @JoinColumn(name = "id_dino")
        private DinosaureEntity dinosaure;

        private int niveau;

        private int attaque;

        @Column(name="resistance_physique")
        private int resistancePhysique;

        private int vie;

        @Column(name="chance_critique")
        private int chanceCritique;

        @ManyToOne
        @JoinColumn(name="id_faiblesse")
        private TypesEntity faiblesse;

        @ManyToOne
        @JoinColumn(name="id_resistance")
        private TypesEntity resistance;

        @ManyToOne
        @JoinColumn(name="id_force")
        private TypesEntity force;


}
