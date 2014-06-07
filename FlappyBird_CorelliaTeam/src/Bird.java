import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Bird implements Runnable {
	private Point birdCoordinates;
	private Image birdImage;
	private Column firstColumn;
	private Column secondColumn;
	private boolean pressedSpace;
	private boolean isAlive;
	private int successfulCrossings;

	public Bird() {
		this.birdCoordinates = new Point(100, 350);
		ImageIcon ic = new ImageIcon("src/images/Bird2x.png");
		this.birdImage = ic.getImage();
		this.isAlive = true;
		firstColumn = new Column();
		secondColumn = new Column("second");
		pressedSpace = false;
		successfulCrossings = 0;
	}

	public Point getBirdCoordinates() {
		return birdCoordinates;
	}

	public void setBirdCoordinates(Point birdCoordinates) {
		this.birdCoordinates = birdCoordinates;
	}

	public Image getBird() {
		return birdImage;
	}

	public void setBird(Image bird) {
		this.birdImage = bird;
	}

	public boolean getIsAlive() {
		return this.isAlive;
	}

	public int getSuccessfulCrossings() {
		return this.successfulCrossings;
	}

	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_SPACE && this.isAlive) {
			this.birdCoordinates.y -= 60;
			pressedSpace = true;
		}
	}

	public boolean collision() {
		Rectangle birdRectangle =
				new Rectangle(this.birdCoordinates.x, this.birdCoordinates.y,
						this.birdImage.getWidth(null),
						this.birdImage.getHeight(null));
		if (birdRectangle.intersects(this.firstColumn.getDownRectangle()) ||
				birdRectangle.intersects(this.firstColumn.getUpRectangle()) ||
				birdRectangle.intersects(this.secondColumn.getDownRectangle())
				||
				birdRectangle.intersects(this.secondColumn.getUpRectangle()))
			return true;

		return false;
	}

	public void draw(Graphics g) {
		g.drawImage(this.birdImage, this.birdCoordinates.x,
				this.birdCoordinates.y, null);
	}

	public Column getFirstColumn() {
		return firstColumn;
	}

	public Column getSecondColumn() {
		return secondColumn;
	}

	public void move() {
		if (pressedSpace) {
			this.birdCoordinates.y -= 60;
			pressedSpace = false;
		}
		else {
			if (collision()
					|| this.birdCoordinates.y + this.birdImage.getHeight(null) == Window.height) {
				this.birdCoordinates.y =
						Window.height - this.birdImage.getHeight(null);
				this.isAlive = false;
			}
			else
				this.birdCoordinates.y += 2;
		}
		// counting
		if ((this.birdCoordinates.x + this.birdImage.getWidth(null) == firstColumn
				.getUpRectangle().x
				+ firstColumn.getUpRectangle().width)
				|| (this.birdCoordinates.x + this.birdImage.getWidth(null) == secondColumn
						.getUpRectangle().x
						+ secondColumn.getUpRectangle().width))
			this.successfulCrossings++;

		firstColumn.move();
		secondColumn.move();
	}

	// @Override
	@Override
	public void run() {
		try {
			while (true) {
				move();
				Thread.sleep(10);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
