package com.mideros.paintingShop.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "author")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_author")
	private int idAuthor;

	@Column(name = "name_author", length = 255, unique = true)
	@Size(min = 3, max = 255, message = "Name  must be between 3 and 255 characters")
	private String nameAuthor;

	@Column(name = "anonymous_author", columnDefinition = "tinyint default false")
	private boolean anonymousAuthor;

	@OneToMany
	@JoinColumn(name = "author_id")
	private List<Painting> paintingList;

	public Author() {

	}

	public Author(boolean anonymousAuthor) {

		this.anonymousAuthor = anonymousAuthor;
	}

	public Author(String nameAuthor, boolean anonymousAuthor) {

		this.nameAuthor = nameAuthor;
		this.anonymousAuthor = anonymousAuthor;
	}

	public Author(int idAuthor, String nameAuthor, boolean anonymousAuthor) {

		this.idAuthor = idAuthor;
		this.nameAuthor = nameAuthor;
		this.anonymousAuthor = anonymousAuthor;
	}

	public int getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(int idAuthor) {
		this.idAuthor = idAuthor;
	}

	public String getNameAuthor() {
		return nameAuthor;
	}

	public void setNameAuthor(String nameAuthor) {
		this.nameAuthor = nameAuthor;
	}

	public boolean getAnonymousAuthor() {
		return anonymousAuthor;
	}

	public void setAnonymousAuthor(boolean anonymousAuthor) {
		this.anonymousAuthor = anonymousAuthor;
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
		result = prime * result + (anonymousAuthor ? 1231 : 1237);
		result = prime * result + ((nameAuthor == null) ? 0 : nameAuthor.hashCode());
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
		Author other = (Author) obj;
		if (anonymousAuthor != other.anonymousAuthor)
			return false;
		if (nameAuthor == null) {
			if (other.nameAuthor != null)
				return false;
		} else if (!nameAuthor.equals(other.nameAuthor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Author [idAuthor=" + idAuthor + ", nameAuthor=" + nameAuthor + ", anonymousAuthor=" + anonymousAuthor
				+ "]";
	}
}