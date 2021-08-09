package com.libraryapp.libraryapp.dto;

import com.libraryapp.libraryapp.entities.Book;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
public class BookDto implements Serializable {
    @NonNull
    Long id;
    @NonNull
    String bookName;
    @NonNull
    String bookAuthor;
    @NonNull
    String bookPage;
    public static BookDto of (Book book){
        return new BookDto(book.getId(),book.getBookName(),book.getBookAuthor(),book.getBookPage());
    }

}
