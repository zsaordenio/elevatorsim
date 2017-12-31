import javax.swing.JPanel;
import java.awt.BorderLayout;

//Driver class
public class Simulation {
    private static GameFrame gameFrame;
    private static JPanel mainPanel;
    private static Elevator[] elevators;

    public static void main(String[] args) {
        //Creates the GameFrame
        gameFrame = new GameFrame();
        //Call helper methods
        createPanels();
        buildElevators();
        //Update the visuals of the window
        mainPanel.repaint();
        mainPanel.revalidate();
        //Ensures of proper sizing
        gameFrame.pack();
        //Makes the frame visible
        gameFrame.setVisible(true);
        executeTasks();
    }

    private static void createPanels() {
        //The mainPanel will have a borderLayout with gap size 10 on x and y

        mainPanel = new JPanel(new BorderLayout(10, 10));
        //Glue the mainPanel to the gameFrame
        gameFrame.getContentPane().add(mainPanel);
    }

    private static void buildElevators() {
        //Initialize the elevator array
        elevators = new Elevator[3];
        for (int i = 0; i < 3; i++) {
            //Add the 3 elevators to the array and the mainPanel
            elevators[i] = new Elevator(i + 1);
            //Call helper method to determine the position
            mainPanel.add(elevators[i], choosePosition(i + 1));
        }
    }

    private static String choosePosition(int number) {
        //These are the constant value positions based on BorderLayout
        switch (number) {
            case 1:
                return BorderLayout.EAST;
            case 2:
                return BorderLayout.CENTER;
            case 3:
                return BorderLayout.WEST;
            //default case is for debugging purposes
            default:
                System.out.println("Illegal elevator number, should not be printing.");
                return null;
        }
    }

    private static void executeTasks() {
        for (Elevator elevator : elevators) {
            elevator.initTimerTask();
        }
    }

    public static void triggerHighlight(int floor, boolean direction) {
        for (int i = 0; i < 3; i++) {
            elevators[i].getFloors()[16 - floor].highLight();
            elevators[i].getFloors()[16 - floor].getDirectionButtonPanel(direction).highLight();
        }
    }

    public static void triggerHighlight(int floor, int elevator) {
        elevators[elevator - 1].getFloorButtonPanels()[floor - 1].highLight();
    }

    public static Elevator getElevator(int elevator) {
        return elevators[elevator-1];
    }
}