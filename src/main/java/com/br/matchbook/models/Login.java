package com.br.matchbook.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "O campo nickname precisa ser preenchido")
	@Size(min = 2, message = "O nickname precisa ter no mínimo dois caracteres")
	private String nickname;

	@NotBlank(message = "O campo e-mail precisa ser preenchido")
	@Email
	private String email;

	@NotBlank(message = "O campo senha precisa ser preenchido")
	@Size(min = 6, message = "Sua senha precisa ter no mínimo seis caracteres")
	private String password;

	@OneToOne(cascade = {CascadeType.ALL})
	private User user;

	public Login() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
