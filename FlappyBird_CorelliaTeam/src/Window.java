import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

public class Window extends JFrame {

	private static final long serialVersionUID = 3797887780208761729L;

	public static int width = 450, height = 600;

	private Dimension windowSize = new Dimension(width, height);

	private Image dbImage;
	private Graphics dbg;

	// Image face;
	private BufferedImage background;

	// Game Start
	private boolean gameStarted;
	
	//Hover
	boolean startHover;
	boolean quitHover;
	

	// Menu Buttons
	private Rectangle startButton;
	private Rectangle quitButton;
	private Rectangle finalExitButton;

	// Bird
	static Bird bird = new Bird();

	// Thread
	static Thread t1 = new Thread(bird);
	
	private File file;
	private int bestScore;

	public Window() {
		try {
			background = ImageIO.read(new File("src/images/background.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/sound/background.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
           
            clip.loop(Clip.LOOP_CONTINUOUSLY);
                     
        }
		 catch(Exception e) {
	            e.printStackTrace();
	     }

		setUndecorated(true);
		setSize(windowSize);
		setTitle("Flappy Bird");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		this.initStart();

		addKeyListener(new KeyListen());
		addMouseListener(new MouseHandler());
		addMouseMotionListener(new MouseHandler());
		
		this.file = new File("src/best_score.txt");
		try {
			this.setBestScore();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void initStart() {
		this.startButton = new Rectangle(150, 200, 100, 25);
		this.quitButton = new Rectangle(150, 250, 100, 25);
		this.gameStarted = false;
	}

	public void paint(Graphics g) {
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		draw(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}

	public void draw(Graphics g) {
		// Background
		g.drawImage(background, 0, 0, this);

		// Check if the game is started
		if (!gameStarted) {
			// Menu
			g.setFont(new Font("Arial", Font.BOLD, 26));
			g.setColor(Color.WHITE);
			g.drawString("FlappyBird!", 125, 175);
			if (!startHover) {
				g.setColor(Color.CYAN);
			}
			else {
				g.setColor(Color.ORANGE);
			}
			g.fillRect(startButton.x, startButton.y, startButton.width,
					startButton.height);
			g.setFont(new Font("Arial", Font.BOLD, 12));
			g.setColor(Color.GRAY);
			g.drawString("Start Game", startButton.x + 10, startButton.y + 17);
			if (!quitHover) {
				g.setColor(Color.CYAN);
			}
			else {
				g.setColor(Color.ORANGE);
			}
			//g.setColor(Color.CYAN);
			g.fillRect(quitButton.x, quitButton.y, quitButton.width,
					quitButton.height);
			g.setColor(Color.GRAY);
			g.drawString("Quit Game", quitButton.x + 12, quitButton.y + 17);
		}
		else if (gameStarted) {
			// Game drawing
			
			g.setColor(Color.DARK_GRAY);// columns color
			bird.draw(g);
			bird.getFirstColumn().draw(g);
			bird.getSecondColumn().draw(g);
			// result
			g.setFont(new Font("Arial", Font.BOLD, 26));
			g.setColor(Color.ORANGE);
			g.drawString("" + bird.getSuccessfulCrossings(), 0, 20);
		}

		if (!bird.getIsAlive()) {
			g.drawString("Game Over", 170, 200);
			try {
				if(this.endGame()) {
					g.drawString("New Best: " + bird.getSuccessfulCrossings(), 167, 230);
				}
				else 
					g.drawString("Best: " + this.bestScore, 200, 230);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			g.setColor(Color.CYAN);
			g.fillRect(finalExitButton.x, finalExitButton.y, finalExitButton.width, finalExitButton.height);
			g.setColor(Color.GRAY);
			g.drawString("Exit", 215, 285);
		}
		repaint();
	}

	public void startGame() {
		gameStarted = true;
		t1.start();
	}
	
	@SuppressWarnings("deprecation")
	public boolean endGame() throws FileNotFoundException {
		this.finalExitButton = new Rectangle(170, 250, 140, 50);
		boolean newRecord = false;
		if (bird.getSuccessfulCrossings() > this.bestScore) {
			newRecord = true;
			PrintWriter pw = new PrintWriter(file);
			pw.print(bird.getSuccessfulCrossings());
			pw.close();
		}
		t1.stop();
		return newRecord;
	}

	public static void main(String[] args) {
		new Window();
		
	}

	public void setBestScore() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(this.file));
		this.bestScore = Integer.parseInt(br.readLine());
		br.close();
	}
	public class KeyListen extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			int keyCode = e.getKeyCode();
			if (keyCode == KeyEvent.VK_ESCAPE) {
				initStart();
			} else {
				bird.keyReleased(e);
			}
		}

	}

	public class MouseHandler extends MouseAdapter {
		// @Override
		public void mouseMoved(MouseEvent e) {
			int mx = e.getX();
			int my = e.getY();
			//starHover
			if (mx > startButton.x && mx < startButton.x + startButton.width
					&& my > startButton.y
					&& my < startButton.y + startButton.height) {
				startHover=true;
			}
			else {
				startHover=false;
			}
			//quitHOver
			if (mx > quitButton.x && mx < quitButton.x + quitButton.width
					&& my > quitButton.y
					&& my < quitButton.y + quitButton.height) {
				quitHover=true;
			}
			else {
				quitHover=false;
			}
			
		}

		// @Override
		public void mousePressed(MouseEvent e) {
			int mx = e.getX();
			int my = e.getY();
			if (mx > startButton.x && mx < startButton.x + startButton.width
					&& my > startButton.y
					&& my < startButton.y + startButton.height) {
				startGame();
			}
			if (mx > quitButton.x && mx < quitButton.x + quitButton.width
					&& my > quitButton.y
					&& my < quitButton.y + quitButton.height) {
				System.exit(0);
			}
			if (!bird.getIsAlive() && mx > finalExitButton.x && mx < finalExitButton.x + finalExitButton.width 
					&& my > finalExitButton.y &&  my < finalExitButton.y + finalExitButton.height) {
				System.exit(0);
			}

		}
	}
}
