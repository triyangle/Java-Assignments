
import java.awt.*;
import javax.swing.JFrame;

public class CowFrame extends JFrame {
	private final Color BISQUE = new Color(0xcdb79e);

	public CowFrame () {
		init();
	}

	public void init() {
		setSize(700,600);
		setBackground(new Color(0x87ceeb));
		repaint();
	}

	/**
	 * Displays the various components of the cow as commented
	 */
	public void paint(Graphics g) {

		//ground
		g.setColor(new Color(0x228b22));
		g.fillRect(0, 400, getWidth(), getHeight());

		//this is the body of the cow
		g.setColor(BISQUE);
		g.fillRoundRect(50, 100, 400, 200, 50, 100);

		//legs of cow
		g.fillOval(385, 300, 25, 150);
		g.fillOval(85, 300, 25, 150);

		//head of cow
		g.setColor(Color.BLACK);
		//g.fillRoundRect(350, 50, 170, 85, 25, 50);
		g.fillRoundRect(400, 50, 120, 85, 25, 50);

		//eyes of cow
		g.setColor(Color.WHITE);
		g.fillOval(480, 70, 20, 20);
		g.fillOval(440, 70, 20, 20);

		//"COW" text
		g.setColor(Color.BLACK);
		g.setFont(new Font("ComicSans", Font.PLAIN, 20));
		g.drawString("COW", 250, 75);

		//tail
		g.drawArc(0, 125, 50, 100, 0, -180);


		//spots
		g.setColor(Color.WHITE);
		g.fillOval(100, 125, 50, 50);
		g.fillOval(200, 150, 45, 45);
		g.fillOval(300, 200, 55, 55);
		g.fillOval(350, 140, 40, 40);
		g.fillOval(75, 225, 60, 60);
		g.fillOval(175, 210, 50, 50);

		//ears
		g.setColor(Color.ORANGE);
		g.fillPolygon(new int[] {510, 485, 475}, new int[] {50, 30, 50}, 3);
		g.fillPolygon(new int[] {450, 425, 415} , new int[] {50, 30, 50}, 3);

		//nose
		g.setColor(BISQUE);
		g.fillOval(440, 95, 60, 30);

		g.setColor(Color.BLACK);
		g.fillOval(455, 105, 10, 10);
		g.fillOval(475, 105, 10, 10);

		//sun
		g.setColor(Color.YELLOW);
		g.fillOval(600, 0, 150, 150);

	}

}
