import java.util.ArrayList;
import javax.swing.JPanel;

/*
 * 
 * @author Daniel Busarello
 *  
 */

public class ModuloM05 implements ModuleInterface{
	private ArrayList<JPanel> enigmas = new ArrayList<JPanel>();
	//private BombInterface bomb;
	
	public ModuloM05() {
		enigmas.add(new Enigma01());
		enigmas.add(new Enigma02());
	}
	
	@Override
	public void attach(BombInterface arg0) {
		
	}

	@Override
	public EnigmaLevel getEnigmaLevel(byte arg0) {
		
		return null;
	}

	@Override
	public int getHowManyActivations() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHowManyExecutions(byte arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHowManyRightAnswers(byte arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHowManyWrongAnswers(byte arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public JPanel getPanel(byte arg0) {
		if(arg0 < 3) {
			return enigmas.get(0);
		} else 
			return enigmas.get(1);
		
	}

	@Override
	public boolean isDefused() {
		// TODO Auto-generated method stub
		return false;
	}	
}

