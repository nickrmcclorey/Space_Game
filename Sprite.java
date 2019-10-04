import java.awt.Polygon;

public class Sprite {
    double xPosition;
    double yPosition;
    double xVelocity;
    double yVelocity;
    double rotation;

    public Sprite(int xPos, int yPos, double rot) {
        xPosition = xPos;
        yPosition = yPos;
        xVelocity = 0;
        yVelocity = 0;
        rotation = rot;
    }

    public Polygon polygon() {
        Polygon polygon = new Polygon();
        // top point of spaceship
        double x = Math.cos(3 * Math.PI / 2 + rotation) * 20 + xPosition;
        double y = Math.sin(3 * Math.PI / 2 + rotation) * 20 + yPosition;
        polygon.addPoint((int)x, (int)y);

        // bottom right
        x = Math.cos(Math.PI / 4 + rotation) * 20 + xPosition;
        y = Math.sin(Math.PI / 4 + rotation) * 20 + yPosition;
        polygon.addPoint((int)x, (int)y);

        // bottom left
        x = Math.cos(3 * Math.PI / 4 + rotation) * 20 + xPosition;
        y = Math.sin(3 * Math.PI / 4 + rotation) * 20 + yPosition;
        polygon.addPoint((int)x, (int)y);
        return polygon;
    }

    public void printInfo() {
        System.out.println("xPosition: " + xPosition);
        System.out.println("yPosition: " + yPosition);
        System.out.println("xVelocity: " + xVelocity);
        System.out.println("yVelocity: " + yVelocity);
    }

}