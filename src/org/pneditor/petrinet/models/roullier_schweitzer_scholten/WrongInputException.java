package org.pneditor.petrinet.models.roullier_schweitzer_scholten;
/**
 * Exception when input data are wrong
 * @author SCHOLTEN_SCHWEITZER_ROULLIER
 *
 */
@SuppressWarnings("serial")
public class WrongInputException extends Exception{

	public WrongInputException() {
		System.out.println("Input Data are wrong");
	}
}
