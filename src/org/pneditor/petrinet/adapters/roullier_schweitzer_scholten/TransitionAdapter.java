package org.pneditor.petrinet.adapters.roullier_schweitzer_scholten;

import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.models.roullier_schweitzer_scholten.Transition;

public class TransitionAdapter extends AbstractTransition{

	private Transition transition;
	
	public TransitionAdapter(String label) {
		super(label);
		transition = new Transition();
	}
	
	public Transition getTransition() {
		return this.transition;
	}

}
