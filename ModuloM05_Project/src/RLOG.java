import javax.swing.JPanel;

/*
 * 
 * @author Daniel Busarello
 *  
 */

public class RLOG extends Enigma {
	private static final long serialVersionUID = 1L;
	
	public RLOG(final ModuloM05 m) {
		super(m);
		super.setAnswer("D");
	}
	
	public RLOG() {
		super.setAnswer("D");
	}
	
	@Override
	public JPanel getPanel() {
		return new Enigma01(super.m);
	}
}
