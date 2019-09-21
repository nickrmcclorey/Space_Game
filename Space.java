import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

        Camera panel = new Camera(Scene.scene1());
        Controls controls = new Controls();
        panel.addKeyListener(controls);
        panel.setFocusable(true);
        panel.requestFocusInWindow();
        GameRunner runner = new GameRunner(panel, controls);
        runner.start();

        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.add(panel, BorderLayout.PAGE_END);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}