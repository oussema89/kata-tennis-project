package fr.com.kata.tennis.impl;

import fr.com.kata.tennis.ITennisGame;

/**
 * @author OUSSAMA-ALOUI
 * 
 */
public class TennisGame implements ITennisGame {

	private TennisPlayer tennisPlayer1;

	private TennisPlayer tennisPlayer2;

	private Boolean activeTieBreak;

	public TennisGame(TennisPlayer tennisPlayer1, TennisPlayer tennisPlayer2) {
		this.tennisPlayer1 = tennisPlayer1;
		this.tennisPlayer2 = tennisPlayer2;
		this.activeTieBreak = false;
	}

	/**
	 * getGameScoreTennisMatch return the current game score : player how won
	 * the match or the score exact
	 * */
	public String getGameScoreTennisMatch() {
		if (tennisPlayer1.getCurrentScore() > 3
				&& tennisPlayer2.getCurrentScore() > 3) {
			if (tennisPlayer1.getCurrentScore()
					- tennisPlayer2.getCurrentScore() > 0) {
				setScoreMode(tennisPlayer1);
				return PlayerwinGame(tennisPlayer1);
			}

			if (tennisPlayer2.getCurrentScore()
					- tennisPlayer1.getCurrentScore() > 0) {
				setScoreMode(tennisPlayer2);
				return PlayerwinGame(tennisPlayer2);
			}
		}

		if (tennisPlayer1.getCurrentScore() > 3) {
			setScoreMode(tennisPlayer1);
			return PlayerwinGame(tennisPlayer1);
		}
		if (tennisPlayer2.getCurrentScore() > 3) {
			setScoreMode(tennisPlayer2);
			return PlayerwinGame(tennisPlayer2);
		}
		return tennisPlayer1.getScore() + "-" + tennisPlayer2.getScore();
	}

	/**
	 * getGameScoreTennisMatchWithDeuceRule return the current game score :
	 * player how won the match or the score exact with option Deuce Rule
	 * */
	public String getGameScoreTennisMatchWithDeuceRule() {

		if (tennisPlayer1.getCurrentScore() > 2
				&& tennisPlayer2.getCurrentScore() > 2) {
			if (tennisPlayer1.getCurrentScore()
					- tennisPlayer2.getCurrentScore() == 1) {
				return tennisPlayer1.getName() + " has advantage";
			}

			if (tennisPlayer2.getCurrentScore()
					- tennisPlayer1.getCurrentScore() == 1) {
				return tennisPlayer2.getName() + " has advantage";
			}

			if (tennisPlayer1.getCurrentScore() == tennisPlayer2
					.getCurrentScore()) {
				return "Deuce";
			}

			if (tennisPlayer2.getCurrentScore()
					- tennisPlayer1.getCurrentScore() == 2) {
				setScoreMode(tennisPlayer2);

				return PlayerwinGame(tennisPlayer2);
			}

			if (tennisPlayer1.getCurrentScore()
					- tennisPlayer2.getCurrentScore() == 2) {
				setScoreMode(tennisPlayer1);
				return PlayerwinGame(tennisPlayer1);
			}
		}

		if (tennisPlayer1.getCurrentScore() > 3) {
			setScoreMode(tennisPlayer1);
			return PlayerwinGame(tennisPlayer1);
		}
		if (tennisPlayer2.getCurrentScore() > 3) {
			setScoreMode(tennisPlayer1);
			return PlayerwinGame(tennisPlayer2);
		}
		return tennisPlayer1.getScore() + "-" + tennisPlayer2.getScore();

	}

	/**
	 * getSetScoreTennisMatch return the current set score : player how won the
	 * match or the score exact
	 * */
	public String getSetScoreTennisMatch() {
		if (tennisPlayer1.getSetCurrentScore() > 5
				&& tennisPlayer2.getSetCurrentScore() > 5) {

			if (tennisPlayer1.getSetCurrentScore()
					- tennisPlayer2.getSetCurrentScore() > 0) {
				tennisPlayer1.setCurrentScore(0);
				return PlayerwinsTheSet(tennisPlayer1);
			}
			if (tennisPlayer2.getSetCurrentScore()
					- tennisPlayer1.getSetCurrentScore() > 0) {
				tennisPlayer2.setCurrentScore(0);
				return PlayerwinsTheSet(tennisPlayer2);
			}
		}
		if (tennisPlayer1.getSetCurrentScore() > 5
				&& tennisPlayer2.getSetCurrentScore() < 5) {
			tennisPlayer1.setCurrentScore(0);
			return PlayerwinsTheSet(tennisPlayer1);
		}

		if (tennisPlayer2.getSetCurrentScore() > 5
				&& tennisPlayer1.getSetCurrentScore() < 5) {
			tennisPlayer2.setCurrentScore(0);
			return PlayerwinsTheSet(tennisPlayer2);
		}
		return tennisPlayer1.getSetCurrentScore() + "-"
				+ tennisPlayer2.getSetCurrentScore();
	}

	/**
	 * getSetScoreTennisMatchWithTieBreakRule return the current set score :
	 * player how won the match or the score exact with option tir break rule
	 * */
	public String getSetScoreTennisMatchWithTieBreakRule() {
		if (isActivateTieBreak()) {
			if (tennisPlayer1.getTiebreackScore() > 5
					&& tennisPlayer2.getTiebreackScore() > 5) {

				if (tennisPlayer1.getTiebreackScore()
						- tennisPlayer2.getTiebreackScore() > 0) {
					tennisPlayer1.setCurrentScore(0);
					return PlayerwinsTheSet(tennisPlayer1);
				}
				if (tennisPlayer2.getTiebreackScore()
						- tennisPlayer1.getTiebreackScore() > 0) {
					tennisPlayer2.setCurrentScore(0);
					return PlayerwinsTheSet(tennisPlayer2);
				}
			}
			if (tennisPlayer1.getTiebreackScore() > 5
					&& tennisPlayer2.getTiebreackScore() < 5) {
				tennisPlayer1.setCurrentScore(0);
				return PlayerwinsTheSet(tennisPlayer1);
			}

			if (tennisPlayer2.getTiebreackScore() > 5
					&& tennisPlayer1.getTiebreackScore() < 5) {
				tennisPlayer2.setCurrentScore(0);
				return PlayerwinsTheSet(tennisPlayer2);
			}
			return tennisPlayer1.getTiebreackScore() + "-"
					+ tennisPlayer2.getTiebreackScore();
		}
		return getSetScoreTennisMatch();
	}

	private Boolean isActivateTieBreak() {
		return getActiveTieBreak() && tennisPlayer1.getSetCurrentScore() == 6
				&& tennisPlayer2.getSetCurrentScore() == 6;
	}

	private void setScoreMode(TennisPlayer player) {
		if (isActivateTieBreak()) {
			player.setTiebreackScore(player.getTiebreackScore() + 1);
		} else {
			player.setSetCurrentScore(player.getSetCurrentScore() + 1);
		}
	}

	public String getSetGameTennisMatchWithTieBreak(TennisPlayer player1,
			TennisPlayer player2) {
		return null;
	}

	public void player1eScore() {
		this.tennisPlayer1.score();
	}

	public void player2Score() {
		this.tennisPlayer2.score();
	}

	private String PlayerwinGame(TennisPlayer player) {
		return player.getName() + " WIN";
	}

	private String PlayerwinsTheSet(TennisPlayer player) {
		return player.getName() + " win the set";
	}

	public Boolean getActiveTieBreak() {
		return activeTieBreak;
	}

	public void setActiveTieBreak(Boolean activeTieBreak) {
		this.activeTieBreak = activeTieBreak;
	}

}
