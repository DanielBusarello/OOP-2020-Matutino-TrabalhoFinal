import java.io.*;
import javax.swing.JPanel;

/*
 * 
 * @author Daniel Busarello
 *  
 */

public abstract class Enigma extends JPanel implements Serializable {
	private static final long serialVersionUID = 1L;

	private int numWasUsed = 0;
	private int numDeciphered = 0;
	private int numErrors = 0;
	private String answer;
	
	private boolean desarmed = false;
	
	protected ModuloM05 m;

	public Enigma(final ModuloM05 m) {
		this.m = m;
	}
	
	public Enigma() {
		m = ModuloM05.instance;
	}

	public abstract JPanel getPanel();
	
	public void attach() {
        this.m = ModuloM05.instance;
    }
	
	public boolean checkAnswer(String usrAns) {
		if (usrAns == answer) {
			this.numDeciphered++;
			this.desarmed = true;
			return true;
		}
		numErrors++;
		return false;
	}

	public void wasUsed() {
		this.numWasUsed++;
	}

	public int getNumWasUsed() {
		return numWasUsed;
	}

	public void setNumWasUsed(int numWasUsed) {
		this.numWasUsed = numWasUsed;
	}

	public int getDeciphered() {
		return this.numDeciphered;
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

	public void isDesarmed(boolean b) {
		this.desarmed = b;
	}
	
	public boolean getDesarmed() {
		if(this.desarmed) {
			return true;
		} else 
			return false;
	}
}
