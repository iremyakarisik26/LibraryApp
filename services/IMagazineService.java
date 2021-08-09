package com.libraryapp.libraryapp.services;

import com.libraryapp.libraryapp.dto.MagazineDto;
import com.libraryapp.libraryapp.entities.Magazine;

import java.util.List;

public interface IMagazineService {
    List<MagazineDto> getAllMagazines();
    void saveMagazines(MagazineDto newMagazine);
}
