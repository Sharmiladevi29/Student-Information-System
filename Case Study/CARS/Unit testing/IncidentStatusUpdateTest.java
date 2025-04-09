package casestudy.crimeanalysis;

import org.junit.jupiter.api.*;
import java.util.Date;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IncidentStatusUpdateTest {

	private Incident incident;

	@BeforeAll
	void setup() {
		incident = new Incident(2, "Assault", new Date(125, 1, 28), "City Park", "Physical assault reported", "Closed",
				3, 5, 4);
	}

	@Test
	void testUpdateToValidStatus() {
		incident.setStatus("Ongoing");
		Assertions.assertEquals("Ongoing", incident.getStatus());
	}

	@Test
	void testUpdateToInvalidStatus() {
		incident.setStatus("INVALID_STATUS");
		Assertions.assertEquals("INVALID_STATUS", incident.getStatus());
	}
}
