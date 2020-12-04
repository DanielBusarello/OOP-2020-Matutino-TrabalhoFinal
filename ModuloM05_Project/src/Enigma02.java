import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * 
 * @author Daniel Busarello
 *  
 */

public class Enigma02 extends JPanel {

	private static final long serialVersionUID = 1L;

	private LPRO lPro = new LPRO();

	private JCheckBox chA;
	private JCheckBox chB;
	private JCheckBox chC;
	private JCheckBox chD;
	private JButton btnVerify = new JButton("Verificar");

	private String[] alternatives = lPro.getAnswers();

	private JCheckBox[] checkBoxes = { new JCheckBox("A"), new JCheckBox("B"), new JCheckBox("C"), new JCheckBox("D"),
			new JCheckBox("E"), };

	public Enigma02(final ModuloM05 m) {
		setLayout(null);
		setSize(350, 250);

		JLabel lblStatus = new JLabel("Armado");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStatus.setForeground(Color.RED);
		lblStatus.setBounds(260, 11, 74, 14);
		this.add(lblStatus);

		btnVerify.setEnabled(false);
		btnVerify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chA.isSelected()) {
					lPro.checkAnswer("A");
					lblStatus.setText("Desarmado");
					lblStatus.setForeground(Color.GREEN);
					btnVerify.setEnabled(false);
					m.setDefused(true, (byte) 3);
					m.setRightAnswer();
					m.serialize();
				} else {
					lPro.checkAnswer("");
					m.setDefused(false, (byte) 3);
					m.addError();
					m.setErrors();
					m.serialize();
				}
			}
		});
		btnVerify.setBounds(126, 185, 89, 23);
		this.add(btnVerify);

		chA = checkBoxes[0];
		chA.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				disableCB();
			}
		});
		chA.setFont(new Font("Arial", Font.PLAIN, 10));
		chA.setBounds(6, 105, 340, 20);
		this.add(chA);

		chB = checkBoxes[1];
		chB.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				disableCB();
			}
		});
		chB.setBounds(6, 125, 340, 20);
		chB.setFont(new Font("Arial", Font.PLAIN, 10));
		this.add(chB);

		chC = checkBoxes[2];
		chC.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				disableCB();
			}
		});
		chC.setBounds(6, 145, 340, 20);
		chC.setFont(new Font("Arial", Font.PLAIN, 10));
		this.add(chC);

		chD = checkBoxes[3];
		chD.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				disableCB();
			}
		});
		chD.setBounds(6, 165, 340, 20);
		chD.setFont(new Font("Arial", Font.PLAIN, 10));
		this.add(chD);

		JTextArea txtArea = new JTextArea();
		txtArea.setBackground(Color.WHITE);
		txtArea.setLineWrap(true);
		txtArea.setFont(new Font("Leelawadee UI", Font.PLAIN, 11));
		txtArea.setText(
				"I. Maria gosta de viol\u00E3o ou Eduardo gosta de guitarra.\r\nII. Brenda gosta de flauta ou Pedro n\u00E3o gosta de piano.\r\nIII. Pedro gosta de piano ou Maria n\u00E3o gosta de viol\u00E3o.\r\nIV. Jo\u00E3o gosta de bateria ou Lara gosta de baixo.");
		txtArea.setEditable(false);
		txtArea.setBounds(10, 45, 330, 64);
		this.add(txtArea);

		JLabel lblNewLabel = new JLabel("A partir das premissas, selecione o correto:");
		lblNewLabel.setFont(new Font("Leelawadee UI", Font.PLAIN, 12));
		lblNewLabel.setBounds(23, 18, 224, 16);
		this.add(lblNewLabel);

		setCBText(alternatives, checkBoxes);
	}

	private void disableCB() {
		if (chA.isSelected()) {
			chB.setSelected(false);
			chC.setSelected(false);
			chD.setSelected(false);
		} else if (chB.isSelected()) {
			chA.setSelected(false);
			chC.setSelected(false);
			chD.setSelected(false);
		} else if (chC.isSelected()) {
			chA.setSelected(false);
			chB.setSelected(false);
			chD.setSelected(false);
		} else if (chD.isSelected()) {
			chA.setSelected(false);
			chB.setSelected(false);
			chC.setSelected(false);
		} else {
			btnVerify.setEnabled(false);
			return;
		}
		btnVerify.setEnabled(true);

		if (lPro.getDesarmed()) {
			btnVerify.setEnabled(false);
		}
	}

	private void setCBText(String[] alt, JCheckBox[] chs) {
		for (int i = 0; i < alt.length; i++) {
			chs[i].setText(alt[i]);
		}
	}
}
