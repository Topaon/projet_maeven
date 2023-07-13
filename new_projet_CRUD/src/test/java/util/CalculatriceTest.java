package util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatriceTest {

	@Test
	void add() {
		Calculatrice calc = new Calculatrice();
		int res = calc.add(2, 3);
		assertEquals(5, res);
	}
}
