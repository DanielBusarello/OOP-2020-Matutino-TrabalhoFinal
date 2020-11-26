/*
 * 
 * @author Daniel Busarello
 *  
 */

public class LPRO extends Enigma{
	private String[] alternatives = {
		"se Maria gosta de viol�o, ent�o Eduardo gosta de guitarra.",
		"se Brenda n�o gosta de flauta, ent�o Eduardo gosta de guitarra.",
		"se Jo�o gosta de bateria, ent�o Lara gosta de baixo.",
		"se Brenda n�o gosta de flauta, ent�o Pedro gosta de piano.",
		"se Maria n�o gosta de viol�o, ent�o Brenda gosta de flauta."	
	};
	
	public LPRO(int nwu, int nd, int ne, String ans) {
		super(nwu, nd, ne, ans);
	}
	
	public LPRO() {
		super.setAnswer("A");
		super.setDificult(3);
	}
	
	public String[] getAnswers() {
		return this.alternatives;
	}
}
