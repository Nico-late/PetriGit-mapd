package org.pneditor.petrinet.adapters.roullier_schweitzer_scholten;

import org.pneditor.petrinet.AbstractPlace;

import org.pneditor.petrinet.models.roullier_schweitzer_scholten.Place;
import org.pneditor.petrinet.models.roullier_schweitzer_scholten.WrongInputException;

public class PlaceAdapter extends AbstractPlace{
	
	private Place place;

	public PlaceAdapter(String label) {
		super(label);
		place = new Place();
	}

	@Override
	public void addToken() {
		try {
			place.addToken(1);
		} catch (WrongInputException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeToken() {
		try {
			place.delToken(1);
		} catch (WrongInputException e) {
			e.printStackTrace();
		}
	}		

	@Override
	public int getTokens() {
		return place.getToken();
	}

	@Override
	public void setTokens(int tokens) {
		try {
			place.setToken(tokens);
		} catch (WrongInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
	}
	
	public Place getPlace() {
		return this.place;
	}

}
