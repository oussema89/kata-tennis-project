package fr.com.kata.tennis.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.com.kata.tennis.impl.TennisPlayer;



public class TennisPlayerLocalTest {

	private TennisPlayer player;

	@Before
	public void setup() {
		player = new TennisPlayer("Player One");
	}

	@Test
	public void player_start_with_zero_point() {
		assertEquals(player.getCurrentScore(), 0);
	}

	@Test
	public void player_score_one_point() {
		player.score();
		assertEquals(player.getScore(), 15);
	}
	
	@Test
	public void player_score_two_points() {
		player.score();
		player.score();
		assertEquals(player.getScore(), 30);
	}
	
	@Test
	public void player_score_three_points() {
		player.score();
		player.score();
		player.score();
		assertEquals(player.getScore(), 40);
	}

}
