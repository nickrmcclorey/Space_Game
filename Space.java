import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.*;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Space {
    public static void main (String[] args) {

        JFrame frame = new JFrame();
        frame.setTitle("Space Cruiser");
        frame.setSize(1000, 1000);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        Container contentPane = frame.getContentPane();

        Camera panel = new Camera(Scene.allScenes()[0]);
        Controls controls = new Controls();
        panel.addKeyListener(controls);
        panel.setFocusable(true);
        panel.requestFocusInWindow();
        GameRunner runner = new GameRunner(panel, controls);
        runner.start();

        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.add(panel, BorderLayout.PAGE_END);
        frame.setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Levels");
        
        Scene[] scenes = Scene.allScenes();
        for (int k = 0; k < scenes.length; k++) {
            JMenuItem button = new LevelLoaderButton("Level " + (k + 1), scenes[k], runner);
            menu.add(button);
        }
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("./uc_claw.jpg"));
    }

}