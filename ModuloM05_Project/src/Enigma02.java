import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Enigma02 extends JPanel {

	private static final long serialVersionUID = 1L;

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
	
	public Enigma02() {
		setLayout(null);
		setSize(350, 250);
		
		JLabel lblStatus = new JLabel("Armado");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStatus.setForeground(Color.RED);
		lblStatus.setBounds(266, 11, 74, 14);
		this.add(lblStatus);
		
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
		btnVerify.setBounds(126, 216, 89, 23);
		this.add(btnVerify);
		
		chA = checkBoxes[0];
		chA.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				disableCB();
			}
		});
		chA.setBounds(10, 125, 400, 23);
		this.add(chA);
		
		chB = checkBoxes[1];
		chB.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				disableCB();
			}
		});
		chB.setBounds(10, 151, 400, 23);
		this.add(chB);
		
		chC = checkBoxes[2];
		chC.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				disableCB();
			}
		});
		chC.setBounds(10, 177, 400, 23);
		this.add(chC);
		
		chD = checkBoxes[3];
		chD.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				disableCB();
			}
		});
		chD.setBounds(10, 203, 400, 23);
		this.add(chD);
		
		JTextArea txtArea = new JTextArea();
		txtArea.setBackground(Color.WHITE);
		txtArea.setLineWrap(true);
		txtArea.setFont(new Font("Leelawadee UI", Font.PLAIN, 12));
		txtArea.setText("I. Maria gosta de viol\u00E3o ou Eduardo gosta de guitarra.\r\nII. Brenda gosta de flauta ou Pedro n\u00E3o gosta de piano.\r\nIII. Pedro gosta de piano ou Maria n\u00E3o gosta de viol\u00E3o.\r\nIV. Jo\u00E3o gosta de bateria ou Lara gosta de baixo.");
		txtArea.setEditable(false);
		txtArea.setBounds(10, 45, 330, 73);
		this.add(txtArea);
		
		JLabel lblNewLabel = new JLabel("A partir das premissas, selecione o correto:");
		lblNewLabel.setFont(new Font("Leelawadee UI", Font.PLAIN, 12));
		lblNewLabel.setBounds(23, 18, 224, 16);
		this.add(lblNewLabel);
		
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
