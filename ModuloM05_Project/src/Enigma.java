import javax.swing.JPanel;

/*
 * 
 * @author Daniel Busarello
 *  
 */

public abstract class Enigma {
	private int numWasUsed;
	private int numDeciphered;
	private int numErrors;
	private String answer;
	
	private int currentErrors;
	private boolean desarmed = false;
	private int dificult;
	private int i = 0;
	
	private JPanel panel;
	
	public Enigma() {
		this.wasUser();
	}
	
	// For serialize
	public Enigma(int nwu, int nd, int ne, String ans){
		this.setNumWasUsed(nwu);
		this.setNumDeciphered(nd);
		this.setNumErrors(ne);
		this.setAnswer(ans);
		this.wasUser();
	}

	public boolean checkAnswer(String usrAns) {
		if(usrAns == answer) {
			i = this.getDeciphered();
			i++;
			this.setNumDeciphered(i);
			return true;
		}
		i = this.getCurrentErrors();
		i++;
		this.setCurrentErrors(i);
		return false;
	}
	
	public void wasUser() {
		i = this.getNumWasUsed();
		i++;
		this.setNumWasUsed(i);
	}
	
	public JPanel getPanel() {
		return this.panel;
	}
	public void setPanel(JPanel panel) { 
		this.panel = panel;
	}
	
	public int getNumWasUsed() {
		return numWasUsed;
	}
	public void setNumWasUsed(int numWasUsed) {
		this.numWasUsed = numWasUsed;
	}
	public int getDeciphered() {
		return numDeciphered;
	}
	public void setNumDeciphered(int deciphered) {
		numDeciphered = deciphered;
	}
	public int getNumErrors() {
		return numErrors;
	}
	public void setNumErrors(int numErrors) {
		this.numErrors = numErrors;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public boolean isDesarmed() {
		if(this.desarmed == true) {
			return true;
		}
		return false;
	}
	public int getDificult() {
		return dificult;
	}
	public void setDificult(int dificult) {
		this.dificult = dificult;
	}
	public int getCurrentErrors() {
		return currentErrors;
	}
	public void setCurrentErrors(int currentErrors) {
		this.currentErrors = currentErrors;
		// Add error to total errors' historic
		i = this.getNumErrors();
		i++;
		this.setNumErrors(i);
	}
}
