import javax.swing.JPanel;

/*
 * 
 * @author Daniel Busarello
 *  
 */

public class LPRO extends Enigma {
	private static final long serialVersionUID = 1L;
	private String[] alternatives = { "se Maria gosta de viol�o, ent�o Eduardo gosta de guitarra.",
			"se Brenda n�o gosta de flauta, ent�o Eduardo gosta de guitarra.",
			"se Jo�o gosta de bateria, ent�o Lara gosta de baixo.",
			"se Brenda n�o gosta de flauta, ent�o Pedro gosta de piano.",
			"se Maria n�o gosta de viol�o, ent�o Brenda gosta de flauta." };

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

