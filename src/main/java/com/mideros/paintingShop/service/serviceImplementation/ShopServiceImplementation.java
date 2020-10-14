package com.mideros.paintingShop.service.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mideros.paintingShop.dto.Shop;
import com.mideros.paintingShop.repository.IShopRepository;
import com.mideros.paintingShop.service.IShopService;


@Service
public class ShopServiceImplementation implements IShopService{
	
	
	@Autowired
	IShopRepository shopRepository;

	public ShopServiceImplementation(IShopRepository storeRepository) {	
		this.shopRepository = storeRepository;
	}

	@Override
	public List<Shop> listShop() {
		
		return shopRepository.findAll();
	}

	@Override
	public Shop saveShop(Shop shop) {
		return shopRepository.save(shop);
	}

	@Override
	public Shop getShopById(int idShop) {
		return shopRepository.findById(idShop).get();
	}

	@Override
	public Shop updateShop(Shop shop) {
		
		return shopRepository.save(shop);
	}

	@Override
	public void deleteShop(int idShop) {
		
		shopRepository.deleteById(idShop);
	}
		

}