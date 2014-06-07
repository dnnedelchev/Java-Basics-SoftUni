import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;



public class Column  implements Runnable{

	private int xCoords;
	private int yCoords;
	private Rectangle downRectangle;
	private Rectangle upRectangle;
	
	private int width = 50;
	private int gapHeight = 200;
	
	Column() {
		this.xCoords = Window.width;
		this.yCoords = chooseColumnPosition();
		this.downRectangle = new Rectangle(this.xCoords, this.yCoords, this.width, Window.height - this.yCoords);
		this.upRectangle = new Rectangle(this.xCoords, 0, this.width, Window.height - this.downRectangle.height - this.gapHeight);
	}
	Column(String type) {
		if (type.equals("second"))
		{
			this.xCoords = Window.width + Window.width / 2 + 25  ;
			this.yCoords = chooseColumnPosition();
			this.downRectangle = new Rectangle(this.xCoords, this.yCoords, this.width, Window.height - this.yCoords);
			this.upRectangle = new Rectangle(this.xCoords, 0, this.width, Window.height - this.downRectangle.height - this.gapHeight);
		}
	}
	
	
	public Rectangle getDownRectangle() {
		return this.downRectangle;
	}
	
	
	public Rectangle getUpRectangle() {
		return this.upRectangle;
	}
	
	public int chooseColumnPosition () {
		Random r = new Random();
		return r.nextInt(Window.width - Window.width / 2 ) + Window.width / 2; // returns 30-380
	}
	
	public void move() {
		downRectangle.x -= 2;
		upRectangle.x -= 2;
		if(downRectangle.x + downRectangle.width <= 0) {
			int newYPosition = chooseColumnPosition();
			this.downRectangle.x = Window.width;
			this.downRectangle.y = newYPosition;
			this.downRectangle.height = Window.height - newYPosition;
			
			this.upRectangle.x = Window.width;
			this.upRectangle.y = 0;
			this.upRectangle.height = Window.height - this.downRectangle.height - this.gapHeight;
		}
	}
	
	public void draw(Graphics g) {
		g.fillRect(downRectangle.x, downRectangle.y, downRectangle.width, downRectangle.height);
		g.fillRect(upRectangle.x, upRectangle.y, upRectangle.width, upRectangle.height);
	}
	
	public void run() {
		try {
			while (true) {
				move();
				Thread.sleep(11);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}