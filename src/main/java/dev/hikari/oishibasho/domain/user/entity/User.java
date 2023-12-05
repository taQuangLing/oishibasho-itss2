package dev.hikari.oishibasho.domain.user.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "users")
@Builder
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String address;

    private Boolean gender;

    private String name;

    private String avatar;

    @Column(name = "role_id")
    private Integer roleId;
}