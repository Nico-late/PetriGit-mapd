package org.pneditor.petrinet.models.roullier_schweitzer_scholten;
/**
 * Interface of the PetriNet
 * @author SCHOLTEN_SCHWEITZER_ROULLIER
 *
 */
public interface IPetriNet {

	/**
	 * Adds a place to the PetriNet
	 * @param place
	 */
	void addPlace(Place place);
	
	/**
	 * Deletes a place from the PetriNet
	 * @param place
	 */
	void delPlace(Place place);
	
	/**
	 * Adds a transition to the PetriNet
	 * @param transition
	 */
	void addTransition(Transition transition);
	
	/**
	 * Deletes a transition from the PetriNet
	 * @param transition
	 */
	void delTransition(Transition transition);
	
	/**
	 * Adds a arc to the PetriNet
	 * @param arc
	 */
	void addArc(Arc arc);

	/**
	 * Deletes a arc from the PetriNet
	 * @param place
	 */
	void delArc(Arc arc);

	/**
	 * Fires a transition
	 * @param transition
	 * @throws WrongInputException
	 */
	void fire(Transition transition) throws WrongInputException;
	
	/**
	 * Launches the simulation and stops when no transitions can be fired anymore
	 * @throws WrongInputException
	 */
	void launch() throws WrongInputException;
	
	/**
	 * Adds a number of tokens to a place
	 * @param place
	 * @param number
	 * @throws WrongInputException
	 */
	void addToken(Place place, int number) throws WrongInputException;
	
	/**
	 * Deletes a number of tokens from a place
	 * @param place
	 * @param number
	 * @throws WrongInputException
	 */
	void delToken(Place place, int number) throws WrongInputException;
	
	/**
	 * Sets a place to a number of tokens
	 * @param place
	 * @param number
	 * @throws WrongInputException
	 */
	void setToken(Place place, int number) throws WrongInputException;
	
	/**
	 * Sets the weight of an arc
	 * @param arc
	 * @param weight
	 * @throws WrongInputException
	 */
	void setWeight(Arc arc, int weight) throws WrongInputException;
	
	/**
	 * Sets an arc to a special type (0 or 2)
	 * @param arc
	 * @param type
	 * @throws WrongInputException
	 */
	void setType(Arc arc, int type) throws WrongInputException;

	/**
	 * Sets an arc to a normal type (-1 or 1)
	 * @param arc
	 * @param type
	 * @param weight
	 * @throws WrongInputException
	 */
	void setType(Arc arc, int type, int weight) throws WrongInputException;
}
