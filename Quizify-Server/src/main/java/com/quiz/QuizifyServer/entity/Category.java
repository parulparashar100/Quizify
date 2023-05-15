package com.quiz.QuizifyServer.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "description", length = 5000)
	private String description;
	
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Quiz> quizzes = new LinkedHashSet<>();

	public Category() {
	}

	public Category(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Category(Integer id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}
