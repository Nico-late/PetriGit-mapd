package org.pneditor.petrinet.models.roullier_schweitzer_scholten;
import java.util.ArrayList;

/**
 * Class that defines the transitions
 * @author SCHOLTEN_SCHWEITZER_ROULLIER
 *
 */
public class Transition {
	
	private ArrayList<Arc> arcsInput;
	private ArrayList<Arc> arcsOutput;
	
	/**
	 * A transition is defined by its outgoing and incoming arcs.
	 */
	public Transition() {
		arcsInput = new ArrayList<Arc>();
		arcsOutput = new ArrayList<Arc>();
	}
	
	/**
	 * This function checks if the transition can be fired
	 * @return boolean
	 */
	public boolean fireable() {
		for(int i=0; i<arcsInput.size(); i++) {
			
			// We have to make a difference for each type of arc
			// Zero Arcs
			if (arcsInput.get(i).getType() ==0) {
				if (arcsInput.get(i).getPlace().getToken()!=0) { // We can't fire if the place is not empty
					return false;
				}
			}
			
			// Empty Edges Arcs
			if (arcsInput.get(i).getType() ==2) {
				if (arcsInput.get(i).getPlace().getToken()==0) { // We can't fire if the place is empty
					return false;
				}
			}
			
			// Normal Arcs
			else {			
				if (arcsInput.get(i).getWeight()>arcsInput.get(i).getPlace().getToken()) { // We can't fire if the place doesnn't have enough tokens
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * This function fires the transition (if possible)
	 * @throws WrongInputException
	 */
	public void fire() throws WrongInputException {
		if (this.fireable()) {
			for(int i=0; i<arcsInput.size(); i++) {
				if (arcsInput.get(i).getType()==1) {	// We delete the tokens for the normal Arcs
					arcsInput.get(i).getPlace().delToken(arcsInput.get(i).getWeight());
				}
				if (arcsInput.get(i).getType()==2) {    // We delete all the tokens for the Empty Edges Arcs
					arcsInput.get(i).getPlace().setToken(0);
				}
			}
			for(int j=0; j<arcsOutput.size(); j++) {
				arcsOutput.get(j).getPlace().addToken(arcsOutput.get(j).getWeight());
			}
		}
		else {
			throw new WrongInputException();
		}
	}
	
	/**
	 * This function adds an arc to the corresponding list of the transition (arcInput or arcOutput)
	 * @param arc
	 */
	public void addArc(Arc arc) {
		if (arc.getType()== -1) {
			arcsOutput.add(arc);
		}
		else {
			arcsInput.add(arc);
		}
	}
	
	/**
	 *  Function that deletes all the arcs tied to this transition in all the places
	 */
		public void delArcTransition() {
			for(int i=0; i<arcsOutput.size(); i++) {
				arcsOutput.get(i).getPlace().getArcsInput().remove(arcsOutput.get(i));
			}
			for(int j=0; j<arcsInput.size(); j++) {
				arcsInput.get(j).getPlace().getArcsOutput().remove(arcsInput.get(j));
			}
		}
	
	public ArrayList<Arc> getArcsInput(){
		return arcsInput;
	}
	
	public ArrayList<Arc> getArcsOutput(){
		return arcsOutput;
	}
}
