
import javax.swing.*;
import java.awt.*;

public class ButtonDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EventQueue.invokeLater(() -> {

			JFrame buttonFrame = new ButtonFrame();
			buttonFrame.setVisible(true);

		});

	}

}

class ButtonFrame extends JFrame {

	private final int WIDTH = 600;
	private final int HEIGHT = 200;

	private JButton yesButton = new JButton("Yes");
	private JButton maybeButton = new JButton("Maybe");
	private JButton alrightButton = new JButton("Alright");
	private JButton resetButton = new JButton("Reset");
	private JButton timeoutButton = new JButton("Timeout");
	private JButton ignoreButton = new JButton("Ignore");

	public ButtonFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Button Demo");
		setLayout(new GridBagLayout());
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);

		JPanel mainPanel = new JPanel();

		mainPanel.add(yesButton);
		mainPanel.add(maybeButton);
		mainPanel.add(alrightButton);
		mainPanel.add(resetButton);
		mainPanel.add(timeoutButton);
		mainPanel.add(ignoreButton);

		add(mainPanel);

		yesButton.addActionListener(e -> {

			getContentPane().setBackground(Color.BLACK);
			mainPanel.setBackground(Color.BLACK);

		});

		maybeButton.addActionListener(e -> {

			getContentPane().setBackground(Color.BLUE);
			mainPanel.setBackground(Color.BLUE);

		});

		alrightButton.addActionListener(e -> {

			getContentPane().setBackground(Color.CYAN);
			mainPanel.setBackground(Color.CYAN);

		});

		resetButton.addActionListener(e -> {

			getContentPane().setBackground(Color.GREEN);
			mainPanel.setBackground(Color.GREEN);

		});

		timeoutButton.addActionListener(e -> {

			getContentPane().setBackground(Color.MAGENTA);
			mainPanel.setBackground(Color.MAGENTA);

		});

		ignoreButton.addActionListener(e -> {

			getContentPane().setBackground(Color.YELLOW);
			mainPanel.setBackground(Color.YELLOW);

		});

	}

}
