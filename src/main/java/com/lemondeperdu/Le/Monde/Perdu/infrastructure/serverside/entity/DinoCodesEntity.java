package com.lemondeperdu.Le.Monde.Perdu.infrastructure.serverside.entity;

import com.lemondeperdu.Le.Monde.Perdu.metier.model.DinoCodes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="dino_codes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DinoCodesEntity {

    @Id
    String code;

    @OneToOne
    @JoinColumn(name="dinosaure_id")
    DinosaureEntity dinosaureEntity;

    @OneToOne
    @JoinColumn(name="used_by")
    UserEntity userEntity;

    @JoinColumn(name="used_at")
    private LocalDateTime usedAt;


}
