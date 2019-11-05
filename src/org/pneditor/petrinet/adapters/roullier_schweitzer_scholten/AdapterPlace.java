package org.pneditor.petrinet.adapters.roullier_schweitzer_scholten;

import org.pneditor.petrinet.AbstractPlace;

import org.pneditor.petrinet.models.roullier_schweitzer_scholten.Place;

public class AdapterPlace extends AbstractPlace{
	
	private Place place;

	public AdapterPlace(String label) {
		super(label);
		place = new Place();
	}

	@Override
	public void addToken() {
		place.addToken();
	}

	@Override
	public void removeToken() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTokens() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setTokens(int tokens) {
		// TODO Auto-generated method stub
		
	}

}
