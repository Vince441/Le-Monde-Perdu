package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="periodes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeriodesEntity {


    @Id
    int id;
    String periode;


}
