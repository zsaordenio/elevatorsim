import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;

public class Floor extends JButton {
    private DirectionButtonPanel upPanel;
    private DirectionButtonPanel downPanel;
    private int floor;

    public Floor(int floor) {
        //Floor 1 will be initialized to true (The cab will start at the bottom)
        if (floor == 1) {
            this.setBorder(new LineBorder(Color.black, 5));
        }
        //Initializes floor variable and visuals
        this.floor = floor;
        this.setEnabled(false);
        this.setLayout(new GridBagLayout());
        initButtons();
    }

    private void initButtons() {
        //This defines the constraints for the GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.weightx = 1;
        if (floor != 1) {
            DirectionButton db1 = new DirectionButton(floor, DirectionButton.DOWN);
            downPanel = new DirectionButtonPanel(db1);
            downPanel.add(db1, gbc);
            this.add(downPanel, gbc);
            gbc.gridx++;
        }
        if(floor != 16) {
            DirectionButton db2 = new DirectionButton(floor, DirectionButton.UP);
            upPanel = new DirectionButtonPanel(db2);
            upPanel.add(db2, gbc);
            this.add(upPanel, gbc);
            gbc.gridx++;
        }
        JButton floorSign = new JButton("" + floor);
        floorSign.setEnabled(false);
        floorSign.setForeground(Color.black);
        floorSign.setBackground(Color.blue);
        this.add(floorSign, gbc);
    }


    //Useful for the logic implementation
    public void highLight() {
        this.setBackground(Color.red);
    }

    public void unHighLight() {
        this.setBackground(null);
    }

    public DirectionButtonPanel getDirectionButtonPanel(boolean dir) {
        if (dir) return upPanel;
        else return downPanel;
    }
}