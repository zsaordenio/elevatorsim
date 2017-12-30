import javax.swing.*;
import java.awt.*;

public class DirectionButtonPanel extends JPanel {
    private DirectionButton directionButton;

    public DirectionButtonPanel(DirectionButton directionButton) {
        this.directionButton = directionButton;
        this.setLayout(new GridBagLayout());
    }


    public void highLight() {
        this.setBackground(Color.green);
        System.out.println("Highlight green");
    }

    public void unHighLight() {
        this.setBackground(null);
    }

}
