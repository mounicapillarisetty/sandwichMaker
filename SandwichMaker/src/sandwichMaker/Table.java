package sandwichMaker;

/**
 * 
 * @author Mounica Pillarisetty
 * 101041499
 * Assignment 1 - SYSC 3303
 * 
 * This class is Table.
 * The table is where the agent places the chosen ingredients.
 * This is where the chefs come to grab their ingredients in order to make a sandwich.
 * 
 */

public class Table { 

	private boolean isBread = false; // boolean to indicate if bread is placed on the table
	private boolean isJam = false; // boolean to indicate if jam is placed on the table
	private boolean isPB = false; // boolean to indicate if peanut butter is placed on the table
	private boolean isChefBread = false; // boolean to indicate if chef bread is made the sandwich
	private boolean isChefJam = false; // boolean to indicate if chef jam is made the sandwich
	private boolean isChefPB = false; // boolean to indicate if chef peanut butter is made the sandwich
	private int counter = 1; // counter to keep track of the number of sandwiches made and consumed by chefs

	/*
	 * The synchronized put method is used to place ingredients on the table 
	 * and wait when the table is already full or when 20 sandwiches are made
	 * 
	 * @param integer value representing the ingredient on the table
	 */
	public synchronized void put(int ingredient) {
		while(counter > 20 || isSandwichMade()){
			try{
				wait();
			}
			catch(InterruptedException e){
				return;
			}
		}
		setIngredients(ingredient);

		if(isSandwichMade()){
			notifyAll();
		}
	}

	/*
	 * This method associates the number to the ingredient (ie: 1 = bread, 2 = jam ...) and outputs it
	 * Also sets its corresponding boolean value
	 * 
	 * @param integer value representing the ingredient that is placed on the table
	 */
	public void setIngredients(int ingredient) {
		if(ingredient == 1) {
			isBread = true;
			System.out.println(Thread.currentThread().getName() + " placed bread on the table");
		}
		if(ingredient == 2) {
			isJam = true;		
			System.out.println(Thread.currentThread().getName() + " placed jam on the table");
		}
		if(ingredient == 3) {
			isPB = true;
			System.out.println(Thread.currentThread().getName() + " placed peanut butter on the table");
		}
	}

	/*
	 * This is used to determine if the table is full or not and which chef made and ate the sandwich
	 * 
	 * @return boolean if a sandwich is made and ate by which chef
	 */
	public boolean isSandwichMade(){
		if(isBread && isJam){
			isChefPB = true;
			return true;
		}
		if(isBread && isPB){
			isChefJam = true;
			return true;
		}
		if(isJam && isPB){
			isChefBread = true;
			return true;
		}
		return false;	
	}

	/*
	 * The next 3 synchronized methods represent the three chefs' creation and consumption of PBJs
	 * and used to lock the other objects so the ingredients are shared appropriately 
	 */
	public synchronized void chefBread() {
		while(!isSandwichMade() || !isChefBread) {
			try {
				wait();
			} catch (InterruptedException e) {
				return ;
			}
		}
		System.out.println(Thread.currentThread().getName() + " made and ate their sandwich.");
		System.out.println("Number of sandwich(es) made and consumed: " + counter++ + "\n");

		cleanTable();
		notifyAll();
	}

	public synchronized void chefJam() {
		while(!isSandwichMade() || !isChefJam) {
			try {
				wait();
			} catch (InterruptedException e) {
				return ;
			}
		}
		System.out.println(Thread.currentThread().getName() + " made and ate their sandwich.");
		System.out.println("Number of sandwich(es) made and consumed: " + counter++ + "\n");

		cleanTable();
		notifyAll();
	}

	public synchronized void chefPB() {
		while(!isSandwichMade() || !isChefPB) {
			try {
				wait();
			} catch (InterruptedException e) {
				return ;
			}
		}
		System.out.println(Thread.currentThread().getName() + " made and ate their sandwich.");
		System.out.println("Number of sandwich(es) made and consumed: " + counter++ + "\n");

		cleanTable();
		notifyAll();
	}

	/*
	 * This method cleans the table after every turn
	 */
	public void cleanTable(){
		isChefBread = false;
		isChefJam = false;
		isChefPB = false;
		isBread = false;
		isJam = false;
		isPB = false;
	} 

}
