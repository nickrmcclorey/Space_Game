import java.util.ArrayList;
import java.util.List;


public class Scene {
    public double gravity = 100000;
    Sprite spaceShip;
    public List<Planet> planets;

    public Scene() {
        spaceShip = new Sprite(300, 300, 0, 0, 0);
        // spaceShip = new Sprite(300, 300, 0, 0, 0);
        planets = new ArrayList<Planet>();
        planets.add(new Planet(0, 0, 200));
        planets.add(new Planet(800, 500, 200));
    }

    public void update(double timeEllapsed, Controls controls) {
        for (Planet planet : planets) {
            double dx = planet.xPosition - spaceShip.xPosition;
            double dy = planet.yPosition - spaceShip.yPosition;
            double distanceSquared = Math.pow(dx, 2) + Math.pow(dy, 2);
            double force = gravity * planet.mass / distanceSquared;
            double theta = Math.atan2(dy, dx);
            double forceX = Math.cos(theta) * force;
            double forceY = Math.sin(theta) * force;
            // System.out.println("force: " + force);
            // System.out.println("theta: " + theta);
            // System.out.println("forceX: " + forceX);
            // System.out.println("forceY: " + forceY);
            spaceShip.xVelocity += forceX * timeEllapsed;
            spaceShip.yVelocity += forceY * timeEllapsed;
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
        // spaceShip.printInfo();
    }
}