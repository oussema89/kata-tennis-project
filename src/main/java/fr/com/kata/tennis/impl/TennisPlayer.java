package fr.com.kata.tennis.impl;

import java.util.Arrays;
import java.util.List;

public class TennisPlayer {

	private String name;

	private Integer currentScore;

	private Integer setCurrentScore;

	private Integer tiebreackScore;

	private final static List<Integer> scores = Arrays.asList(0, 15, 30, 40);

	public TennisPlayer(String name) {
		this.name = name;
		this.currentScore = 0;
		this.setCurrentScore = 0;
		this.tiebreackScore = 0;
	}

	public int getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(Integer currentScore) {
		this.currentScore = currentScore;
	}

	public void score() {
		this.currentScore++;
	}

	public int getScore() {
		return scores.get(currentScore);
	}

	public String getName() {
		return name;
	}

	public Integer getSetCurrentScore() {
		return setCurrentScore;
	}

	public void setSetCurrentScore(Integer setCurrentScore) {
		this.setCurrentScore = setCurrentScore;
	}

	public Integer getTiebreackScore() {
		return tiebreackScore;
	}

	public void setTiebreackScore(Integer tiebreackScore) {
		this.tiebreackScore = tiebreackScore;
	}

}
