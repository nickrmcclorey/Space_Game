import java.awt.Polygon;
import java.awt.Graphics;

public class Sprite {
    double xPosition;
    double yPosition;
    double xVelocity;
    double yVelocity;
    double rotation;

    public Sprite(int xPos, int yPos, int xVel, int yVel, double rot) {
        xPosition = xPos;
        yPosition = yPos;
        xVelocity = xVel;
        yVelocity = yVel;
        rotation = rot;
    }

    public Polygon polygon() {
        Polygon polygon = new Polygon();
        polygon.addPoint((int)xPosition, (int) yPosition - 20);
        polygon.addPoint((int) xPosition + 20, (int) yPosition + 20);
        polygon.addPoint((int) xPosition - 20, (int) yPosition + 20);
        return polygon;
    }

    public void printInfo() {
        System.out.println("xPosition: " + xPosition);
        System.out.println("yPosition: " + yPosition);
        System.out.println("xVelocity: " + xVelocity);
        System.out.println("yVelocity: " + yVelocity);
    }

}