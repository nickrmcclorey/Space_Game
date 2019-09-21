import java.awt.Polygon;
import java.awt.Graphics;

public class Sprite {
    int xPosition;
    int yPosition;
    int xVelocity;
    int yVelocity;
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
        polygon.addPoint(xPosition, yPosition - 20);
        polygon.addPoint(xPosition + 20, yPosition + 20);
        polygon.addPoint(xPosition - 20, yPosition + 20);
        return polygon;
    }

    public void draw(Graphics g) {

    }
}