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
	private int enigmaIndex = 0;
	private boolean defused;
	private int activations;
	
	public static ModuloM05 instance;

	String fileName = ".\\ModuloM05.ser";
	
	private BombInterface bomb;
		
	public ModuloM05() {
		this.enigmasList.add(new RLOG());
		this.enigmasList.add(new LPRO());
		deserialize();
		this.activations++;
	}
	
	public void addError() {
		this.bomb.addError();
	}
	
	public void deserialize() {
		try
        {   
			FileInputStream file = new FileInputStream(fileName); 
            ObjectInputStream in = new ObjectInputStream(file); 
            
            ModuloM05 m;
            m = (ModuloM05) in.readObject(); 
              
            in.close(); 
            file.close();
            
            this.setActivation(m.getActivations());
            
            for(int i = 0; i < enigmasList.size(); i++) {
            	enigmasList.get(i).setNumDeciphered(m.enigmasList.get(i).getDeciphered());
            	enigmasList.get(i).setNumErrors(m.enigmasList.get(i).getNumErrors());
            	enigmasList.get(i).setNumWasUsed(m.enigmasList.get(i).getNumWasUsed());
            }
              
        } catch(IOException ex) { 
            System.out.println("IOException is caught"); 
            ex.printStackTrace();
        } catch(ClassNotFoundException ex) { 
            System.out.println("ClassNotFoundException is caught"); 
        } 
	}
	
	public void serialize() {
		try {
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			out.writeObject(this); 
            
            out.close(); 
            file.close();
            System.out.println("Gravação completa");
		} catch(IOException ex) {
			System.out.println("IOException is caught");
			ex.printStackTrace();
		}
	}
	
	private int setEnigmaIndex(byte arg0) {
		if (arg0 < 3) {
			return 0;
		} else
			return 1;
	}

	private void setActivation(int a) {
		this.activations = a;
	}
	
	public int getActivations() {
		return this.activations;
	}
	
	public BombInterface getBomb() {
		return this.bomb;
	}
	
	@Override
	public void attach(final BombInterface bomb) {
		this.bomb = bomb;
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
		return this.getActivations();
	}

	@Override
	public int getHowManyExecutions(byte arg0) {
		this.enigmaIndex = setEnigmaIndex(arg0);
		return this.enigmasList.get(enigmaIndex).getNumWasUsed();
	}

	@Override
	public int getHowManyRightAnswers(byte arg0) {
		this.enigmaIndex = setEnigmaIndex(arg0);
		return this.enigmasList.get(enigmaIndex).getDeciphered();
		//return 0;
	}

	@Override
	public int getHowManyWrongAnswers(byte arg0) {
		this.enigmaIndex = setEnigmaIndex(arg0);
		return this.enigmasList.get(enigmaIndex).getNumErrors();
	}

	@Override
	public JPanel getPanel(byte arg0) {
		this.enigmaIndex = this.setEnigmaIndex(arg0);
		return this.enigmasList.get(enigmaIndex).getPanel();
	}

	@Override
	public boolean isDefused() {
		if(this.enigmasList.get(enigmaIndex).isDesarmed()) {
			this.defused = true;
		}
		else
			this.defused = false;
		serialize();
		return this.defused;
	}
}
