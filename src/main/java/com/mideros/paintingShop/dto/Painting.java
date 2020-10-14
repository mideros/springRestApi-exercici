package com.mideros.paintingShop.dto;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "painting")
public class Painting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_painting")
	private int id_painting;

	@Column(name = "name_painting", nullable = false, length = 255, unique = true)
	@NotNull
	@NotEmpty(message = "Name must not be empty")
	@Size(min = 2, max = 255, message = "Name should have atleast 2 characters")
	private String name_painting;

	@Column(name = "price_painting")
	private double price_painting;

	@Column(name = "entry_date_painting")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date entry_date_painting;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;

	@ManyToOne
	@JoinColumn(name = "shop_id")
	private Shop shop;

	public Painting() {

	}

	public Painting(String name_painting, double price_painting, Author author, Shop shop) {

		this.name_painting = name_painting;
		this.price_painting = price_painting;
		this.author = author;
		this.shop = shop;
	}

	public Painting(String name_painting, double price_painting, Date entry_date_painting, Author author, Shop shop) {

		this.name_painting = name_painting;
		this.price_painting = price_painting;
		this.entry_date_painting = entry_date_painting;
		this.author = author;
		this.shop = shop;
	}

	public int getId_painting() {
		return id_painting;
	}

	public void setId_painting(int id_painting) {
		this.id_painting = id_painting;
	}

	public String getName_painting() {
		return name_painting;
	}

	public void setName_painting(String name_painting) {
		this.name_painting = name_painting;
	}

	public double getPrice_painting() {
		return price_painting;
	}

	public void setPrice_painting(double price_painting) {
		this.price_painting = price_painting;
	}

	public Date getEntry_date_painting() {
		return entry_date_painting;
	}

	public void setEntry_date_painting(Date entry_date_painting) {
		this.entry_date_painting = entry_date_painting;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((name_painting == null) ? 0 : name_painting.hashCode());
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
		Painting other = (Painting) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (author.getIdAuthor() != (other.author.getIdAuthor()))
			return false;
		if (name_painting == null) {
			if (other.name_painting != null)
				return false;
		} else if (!name_painting.equals(other.name_painting))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Painting [id_painting=" + id_painting + ", name_painting=" + name_painting + ", price_painting="
				+ price_painting + ", entry_date_painting=" + entry_date_painting + ", author=" + author + ", shop="
				+ shop + "]";
	}

}
