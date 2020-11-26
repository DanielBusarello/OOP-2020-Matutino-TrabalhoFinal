import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

/*
 * 
 * @author Daniel Busarello
 *  
 */

public class EnigmaRL02 extends JFrame{

	private JFrame frame;
	private JButton btnVerify = new JButton("Verificar");
	private JToggleButton chA;
	private JToggleButton chB;
	private JToggleButton chC;
	private JToggleButton chD;
	private JLabel lblStatus;
	
	// Variables
	private RLOG rLog = new RLOG();
	
	ImageIcon ii = new ImageIcon();
	private String[] imgName = {
		"/img/imgIntro.png",
		"/img/01.png",
		"/img/02.png",
		"/img/03.png",
		"/img/04.png",
		"/img/01S.png",
		"/img/02S.png",
		"/img/03S.png",
		"/img/04S.png"
	};
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnigmaRL02 window = new EnigmaRL02();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EnigmaRL02() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblStatus = new JLabel("Armado");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStatus.setForeground(Color.RED);
		lblStatus.setBounds(348, 6, 76, 14);
		
		btnVerify.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVerify.setEnabled(false);
		btnVerify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chD.isSelected()) {
					rLog.checkAnswer("D");
					lblStatus.setText("Desarmado");
					lblStatus.setForeground(Color.GREEN);
					btnVerify.setEnabled(false);
				} else {
					JOptionPane.showMessageDialog(btnVerify, "Você errou!");
				}
			}
		});
		btnVerify.setBounds(174, 227, 89, 23);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblStatus);
		frame.getContentPane().add(btnVerify);
		
		JLabel lblImg = new JLabel();
		ii = new ImageIcon(EnigmaRL02.class.getResource(imgName[0]));
		ii.setImage(ii.getImage().getScaledInstance(400, 130, 60));
		lblImg.setIcon(ii);
		lblImg.setBounds(20, 31, 392, 126);
		frame.getContentPane().add(lblImg);
		
		chA = new JToggleButton();
		chA.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				disableTB();
			}
		});
		ii = new ImageIcon(EnigmaRL02.class.getResource(imgName[1]));
		ii.setImage(ii.getImage().getScaledInstance(64, 48, 25));
		chA.setIcon(ii);
		ii = new ImageIcon(EnigmaRL02.class.getResource(imgName[5]));
		ii.setImage(ii.getImage().getScaledInstance(64, 48, 25));
		chA.setSelectedIcon((ii));
		chA.setBounds(85, 168, 52, 50);
		frame.getContentPane().add(chA);
		
		chB = new JToggleButton();
		chB.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				disableTB();
			}
		});
		ii = new ImageIcon(EnigmaRL02.class.getResource(imgName[2]));
		ii.setImage(ii.getImage().getScaledInstance(64, 48, 25));
		chB.setIcon(ii);
		ii = new ImageIcon(EnigmaRL02.class.getResource(imgName[6]));
		ii.setImage(ii.getImage().getScaledInstance(64, 48, 25));
		chB.setSelectedIcon((ii));
		chB.setBounds(159, 168, 52, 50);
		frame.getContentPane().add(chB);
		
		chC = new JToggleButton();
		chC.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				disableTB();
			}
		});
		ii = new ImageIcon(EnigmaRL02.class.getResource(imgName[3]));
		ii.setImage(ii.getImage().getScaledInstance(64, 48, 25));
		chC.setIcon(ii);
		ii = new ImageIcon(EnigmaRL02.class.getResource(imgName[7]));
		ii.setImage(ii.getImage().getScaledInstance(64, 48, 25));
		chC.setSelectedIcon((ii));
		chC.setBounds(235, 168, 52, 50);
		frame.getContentPane().add(chC);
		
		chD = new JToggleButton();
		chD.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				disableTB();
			}
		});
		ii = new ImageIcon(EnigmaRL02.class.getResource(imgName[4]));
		ii.setImage(ii.getImage().getScaledInstance(64, 48, 25));
		chD.setIcon(ii);
		ii = new ImageIcon(EnigmaRL02.class.getResource(imgName[8]));
		ii.setImage(ii.getImage().getScaledInstance(64, 48, 25));
		chD.setSelectedIcon((ii));
		chD.setBounds(312, 168, 52, 50);
		frame.getContentPane().add(chD);
	}
	
	private void disableTB(){
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
		
		if(rLog.isDesarmed()) {
			btnVerify.setEnabled(false);
		}
	}
}
