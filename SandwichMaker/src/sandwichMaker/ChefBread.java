package sandwichMaker;

/**
 * 
 * @author Mounica Pillarisetty
 * 101041499
 * Assignment 1 - SYSC 3303
 * 
 * This class is for Chef One
 * They have an infinite supply of bread, hence Chef Bread!
 * It implements Runnable object in order to invoke Runnable object's run() method
 * 
 */
public class ChefBread implements Runnable {

	private Table t;

	public ChefBread(Table t) {
		this.t = t;
	}

	public void run() {
		// TODO Auto-generated method stub
		while(true){
			System.out.println(Thread.currentThread().getName() + " is hungry are ready to eat!");
			t.chefBread();

			try {
				Thread.sleep((int)(Math.random() * 2000));
			} catch (InterruptedException e) {}
		}
	}
}