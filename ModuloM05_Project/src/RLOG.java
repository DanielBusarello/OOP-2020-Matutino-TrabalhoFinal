import javax.swing.JPanel;

/*
 * 
 * @author Daniel Busarello
 *  
 */

public class RLOG extends Enigma {
	public RLOG(int nwu, int nd, int ne, String ans) {
		super(nwu, nd, ne, ans);
	}

	public RLOG() {
		super.setAnswer("D");
	}
	
	@Override
	public JPanel getPanel() {
		return new Enigma01();
	}

}
