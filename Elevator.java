import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Elevator extends JPanel {
    private static final int NUMFLOOR = 16;
    private static final int DELAY = 1000;
    private JPanel buttonPanel;
    private JPanel elevatorPanel;

    private int number;
    private int currentFloor;
    private int destination;
    private boolean direction;
    private boolean busy;
    private int pauseSeconds;

    private Floor[] floors;
    private FloorButtonPanel[] floorButtonPanels;

    public int getCurrentFloor() {
        return currentFloor;
    }

    public boolean getDirection() {
        return direction;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    public FloorButtonPanel[] getFloorButtonPanels() {
        return floorButtonPanels;
    }

    public Floor[] getFloors() {
        return floors;
    }

    public Elevator(int number) {
        super(new GridBagLayout());
        //Call helper methods to initialize all fields and visuals
        initFields(number);
        initFloors();
        initPanels();
        if (number == 1)
            this.setBackground(Color.red);
        if (number == 2)
            this.setBackground(Color.blue);
        if (number == 3)
            this.setBackground(Color.green);
    }

    private void initFields(int number) {
        //Initialize the floor number
        this.number = number;
        //Initialize the arrays
        this.floors = new Floor[NUMFLOOR];
        this.floorButtonPanels = new FloorButtonPanel[NUMFLOOR];
        //Initialize the panels
        this.elevatorPanel = new JPanel(new GridBagLayout());
        this.buttonPanel = new JPanel(new GridBagLayout());
    }

    private void initFloors() {
        //This defines the constraints for the GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        //Fill in both x and y in case display area is larger than requested size
        gbc.fill = GridBagConstraints.BOTH;
        for (int i = 0; i < NUMFLOOR; i++) {
            //Modify each gridy since the elevator is visually 16row by 1 column
            gbc.gridy = i;
            //Add the floor to the floor array
            floors[i] = new Floor(16 - i);
            //Add the floor to elevator panel with specified constraints
            elevatorPanel.add(floors[i], gbc);
        }
    }

    private void initPanels() {
        initButtons();
        addLabel();
        splitPane();
    }

    private void initButtons() {
        //This defines the constraints for the GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        for (int i = 0; i < 4; i++) {
            //Modify each gridx since the elevator is visually 4row by 4 column
            gbc.gridx = i + 2;
            for (int j = 0; j < NUMFLOOR / 4; j++) {
                //Modify each gridy since the elevator is visually 4row by 4 column
                gbc.gridy = j + 2;
                //Add the floorButton to the floorButton array
                int floorNumber = i * (NUMFLOOR / 4) + j;
                FloorButton fb = new FloorButton(floorNumber + 1, number);
                FloorButtonPanel fbp = new FloorButtonPanel(fb);
                GridBagConstraints gbc2 = new GridBagConstraints();
                gbc2.insets = new Insets(2, 2, 2, 2);
                fbp.add(fb, gbc2);
                floorButtonPanels[floorNumber] = fbp;

                //Add the floorButton to button panel with specified constraints
                buttonPanel.add(fbp, gbc);
            }
        }
    }

    private void addLabel() {
        JLabel e = new JLabel("Elevator " + (3 - number + 1));
        e.setFont(new Font(Font.SANS_SERIF, 0, 20));
        e.setBackground(Color.blue);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        buttonPanel.add(e, gbc);
    }

    private void splitPane() {
        //Add the 2 panels to a splitPane
        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, elevatorPanel, buttonPanel);
        //Disables resizing
        sp.setEnabled(false);
        //Restricts movement of divider when resizing window
        sp.setResizeWeight(0.5);
        //Glue the splitPane to the Elevator
        this.add(sp);
    }

    public void initTimerTask() {
        direction = true;
        pauseSeconds = 3;
        currentFloor = 1;
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            public void run() {
                updateElevator();
            }
        };
        timer.scheduleAtFixedRate(timerTask, DELAY, 1000);
    }

    private void updateElevator() {
        if (pauseSeconds != 3) {
            pauseSeconds++;
            return;
        }
        if (busy) {
            floors[16 - currentFloor].setBorder(new JButton().getBorder());
            if (direction) {
                currentFloor++;
            } else {
                currentFloor--;
            }
            floors[16 - currentFloor].setBorder(new LineBorder(Color.black, 5));

            if (floorButtonPanels[currentFloor - 1].getFloorButton().isSelected()) {
                pauseSeconds = 0;
                System.out.println("PAUSE");
            }

            if (direction) {
                if (floors[16 - currentFloor].getDirectionButtonPanel(true).getDirectionButton().isSelected()) {
                    pauseSeconds = 0;
                    System.out.println("PAUSE");
                }
            } else {
                if (floors[16 - currentFloor].getDirectionButtonPanel(false).getDirectionButton().isSelected()) {
                    pauseSeconds = 0;
                    System.out.println("PAUSE");
                }
            }

            if (currentFloor == destination) {
                busy = false;
            }
        }
    }
}

