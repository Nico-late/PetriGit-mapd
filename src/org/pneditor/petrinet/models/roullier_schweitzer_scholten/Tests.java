package org.pneditor.petrinet.models.roullier_schweitzer_scholten;
/**
 * Class that tests the code
 * @author SCHOLTEN_SCHWEITZER_ROULLIER
 *
 */
public class Tests {

	public static void main(String[] args) throws WrongInputException {
		PetriNet petri = new PetriNet();
		
		// Test 1 : 
		// Creation of a place, a transition and a normal arc going from the place to the transition
		// Can the transition be fired when it should be possible (they are enough tokens in the place)
		// Are the tokens deleted in the place
		
		Place p1 = new Place(4);
		Transition t1 = new Transition();
		Arc a1 = new Arc(3, p1, t1, 1);
		
		petri.addPlace(p1);
		petri.addTransition(t1);
		petri.addArc(a1);
		
		petri.fire(t1);
		System.out.println("Test 1 expectations:");
		System.out.println("1");
		System.out.println("Test 1 results:");
		System.out.println(p1.getToken());

		
		// Test 2 :
		// Creation of a normal arc going from a transition to a  place
		// When the transition is fired, are tokens added to this new place
		
		Place p2 = new Place(0);
		Transition t2 = new Transition();
		Arc a2 = new Arc(2, p2, t2, -1);
		
		petri.addPlace(p2);
		petri.addArc(a2);
		petri.addTransition(t2);
				
		petri.fire(t2);
		System.out.println("Test 2 expectations:");
		System.out.println("2");
		System.out.println("Test 2 results:");
		System.out.println(p2.getToken());
		
		
		// Test 3 :
		// Is the transition not fired when it shouldn't be possible (not enough tokens in the first place)
		
		System.out.println("Test 3 expectations:");
		System.out.println("WrongInputException");
		System.out.println("Test 3 results:");
		// Remove // in the next line
		//petri.fire(t1);

		
		//Test 4 : Verification it still works when they are several places connected to a transition
		
		Place p3 = new Place(4);
		Place p4 = new Place(6);
		Place p5 = new Place(0);
		Place p6 = new Place(1);
		Transition t3 = new Transition();
		Arc a3 = new Arc(2, p3, t3, 1);
		Arc a4 = new Arc(3, p4, t3, 1);
		Arc a5 = new Arc(1, p5, t3, -1);
		Arc a6 = new Arc(4, p6, t3, -1);
		
		petri.addPlace(p3);
		petri.addPlace(p4);
		petri.addPlace(p5);
		petri.addPlace(p6);
		petri.addTransition(t3);
		petri.addArc(a3);
		petri.addArc(a4);
		petri.addArc(a5);
		petri.addArc(a6);

		petri.fire(t3);
		System.out.println("Test 4 expectations:");
		System.out.println("2");
		System.out.println("3");
		System.out.println("1");
		System.out.println("5");
		System.out.println("Test 4 results:");
		System.out.println(p3.getToken());
		System.out.println(p4.getToken());
		System.out.println(p5.getToken());
		System.out.println(p6.getToken());
		
		
		//Test 5 : Verification zero arcs work
		
		Place p7 = new Place(0);
		Place p8 = new Place(0);
		Transition t4 = new Transition();
		Arc a7 = new Arc(p7, t4, 0);
		Arc a8 = new Arc(1, p8, t4, -1);

		petri.addPlace(p7);
		petri.addPlace(p8);
		petri.addTransition(t4);
		petri.addArc(a7);
		petri.addArc(a8);

		petri.fire(t4);
		System.out.println("Test 5 expectations:");
		System.out.println("0");
		System.out.println("1");
		System.out.println("Test 5 results:");
		System.out.println(p7.getToken());
		System.out.println(p8.getToken());
		
		
		//Test 6 : Verification empty arcs work
		
		Place p9 = new Place(7);
		Place p10 = new Place(0);
		Transition t5 = new Transition();
		Arc a9 = new Arc(p9, t5, 2);
		Arc a10 = new Arc(2, p10, t5, -1);

		petri.addPlace(p9);
		petri.addPlace(p10);
		petri.addTransition(t5);
		petri.addArc(a9);
		petri.addArc(a10);

		petri.fire(t5);
		System.out.println("Test 6 expectations:");
		System.out.println("0");
		System.out.println("2");
		System.out.println("Test 6 results:");
		System.out.println(p9.getToken());
		System.out.println(p10.getToken());
		
		
		// Test 7 :
		// Verification the launch works
		
		PetriNet petriLaunch = new PetriNet();
		
		Place p11 = new Place(9);
		Place p12 = new Place(2);
		Place p13 = new Place(0);
		Place p14 = new Place(0);
		Transition t6 = new Transition();
		Transition t7 = new Transition();
		Arc a11 = new Arc(3, p11, t6, 1);
		Arc a12 = new Arc(1, p12, t6, 1);
		Arc a13 = new Arc(5, p13, t6, -1);
		Arc a14 = new Arc(p13, t7, 2);
		Arc a15 = new Arc(2, p14, t7, -1);

		petriLaunch.addPlace(p11);
		petriLaunch.addPlace(p12);
		petriLaunch.addPlace(p13);
		petriLaunch.addPlace(p14);
		petriLaunch.addTransition(t6);
		petriLaunch.addTransition(t7);
		petriLaunch.addArc(a11);
		petriLaunch.addArc(a12);
		petriLaunch.addArc(a13);
		petriLaunch.addArc(a14);
		petriLaunch.addArc(a15);

		petriLaunch.launch();
		System.out.println("Test 7 expectations:");
		System.out.println("3");
		System.out.println("0");
		System.out.println("0");
		System.out.println("2 or 4");
		System.out.println("Test 7 results:");
		System.out.println(p11.getToken());
		System.out.println(p12.getToken());
		System.out.println(p13.getToken());
		System.out.println(p14.getToken());
		
		
		// Test 8 :
		// Verification setWeight of an arc works
		
		Place p15 = new Place(4);
		Transition t8 = new Transition();
		Arc a16 = new Arc(5, p15, t8, 1);
		petri.setWeight(a16,4);
		
		petri.addPlace(p15);
		petri.addTransition(t8);
		petri.addArc(a16);
		
		petri.fire(t8);
		System.out.println("Test 8 expectations:");
		System.out.println("0");
		System.out.println("Test 8 results:");
		System.out.println(p15.getToken());

		
		// Test 9 :
		// Verification setType of an arc works
		
		Place p16 = new Place(0);
		Place p17 = new Place(8);
		Transition t9 = new Transition();
		Arc a17 = new Arc(4, p16, t9, -1);
		Arc a18 = new Arc(p17, t9, 0);

		petri.addPlace(p16);
		petri.addPlace(p17);
		petri.addTransition(t9);
		petri.addArc(a17);
		petri.addArc(a18);
		petri.setType(a17, 0);
		petri.setType(a18, -1, 4);

		petri.fire(t9);
		System.out.println("Test 9 expectations:");
		System.out.println("12");
		System.out.println("Test 9 results:");
		System.out.println(p17.getToken());
		petri.fire(t9);

	}

}
