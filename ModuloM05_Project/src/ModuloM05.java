import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

/*
 * 
 * @author Daniel Busarello
 *  
 */

public class ModuloM05 {
	private int numberExec;
	private int numberActiv; 
	private int rightAnswers;
	private int wrongAnswers;
	private boolean defused;
	
	private EnigmaRL02 enigmaRL = new EnigmaRL02();
	private EnigmaLPRO01 enigmaLPro = new EnigmaLPRO01();
	
	private ArrayList<JFrame> enigmas = new ArrayList<JFrame>();
	Random r = new Random();
	
	public ModuloM05() {
		enigmas.add(this.enigmaRL);
		enigmas.add(this.enigmaLPro);
	}
	
	public JFrame getEnigma() {
		return enigmas.get(r.nextInt(2));
	}
	
	public int getNumberExec() {
		return numberExec;
	}
	public void setNumberExec(int numberExec) {
		this.numberExec = numberExec;
	}
	public int getNumberActiv() {
		return numberActiv;
	}
	public void setNumberActiv(int numberActiv) {
		this.numberActiv = numberActiv;
	}
	public int getRightAnswers() {
		return rightAnswers;
	}
	public void setRightAnswers(int rightAnswers) {
		this.rightAnswers = rightAnswers;
	}
	public int getWrongAnswers() {
		return wrongAnswers;
	}
	public void setWrongAnswers(int wrongAnswers) {
		this.wrongAnswers = wrongAnswers;
	}
	public boolean isDefused() {
		return defused;
	}
	public void setDefused(boolean defused) {
		this.defused = defused;
	}
	
	
}

