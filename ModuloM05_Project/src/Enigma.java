import java.io.*;
import javax.swing.JPanel;

/*
 * 
 * @author Daniel Busarello
 *  
 */

public abstract class Enigma extends JPanel implements Serializable {
	private static final long serialVersionUID = 1L;

	private int numWasUsed;
	private int numDeciphered;
	private int numErrors;
	private String answer;
	
	private int currentErrors;
	private boolean desarmed = false;
	private int i = 0;

	private ModuloM05 m;

	public Enigma() {
		this.wasUsed();
	}

	public abstract JPanel getPanel();
	
	public Enigma(int nwu, int nd, int ne, String ans) {
		this.setNumWasUsed(nwu);
		this.setNumDeciphered(nd);
		this.setNumErrors(ne);
		this.setAnswer(ans);
		this.wasUsed();
	}
	
	public void attach() {
        this.m = ModuloM05.instance;
    }
	
	public boolean checkAnswer(String usrAns) {
		if (usrAns == answer) {
			i = this.getDeciphered();
			i++;
			this.setNumDeciphered(i);
			System.out.println("Deciphered: " + this.getDeciphered());
			this.desarmed = true;
			return true;
		}
		i = this.getCurrentErrors();
		i++;
		this.setCurrentErrors(i);
		System.out.println("Errors: " + this.getNumErrors());
		m.addError();
		return false;
	}

	public void wasUsed() {
		i = this.getNumWasUsed();
		i++;
		this.setNumWasUsed(i);
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
		if (this.desarmed == true) {
			return true;
		}
		return false;
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
