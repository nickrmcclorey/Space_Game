import java.lang.Thread;

public class GameRunner extends Thread {
    Camera camera;

    public GameRunner(Camera cam) {
        camera = cam;
    }

    public void run() {
        System.out.println("let's go");
        while (true) {
            int sleepTime = 1000;
            try { Thread.sleep(sleepTime); } catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
            camera.scene.update(sleepTime / 1000);
            camera.repaint();
        }
    }
}