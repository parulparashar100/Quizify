package com.quiz.QuizifyServer.entity;

import java.util.Date;

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
@Table(name = "Attempt")
public class Attempt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "quiz_id")
	private Integer quizId;
	@Column(name = "score")
	private Integer score;
	@Column(name = "attempt_date")
	private Date attemptDate;
	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User user;
	
	@ManyToOne(targetEntity = Quiz.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "quiz_id", insertable = false, updatable = false)
	private Quiz quiz;

	public Attempt() {
	}

	public Attempt(Integer userId, Integer quizId, Integer score, Date attemptDate) {
		this.userId = userId;
		this.quizId = quizId;
		this.score = score;
		this.attemptDate = attemptDate;
	}

	public Attempt(Integer id, Integer userId, Integer quizId, Integer score, Date attemptDate) {
		this.id = id;
		this.userId = userId;
		this.quizId = quizId;
		this.score = score;
		this.attemptDate = attemptDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getQuizId() {
		return quizId;
	}

	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Date getAttemptDate() {
		return attemptDate;
	}

	public void setAttemptDate(Date attemptDate) {
		this.attemptDate = attemptDate;
	}

	@Override
	public String toString() {
		return "Attempt [id=" + id + ", userId=" + userId + ", quizId=" + quizId + ", score=" + score + ", attemptDate="
				+ attemptDate + "]";
	}

}
