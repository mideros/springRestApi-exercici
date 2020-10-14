package com.mideros.paintingShop.service.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mideros.paintingShop.dto.Painting;
import com.mideros.paintingShop.dto.Shop;
import com.mideros.paintingShop.repository.IPaintingRepository;
import com.mideros.paintingShop.service.IPaintingService;

@Service
public class PaintingServiceImplementation implements IPaintingService {

	@Autowired
	IPaintingRepository paintingRepository;

	public PaintingServiceImplementation(IPaintingRepository paintingRepository) {
		this.paintingRepository = paintingRepository;
	}

	@Override
	public List<Painting> listPainting() {

		return paintingRepository.findAll();
	}

	@Override
	public Painting savePainting(Painting painting) {	

		return paintingRepository.save(painting);
	}

	@Override
	public Painting getPaintingById(int idPainting) {
		return paintingRepository.findById(idPainting).get();
	}

	@Override
	public Painting updatePainting(Painting painting) {

		return paintingRepository.save(painting);
	}

	@Override
	public void deletePainting(int idPainting) {

		paintingRepository.deleteById(idPainting);

	}

	@Override
	public List<Painting> getPaintingByShop(Shop shop) {
		return paintingRepository.getPaintingByShop(shop);
	}

	@Override
	public void deletePaintingByShop(Shop shop) {

		paintingRepository.deletePaintingByShop(shop);
	}

}