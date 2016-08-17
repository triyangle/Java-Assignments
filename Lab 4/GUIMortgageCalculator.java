

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

/**
@version 1.0 08/02/2014
@author William Yang

File name: GUIMortgageCalculator.java
Program purpose: This program is to implement a simple GUI mortgage calculation program.

Revision history:
Date		Programmer		Change ID	Description
08/02/2014	William Yang	1			Initial creation
*/

public class GUIMortgageCalculator {

	public static void main(String[] args) {

		EventQueue.invokeLater( new Runnable ( )   // create a GUI thread that displays the Frame
				{
			public void run ( ) {
				JFrame frame = new AppFrame ( );
				frame.setVisible (true); // AppFrame now comes to life
			}
				} );

	}

}

class AppFrame extends JFrame {

	public static final double taxRate = 1.5;

	// Frame size might be defined here
	private final int WIDTH = 500 ;
	private final int HEIGHT = 300 ;

	private JLabel propertyValueLabel = new JLabel("Enter a property value ($):");
	private JTextField propertyValueField = new JTextField(20);

	private JLabel interestRateLabel = new JLabel("Enter annual interest rate (in %):");
	private JTextField interestRateField = new JTextField(20);

	private JLabel loanLabel = new JLabel("Enter loan duration (in years):");
	private JTextField loanField = new JTextField(20);

	private JLabel downPaymentLabel = new JLabel("Enter down payment (in %):");
	private JTextField downPaymentField = new JTextField(20);

	private JCheckBox propertyTaxCheck = new JCheckBox("Include Property Tax");

	private JTextField mortgageField = new JTextField(20);

	private JButton calculateButton = new JButton("Calculate");
	private JButton clearButton = new JButton("Clear");
	private JButton cancelButton = new JButton("Cancel");

	public AppFrame ()
	{
		// setting frame attributes ("look and feel")
		setTitle ("William Yang");

		setResizable(false);
		setSize(WIDTH, HEIGHT);
		// positioning the frame in the center of the screen
		setLocationRelativeTo (null);  

		// setting frame behavior
		addWindowListener (new WindowAdapter ( )
		{
			public void windowClosing (WindowEvent e) {

				JOptionPane.showMessageDialog(null, "Thanks for using our Mortgage Calculator application. See you again!", "Exit", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}            
		}
				);

		//main northPanel
		JPanel northPanelMain = new JPanel ();

		northPanelMain.setLayout(new BorderLayout());


		JPanel northPanelNorth = new JPanel();
		northPanelNorth.setLayout(new BorderLayout());

		JPanel northPanelCenter = new JPanel();
		northPanelCenter.setLayout(new BorderLayout());

		//panel for the first labels and textfields
		JPanel northPanel1 = new JPanel();
		northPanel1.setLayout(new BorderLayout());

		//aligns propertyValueLabel to the left
		JPanel northPanel1Left = new JPanel();
		northPanel1Left.setLayout(new FlowLayout(FlowLayout.LEFT));
		northPanel1Left.add(propertyValueLabel);

		//aligns propertyValueField to the right
		JPanel northPanel1Right = new JPanel();
		northPanel1Right.setLayout(new FlowLayout(FlowLayout.RIGHT));
		northPanel1Right.add(propertyValueField);

		//adds the panels with the UI components to their respective orientation alignment
		northPanel1.add(northPanel1Left, BorderLayout.WEST);
		northPanel1.add(northPanel1Right, BorderLayout.EAST);

		JPanel northPanel2 = new JPanel();
		northPanel2.setLayout(new BorderLayout());

		JPanel northPanel2Left = new JPanel();
		northPanel2Left.setLayout(new FlowLayout(FlowLayout.LEFT));
		northPanel2Left.add(interestRateLabel);

		JPanel northPanel2Right = new JPanel();
		northPanel2Right.setLayout(new FlowLayout(FlowLayout.RIGHT));
		northPanel2Right.add(interestRateField);

		northPanel2.add(northPanel2Left, BorderLayout.WEST);
		northPanel2.add(northPanel2Right, BorderLayout.EAST);

		JPanel northPanel3 = new JPanel();
		northPanel3.setLayout(new BorderLayout());

		JPanel northPanel3Left = new JPanel();
		northPanel3Left.setLayout(new FlowLayout(FlowLayout.LEFT));
		northPanel3Left.add(loanLabel);

		JPanel northPanel3Right = new JPanel();
		northPanel3Right.setLayout(new FlowLayout(FlowLayout.RIGHT));
		northPanel3Right.add(loanField);

		northPanel3.add(northPanel3Left, BorderLayout.WEST);
		northPanel3.add(northPanel3Right, BorderLayout.EAST);

		JPanel northPanel4 = new JPanel();
		northPanel4.setLayout(new BorderLayout());

		JPanel northPanel4Left = new JPanel();
		northPanel4Left.setLayout(new FlowLayout(FlowLayout.LEFT));
		northPanel4Left.add(downPaymentLabel);

		JPanel northPanel4Right = new JPanel();
		northPanel4Right.setLayout(new FlowLayout(FlowLayout.RIGHT));
		northPanel4Right.add(downPaymentField);

		northPanel4.add(northPanel4Left, BorderLayout.WEST);
		northPanel4.add(northPanel4Right, BorderLayout.EAST);

		JPanel northPanel5 = new JPanel();
		northPanel5.add(propertyTaxCheck);

		//adds the panels for the first 3 labels and textfields
		northPanelNorth.add(northPanel1, BorderLayout.NORTH);
		northPanelNorth.add(northPanel2, BorderLayout.CENTER);
		northPanelNorth.add(northPanel3, BorderLayout.SOUTH);

		//adds the panels for the last 4th label and textfield and the checkbox
		northPanelCenter.add(northPanel4, BorderLayout.NORTH);
		northPanelCenter.add(northPanel5, BorderLayout.CENTER);

		//adds the segments of the northPanels together and creates a border
		northPanelMain.add(northPanelNorth, BorderLayout.NORTH);
		northPanelMain.add(northPanelCenter, BorderLayout.CENTER);
		northPanelMain.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Mortgage Information"));


		//makes the center panel with the mortgage payment results
		JPanel centerPanelMain = new JPanel();
		centerPanelMain.setLayout(new BorderLayout());

		JLabel mortgageResults = new JLabel("Monthly Mortgage Payment ($):");

		JPanel centerPanelMainLeft = new JPanel();
		centerPanelMainLeft.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerPanelMainLeft.add(mortgageResults);

		JPanel centerPanelMainRight = new JPanel();
		centerPanelMainRight.setLayout(new FlowLayout(FlowLayout.RIGHT));
		centerPanelMainRight.add(mortgageField);

		centerPanelMain.add(centerPanelMainLeft, BorderLayout.WEST);
		centerPanelMain.add(centerPanelMainRight, BorderLayout.EAST);

		centerPanelMain.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Mortgage Calculation Results"));

		//creates the south panel with the various buttons
		JPanel southPanelMain = new JPanel();

		southPanelMain.add(calculateButton);
		southPanelMain.add(clearButton);
		southPanelMain.add(cancelButton);

		add(northPanelMain, BorderLayout.NORTH);
		add(centerPanelMain, BorderLayout.CENTER);
		add(southPanelMain, BorderLayout.SOUTH);


		//listeners

		calculateButton.addActionListener(new ActionListener() {

			public void actionPerformed (ActionEvent e)    {

				double propertyValue = Double.parseDouble(propertyValueField.getText());
				double interestRate = Double.parseDouble(interestRateField.getText());
				int loanDuration = Integer.parseInt(loanField.getText());
				double downPayment = Double.parseDouble(downPaymentField.getText());

				double loanAmount = propertyValue*(1-(downPayment/100));
				double monthlyRate = interestRate/100/12;
				double monthlyPayment = loanAmount*monthlyRate/(1-1/Math.pow(1+monthlyRate, loanDuration*12));
				double monthlyTaxPayment = propertyValue*taxRate/100/12;

				//if the propertyTaxCheckbox is selected, will display the monthly payment with tax
				if(propertyTaxCheck.isSelected() == true) {

					mortgageField.setText(String.format("%-20.2f", monthlyPayment+monthlyTaxPayment));

				} else {

					mortgageField.setText(String.format("%-20.2f", monthlyPayment));
				}

			}
		});

		ActionListener listener = new ButtonListener();

		clearButton.addActionListener(listener);
		cancelButton.addActionListener(listener);
	}

	class ButtonListener implements ActionListener  {

		public void actionPerformed (ActionEvent e)    {

			JButton button = (JButton) e.getSource ( ) ;

			if (button == clearButton) {

				propertyValueField.setText("");
				interestRateField.setText("");
				loanField.setText("");
				downPaymentField.setText("");
				propertyTaxCheck.setSelected(false);
				mortgageField.setText("");

			}
			else {

				if (button == cancelButton) {

					JOptionPane.showMessageDialog(null, "Thanks for using our Mortgage Calculator application. See you again!", "Exit", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);

				}
			}
		}

	} // end of inner class ButtonListener

} // end of class AppFrame