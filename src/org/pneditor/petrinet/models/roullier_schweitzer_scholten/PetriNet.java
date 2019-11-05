package org.pneditor.petrinet.models.roullier_schweitzer_scholten;
import java.util.ArrayList;

/**
 * Class that defines the PetriNet
 * @author SCHOLTEN_SCHWEITZER_ROULLIER
 *
 */
public class PetriNet implements IPetriNet{
	
	private ArrayList<Place> placeList;
	private ArrayList<Transition> transitionList;

	public PetriNet() {
		placeList = new ArrayList<Place>();
		transitionList = new ArrayList<Transition>();
	}
	
	public PetriNet(ArrayList<Place> places, ArrayList<Transition> transitions) {
		placeList = places;
		transitionList = transitions;
	}
	
	public void addPlace(Place place) {
			placeList.add(place);
	}
	
	public void addTransition(Transition transition) {
		transitionList.add(transition);
	}
	
	/**
	 * If the place is in the list, then it deletes the place and all the arcs linked to it
	 * Else, it does nothing.
	 * @param place
	 */
	public void delPlace(Place place) {
		if (placeList.contains(place)) {
			place.delArcPLace();
			placeList.remove(place);
		}
	}
	
	/**
	 * If the transition is in the list, then it deletes the transition and all the arcs linked to it.
	 * Else, it does nothing.
	 * @param transition
	 */
	public void delTransition(Transition transition) {
		if (transitionList.contains(transition)) {
			transition.delArcTransition();
			transitionList.remove(transition);
		}
	}
	
	/**
	 * Function that adds an arc to the place and the transition it is linked to
	 * @param arc
	 */
	public void addArc(Arc arc) {
		arc.getPlace().addArc(arc);
		arc.getTransition().addArc(arc);

	}
	
	/**
	 * Function that deletes an Arc.
	 * The condition is here to delete the arc in the good list in place an in transition (it depends on the arc's direction)
	 * @param arc
	 */
	
	public void delArc(Arc arc) {
		if (arc.getType()==-1) {
			if(arc.getPlace().getArcsInput().contains(arc) & arc.getTransition().getArcsOutput().contains(arc)) {
				arc.getPlace().getArcsInput().remove(arc);
				arc.getTransition().getArcsOutput().remove(arc);
			}
			
		}
		else {
			if(arc.getTransition().getArcsInput().contains(arc) & arc.getPlace().getArcsOutput().remove(arc)) {
				arc.getTransition().getArcsInput().remove(arc);
				arc.getPlace().getArcsOutput().remove(arc);
			}
			
		}
	}
	
	
	/**
	 * Function that fire a specific transition
	 * @param transition
	 */
	public void fire(Transition transition) throws WrongInputException {
		if (transitionList.contains(transition) & transition.fireable()) {
			transition.fire();
		}
	}
	
	/**
	 * Function that fires all the fireable transitions in a random order until no transition can be fired anymore
	 */
	
	public void launch() throws WrongInputException {
		ArrayList<Transition> fireableTransition = new ArrayList<Transition>();
		for(int i=0; i<transitionList.size(); i++) {
			if (transitionList.get(i).fireable()) {
				fireableTransition.add(transitionList.get(i));
			}
		}
		while(fireableTransition.size()!=0) {
			int randomNumber = (int) Math.floor(Math.random() * Math.floor(fireableTransition.size()));
			fireableTransition.get(randomNumber).fire();
			fireableTransition.clear();
			
			for(int i=0; i<transitionList.size(); i++) {
				if (transitionList.get(i).fireable()) {
					fireableTransition.add(transitionList.get(i));
				}
			}
		}
		
	}
	
	/**
	 * Function that adds a certain amount of tokens to a place
	 * @param place
	 * @param number
	 * @throws WrongInputException 
	 */
	public void addToken(Place place, int token) throws WrongInputException {
		if (placeList.contains(place)) {
			place.addToken(token);
		}
	}
	
	/**
	 * Function that deletes a certain amount of token from a place if it's possible
	 * If it's not, an error is raised
	 * @param place
	 * @param token
	 * @throws WrongInputException
	 */
	public void delToken(Place place, int token) throws WrongInputException {
		if (placeList.contains(place)) {
			place.delToken(token);
		}
	}
	
	/**
	 * Function that sets the amount of tokens from a place to a certain number
	 * @param place
	 * @param token
	 * @throws WrongInputException 
	 */
	public void setToken(Place place, int token) throws WrongInputException {
		if (placeList.contains(place)) {
			place.setToken(token);
		}
	}
	
	/**
	 * Function that sets the weight of an arc to a certain number
	 * @param arc
	 * @param weight
	 * @throws WrongInputException
	 */
	public void setWeight(Arc arc,int weight) throws WrongInputException {
		arc.setWeight(weight);
	}
	
	/**
	 * This function is used to change the type of an arc to a type which doesn't have weight (Zero or empty arc)
	 * @param arc
	 * @param type
	 * @throws WrongInputException 
	 */
	public void setType(Arc arc, int type) throws WrongInputException {
		arc.setType(type);
	}
	
	/**
	 * This function is used to change the type of an arc to a type which has weight (outgoing or incoming arc)
	 * @param arc
	 * @param type
	 * @param weight
	 * @throws WrongInputException 
	 */
	public void setType(Arc arc, int type, int weight) throws WrongInputException {
		arc.setType(type,weight);
	}
}
