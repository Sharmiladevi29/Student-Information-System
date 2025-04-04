package casestudy.crimeanalysis;

public class Evidence {
	private int evidenceID;
	private String evidenceDescription;
	private String locationFound;
	private int incidentID;

	public Evidence() {
	}

	public Evidence(int evidenceID, String evidenceDescription, String locationFound, int incidentID) {
		this.evidenceID = evidenceID;
		this.evidenceDescription = evidenceDescription;
		this.locationFound = locationFound;
		this.incidentID = incidentID;
	}

	public int getEvidenceID() {
		return evidenceID;
	}

	public void setEvidenceID(int evidenceID) {
		this.evidenceID = evidenceID;
	}

	public String getEvidenceDescription() {
		return evidenceDescription;
	}

	public void setEvidenceDescription(String evidenceDescription) {
		this.evidenceDescription = evidenceDescription;
	}

	public String getLocationFound() {
		return locationFound;
	}

	public void setLocationFound(String locationFound) {
		this.locationFound = locationFound;
	}

	public int getIncidentID() {
		return incidentID;
	}

	public void setIncidentID(int incidentID) {
		this.incidentID = incidentID;
	}
}
