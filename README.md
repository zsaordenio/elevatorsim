3 elevators
16 floors


Simulation - The driver class

GameFrame - The Java Window

Elevator - The transportations
    -There will be 3 elevators, e1, e2, and e3
    -Each elevator has 16 floors, stored in an array
    -Each elevator also has the visual elevatorPanel and a visual button panel

Floor - Where people enter/exit, where the elevator stops/passes
    -Floor can either be selected or not (boolean)
    -If floor is selected, elevator must stop there
    -Floor contains 2 direction buttons: up and down

DirectonButton - What you press to tell the elevator which direction to go
    -Contains a boolean value of the direction: up = true, down = false.

Instructions for Eunice and Risshie

I need you guys to figure out the logic / algorithms to implement the elevator's cab movement.
1. Determine which elevator should stop at a certain floor
2. When en elevator stops, the corresponding floor button must be pressed for the elevator to proceed, unless it already has previously pressed buttons

Because data is fixed, we will be using a standard array to construct the elevators and floors
Change the highlighted floors based on where the cab is located on the elevator.
Change the highlighted floor every 3 seconds for when it passes a floor, and 6 seconds for when it has to stop at a floor
Change the highlight buttons of each elevator cab and each floor.

Note:
Only one floor can be highlighted at a time
Multiple floor buttons can be highlight, but if more than 1/2 is highlighted, reset all buttons
The direction buttons can be in either 4 states:
up: false down: false
up: false down: true
up: true  down: false
up: true  down: true
 
