import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/*
 * 
 * @author Daniel Busarello
 *  
 */

public class BombTest extends JPanel{

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BombTest window = new BombTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BombTest() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setSize(350, 250);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 400, 300);
		tabbedPane.add(new Enigma01());
		tabbedPane.add(new Enigma02());
		frame.getContentPane().add(tabbedPane);
	}
}
