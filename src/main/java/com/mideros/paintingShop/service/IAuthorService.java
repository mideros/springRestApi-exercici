package com.mideros.paintingShop.service;

import java.util.List;

import com.mideros.paintingShop.dto.Author;

public interface IAuthorService {

	public List<Author> listAuthor();

	public Author saveAuthor(Author author);

	public Author getAuthorById(int idAuthor);

	public Author updateAuthor(Author author);

	public void deleteAuthor(int idAuthor);

}
