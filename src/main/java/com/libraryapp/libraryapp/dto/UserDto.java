package com.libraryapp.libraryapp.dto;

import com.libraryapp.libraryapp.entities.User;
import lombok.*;

import javax.persistence.Id;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class UserDto implements Serializable {

    Long id;
    String userMail;
    String userPassword;
    String role;
    //String role;//Admin veya User

    public static UserDto of (User user){
        return new UserDto(user.getId(),user.getUserMail(),user.getUserPassword(),user.getRole());
    }

}
