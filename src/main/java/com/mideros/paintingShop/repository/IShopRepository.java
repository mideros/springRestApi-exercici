package com.mideros.paintingShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mideros.paintingShop.dto.Shop;

public interface IShopRepository extends JpaRepository<Shop, Integer> {

}
