package sandwichMaker;

import java.util.*;

/**
 * 
 * @author Mounica Pillarisetty
 * 101041499
 * Assignment 1 - SYSC 3303
 * 
 * This class is for the Agent
 * The agent has an infinite supply of all three ingredients.
 * It implements Runnable object in order to invoke Runnable object's run() method.
 * 
 * In this class, the three ingredients are generated and
 * the agent randomly selects two of the ingredients and places them on a table.
 * 
 */
public class Agent implements Runnable {

	private Table t;
	private List<Integer> ingredientList= new ArrayList<Integer>();

	/*
	 * The constructor for agent
	 */
	public Agent(Table t){
		this.t = t;
	}

	/*
	 * This class loads a list with numbers 1 - 3 to represent the three ingredients
	 */
	public void ingredients() {
		for(int i=1; i<4; i++) {
			ingredientList.add(new Integer(i));
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		// This array will store the 2 chosen ingredients to be placed on the table
		List<Integer> chosenIngredients = new ArrayList<Integer>(); 

		ingredients();

		//The first for loop allows the program to run until 20 sandwiches have been made and consumed
		for(int i=0; i<20; i++) {
			// The shuffle and for loop allow the list of three ingredients to be randomly re-arranged every turn
			// so when the first 2 ingredients are selected, they are always different.
			// This will also eliminate the possibility of the agent picking 2 of the same ingredients in one turn.
			Collections.shuffle(ingredientList);
			for(int j=0; j<2; j++) {
				chosenIngredients.add(ingredientList.get(j)); 
			}
			for(int ingredient:chosenIngredients){
				t.put(ingredient); // placing the chosen ingredients on the table, one at a time
			}
		}
	}
}
