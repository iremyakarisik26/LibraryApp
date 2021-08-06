package com.libraryapp.libraryapp.entities;

import javax.persistence.*;

import com.libraryapp.libraryapp.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="user")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"userMail"})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String userMail;
	String userPassword;

	private User (String userMail, String userPassword){
		this.userMail = userMail;
		this.userPassword = userPassword;
	}

	public static User of (UserDto userDto){
		return new User(userDto.getUserMail(),userDto.getUserPassword());
	}




}
