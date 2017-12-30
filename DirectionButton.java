import javax.swing.JButton;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DirectionButton extends JButton implements MouseListener {
    // up = true, down = false;
    public static final boolean UP = true;
    public static final boolean DOWN = false;
    private int elevator;
    private boolean direction;
    private int floor;

    public DirectionButton(int floor, boolean direction) {
        //Initializes direction variable and visuals
        this.floor = floor;
        this.direction = direction;
        this.elevator = elevator;
        setBackground(Color.black);
        setForeground(Color.white);
        if (direction == UP) {
            setText("UP");
        } else {
            setText("DOWN");
        }
        //   setMinimumSize(new Dimension(getPreferredSize().width,
        //           getPreferredSize().height));
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
        Simulation.triggerHighlight(floor, direction);
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }
}