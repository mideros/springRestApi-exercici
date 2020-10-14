package com.mideros.paintingShop.service;

import java.util.List;

import com.mideros.paintingShop.dto.Painting;
import com.mideros.paintingShop.dto.Shop;

public interface IPaintingService {

	public List<Painting> listPainting(); 
	
	public Painting savePainting(Painting painting);
	
	public Painting getPaintingById(int idPainting);
	
	public Painting updatePainting(Painting painting); 
	
	public void deletePainting(int idPainting);	
	
	List<Painting> getPaintingByShop(Shop shop);
	
	public void deletePaintingByShop(Shop shop);		
	
}
