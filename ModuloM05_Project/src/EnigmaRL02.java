import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class EnigmaRL02 {

	private JFrame frame;

	// Variables
	
	private RLOG rLog = new RLOG();
	protected static EnigmaLevel level;
	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public EnigmaRL02() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(378, 11, 46, 14);
		
		JButton btnVerify = new JButton("Verificar");
		btnVerify.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVerify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnVerify.setBounds(172, 227, 89, 23);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(btnVerify);
	}
	
	private void generateBoard() {
		for(int i = 0; i < this.board.length; i++) {
			
		}
	}
	
	/* Variables */
	public int[][] board = new int[4][4];
}
