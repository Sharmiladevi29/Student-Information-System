package casestudy.crimeanalysis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Incidentservice {

	private List<Incident> incidentList = new ArrayList<>();

	public boolean createIncident(Incident incident) {
		return incidentList.add(incident);
	}

	public boolean updateIncidentStatus(String newStatus, int incidentId) {
		for (Incident incident : incidentList) {
			if (incident.getIncidentID() == incidentId) {
				incident.setStatus(newStatus);
				return true;
			}
		}
		return false;
	}

	public Collection<Incident> getIncidentsInDateRange(Date startDate, Date endDate) {
		List<Incident> result = new ArrayList<>();
		for (Incident incident : incidentList) {
			Date date = incident.getIncidentDate();
			if (date != null && !date.before(startDate) && !date.after(endDate)) {
				result.add(incident);
			}
		}
		return result;
	}

	public Collection<Incident> searchIncidents(String incidentType) {
		List<Incident> result = new ArrayList<>();
		for (Incident incident : incidentList) {
			if (incident.getIncidentType().equalsIgnoreCase(incidentType)) {
				result.add(incident);
			}
		}
		return result;
	}

	public Report generateIncidentReport(Incident incident) {
		String details = "Incident Report:\n" + "ID: " + incident.getIncidentID() + "\n" + "Type: "
				+ incident.getIncidentType() + "\n" + "Date: " + incident.getIncidentDate() + "\n" + "Location: "
				+ incident.getLocation() + "\n" + "Description: " + incident.getDescription() + "\n" + "Status: "
				+ incident.getStatus();

		return new Report(incident.getIncidentID(), details, new Date(), incident.getIncidentID());
	}

	public List<Incident> getAllIncidents() {
		return incidentList;
	}
}
