package fr.com.kata.tennis.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fr.com.kata.tennis.impl.TennisGame;
import fr.com.kata.tennis.impl.TennisPlayer;

public class TennisGameLocalTest {

	private TennisPlayer playerOne;
	private TennisPlayer playerTwo;
	private TennisGame game;

	@Before
	public void setup() {
		playerOne = new TennisPlayer("PlayerOne");
		playerTwo = new TennisPlayer("PlayerTwo");
		game = new TennisGame(playerOne, playerTwo);
	}

	@Test
	public void two_players_have_score_zero_zero() {
		assertEquals(playerOne.getCurrentScore(), 0);
		assertEquals(playerTwo.getCurrentScore(), 0);
	}

	@Test
	public void player_one_scores_one_point() {
		playerOne.score();
		assertEquals(game.getGameScoreTennisMatch(), "15-0");
	}

	@Test
	public void game_have_score_15_15() {
		playerOne.score();
		playerTwo.score();

		assertEquals(game.getGameScoreTennisMatch(), "15-15");
	}

	@Test
	public void game_have_score_30_15() {
		playerOne.score();
		playerTwo.score();
		playerOne.score();

		assertEquals(game.getGameScoreTennisMatch(), "30-15");
	}

	@Test
	public void game_have_score_30_30() {
		playerOne.score();
		playerTwo.score();
		playerOne.score();
		playerTwo.score();

		assertEquals(game.getGameScoreTennisMatch(), "30-30");
	}

	@Test
	public void game_have_score_40_30() {
		playerOne.score();
		playerTwo.score();
		playerOne.score();
		playerTwo.score();
		playerOne.score();

		assertEquals(game.getGameScoreTennisMatch(), "40-30");
	}

	@Test
	public void game_have_score_40_40() {
		playerOne.score();
		playerTwo.score();
		playerOne.score();
		playerTwo.score();
		playerOne.score();
		playerTwo.score();

		assertEquals(game.getGameScoreTennisMatch(), "40-40");
	}

	@Test
	public void game_have_score_40_40_and_player_one_scores_and_win_without_deuceRule() {
		playerOne.score();
		playerTwo.score();
		playerOne.score();
		playerTwo.score();
		playerOne.score();
		playerTwo.score();
		playerOne.score();

		assertEquals(game.getGameScoreTennisMatch(), "PlayerOne WIN");
	}

	@Test
	public void game_have_score_40_40_and_player_two_scores_and_win_without_deuceRule() {
		playerOne.score();
		playerTwo.score();
		playerOne.score();
		playerTwo.score();
		playerOne.score();
		playerTwo.score();
		playerTwo.score();

		assertEquals(game.getGameScoreTennisMatch(), "PlayerTwo WIN");
	}

	@Test
	public void game_have_score_40_40_and_player_two_scores_and_has_advantage_with_deuceRule() {

		playerOne.score();
		playerTwo.score();
		playerOne.score();
		playerTwo.score();
		playerOne.score();
		playerTwo.score();
		playerTwo.score();

		assertEquals(game.getGameScoreTennisMatchWithDeuceRule(),
				"PlayerTwo has advantage");
	}

	@Test
	public void game_have_score_40_40_and_player_one_scores_and_has_advantage_with_deuceRule() {

		playerOne.score();
		playerTwo.score();
		playerOne.score();
		playerTwo.score();
		playerOne.score();
		playerTwo.score();
		playerOne.score();

		assertEquals(game.getGameScoreTennisMatchWithDeuceRule(),
				"PlayerOne has advantage");
	}

	@Test
	public void game_have_score_40_40_and_player_one_scores_and_player_two_scores_with_deuceRule() {

		playerOne.score();
		playerTwo.score();
		playerOne.score();
		playerTwo.score();
		playerOne.score();
		playerTwo.score();
		playerOne.score();
		playerTwo.score();

		assertEquals(game.getGameScoreTennisMatchWithDeuceRule(), "Deuce");
	}

	@Test
	public void game_have_score_40_40_and_player_one_scores_two_points_with_deuceRule() {

		playerOne.score();
		playerTwo.score();
		playerOne.score();
		playerTwo.score();
		playerOne.score();
		playerTwo.score();
		playerOne.score();
		playerOne.score();

		assertEquals(game.getGameScoreTennisMatchWithDeuceRule(),
				"PlayerOne WIN");
	}

	@Test
	public void game_have_score_40_40_and_player_two_scores_two_points_with_deuceRule() {

		playerOne.score();
		playerTwo.score();
		playerOne.score();
		playerTwo.score();
		playerOne.score();
		playerTwo.score();
		playerTwo.score();
		playerTwo.score();

		assertEquals(game.getGameScoreTennisMatchWithDeuceRule(),
				"PlayerTwo WIN");
	}

	@Test
	public void game_have_set_score_3_1_and_score_40_15_and_player_one_scores_point() {
		playerOne.setCurrentScore(3);
		playerOne.setSetCurrentScore(3);

		playerTwo.setCurrentScore(1);
		playerTwo.setSetCurrentScore(1);

		assertEquals(playerOne.getScore(), 40);
		assertEquals(playerTwo.getScore(), 15);

		playerOne.score();

		game.getGameScoreTennisMatch();

		assertEquals(game.getSetScoreTennisMatch(), "4-1");

		assertEquals(playerOne.getSetCurrentScore(), Integer.valueOf(4));
		assertEquals(playerTwo.getSetCurrentScore(), Integer.valueOf(1));

	}

	@Test
	public void game_have_set_score_5_1_and_score_40_15_and_player_one_scores_point() {
		playerOne.setCurrentScore(3);
		playerOne.setSetCurrentScore(5);

		playerTwo.setCurrentScore(1);
		playerTwo.setSetCurrentScore(1);

		assertEquals(playerOne.getScore(), 40);
		assertEquals(playerTwo.getScore(), 15);

		playerOne.score();

		game.getGameScoreTennisMatch();

		assertEquals(game.getSetScoreTennisMatch(), "PlayerOne win the set");

		assertEquals(playerOne.getSetCurrentScore(), Integer.valueOf(6));
		assertEquals(playerTwo.getSetCurrentScore(), Integer.valueOf(1));
	}

	@Test
	public void game_have_set_score_4_5_and_score_30_40_and_player_two_scores_point() {
		playerOne.setCurrentScore(2);
		playerOne.setSetCurrentScore(4);

		playerTwo.setCurrentScore(3);
		playerTwo.setSetCurrentScore(5);

		assertEquals(playerOne.getScore(), 30);
		assertEquals(playerTwo.getScore(), 40);

		playerTwo.score();

		game.getGameScoreTennisMatch();

		assertEquals(game.getSetScoreTennisMatch(), "PlayerTwo win the set");

		assertEquals(playerOne.getSetCurrentScore(), Integer.valueOf(4));
		assertEquals(playerTwo.getSetCurrentScore(), Integer.valueOf(6));
	}

	@Test
	public void game_have_set_score_5_5_and_score_30_40_and_player_two_scores_point() {
		playerOne.setCurrentScore(2);
		playerOne.setSetCurrentScore(5);

		playerTwo.setCurrentScore(3);
		playerTwo.setSetCurrentScore(5);

		assertEquals(playerOne.getScore(), 30);
		assertEquals(playerTwo.getScore(), 40);

		playerTwo.score();

		game.getGameScoreTennisMatch();

		assertEquals(game.getSetScoreTennisMatch(), "5-6");

		assertEquals(playerOne.getSetCurrentScore(), Integer.valueOf(5));
		assertEquals(playerTwo.getSetCurrentScore(), Integer.valueOf(6));
	}

	@Test
	public void game_have_set_score_6_6_and_score_40_0_and_player_two_scores_point() {
		playerOne.setCurrentScore(3);
		playerOne.setSetCurrentScore(6);

		playerTwo.setCurrentScore(0);
		playerTwo.setSetCurrentScore(6);

		assertEquals(playerOne.getScore(), 40);
		assertEquals(playerTwo.getScore(), 0);

		playerOne.score();
		
		game.getGameScoreTennisMatch() ;

		assertEquals(game.getSetScoreTennisMatch(), "PlayerOne win the set");

		assertEquals(playerOne.getSetCurrentScore(), Integer.valueOf(7));
		assertEquals(playerTwo.getSetCurrentScore(), Integer.valueOf(6));
	}
	
	@Test
	public void game_have_set_score_6_5_and_score_0_40_and_player_two_scores_point_with_Tie_break() {
		game.setActiveTieBreak(true);

		playerOne.setCurrentScore(0);
		playerOne.setSetCurrentScore(6);

		playerTwo.setCurrentScore(3);
		playerTwo.setSetCurrentScore(5);

		assertEquals(playerOne.getScore(), 0);
		assertEquals(playerTwo.getScore(), 40);

		playerTwo.score();
		
		game.getGameScoreTennisMatch() ;

		assertEquals(game.getSetScoreTennisMatchWithTieBreakRule(), "0-0");

		assertEquals(playerOne.getSetCurrentScore(), Integer.valueOf(6));
		assertEquals(playerTwo.getSetCurrentScore(), Integer.valueOf(6));
	}
	
	@Test
	public void game_have_set_score_6_6_and_score_0_40_and_player_two_scores_point_with_Tie_break() {
		game.setActiveTieBreak(true);

		playerOne.setCurrentScore(0);
		playerOne.setSetCurrentScore(6);

		playerTwo.setCurrentScore(3);
		playerTwo.setSetCurrentScore(6);

		assertEquals(playerOne.getScore(), 0);
		assertEquals(playerTwo.getScore(), 40);

		playerTwo.score();
		
		game.getGameScoreTennisMatch() ;

		assertEquals(game.getSetScoreTennisMatchWithTieBreakRule(), "0-1");

		assertEquals(playerOne.getSetCurrentScore(), Integer.valueOf(6));
		assertEquals(playerTwo.getSetCurrentScore(), Integer.valueOf(6));
	}
	
	@Test
	public void game_have_set_score_6_6_and_tie_break_4_5_and_score_0_40_and_player_two_scores_point_with_Tie_break() {
		game.setActiveTieBreak(true);

		playerOne.setCurrentScore(0);
		playerOne.setSetCurrentScore(6);
		playerOne.setTiebreackScore(4);

		playerTwo.setCurrentScore(3);
		playerTwo.setSetCurrentScore(6);
		playerTwo.setTiebreackScore(5);

		assertEquals(playerOne.getScore(), 0);
		assertEquals(playerTwo.getScore(), 40);

		playerTwo.score();
		
		game.getGameScoreTennisMatch() ;

		assertEquals(game.getSetScoreTennisMatchWithTieBreakRule(), "PlayerTwo win the set");

		assertEquals(playerOne.getSetCurrentScore(), Integer.valueOf(6));
		assertEquals(playerTwo.getSetCurrentScore(), Integer.valueOf(6));
	}
	
	
}
