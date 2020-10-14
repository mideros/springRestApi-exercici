package com.mideros.paintingShop.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mideros.paintingShop.dto.Author;
import com.mideros.paintingShop.exception.ResourceNotFoundException;
import com.mideros.paintingShop.service.IAuthorService;

@RestController
@RequestMapping("/v1/shops/painting")
public class AuthorController {

	@Autowired
	private IAuthorService authorService;

	@GetMapping("/authors")
	public List<Author> listAuthor() {
		return authorService.listAuthor();
	}

	@PostMapping("/authors")
	public ResponseEntity<Author> addAuthor(@Valid @RequestBody Author author) {

		try {

			List<Author> listA = authorService.listAuthor();

			if (author.getAnonymousAuthor()) {
				author.setNameAuthor("ANONYMOUS");
			}

			String nAuthor = author.getNameAuthor().toUpperCase();

			author.setNameAuthor(nAuthor);

			if (listA.contains(author)) {
				return new ResponseEntity<Author>(HttpStatus.BAD_REQUEST);

			} else {
				Author au = authorService.saveAuthor(author);
				return new ResponseEntity<Author>(au, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<Author>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/authors/{id}")
	public ResponseEntity<Author> getAuthorById(@PathVariable(value = "id") int idAuthor) {

		Author sById = authorService.getAuthorById(idAuthor);

		return new ResponseEntity<Author>(sById, HttpStatus.OK);
	}

	@PutMapping("/authors/{id}")
	public ResponseEntity<Author> updateAuthor(@PathVariable(value = "id") int idAuthor,
			@Valid @RequestBody Author author) throws ResourceNotFoundException {

		Author oldDataAuthor = new Author();
		Author newDataAuthor = new Author();
		List<Author> listAUp = authorService.listAuthor();
		String nAuthor = author.getNameAuthor().toUpperCase();
		oldDataAuthor = authorService.getAuthorById(idAuthor);

		if (author.getAnonymousAuthor()) {
			author.setNameAuthor("ANONYMOUS");
		}

		author.setNameAuthor(nAuthor);

		if (listAUp.contains(author)) {
			return new ResponseEntity<Author>(HttpStatus.BAD_REQUEST);

		} else {

			oldDataAuthor.setNameAuthor(author.getNameAuthor().toUpperCase());
			oldDataAuthor.setAnonymousAuthor(author.getAnonymousAuthor());
			newDataAuthor = authorService.updateAuthor(oldDataAuthor);
			return new ResponseEntity<Author>(newDataAuthor, HttpStatus.OK);
		}
	}

	@DeleteMapping("/authors/{id}")
	public ResponseEntity<Void> deleteAuthor(@PathVariable(value = "id") int idAuthor)
			throws ResourceNotFoundException {
		authorService.deleteAuthor(idAuthor);
		return ResponseEntity.noContent().build();
	}
}
