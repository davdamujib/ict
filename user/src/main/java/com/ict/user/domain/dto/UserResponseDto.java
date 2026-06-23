package com.ict.user.domain.dto;

import com.ict.user.domain.entity.User;
import com.ict.user.domain.enums.Country;
import com.ict.user.domain.enums.Gender;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {

    private Long id;

    private String name;

    private String email;

    private String password;

    private Integer age;

    private String mobileNumber;

    private LocalDate dob;

    private Gender gender;

    private String hobbies;

    private Country country;

    private String address;

    public static UserResponseDto response(User user){
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .age(user.getAge())
                .mobileNumber(user.getMobileNumber())
                .dob(user.getDob())
                .gender(user.getGender())
                .hobbies(user.getHobbies())
                .country(user.getCountry())
                .address(user.getAddress())
                .build();
    }

}
