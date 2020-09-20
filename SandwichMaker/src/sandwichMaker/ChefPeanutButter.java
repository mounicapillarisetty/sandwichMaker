package sandwichMaker;

/**
 * 
 * @author Mounica Pillarisetty
 * 101041499
 * Assignment 1 - SYSC 3303
 * 
 * This class is for Chef Three
 * They have an infinite supply of peanut butter, hence Chef Peanut butter!
 * It implements Runnable object in order to invoke Runnable object's run() method
 * 
 */
public class ChefPeanutButter implements Runnable{

	private Table t;

	public ChefPeanutButter(Table t) {
		this.t = t;
	}

	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println(Thread.currentThread().getName() + " is hungry and ready to eat!");
			t.chefPB();

			try {
				Thread.sleep((int)(Math.random() * 2000));
			} catch (InterruptedException e) {}
		}
	}
}