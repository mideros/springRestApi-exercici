package com.mideros.paintingShop.service.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mideros.paintingShop.dto.Author;
import com.mideros.paintingShop.repository.IAuthorRepository;
import com.mideros.paintingShop.service.IAuthorService;

@Service
public class AuthorServiceImplementation implements IAuthorService {

	@Autowired
	IAuthorRepository authorRepository;

	public AuthorServiceImplementation(IAuthorRepository authorRepository) {

		this.authorRepository = authorRepository;
	}

	@Override
	public List<Author> listAuthor() {

		return authorRepository.findAll();
	}

	@Override
	public Author saveAuthor(Author author) {

		return authorRepository.save(author);

	}

	@Override
	public Author getAuthorById(int idAuthor) {

		return authorRepository.findById(idAuthor).get();
	}

	@Override
	public Author updateAuthor(Author author) {

		return authorRepository.save(author);
	}

	@Override
	public void deleteAuthor(int idAuthor) {
		authorRepository.deleteById(idAuthor);

	}

}
