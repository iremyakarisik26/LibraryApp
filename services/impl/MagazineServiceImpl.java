package com.libraryapp.libraryapp.services.impl;

import com.libraryapp.libraryapp.dto.BookDto;
import com.libraryapp.libraryapp.dto.MagazineDto;
import com.libraryapp.libraryapp.entities.Book;
import com.libraryapp.libraryapp.entities.Magazine;
import com.libraryapp.libraryapp.repos.MagazineRepository;
import com.libraryapp.libraryapp.services.IMagazineService;

import java.util.List;
import java.util.stream.Collectors;

public class MagazineServiceImpl implements IMagazineService {

    private MagazineRepository magazineRepository;
    public MagazineServiceImpl(MagazineRepository magazineRepository){this.magazineRepository=magazineRepository;}


    @Override
    public List<MagazineDto> getAllMagazines() {
        return magazineRepository.findAll().stream()
                .map(MagazineDto::of)
                .collect(Collectors.toList());
    }
    @Override
    public void saveMagazines(MagazineDto newMagazine){
        magazineRepository.save(Magazine.of(newMagazine));
    }

}
