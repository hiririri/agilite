Feature: Manage Aircraft and Pilot

  Scenario Outline: Refuel an aircraft with different amounts
    Given an aircraft with registration "<registration>" and remaining fuel of <initialFuel>
    When I add <fuelToAdd> units of fuel
    Then the remaining fuel should be <expectedFuel>

    Examples:
      | registration | initialFuel | fuelToAdd | expectedFuel |
      | F-GZDK       | 150         | 50        | 200          |
      | F-GJKL       | 100         | 25        | 125          |
      | F-GBCD       | 200         | 0         | 200          |

  Scenario Outline: Assign a pilot to an aircraft
    Given a pilot named "<pilotName>"
    And an aircraft with registration "<registration>" and remaining fuel of <initialFuel>
    When I assign the pilot to the aircraft
    Then the aircraft should have the pilot "<pilotName>"
    And the pilot should have 1 aircraft

    Examples:
      | pilotName | registration | initialFuel |
      | Maverick  | F-GZDK       | 100         |
      | Goose     | F-GJKL       | 200         |
      | Iceman    | F-GBCD       | 150         |

  Scenario Outline: Remove a pilot from an aircraft
    Given an aircraft with registration "<registration>" and remaining fuel of <initialFuel>
    And the aircraft has a pilot "<pilotName>"
    When I remove the pilot from the aircraft
    Then the aircraft should not have a pilot
    And the pilot should not have the aircraft

    Examples:
      | registration | initialFuel | pilotName |
      | F-GZDK       | 150         | Maverick  |
      | F-GJKL       | 100         | Goose     |
      | F-GBCD       | 200         | Iceman    |

  Scenario Outline: Pilot manages multiple aircrafts
    Given a pilot named "<pilotName>"
    And an aircraft with registration "F-GZDK" and remaining fuel of 150
    And another aircraft with registration "F-GJKL" and remaining fuel of 200
    When I assign the pilot to both aircrafts
    Then the pilot should have 2 aircrafts

    Examples:
      | pilotName |
      | Maverick  |
      | Goose     |
      | Iceman    |