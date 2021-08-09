package com.libraryapp.libraryapp.dto;

import com.libraryapp.libraryapp.entities.Newspaper;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class NewspaperDto implements Serializable {
    @NonNull
    Long id;

    @NonNull
    String newspaperName;

    @NonNull
    String newspaperAuthor;

    @NonNull
    String newspaperDay;

    @NonNull
    String newspaperPage;

    public static NewspaperDto of (Newspaper newspaper){
        return new NewspaperDto(newspaper.getId(), newspaper.getNewspaperName(), newspaper.getNewspaperAuthor(), newspaper.getNewspaperDay(), newspaper.getNewspaperPage());
    }
}
