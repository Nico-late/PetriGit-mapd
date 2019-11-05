package org.pneditor.petrinet.adapters.roullier_schweitzer_scholten;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.ResetArcMultiplicityException;

import org.pneditor.petrinet.models.roullier_schweitzer_scholten.Place;
import org.pneditor.petrinet.models.roullier_schweitzer_scholten.Arc;
import org.pneditor.petrinet.models.roullier_schweitzer_scholten.Transition;

import org.pneditor.petrinet.models.roullier_schweitzer_scholten.WrongInputException;

public class AdapterArc extends AbstractArc {
	private Arc arc;
	private Place place;
	private Transition transition;
	
	
	@Override	
	public AbstractNode getSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractNode getDestination() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isReset() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRegular() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInhibitory() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getMultiplicity() throws ResetArcMultiplicityException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMultiplicity(int multiplicity) throws ResetArcMultiplicityException {
		// TODO Auto-generated method stub
		
	}

}
