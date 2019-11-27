package org.pneditor.petrinet.adapters.roullier_schweitzer_scholten;

import org.pneditor.petrinet.AbstractPlace;

import org.pneditor.petrinet.models.roullier_schweitzer_scholten.Place;
import org.pneditor.petrinet.models.roullier_schweitzer_scholten.WrongInputException;

public class PlaceAdapter extends AbstractPlace{
	
	private Place place;

	/**
	 * Adapter of Place's constructor
	 * @param label
	 */
	public PlaceAdapter(String label) {
		super(label);
		place = new Place();
	}

	/**
	 * It adapts addToken method. Already described in Place.
	 */
	@Override
	public void addToken() {
		try {
			place.addToken(1);
		} catch (WrongInputException e) {
			e.printStackTrace();
		}
	}

	/**
	 * It adapts delToken method. Already described in Place.
	 */
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

	/**
	 * It adapts setToken method. Already described in Place.
	 */
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
