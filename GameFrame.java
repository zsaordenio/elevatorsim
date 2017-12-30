import javax.swing.JFrame;
import java.awt.Dimension;

public class GameFrame extends JFrame {

    public GameFrame() {
        //Sets the size of the frame
        this.setPreferredSize(new Dimension(800, 800));
        //Initially, this window will be full-screen when launched
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //The name of the window
        this.setTitle("Elevator Simulator");
        //Enables the minimize/maximize button
        this.setResizable(true);
    }

}