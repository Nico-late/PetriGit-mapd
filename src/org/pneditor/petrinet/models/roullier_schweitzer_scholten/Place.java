package org.pneditor.petrinet.models.roullier_schweitzer_scholten;
import java.util.ArrayList;

/**
 * Class that defines the places
 * @author SCHOLTEN_SCHWEITZER_ROULLIER
 *
 */
public class Place {
	
	private int token;
	private ArrayList<Arc> arcsInput;
	private ArrayList<Arc> arcsOutput;

	/**
	 * A place is defined by its number of tokens and its outgoing and incoming arcs.
	 * @param token
	 */
	public Place(int token) {
		this.token = token;
		arcsInput = new ArrayList<Arc>(); 
		arcsOutput = new ArrayList<Arc>();
	}
	
	public Place() {
		this.token = 0;
		arcsInput = new ArrayList<Arc>(); 
		arcsOutput = new ArrayList<Arc>();
	}
	
	/**
	 * Adds the number of token to the place if it is positive. Else, it does nothing
	 * @param number
	 * @throws WrongInputException 
	 */
	public void addToken() {
		this.token += 1;
	}
	
	public int getToken() {
		return this.token;
	}
	
	/**
	 * Delete the number of token from the place.
	 * @param number
	 * @throws WrongInputException
	 */
	public void delToken(){
		if (this.getToken()>=1) {
			this.token -= 1;
		}
	}
	
	/**
	 * Sets the number of token of a place.
	 * @param number
	 * @throws WrongInputException 
	 */
	public void setToken(int number) throws WrongInputException{
		if (number >= 0) {
			this.token = number;
		}
		else {
			throw new WrongInputException();
		}
	}
	
	/**
	 * This function adds an arc to the corresponding list of the place (arcInput or arcOutput)
	 * @param arc
	 */
	
	public void addArc(Arc arc) {
		if (arc.getType()== -1) {
			arcsInput.add(arc);
		}
		else {
			arcsOutput.add(arc);
		}
	}
	
	/**
	 * Function that deletes all the arcs tied to this place in all the transitions
	 */
	public void delArcPLace() {
		for(int i=0; i<arcsOutput.size(); i++) {
			arcsOutput.get(i).getTransition().getArcsInput().remove(arcsOutput.get(i));
		}
		for(int j=0; j<arcsInput.size(); j++) {
			arcsInput.get(j).getTransition().getArcsOutput().remove(arcsInput.get(j));
		}
	}
	
	public ArrayList<Arc> getArcsInput(){
		return arcsInput;
	}
	
	public ArrayList<Arc> getArcsOutput(){
		return arcsOutput;
	}
}
