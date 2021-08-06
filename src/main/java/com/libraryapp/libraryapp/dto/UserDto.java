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
    //jwt token
    //stream
   //spring security
    Long id;
    String userMail;
    String userPassword;

    public static UserDto of (User user){
        return new UserDto(user.getId(),user.getUserMail(),user.getUserPassword());
    }
}
