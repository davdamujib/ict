package com.ict.user.domain.dto;

import com.ict.user.domain.entity.User;
import com.ict.user.domain.enums.Country;
import com.ict.user.domain.enums.Gender;
import com.ict.user.domain.enums.Hobbies;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name Must Be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email Should be valid")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age Must Be at least 18")
    @Max(value = 100, message = "Age Must Be Less than 100")
    private Integer age;

    @NotBlank(message = "Mobile Number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String mobileNumber;

    @NotNull(message = "Date Of Birth is required")
    private LocalDate dob;

    @NotNull(message = "Gender is required")
    private Gender gender;

    @NotNull(message = "Hobbies is required")
    private String hobbies;

    @NotNull(message = "Country is required")
    private Country country;

    @NotBlank(message = "Address is required")
    @Size(min = 5, max = 100, message = "Address Must Be between 5 and 100 characters")
    private String address;

    public static User request(UserRequestDto requestDto){
        return User.builder()
                .name(requestDto.name)
                .email(requestDto.getEmail())
                .password(requestDto.getPassword())
                .age(requestDto.getAge())
                .mobileNumber(requestDto.getMobileNumber())
                .dob(requestDto.getDob())
                .gender(requestDto.getGender())
                .hobbies(requestDto.getHobbies())
                .country(requestDto.getCountry())
                .address(requestDto.getAddress())
                .build();
    }

    public static void updateUser(User user, UserRequestDto requestDto){

        if (requestDto.getName() != null){
            user.setName(requestDto.getName());
        }

        if (requestDto.getEmail() != null){
            user.setEmail(requestDto.getEmail());
        }

        if (requestDto.getPassword() != null){
            user.setPassword(requestDto.getPassword());
        }

        if (requestDto.getAge() != null){
            user.setAge(requestDto.getAge());
        }

        if (requestDto.getMobileNumber() != null){
            user.setMobileNumber(requestDto.getMobileNumber());
        }

        if (requestDto.getDob() != null){
            user.setDob(requestDto.getDob());
        }

        if (requestDto.getGender() != null){
            user.setGender(requestDto.getGender());
        }

        if (requestDto.getHobbies() != null){
            user.setHobbies(requestDto.getHobbies());
        }

        if (requestDto.getCountry() != null){
            user.setCountry(requestDto.getCountry());
        }

        if (requestDto.getAddress() != null){
            user.setAddress(requestDto.getAddress());
        }
    }
}
