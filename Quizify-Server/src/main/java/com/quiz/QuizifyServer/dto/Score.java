package com.quiz.QuizifyServer.dto;

import java.util.Date;

public class Score {
	
	private Integer id;
	private Integer userId;
	private Integer quizId;
	private Integer score;
	private Date attemptDate;
	private String title;
	private String description;
	private Integer maxMarks;

	public Score() {

	}

	public Score(Integer id, Integer userId, Integer quizId, Integer score, Date attemptDate, String title,
			String description, Integer maxMarks) {
		super();
		this.id = id;
		this.userId = userId;
		this.quizId = quizId;
		this.score = score;
		this.attemptDate = attemptDate;
		this.title = title;
		this.description = description;
		this.maxMarks = maxMarks;
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


}
