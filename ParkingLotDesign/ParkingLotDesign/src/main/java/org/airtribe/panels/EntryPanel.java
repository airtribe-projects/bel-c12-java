package org.airtribe.panels;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.airtribe.ParkingFloor.ParkingFloor;
import org.airtribe.display.DisplayPanel;
import org.airtribe.parkingspot.ParkingSpot;
import org.airtribe.parkingspot.ParkingSpotType;
import org.airtribe.ticket.ParkingTicket;
import org.airtribe.vehicle.Vehicle;
import org.airtribe.vehicle.VehicleType;


public class EntryPanel {
  String panelId;

  DisplayPanel displayPanel;

  public EntryPanel(String panelId, DisplayPanel displayPanel) {
    this.panelId = panelId;
    this.displayPanel = displayPanel;
  }

  public ParkingTicket generateParkingTicket(Vehicle vehicle, ParkingFloor floor) {
    ParkingSpotType spotType = generateSpotTypeBasedOnVehicleType(vehicle.getType());
    return new ParkingTicket(UUID.randomUUID().toString(), vehicle, null, new Date(), floor);
  }

  public ParkingSpotType generateSpotTypeBasedOnVehicleType(VehicleType vehicleType) {
    switch (vehicleType) {
      case MOTORCYCLE:
        return ParkingSpotType.TWO_WHEELER;
      case BICYCLE:
        return ParkingSpotType.TWO_WHEELER;
      case CAR:
        return ParkingSpotType.MEDIUM;
      case TRUCK:
        return ParkingSpotType.LARGE;
      default:
        return null;
    }
  }


  public String getPanelId() {
    return panelId;
  }

  public void setPanelId(String panelId) {
    this.panelId = panelId;
  }

  public DisplayPanel getDisplayPanel() {
    return displayPanel;
  }

  public void setDisplayPanel(DisplayPanel displayPanel) {
    this.displayPanel = displayPanel;
  }
}
