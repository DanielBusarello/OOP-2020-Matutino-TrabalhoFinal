import javax.swing.JPanel;

/*
 * 
 * @author Daniel Busarello
 *  
 */

public class LPRO extends Enigma {
	private static final long serialVersionUID = 1L;
	private String[] alternatives = { "se Maria gosta de violão, então Eduardo gosta de guitarra.",
			"se Brenda não gosta de flauta, então Eduardo gosta de guitarra.",
			"se João gosta de bateria, então Lara gosta de baixo.",
			"se Brenda não gosta de flauta, então Pedro gosta de piano.",
			"se Maria não gosta de violão, então Brenda gosta de flauta." };

	public LPRO(final ModuloM05 m) {
		super(m);
		super.setAnswer("A");
	}
	
	public LPRO() {
		super.setAnswer("A");
	}

	public String[] getAnswers() {
		return this.alternatives;
	}

	@Override
	public JPanel getPanel() {
		return new Enigma02(super.m);
	}
}

