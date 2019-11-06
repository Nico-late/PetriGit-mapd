package org.pneditor.petrinet.adapters.roullier_schweitzer_scholten;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.PetriNetInterface;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.UnimplementedCaseException;
import org.pneditor.petrinet.models.roullier_schweitzer_scholten.PetriNet;
import org.pneditor.petrinet.models.roullier_schweitzer_scholten.WrongInputException;

public class PetriNetAdapter extends PetriNetInterface{
	
	private PetriNet petriNet;
	private int countPlaces=0;
	private int countTransitions=0;

	public PetriNetAdapter() {
		petriNet = new PetriNet();
	}
	@Override
	public AbstractPlace addPlace() {
		PlaceAdapter placeAdapter = new PlaceAdapter("Place " + countPlaces);
		countPlaces+=1;
		petriNet.addPlace(placeAdapter.getPlace());
		return placeAdapter;
	}

	@Override
	public AbstractTransition addTransition() {
		TransitionAdapter transitionAdapter = new TransitionAdapter("Transition " + countTransitions);
		countTransitions+=1;
		petriNet.addTransition(transitionAdapter.getTransition());
		return transitionAdapter;
	}

	@Override
	public AbstractArc addRegularArc(AbstractNode source, AbstractNode destination) throws UnimplementedCaseException {
		ArcAdapter arcAdapter = new ArcAdapter(source, destination, "regular");
		petriNet.addArc(arcAdapter.getArc());
		return arcAdapter;
	}

	@Override
	public AbstractArc addInhibitoryArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		ArcAdapter arcAdapter = new ArcAdapter(place, transition, "Inhibitory");
		petriNet.addArc(arcAdapter.getArc());
		return arcAdapter;
	}

	@Override
	public AbstractArc addResetArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		ArcAdapter arcAdapter = new ArcAdapter(place, transition, "Reset");
		petriNet.addArc(arcAdapter.getArc());
		return arcAdapter;
	}

	@Override
	public void removePlace(AbstractPlace place) {
		PlaceAdapter placeAdapter = (PlaceAdapter) place; 
		petriNet.delPlace(placeAdapter.getPlace());
	}

	@Override
	public void removeTransition(AbstractTransition transition) {
		TransitionAdapter transitionAdapter = (TransitionAdapter) transition; 
		petriNet.delTransition(transitionAdapter.getTransition());		
	}

	@Override
	public void removeArc(AbstractArc arc) {
		ArcAdapter arcAdapter = (ArcAdapter) arc; 
		petriNet.delArc(arcAdapter.getArc());				
	}

	@Override
	public boolean isEnabled(AbstractTransition transition) throws ResetArcMultiplicityException {
		TransitionAdapter transitionAdapter = (TransitionAdapter) transition; 
		return transitionAdapter.getTransition().fireable();
	}

	@Override
	public void fire(AbstractTransition transition) throws ResetArcMultiplicityException {
		TransitionAdapter transitionAdapter = (TransitionAdapter) transition; 
		try {
			petriNet.fire(transitionAdapter.getTransition());
		} catch (WrongInputException e) {
			e.printStackTrace();
		}
	}

}
