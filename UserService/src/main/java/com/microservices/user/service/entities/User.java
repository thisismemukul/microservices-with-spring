package com.microservices.user.service.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="micro_user")
public class User {

    @Id
    @Column(name="ID")
    private String userId;
    @Column(name="NAME",nullable = false, length = 20)
    private String name;
    @Column(name = "EMAIL",nullable = false,length =20)
    private String email;
    @Column(name = "ABOUT",length = 70)
    private String about;
}
