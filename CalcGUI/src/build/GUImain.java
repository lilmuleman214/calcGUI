package build;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import corePackage.FutureValue;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUImain {

	private JFrame frame;
	private JTextField txtInvestment;
	private JTextField txtYears;
	private JTextField txtRate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUImain window = new GUImain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUImain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 280, 153);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Investment:");
		lblNewLabel.setBounds(10, 11, 78, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblYears = new JLabel("Years:");
		lblYears.setBounds(10, 36, 46, 14);
		frame.getContentPane().add(lblYears);
		
		JLabel lblRate = new JLabel("Rate:");
		lblRate.setBounds(10, 61, 46, 14);
		frame.getContentPane().add(lblRate);
		
		JLabel lblFutureValue = new JLabel("Future Value:");
		lblFutureValue.setBounds(10, 86, 78, 14);
		frame.getContentPane().add(lblFutureValue);
		
		txtInvestment = new JTextField();
		txtInvestment.setBounds(90, 8, 86, 20);
		frame.getContentPane().add(txtInvestment);
		txtInvestment.setColumns(10);
		
		txtYears = new JTextField();
		txtYears.setBounds(90, 33, 86, 20);
		frame.getContentPane().add(txtYears);
		txtYears.setColumns(10);
		
		txtRate = new JTextField();
		txtRate.setText("");
		txtRate.setBounds(90, 58, 86, 20);
		frame.getContentPane().add(txtRate);
		txtRate.setColumns(10);
		
		final JLabel lblSetFV = new JLabel("0");
		lblSetFV.setBounds(98, 86, 46, 14);
		frame.getContentPane().add(lblSetFV);
		
		JButton btnCalc = new JButton("Calc");
		btnCalc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				double investment = Double.parseDouble(txtInvestment.getText());
				double years = Double.parseDouble(txtYears.getText());
				double rate = Double.parseDouble(txtRate.getText());
				FutureValue fv = new FutureValue(investment, years, rate);
				lblSetFV.setText("" + fv.getValue());
			}
		});
		btnCalc.setBounds(186, 7, 68, 70);
		frame.getContentPane().add(btnCalc);
	}
}
