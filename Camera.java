import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;
import java.awt.*;

public class Camera extends JPanel {
    int xOffset = 0;
    int yOffset = 0;
    int zoom = 1;
    Scene scene;

    public Camera(Scene scene) {
        this.scene = scene;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Planet planet : scene.planets) {
            int x = planet.xPosition + xOffset;
            int y = planet.yPosition + yOffset;
            int radius = planet.radius * zoom;

            g.setColor(planet.color);
            g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        }

        List<Point> pointsToRemove = new LinkedList<Point>();
        for (Point star : scene.stars) {
            Polygon polygon = new Polygon();
            for (int k = 0; k < 5; k++) {
                double angle = k * Math.PI * 2 / 5;
                double xPos = Math.cos(angle) * 20;
                double yPos = Math.sin(angle) * 20;
                polygon.addPoint((int)xPos + star.x, (int)yPos + star.y);

                angle = k * Math.PI * 2 / 5 + Math.PI * 2 / 10;
                xPos = Math.cos(angle) * 10;
                yPos = Math.sin(angle) * 10;
                polygon.addPoint((int)xPos + star.x, (int)yPos + star.y);
            }

            if (polygon.getBounds2D().intersects(scene.spaceShip.polygon().getBounds2D())) {
                pointsToRemove.add(star);
            }

            g.drawPolygon(polygon);
        }

        for (Point point : pointsToRemove) {
            scene.stars.remove(point);
        }

        g.drawPolygon(scene.spaceShip.polygon());

    }
}