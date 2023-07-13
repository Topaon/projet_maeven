package crud;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StagiaireTest {
	
	private Stagiaire sta;
	
	@BeforeEach
	void init() {
		sta = new Stagiaire(1, "Martin", "123", "m@sfr.fr", "1995-04-15");
	}
	
	@AfterEach
	void destroy() {
		sta = null;
	}

	@Test
	void testGetId() {
		assertEquals(1, sta.getId());
	}

	@Test
	void testSetId() {
		sta.setId(5);
		assertTrue(sta.getId() == 5);
	}

	@Test
	void testGetPrenom() {
		assertEquals("Martin", sta.getPrenom());
	}

	@Test
	void testSetPrenom() {
		sta.setPrenom("Jose");
		assertTrue(sta.getPrenom() == "Jose");
	}

	@Test
	void testGetMdp() {
		assertEquals("123", sta.getMdp());
	}

	@Test
	void testSetMdp() {
		sta.setMdp("456");
		assertTrue(sta.getMdp() == "456");
	}

	@Test
	void testGetEmail() {
		assertEquals("m@sfr.fr", sta.getEmail());
	}

	@Test
	void testSetEmail() {
		sta.setEmail("m@orange.com");
		assertTrue(sta.getEmail() == "m@orange.com");
	}

	@Test
	void testGetDdn() {
		assertEquals("1995-04-15", sta.getDdn());
	}

	@Test
	void testSetDdn() {
		sta.setDdn("1995-05-15");
		assertTrue(sta.getDdn() == "1995-05-15");
	}
}
