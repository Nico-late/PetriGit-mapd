package org.pneditor.petrinet.adapters.roullier_schweitzer_scholten;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.ResetArcMultiplicityException;

import org.pneditor.petrinet.models.roullier_schweitzer_scholten.Arc;
import org.pneditor.petrinet.models.roullier_schweitzer_scholten.WrongInputException;

public class ArcAdapter extends AbstractArc {
	private Arc arc;
	private AbstractNode source;
	private AbstractNode destination;
	
	
	public ArcAdapter(AbstractNode source, AbstractNode destination, String type) {
		this.source=source;
		this.destination= destination;
		if (type=="regular") {
			if (source.isPlace()) {
				PlaceAdapter sourceAdapter = (PlaceAdapter) source;
				TransitionAdapter destinationAdapter = (TransitionAdapter) destination;
				try {
					arc = new Arc(1, sourceAdapter.getPlace(), destinationAdapter.getTransition(), 1);
				} catch (WrongInputException e) {
					e.printStackTrace();
				}
			}
			else {
				TransitionAdapter sourceAdapter = (TransitionAdapter) source;
				PlaceAdapter destinationAdapter = (PlaceAdapter) destination;
				try {
					arc = new Arc(1, destinationAdapter.getPlace(), sourceAdapter.getTransition(), -1);
				} catch (WrongInputException e) {
					e.printStackTrace();
				}
			}
		}
		if (type=="Inhibitory") {
			this.source=source;
			this.destination= destination;
			PlaceAdapter sourceAdapter = (PlaceAdapter) source;
			TransitionAdapter adapterDestination = (TransitionAdapter) destination;
			try {
				arc = new Arc(sourceAdapter.getPlace(), adapterDestination.getTransition(), 0);
			} catch (WrongInputException e) {
				e.printStackTrace();
			}
		}
		if (type=="Reset") {
			this.source=source;
			this.destination= destination;
			PlaceAdapter sourceAdapter = (PlaceAdapter) source;
			TransitionAdapter destinationAdapter = (TransitionAdapter) destination;
			try {
				arc = new Arc(sourceAdapter.getPlace(), destinationAdapter.getTransition(), 2);
			} catch (WrongInputException e) {
				e.printStackTrace();
			}
		}
	}

	@Override	
	public AbstractNode getSource() {
		return this.source;
	}

	@Override
	public AbstractNode getDestination() {
		return this.destination;
	}

	@Override
	public boolean isReset() {
		if (arc.getType()==2) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isRegular() {
		if ((arc.getType()==-1)||(arc.getType()==1)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInhibitory() {
		if (arc.getType()==0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int getMultiplicity() throws ResetArcMultiplicityException {
		return arc.getWeight();
	}

	@Override
	public void setMultiplicity(int multiplicity) throws ResetArcMultiplicityException {
		try {
			arc.setWeight(multiplicity);
		} catch (WrongInputException e) {
			e.printStackTrace();
		}
	}
	
	public Arc getArc() {
		return this.arc;
	}

}

