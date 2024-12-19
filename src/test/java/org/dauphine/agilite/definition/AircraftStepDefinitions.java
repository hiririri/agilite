package org.dauphine.agilite.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.dauphine.agilite.Aircraft;
import org.dauphine.agilite.Pilot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AircraftStepDefinitions {

    private Pilot pilot;
    private Aircraft aircraft;
    private Aircraft anotherAircraft;

    @Given("an aircraft with registration {string} and remaining fuel of {int}")
    public void an_aircraft_with_registration_and_remaining_fuel(String registration, int initialFuel) {
        aircraft = new Aircraft(registration, initialFuel, null);
    }

    @When("I add {int} units of fuel")
    public void i_add_units_of_fuel(int fuelToAdd) {
        aircraft.refuel(fuelToAdd);
    }

    @Then("the remaining fuel should be {int}")
    public void the_remaining_fuel_should_be(int expectedFuel) {
        assertEquals(expectedFuel, aircraft.getRemainingFuel(),
                "The remaining fuel does not match the expected value.");
    }

    @Given("a pilot named {string}")
    public void aPilotNamed(String pilotName) {
        pilot = new Pilot(pilotName);
    }

    @When("I assign the pilot to the aircraft")
    public void iAssignThePilotToTheAircraft() {
        aircraft.setPilot(pilot);
    }

    @Then("the aircraft should have the pilot {string}")
    public void theAircraftShouldHaveThePilot(String pilotName) {
        assertEquals(pilotName, aircraft.getPilot().getName());
    }

    @And("the pilot should have {int} aircraft")
    public void thePilotShouldHaveAircraft(int numberOfAircraft) {
        assertEquals(numberOfAircraft, pilot.getAircrafts().size());
    }

    @And("the aircraft has a pilot {string}")
    public void theAircraftHasAPilot(String pilotName) {
        pilot = new Pilot(pilotName);
        aircraft = new Aircraft("F-GZDK", 150, pilot);
    }

    @When("I remove the pilot from the aircraft")
    public void iRemoveThePilotFromTheAircraft() {
        aircraft.setPilot(null);
    }

    @Then("the aircraft should not have a pilot")
    public void theAircraftShouldNotHaveAPilot() {
        assertNull(aircraft.getPilot());
    }

    @And("the pilot should not have the aircraft")
    public void thePilotShouldNotHaveTheAircraft() {
        assertEquals(0, pilot.getAircrafts().size());
    }

    @And("another aircraft with registration {string} and remaining fuel of {int}")
    public void anotherAircraftWithRegistrationAndRemainingFuelOf(String registration, int remainingFuel) {
        anotherAircraft = new Aircraft(registration, remainingFuel, null);
    }

    @When("I assign the pilot to both aircrafts")
    public void iAssignThePilotToBothAircrafts() {
        aircraft.setPilot(pilot);
        anotherAircraft.setPilot(pilot);
    }

    @Then("the pilot should have {int} aircrafts")
    public void thePilotShouldHaveAircrafts(int numberOfAircrafts) {
        assertEquals(numberOfAircrafts, pilot.getAircrafts().size());
    }

}
