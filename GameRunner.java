import java.lang.Thread;
import java.util.concurrent.Semaphore;
import java.awt.Point;
import java.awt.Polygon;

public class GameRunner extends Thread {
    Camera camera;
    Controls controls;
    Semaphore lock = new Semaphore(1, true);

    public GameRunner(Camera cam, Controls controller) {
        camera = cam;
        controls = controller;
    }

    public void run() {
        System.out.println("let's go");
        while (true) {
            int sleepTime = 1000 / 60;
            try { 
                Thread.sleep(sleepTime);
                lock.acquire();
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            updateScene(sleepTime * 1.0 / 1000);
            camera.repaint();
            lock.release();
        }
    }

    public void loadScene(Scene scene) {
        try { lock.acquire(); } catch (Exception e) {}
        camera.scene = scene;
        lock.release();
        System.out.println("reset");
    }
    
    public void updateScene(double timeEllapsed) {
        
        if (controls.r) {
            camera.scene.reset();
            return;
        }

        Sprite spaceShip = camera.scene.spaceShip;
        for (Planet planet : camera.scene.planets) {
            double dx = planet.xPosition - spaceShip.xPosition;
            double dy = planet.yPosition - spaceShip.yPosition;
            double distanceSquared = Math.pow(dx, 2) + Math.pow(dy, 2);
            double force = Planet.gravityStrength * planet.mass / distanceSquared;
            double theta = Math.atan2(dy, dx);
            double forceX = Math.cos(theta) * force;
            double forceY = Math.sin(theta) * force;
            spaceShip.xVelocity += forceX * timeEllapsed;
            spaceShip.yVelocity += forceY * timeEllapsed;

            if (Math.sqrt(distanceSquared) < planet.radius) {
                spaceShip.yVelocity = 0;
                spaceShip.xVelocity = 0;
                return;
            }
        }

        if (controls.w) {
            spaceShip.yVelocity += Math.cos(spaceShip.rotation) * -10;
            spaceShip.xVelocity += Math.sin(spaceShip.rotation) * 10;
        }

        if (controls.a) {
            spaceShip.rotation -= Math.PI / 32;
        }

        if (controls.d) {
            spaceShip.rotation += Math.PI / 32;
        }


        spaceShip.xPosition += spaceShip.xVelocity * timeEllapsed;
        spaceShip.yPosition += spaceShip.yVelocity * timeEllapsed;
    }
}
