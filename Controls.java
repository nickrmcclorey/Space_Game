import java.awt.event.*;

public class Controls implements KeyListener {
    public boolean w;
    public boolean a;
    public boolean d;

    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            w = true;
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            a = true;
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            d = true;
        }
    }
    
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            w = false;
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            a = false;
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            d = false;
        }
    }

}