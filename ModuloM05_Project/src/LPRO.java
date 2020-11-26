/*
 * 
 * @author Daniel Busarello
 *  
 */

public class LPRO extends Enigma{
	private String[] alternatives = {
		"se Maria gosta de violão, então Eduardo gosta de guitarra.",
		"se Brenda não gosta de flauta, então Eduardo gosta de guitarra.",
		"se João gosta de bateria, então Lara gosta de baixo.",
		"se Brenda não gosta de flauta, então Pedro gosta de piano.",
		"se Maria não gosta de violão, então Brenda gosta de flauta."	
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
