package util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UtilTest {

	@Test
	void testCapitalize() {
		String attendue = "Simon";
		String renvoyé = Util.capitalize("sImON");
		assertEquals(attendue, renvoyé);
	}

	@Test
	void testHashPassword() {
		fail("Not yet implemented");
	}

	@Test
	void testCheckPassword() {
		fail("Not yet implemented");
	}
}
