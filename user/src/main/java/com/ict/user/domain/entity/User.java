package com.ict.user.domain.entity;

import com.ict.user.common.abstracts.BaseEntity;
import com.ict.user.domain.enums.Country;
import com.ict.user.domain.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String mobileNumber;

    @Column(nullable = false)
    private LocalDate dob;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    private String hobbies;

    @Enumerated(EnumType.STRING)
    private Country country;

    @Column(length = 1000, nullable = false)
    private String address;

}
