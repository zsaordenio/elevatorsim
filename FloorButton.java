import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FloorButton extends JButton implements MouseListener {
    private int floor; // up = true, down = false;
    private int elevator;

    public FloorButton(int floor, int elevator) {
        //Initializes floor variable and visuals
        this.floor = floor;
        this.elevator = elevator;
        setBackground(Color.black);
        setForeground(Color.white);
        if (floor < 10) setText("0" + floor);
        else setText("" + floor);
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
        Simulation.triggerHighlight(floor, elevator);
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

}