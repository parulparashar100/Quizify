package com.quiz.QuizifyServer.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Quiz")
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "title")
	private String title;
	@Column(name = "description", length = 5000)
	private String description;
	@Column(name = "max_marks")
	private Integer maxMarks;
	@Column(name = "number_of_questions")
	private Integer numberOfQuestions;
	@Column(name = "is_active")
	private boolean isActive = false;
	@Column(name = "category_id")
	private Integer categoryId;

	@ManyToOne(targetEntity = Category.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id", insertable = false, updatable = false)
	private Category category;

	@OneToMany(mappedBy = "quiz", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Question> questions = new HashSet<>();

	@OneToMany(mappedBy = "quiz", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Attempt> attempts;

	public Quiz() {
	}

	public Quiz(String title, String description, Integer maxMarks, Integer numberOfQuestions, int timeLimit,
			boolean isActive, Integer categoryId) {
		this.title = title;
		this.description = description;
		this.maxMarks = maxMarks;
		this.numberOfQuestions = numberOfQuestions;
		this.isActive = isActive;
		this.categoryId = categoryId;
	}

	public Quiz(Integer id, String title, String description, Integer maxMarks, Integer numberOfQuestions,
			int timeLimit, boolean isActive, Integer categoryId) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.maxMarks = maxMarks;
		this.numberOfQuestions = numberOfQuestions;
		this.isActive = isActive;
		this.categoryId = categoryId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(Integer maxMarks) {
		this.maxMarks = maxMarks;
	}

	public Integer getNumberOfQuestions() {
		return numberOfQuestions;
	}

	public void setNumberOfQuestions(Integer numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Quiz [id=" + id + ", title=" + title + ", description=" + description + ", maxMarks=" + maxMarks
				+ ", numberOfQuestions=" + numberOfQuestions + ", isActive=" + isActive + ", categoryId=" + categoryId
				+ "]";
	}

}
