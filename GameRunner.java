import java.lang.Thread;

public class GameRunner extends Thread {
    Camera camera;
    Controls controls;

    public GameRunner(Camera cam, Controls controller) {
        camera = cam;
        controls = controller;
    }

    public void run() {
        System.out.println("let's go");
        while (true) {
            int sleepTime = 100;
            try { Thread.sleep(sleepTime); } catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
            camera.scene.update(sleepTime * 1.0 / 1000, controls);
            camera.repaint();
        }
    }
}