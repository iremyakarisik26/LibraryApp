package com.libraryapp.libraryapp.repos;

import com.libraryapp.libraryapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {


    //Query doldurulacak.
    @Query()
    User findByMail(String mail);
}
