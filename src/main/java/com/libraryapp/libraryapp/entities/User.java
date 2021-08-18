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
	String role;

	private User (String userMail, String userPassword, String role){
		this.userMail = userMail;
		this.userPassword = userPassword;
		this.role = role;
	}

	public static User of (UserDto userDto){
		return new User(userDto.getUserMail(),userDto.getUserPassword(),userDto.getRole());
	}




}
