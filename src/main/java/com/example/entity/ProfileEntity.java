package com.example.entity;

import com.example.enums.ProfileRole;
import com.example.enums.ProfileStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "profile")
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String email;


    @Column
    private String password;

    @Column(name = "photo_id")
    private String attachId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "photo_id", insertable = false, updatable = false)
    private AttachEntity attach;

    @Column
    @Enumerated(EnumType.STRING)
    private ProfileRole role;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)

    private ProfileStatus status;
    @Column
    private Boolean visible;



}

