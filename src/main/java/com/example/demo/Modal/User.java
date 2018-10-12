package com.example.demo.Modal;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }),
		@UniqueConstraint(columnNames = { "email" }) })
@Entity
public class User extends DateAudit {

	@Id
	@GeneratedValue
	private long Id;

	@Size(min = 6, max = 30)
	@NotNull
	@Column(name = "name")
	private String name;

	@Size(min = 6, max = 30)
	@NotNull
	@Column(name = "user_name")
	private String username;

	@Size(min = 6, max = 30)
	@NotNull
	@Column(name = "email")
	private String email;
	
	@Column(name="active")
	private int active;

	public int getActive() {
		return active;
	}

	public void setActive(int i) {
		this.active = i;
	}

	public User() {
	}

	@Size(min = 6, max = 30)
	@NotNull
	@Column(name = "password")
	private String password;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(HashSet<Role> hashSet) {
		this.roles = hashSet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Country == null) ? 0 : Country.hashCode());
		result = prime * result + (int) (Id ^ (Id >>> 32));
		result = prime * result + age;
		result = prime * result + (int) (cellPhone ^ (cellPhone >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (Country == null) {
			if (other.Country != null)
				return false;
		} else if (!Country.equals(other.Country))
			return false;
		if (Id != other.Id)
			return false;
		if (age != other.age)
			return false;
		if (cellPhone != other.cellPhone)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@NotNull
	private long cellPhone;

	@NotNull
	private String Country;

	private int age;

	public User(long id, @Size(min = 6, max = 30) @NotNull String name,
			@Size(min = 6, max = 30) @NotNull String username, @Size(min = 6, max = 30) @NotNull String email,
			@Size(min = 6, max = 30) @NotNull String password, @NotNull long cellPhone, @NotNull String country,
			int age) {
		super();
		Id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.cellPhone = cellPhone;
		Country = country;
		this.age = age;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public long getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(long cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
