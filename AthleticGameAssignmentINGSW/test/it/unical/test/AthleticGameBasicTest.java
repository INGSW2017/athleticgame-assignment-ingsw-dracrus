package it.unical.test;

import static org.junit.Assert.assertEquals;

import java.time.Instant;

import org.junit.BeforeClass;
import org.junit.Test;

import it.unical.asde.AthleticGame;

public class AthleticGameBasicTest {

	private static AthleticGame game;

	@BeforeClass
	public static void init() {
		game = new AthleticGame("calcio");
	}

	@Test
	public void testAddArrival() {
		game.addArrival("nicola", Instant.now());
		assertEquals(1, game.getArrivals().size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetTime() {
		game.getParecipiantTime("fabio");
	}
}
