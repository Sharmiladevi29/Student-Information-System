package casestudy.crimeanalysis;

import java.util.Date;

public class Incident {
	private int incidentID;
	private String incidentType;
	private Date incidentDate;
	private String location;
	private String description;
	private String status;
	private int victimID;
	private int suspectID;
	private int officerID;

	public Incident() {
	}

	public Incident(int incidentID, String incidentType, Date incidentDate, String location, String description,
			String status, int victimID, int suspectID, int officerID) {
		this.incidentID = incidentID;
		this.incidentType = incidentType;
		this.incidentDate = incidentDate;
		this.location = location;
		this.description = description;
		this.status = status;
		this.victimID = victimID;
		this.suspectID = suspectID;
		this.officerID = officerID;
	}

	public int getIncidentID() {
		return incidentID;
	}

	public void setIncidentID(int incidentID) {
		this.incidentID = incidentID;
	}

	public String getIncidentType() {
		return incidentType;
	}

	public void setIncidentType(String incidentType) {
		this.incidentType = incidentType;
	}

	public Date getIncidentDate() {
		return incidentDate;
	}

	public void setIncidentDate(Date incidentDate) {
		this.incidentDate = incidentDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getVictimId() {
		return victimID;
	}

	public void setVictimId(int victimId) {
		this.victimID = victimId;
	}

	public int getSuspectId() {
		return suspectID;
	}

	public void setSuspectId(int suspectId) {
		this.suspectID = suspectId;
	}

	public int getOfficerId() {
		return officerID;
	}

	public void setOfficerId(int officerId) {
		this.officerID = officerId;
	}
}
