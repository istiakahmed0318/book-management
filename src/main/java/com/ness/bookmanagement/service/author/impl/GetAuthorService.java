package com.ness.bookmanagement.service.author.impl;

import com.ness.bookmanagement.dto.AuthorDTO;
import com.ness.bookmanagement.entity.AuthorEntity;
import com.ness.bookmanagement.respository.AuthorEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.ness.bookmanagement.service.author.AuthorUtil.authorNotFoundException;

@Service
class GetAuthorService {
    private final AuthorEntityRepository authorEntityRepository;

    @Autowired
    GetAuthorService(AuthorEntityRepository authorEntityRepository) {
        this.authorEntityRepository = authorEntityRepository;
    }

    public List<AuthorDTO> getAllAuthors() {
        List<AuthorEntity> authorEntities = authorEntityRepository.findAll();
        return authorEntities.stream()
                .map(AuthorDTO::buildDTO)
                .collect(Collectors.toList());
    }


    public AuthorDTO getAuthorById(Long id) {
        AuthorEntity authorEntity = authorEntityRepository.findById(id)
                .orElseThrow(authorNotFoundException(id));
        return AuthorDTO.buildDTO(authorEntity);
    }


}
