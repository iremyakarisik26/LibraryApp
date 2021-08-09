package com.libraryapp.libraryapp.dto;

import com.libraryapp.libraryapp.entities.Magazine;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})

public class MagazineDto implements Serializable {
    @NonNull
    Long id;

    @NonNull
    String magazineName;

    @NonNull
    String magazineAuthor;

    @NonNull
    String magazineMonth;

    @NonNull
    String magazinePage;

    public static MagazineDto of(Magazine magazine){
        return new MagazineDto(magazine.getId(), magazine.getMagazineName(), magazine.getMagazineAuthor(), magazine.getMagazineMonth(), magazine.getMagazinePage());
    }
}
