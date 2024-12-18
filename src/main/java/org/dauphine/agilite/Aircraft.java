package org.dauphine.agilite;

public class Aircraft {

    private String registration;

    private int remainingFuel;
    
    private Pilot pilot;
    
    public Aircraft(String registration, int remainingFuel, Pilot pilot) {
        this.registration = registration;
        this.remainingFuel = remainingFuel;
        this.pilot = pilot;
    }
    
    public String getPilotName() {
        return this.pilot.getName();
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public int getRemainingFuel() {
        return remainingFuel;
    }

    public void setRemainingFuel(int remainingFuel) {
        this.remainingFuel = remainingFuel;
    }

    public void addFuel(int fuel) {
        this.remainingFuel += fuel;
    }

}
