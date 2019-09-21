import java.awt.Graphics;
import javax.swing.JPanel;

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

        g.drawPolygon(scene.spaceShip.polygon());
    }
}