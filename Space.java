import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class Space {
    public static void main (String[] args) {

        JFrame frame = new JFrame();
        frame.setTitle("Perimeter Finder");
        frame.setSize(1000, 1000);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        Container contentPane = frame.getContentPane();

        Camera panel = new Camera(new Scene());
        panel.addKeyListener(new Controls());
        panel.setFocusable(true);
        panel.requestFocusInWindow();
        GameRunner runner = new GameRunner(panel);
        runner.start();

        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.add(panel, BorderLayout.PAGE_END);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}