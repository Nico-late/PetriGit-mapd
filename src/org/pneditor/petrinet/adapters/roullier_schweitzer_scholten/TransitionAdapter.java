package org.pneditor.petrinet.adapters.roullier_schweitzer_scholten;

import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.models.roullier_schweitzer_scholten.Transition;

public class TransitionAdapter extends AbstractTransition{

	private Transition transition;
	
	/**
	 * This function adapts the constructor of transition.
	 * Other Transition's methods are adapted in the PetriNetAdapter excluding getTransition
	 * that is adapted just after.
	 * @param label
	 */
	public TransitionAdapter(String label) {
		super(label);
		transition = new Transition();
	}
	
	/**
	 * This function retrieves the transition from the model.
	 * @return
	 */
	public Transition getTransition() {
		return this.transition;
	}

}
