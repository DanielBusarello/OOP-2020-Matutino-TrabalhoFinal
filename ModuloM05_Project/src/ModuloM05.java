import java.io.*;
import java.util.ArrayList;
import javax.swing.JPanel;

/*
 * 
 * @author Daniel Busarello
 *  
 */

public class ModuloM05 implements ModuleInterface, Serializable {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Enigma> enigmasList = new ArrayList<Enigma>();
	Enigma e;
	private int enigmaIndex;
	private int activations = 0;
	private boolean defused = false;
	
	public static ModuloM05 instance;

	String fileName = ".\\ModuloM05.ser";
	
	transient BombInterface bomb;
		
	public ModuloM05() {
		this.enigmasList.add(new RLOG(this));
		this.enigmasList.add(new LPRO(this));
	}
	
	public void inicialize(byte i) {
		enigmaIndex = setEnigmaIndex(i);
		deserialize();
		this.activations++;
		serialize();
	}
	
	public void addError() {
		this.bomb.addError();
	}
	
	public void serialize() {
		try {
			File file = new File(fileName);
			file.delete();
			file.createNewFile();
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
			
			out.writeObject(this);
            out.close(); 
            
        } catch(IOException ex) {
			System.out.println("IOException is caught");
			ex.printStackTrace();
		}
	}
	
	public void deserialize() {
		try
        {   
			File file = new File(fileName);
			if(file.exists()) {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
				ModuloM05 m = (ModuloM05) in.readObject(); 
				this.activations = m.activations;
				
				this.enigmasList.get(enigmaIndex).setNumWasUsed(m.enigmasList.get(enigmaIndex).getNumWasUsed());
				this.enigmasList.get(enigmaIndex).setNumDeciphered(m.enigmasList.get(enigmaIndex).getDeciphered());
				this.enigmasList.get(enigmaIndex).setNumErrors(m.enigmasList.get(enigmaIndex).getNumErrors());
				
				in.close(); 
			}
			
        } catch(IOException ex) { 
            System.out.println("IOException is caught"); 
            ex.printStackTrace();
        } catch(ClassNotFoundException ex) { 
            System.out.println("ClassNotFoundException is caught"); 
        } 
	}
	
	
	private int setEnigmaIndex(byte arg0) {
		if (arg0 < 3) {
			return 0;
		} else
			return 1;
	}
	
	public BombInterface getBomb() {
		return this.bomb;
	}
	
	@Override
	public void attach(final BombInterface arg0) {
		this.bomb = arg0;
	}

	@Override
	public EnigmaLevel getEnigmaLevel(byte arg0) {
		this.enigmaIndex = setEnigmaIndex(arg0);
		if (enigmaIndex == 0) {
			return EnigmaLevel.EASY;
		}
		return EnigmaLevel.HARD;
	}

	@Override
	public int getHowManyActivations() {
		deserialize();
		return this.activations;
	}

	@Override
	public int getHowManyExecutions(byte arg0) {
		deserialize();
		return this.enigmasList.get(enigmaIndex).getNumWasUsed(); 
	}

	@Override
	public int getHowManyRightAnswers(byte arg0) {
		deserialize();
		return this.enigmasList.get(enigmaIndex).getDeciphered();
	}

	@Override
	public int getHowManyWrongAnswers(byte arg0) {
		deserialize();
		return this.enigmasList.get(enigmaIndex).getNumErrors();
	}

	@Override
	public JPanel getPanel(byte arg0) {
		inicialize(arg0);
		this.enigmaIndex = this.setEnigmaIndex(arg0);
		this.enigmasList.get(enigmaIndex).wasUsed();
		serialize();
		return this.enigmasList.get(enigmaIndex).getPanel();
	}

	@Override
	public boolean isDefused() {
		return this.defused;
	}
	
	public void setDefused(boolean b, byte arg0) {
		enigmaIndex = this.setEnigmaIndex(arg0);
		this.e = this.enigmasList.get(enigmaIndex);
		this.defused = b;
	}
	
	public void setRightAnswer() {
		int i = this.e.getDeciphered();
		i++;
		this.e.setNumDeciphered(i);
	}
	
	public void setErrors() {
		int i = this.e.getNumErrors();
		i++;
		this.e.setNumErrors(i);
	}
	
}
