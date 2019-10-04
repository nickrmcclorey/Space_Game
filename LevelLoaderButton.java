import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class LevelLoaderButton extends JMenuItem implements ActionListener {
    
    Scene scene;
    GameRunner runner;

    public LevelLoaderButton (String label, Scene sceneToLoad, GameRunner gameRunner) {
        super(label);
        scene = sceneToLoad;
        runner = gameRunner;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        scene.reset();
        runner.loadScene(scene);
    }
}