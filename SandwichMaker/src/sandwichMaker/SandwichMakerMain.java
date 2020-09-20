package sandwichMaker;

/**
 * 
 * @author Mounica Pillarisetty
 * 101041499
 * Assignment 1 - SYSC 3303
 * 
 * This class is the executable class that allows the application to run.
 * 
 */
public class SandwichMakerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Table t = new Table();
		
		Thread producer = new Thread(new Agent(t), "Agent");
		Thread consumerOne = new Thread(new ChefBread(t), "Chef Bread");
		Thread consumerTwo = new Thread(new ChefJam(t), "Chef Jam");
		Thread consumerThree = new Thread(new ChefPeanutButter(t), "Chef Peanut butter");

		producer.start();
		consumerOne.start();
		consumerTwo.start();
		consumerThree.start();

	}
}