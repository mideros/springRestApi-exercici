package com.mideros.paintingShop.dto;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "shop")
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_shop")
	private int idShop;

	@Column(name = "name_shop", nullable = false, length = 255, unique = true)
	@NotEmpty(message = "Name must not be empty")
	@NotBlank(message = "Name must not be blank")
	@Size(min = 3, max = 255, message = "Name  must be between 3 and 255 characters")
	private String nameShop;

	@Column(name = "max_capacity_shop")
	@NotNull
	@Min(value = 2, message = "the maxim capacity Shop should not be less than 2")
	@Max(value = 500, message = "the maxim capacity Shop should not be greater than 150")
	@Positive(message = "the maxim capacity Shop should be a positive number")
	private int maxCapacityShop;

	@OneToMany
	@JoinColumn(name = "shop_id")
	private List<Painting> paintingList;

	public Shop() {
	}

	public Shop(String nameShop, int maxCapacityShop) {

		this.nameShop = nameShop;
		this.maxCapacityShop = maxCapacityShop;
	}

	public Shop(int idShop, String nameShop, int maxCapacityShop) {

		this.idShop = idShop;
		this.nameShop = nameShop;
		this.maxCapacityShop = maxCapacityShop;
	}

	public int getIdShop() {
		return idShop;
	}

	public void setIdShop(int idShop) {
		this.idShop = idShop;
	}

	public String getNameShop() {
		return nameShop;
	}

	public void setNameShop(String nameShop) {
		this.nameShop = nameShop;
	}

	public int getMaxCapacityShop() {
		return maxCapacityShop;
	}

	public void setMaxCapacityShop(int maxCapacityShop) {
		this.maxCapacityShop = maxCapacityShop;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Painting")
	public List<Painting> getListPainting() {
		return paintingList;
	}

	public void setListPainting(List<Painting> paintingList) {
		this.paintingList = paintingList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maxCapacityShop;
		result = prime * result + ((nameShop == null) ? 0 : nameShop.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shop other = (Shop) obj;
		if (maxCapacityShop != other.maxCapacityShop)
			return false;
		if (nameShop == null) {
			if (other.nameShop != null)
				return false;
		} else if (!nameShop.equals(other.nameShop))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Shop [idShop=" + idShop + ", nameShop=" + nameShop + ", maxCapacityShop=" + maxCapacityShop + "]";
	}

}