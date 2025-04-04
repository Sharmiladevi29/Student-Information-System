package casestudy.crimeanalysis;

import java.util.Date;

public class Report {
	private int reportID;
	private String reportDetails;
	private Date reportDate;
	private int incidentID;

	public Report() {
	}

	public Report(int reportID, String reportDetails, Date reportDate, int incidentID) {
		this.reportID = reportID;
		this.reportDetails = reportDetails;
		this.reportDate = reportDate;
		this.incidentID = incidentID;
	}

	public int getReportID() {
		return reportID;
	}

	public void setReportID(int reportID) {
		this.reportID = reportID;
	}

	public String getReportDetails() {
		return reportDetails;
	}

	public void setReportDetails(String reportDetails) {
		this.reportDetails = reportDetails;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public int getIncidentID() {
		return incidentID;
	}

	public void setIncidentID(int incidentID) {
		this.incidentID = incidentID;
	}
}
