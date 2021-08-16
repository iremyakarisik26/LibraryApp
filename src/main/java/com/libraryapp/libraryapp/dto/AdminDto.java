package com.libraryapp.libraryapp.dto;

import com.libraryapp.libraryapp.entities.Admin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class AdminDto implements Serializable {
    Long id;
    String adminMail;
    String adminPassword;

    public static AdminDto of (Admin admin){
        return new AdminDto(admin.getId(), admin.getAdminMail(), admin.getAdminPassword());
    }
}
