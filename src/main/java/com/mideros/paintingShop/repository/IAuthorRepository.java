package com.mideros.paintingShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mideros.paintingShop.dto.Author;

public interface IAuthorRepository extends JpaRepository<Author, Integer> {

}
