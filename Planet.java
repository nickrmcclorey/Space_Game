import java.awt.Color;

public class Planet {
    public int xPosition;
    public int yPosition;
    public int radius;
    public double mass;
    public Color color;
    public static final double gravityStrength = 80000;

    public Planet(int x, int y, int rad) {
        xPosition = x;
        yPosition = y;
        radius = rad;
        mass = radius;
        color = Color.black;
    }

    public Planet(int x, int y, int rad, Color planetColor) {
        xPosition = x;
        yPosition = y;
        radius = rad;
        mass = radius;
        color = planetColor;
    }
}