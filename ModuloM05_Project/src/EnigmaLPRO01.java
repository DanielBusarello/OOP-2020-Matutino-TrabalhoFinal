import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

/*
 * 
 * @author Daniel Busarello
 *  
 */

public class EnigmaLPRO01 extends JFrame {

	private JFrame frame;

	// Variables
	private LPRO lPro = new LPRO();
	
	private JCheckBox chA;
	private JCheckBox chB;
	private JCheckBox chC;
	private JCheckBox chD;
	private JButton btnVerify = new JButton("Verificar");
	
	private String[] alternatives = lPro.getAnswers();
	
	private JCheckBox[] checkBoxes = {
		new JCheckBox("A"),
		new JCheckBox("B"),
		new JCheckBox("C"),
		new JCheckBox("D"),
		new JCheckBox("E"),
	};
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnigmaLPRO01 window = new EnigmaLPRO01();
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
	public EnigmaLPRO01() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStatus = new JLabel("Armado");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStatus.setForeground(Color.RED);
		lblStatus.setBounds(350, 11, 74, 14);
		frame.getContentPane().add(lblStatus);
		
		btnVerify.setEnabled(false);
		btnVerify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chA.isSelected()) {
					lPro.checkAnswer("A");
					lblStatus.setText("Desarmado");
					lblStatus.setForeground(Color.GREEN);
					btnVerify.setEnabled(false);
				} else {
					JOptionPane.showMessageDialog(btnVerify, "Você errou!");
				}
			}
		});
		btnVerify.setBounds(171, 227, 89, 23);
		frame.getContentPane().add(btnVerify);
		
		chA = checkBoxes[0];
		chA.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				disableCB();
			}
		});
		chA.setBounds(10, 125, 400, 23);
		frame.getContentPane().add(chA);
		
		chB = checkBoxes[1];
		chB.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				disableCB();
			}
		});
		chB.setBounds(10, 151, 400, 23);
		frame.getContentPane().add(chB);
		
		chC = checkBoxes[2];
		chC.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				disableCB();
			}
		});
		chC.setBounds(10, 177, 400, 23);
		frame.getContentPane().add(chC);
		
		chD = checkBoxes[3];
		chD.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				disableCB();
			}
		});
		chD.setBounds(10, 203, 400, 23);
		frame.getContentPane().add(chD);
		
		JTextArea txtrIMariaGosta = new JTextArea();
		txtrIMariaGosta.setBackground(Color.WHITE);
		txtrIMariaGosta.setLineWrap(true);
		txtrIMariaGosta.setFont(new Font("Leelawadee UI", Font.PLAIN, 13));
		txtrIMariaGosta.setText("I. Maria gosta de viol\u00E3o ou Eduardo gosta de guitarra.\r\nII. Brenda gosta de flauta ou Pedro n\u00E3o gosta de piano.\r\nIII. Pedro gosta de piano ou Maria n\u00E3o gosta de viol\u00E3o.\r\nIV. Jo\u00E3o gosta de bateria ou Lara gosta de baixo.");
		txtrIMariaGosta.setEditable(false);
		txtrIMariaGosta.setBounds(10, 45, 414, 73);
		frame.getContentPane().add(txtrIMariaGosta);
		
		JLabel lblNewLabel = new JLabel("A partir das premissas, selecione o correto:");
		lblNewLabel.setFont(new Font("Leelawadee UI", Font.PLAIN, 12));
		lblNewLabel.setBounds(95, 18, 224, 16);
		frame.getContentPane().add(lblNewLabel);
		
		setCBText(alternatives, checkBoxes);
	}
	
	private void disableCB() {
		if(chA.isSelected()) {
			chB.setSelected(false);
			chC.setSelected(false);
			chD.setSelected(false);
		} else if(chB.isSelected()) {
			chA.setSelected(false);
			chC.setSelected(false);
			chD.setSelected(false);
		} else if(chC.isSelected()) {
			chA.setSelected(false);
			chB.setSelected(false);
			chD.setSelected(false);
		} else if(chD.isSelected()) {
			chA.setSelected(false);
			chB.setSelected(false);
			chC.setSelected(false);
		} else {  
			btnVerify.setEnabled(false);
			return;
		}
		btnVerify.setEnabled(true);
		
		if(lPro.isDesarmed()) {
			btnVerify.setEnabled(false);
		}
	}
	
	private void setCBText(String[] alt, JCheckBox[] chs) {
		for(int i = 0; i < alt.length; i++) {
			chs[i].setText(alt[i]);	
		}
	}
}
