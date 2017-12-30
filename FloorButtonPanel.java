import javax.swing.*;
import java.awt.*;

public class FloorButtonPanel extends JPanel {
    private FloorButton floorButton;

    FloorButtonPanel(FloorButton floorButton) {
        this.floorButton = floorButton;
        this.setLayout(new GridBagLayout());
    }

    public void highLight() {
        this.setBackground(Color.red);
    }

    public void unHighLight() {
        this.setBackground(null);
    }

}
