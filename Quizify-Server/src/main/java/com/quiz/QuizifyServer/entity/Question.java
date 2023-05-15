package com.quiz.QuizifyServer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "description", length = 5000)
	private String description;
	@Column(name = "option1", length = 5000)
	private String option1;
	@Column(name = "option2", length = 1000)
	private String option2;
	@Column(name = "option3", length = 1000)
	private String option3;
	@Column(name = "option4", length = 1000)
	private String option4;
	@Column(name = "answer", length = 1000)
	private String answer;
	@Column(name = "score")
	private Integer score;
	@Column(name = "quiz_id")
	private Integer quizId;
	
	@ManyToOne(targetEntity = Quiz.class, fetch = FetchType.EAGER)
	@JoinColumn(name="quiz_id", insertable = false, updatable = false)
	private Quiz quiz;

	public Question() {
	}

	public Question(String description, String option1, String option2, String option3, String option4, String answer,
			Integer score, Integer quizId) {
		this.description = description;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.answer = answer;
		this.score = score;
		this.quizId = quizId;
	}

	public Question(Integer id, String description, String option1, String option2, String option3, String option4,
			String answer, Integer score, Integer quizId) {
		this.id = id;
		this.description = description;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.answer = answer;
		this.score = score;
		this.quizId = quizId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getQuizId() {
		return quizId;
	}

	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", description=" + description + ", option1=" + option1 + ", option2=" + option2
				+ ", option3=" + option3 + ", option4=" + option4 + ", answer=" + answer + ", score=" + score
				+ ", quizId=" + quizId + "]";
	}

}
