package com.libraryapp.libraryapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class DepositsDto implements Serializable {
    Long id;
    String issueDate;
    String deliveryDate;

}
