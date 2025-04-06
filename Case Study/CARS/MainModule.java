package casestudy.crimeanalysis;

import java.util.*;

public class MainModule {
    public static void main(String[] args) {
        Incidentservice service = new Incidentservice();

        Incident incident1 = new Incident(101, "Theft", new Date(), "Chennai", "Stolen bike", "Open", 1, 2, 3);
        Incident incident2 = new Incident(102, "Assault", new Date(), "Coimbatore", "Physical assault in public", "Under Investigation", 4, 5, 6);

        service.createIncident(incident1);
        service.createIncident(incident2);

        service.updateIncidentStatus("Closed", 101);

        Date yesterday = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
        Date today = new Date();
        Collection<Incident> incidentsInRange = service.getIncidentsInDateRange(yesterday, today);
        System.out.println("Incidents in date range: " + incidentsInRange.size());

        Collection<Incident> thefts = service.searchIncidents("Theft");
        System.out.println("Number of Theft Incidents: " + thefts.size());

        Report report = service.generateIncidentReport(incident1);
        System.out.println("Report Details:\n" + report.getReportDetails());

        try {
            Incident found = service.findIncidentById(102);
            System.out.println("Incident found: ID = " + found.getIncidentID());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nAll Incidents:");
        for (Incident i : service.getAllIncidents()) {
            System.out.println("ID: " + i.getIncidentID() + ", Type: " + i.getIncidentType() + ", Status: " + i.getStatus());
        }
    }
}
