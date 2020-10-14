package com.mideros.paintingShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mideros.paintingShop.dto.Painting;
import com.mideros.paintingShop.dto.Shop;

public interface IPaintingRepository extends JpaRepository<Painting, Integer> {

	List<Painting> getPaintingByShop(Shop shop);

	@Transactional
	public void deletePaintingByShop(Shop shop);

}
