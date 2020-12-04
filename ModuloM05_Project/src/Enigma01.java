import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * 
 * @author Daniel Busarello
 *  
 */

public class Enigma01 extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton btnVerify = new JButton("Verificar");
	private JToggleButton chA;
	private JToggleButton chB;
	private JToggleButton chC;
	private JToggleButton chD;
	private JLabel lblStatus;

	private RLOG rLog = new RLOG();

	ImageIcon ii = new ImageIcon();
	private String[] imgName = { "/img/imgIntro.png", "/img/01.png", "/img/02.png", "/img/03.png", "/img/04.png",
			"/img/01S.png", "/img/02S.png", "/img/03S.png", "/img/04S.png" };

	public Enigma01(final ModuloM05 m) {
		setLayout(null);
		setSize(350, 250);

		lblStatus = new JLabel("Armado");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStatus.setForeground(Color.RED);
		lblStatus.setBounds(265, 6, 76, 14);

		btnVerify.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVerify.setEnabled(false);
		btnVerify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chD.isSelected()) {
					rLog.checkAnswer("D");
					lblStatus.setText("Desarmado");
					lblStatus.setForeground(Color.GREEN);
					btnVerify.setEnabled(false);
					m.setDefused(true, (byte) 0);
					m.setRightAnswer();
					m.serialize();
				} else {
					rLog.checkAnswer("");
					m.setDefused(false, (byte) 0);
					m.addError();
					m.setErrors();
					m.serialize();
				}
			}
		});
		btnVerify.setBounds(135, 190, 89, 23);
		this.add(lblStatus);
		this.add(btnVerify);

		JLabel lblImg = new JLabel();
		ii = new ImageIcon(Enigma01.class.getResource(imgName[0]));
		ii.setImage(ii.getImage().getScaledInstance(300, 120, 60));
		lblImg.setIcon(ii);
		lblImg.setBounds(10, 25, 330, 110);
		add(lblImg);

		chA = new JToggleButton();
		chA.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				disableTB();
			}
		});
		ii = new ImageIcon(Enigma01.class.getResource(imgName[1]));
		ii.setImage(ii.getImage().getScaledInstance(62, 45, 25));
		chA.setIcon(ii);
		ii = new ImageIcon(Enigma01.class.getResource(imgName[5]));
		ii.setImage(ii.getImage().getScaledInstance(62, 45, 25));
		chA.setSelectedIcon((ii));
		chA.setBounds(40, 140, 46, 46);
		this.add(chA);

		chB = new JToggleButton();
		chB.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				disableTB();
			}
		});
		ii = new ImageIcon(Enigma01.class.getResource(imgName[2]));
		ii.setImage(ii.getImage().getScaledInstance(62, 45, 25));
		chB.setIcon(ii);
		ii = new ImageIcon(Enigma01.class.getResource(imgName[6]));
		ii.setImage(ii.getImage().getScaledInstance(62, 45, 25));
		chB.setSelectedIcon((ii));
		chB.setBounds(110, 140, 46, 46);
		this.add(chB);

		chC = new JToggleButton();
		chC.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				disableTB();
			}
		});
		ii = new ImageIcon(Enigma01.class.getResource(imgName[3]));
		ii.setImage(ii.getImage().getScaledInstance(62, 45, 25));
		chC.setIcon(ii);
		ii = new ImageIcon(Enigma01.class.getResource(imgName[7]));
		ii.setImage(ii.getImage().getScaledInstance(62, 45, 25));
		chC.setSelectedIcon((ii));
		chC.setBounds(180, 140, 46, 46);
		this.add(chC);

		chD = new JToggleButton();
		chD.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				disableTB();
			}
		});
		ii = new ImageIcon(Enigma01.class.getResource(imgName[4]));
		ii.setImage(ii.getImage().getScaledInstance(62, 45, 25));
		chD.setIcon(ii);
		ii = new ImageIcon(Enigma01.class.getResource(imgName[8]));
		ii.setImage(ii.getImage().getScaledInstance(62, 45, 25));
		chD.setSelectedIcon((ii));
		chD.setBounds(250, 140, 46, 46);
		this.add(chD);

	}

	private void disableTB() {
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

		if (rLog.getDesarmed()) {
			btnVerify.setEnabled(false);
		}
	}

}
