package sandwichMaker;

/**
 * 
 * @author Mounica Pillarisetty
 * 101041499
 * Assignment 1 - SYSC 3303
 * 
 * This class is for Chef Two
 * They have an infinite supply of jam, hence Chef Jam!
 * It implements Runnable object in order to invoke Runnable object's run() method
 * 
 */
public class ChefJam implements Runnable{

	private Table t;

	public ChefJam(Table t) {
		this.t = t;
	}

	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println(Thread.currentThread().getName() + " is hungry and ready to eat!");
			t.chefJam();

			try {
				Thread.sleep((int)(Math.random() * 2000));
			} catch (InterruptedException e) {}
		}
	}
}