package com.br.matchbook.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "O campo nome precisa ser preenchido")
	@Size(min = 2, message = "O campo nome precisa ter no mínimo dois caracteres.")
	private String name;

	@NotBlank(message = "O campo nome precisa ser preenchido")
	@Size(min = 2, message = "O campo sobrenome precisa ter no mínimo dois caracteres.")
	private String lastName;

	@NotNull
	@Min(value = 18, message = "Menores de 18 anos não podem utilizar o Mathbook.")
	private int age;

	@NotBlank(message = "O campo cidade precisa ser preenchido")
	@Size(min = 2, message = "O campo cidade precisa ter no mínimo dois caracteres.")
	private String city;

	@NotBlank(message = "O campo sexo precisa ser preenchido")
	private String gender;

	@OneToOne(mappedBy = "user")
	private Login login;
	
	@ManyToMany
	private List<LiteraryGenre> literaryGenre;

	public User() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<LiteraryGenre> getLiteraryGenre() {
		return literaryGenre;
	}

	public void setLiteraryGenre(List<LiteraryGenre> literaryGenre) {
		this.literaryGenre = literaryGenre;
	}
	

}
