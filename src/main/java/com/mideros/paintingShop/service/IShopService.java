package com.mideros.paintingShop.service;

import java.util.List;

import com.mideros.paintingShop.dto.Shop;

public interface IShopService {
	
public List<Shop> listShop(); 
	
	public Shop saveShop(Shop Shop);
	
	public Shop getShopById(int idShop);
	
	public Shop updateShop(Shop Shop); 
	
	public void deleteShop(int idShop);
	
}
