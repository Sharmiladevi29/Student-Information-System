package casestudy.crimeanalysis;

import org.junit.jupiter.api.*;

import java.util.Date;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IncidentTest {

	private Incident incident;

	@BeforeAll
	void setUp() {
		incident = new Incident(1, "Robbery", new Date(125, 2, 1), "Downtown", "Armed robbery at a bank",
				"Under Investigation", 1, 2, 1);
	}

	@Test
	void testIncidentCreation() {
		Assertions.assertEquals(1, incident.getIncidentID());
		Assertions.assertEquals("Robbery", incident.getIncidentType());
		Assertions.assertEquals("Downtown", incident.getLocation());
	}
}
