package it.unical.test;

import static org.junit.Assert.assertEquals;

import java.time.Instant;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unical.asde.AthleticGame;

public class AthleticGameWinnersTest {
	
	private static AthleticGame game;

	@BeforeClass
	public static void init() {
		game = new AthleticGame("calcio");
	}

	@Before
	public void start() {
		game.start();
	}

	@After
	public void reset() {
		game.reset();
	}

	@Test
	public void testWinner() {
		game.addArrival("Nicola", Instant.now().minusSeconds(10));
		game.addArrival("Fabio", Instant.now().minusMillis(20));
		assertEquals("Nicola", game.getWinner());
	}
	
	@Test(timeout = 1000)
	public void testWinnerTimeout() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		game.addArrival("Nicola", Instant.now().minusSeconds(10));
		game.addArrival("Fabio", Instant.now().minusMillis(20));
		assertEquals("Nicola", game.getWinner());
	}

}
