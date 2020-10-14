package com.mideros.paintingShop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mideros.paintingShop.dto.Painting;
import com.mideros.paintingShop.exception.ResourceNotFoundException;
import com.mideros.paintingShop.service.IPaintingService;

@RestController
@RequestMapping("/v1/shops")
public class PaintingController {

	@Autowired
	private IPaintingService paintingService;

	@GetMapping("/paintings")
	public List<Painting> listPainting() {
		return paintingService.listPainting();
	}

	@PostMapping(value = { "/paintings" }, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Painting> addPainting(@Valid @RequestBody Painting painitng) {

		Painting pt = paintingService.savePainting(painitng);

		return new ResponseEntity<Painting>(pt, HttpStatus.OK);
	}

	@GetMapping("/paintings/{id}")
	public ResponseEntity<Painting> getPaintingById(@PathVariable(value = "id") int idPainting) {

		Painting pById = paintingService.getPaintingById(idPainting);

		return new ResponseEntity<Painting>(pById, HttpStatus.OK);
	}

	@PutMapping("/paintings/{id}")
	public ResponseEntity<Painting> updatePainting(@PathVariable(value = "id") int idPainting,
			@Valid @RequestBody Painting painting) throws ResourceNotFoundException {

		Painting oldDataPainting = new Painting();
		Painting newDataPainting = new Painting();

		oldDataPainting = paintingService.getPaintingById(idPainting);

		oldDataPainting.setName_painting(painting.getName_painting());
		oldDataPainting.setEntry_date_painting(painting.getEntry_date_painting());
		oldDataPainting.setPrice_painting(painting.getPrice_painting());
		oldDataPainting.setAuthor(painting.getAuthor());
		oldDataPainting.setShop(painting.getShop());

		newDataPainting = paintingService.updatePainting(oldDataPainting);

		return new ResponseEntity<Painting>(newDataPainting, HttpStatus.OK);

	}

	@DeleteMapping("/paintings/{id}")
	public ResponseEntity<Void> deletePainting(@PathVariable(value = "id") int idPainting)
			throws ResourceNotFoundException {
		paintingService.deletePainting(idPainting);
		return ResponseEntity.noContent().build();
	}

}
