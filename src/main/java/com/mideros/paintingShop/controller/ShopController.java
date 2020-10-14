package com.mideros.paintingShop.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.mideros.paintingShop.dto.Painting;
import com.mideros.paintingShop.dto.Shop;
import com.mideros.paintingShop.exception.ResourceNotFoundException;
import com.mideros.paintingShop.service.IPaintingService;
import com.mideros.paintingShop.service.IShopService;

@RestController
@RequestMapping("/v1")

public class ShopController {

	@Autowired
	private IShopService shopService;

	@Autowired
	private IPaintingService paintingService;

	@PostMapping(value = { "/shops" }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Shop> addShop(@Valid @RequestBody Shop shop) {

		try {

			List<Shop> listShops = shopService.listShop();

			String nShop = shop.getNameShop().toUpperCase();

			shop.setNameShop(nShop);

			if (listShops.contains(shop)) {
				return new ResponseEntity<Shop>(HttpStatus.BAD_REQUEST);

			} else {
				Shop sp = shopService.saveShop(shop);
				return new ResponseEntity<Shop>(sp, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<Shop>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = { "/shops" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Shop> listShop() {
		return shopService.listShop();
	}

	@PostMapping(value = { "/shops/{id}/paintings" }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Painting> addPaintingByShop(@PathVariable(value = "id") int idShop,
			@Valid @RequestBody Painting painting) {

		try {

			Shop sById = shopService.getShopById(idShop);

			List<Painting> listP = paintingService.getPaintingByShop(sById);

			String nPainting = painting.getName_painting().toUpperCase();

			painting.setName_painting(nPainting);
			painting.setShop(sById);

			if (paintingService.getPaintingByShop(sById).size() < sById.getMaxCapacityShop()) {

				if (listP.contains(painting)) {
					return new ResponseEntity<Painting>(HttpStatus.BAD_REQUEST);
				} else {
					Painting pt = paintingService.savePainting(painting);
					return new ResponseEntity<Painting>(pt, HttpStatus.OK);

				}
			} else {
				return new ResponseEntity<Painting>(HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {

			return new ResponseEntity<Painting>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = { "/shops/{id}/paintings" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Painting> getPaintingByShopById(@PathVariable(value = "id") int idShop)
			throws ResourceNotFoundException {

		Shop sById = shopService.getShopById(idShop);

		return paintingService.getPaintingByShop(sById);
	}

	@DeleteMapping("/shops/{id}/paintings")
	public ResponseEntity<Void> deleteShop(@PathVariable(value = "id") int idShop) throws ResourceNotFoundException {
		Shop sById = shopService.getShopById(idShop);

		paintingService.deletePaintingByShop(sById);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/shops/{id}")
	public ResponseEntity<Shop> updateShop(@PathVariable(value = "id") int idShop, @Valid @RequestBody Shop shop)
			throws ResourceNotFoundException {

		Shop oldDataShop = new Shop();
		Shop newDataShop = new Shop();

		oldDataShop = shopService.getShopById(idShop);
		oldDataShop.setNameShop(shop.getNameShop());
		oldDataShop.setMaxCapacityShop(shop.getMaxCapacityShop());

		newDataShop = shopService.updateShop(oldDataShop);

		return new ResponseEntity<Shop>(newDataShop, HttpStatus.OK);

	}
}