package ProcessingGame.src;

import processing.core.*;
import java.io.*;

/**
 * A simple program that shows an orange screen.
 */
public class Applet extends PApplet {
	Player player;
	Monster monster;
	World world;
	int loading = 2;
	private PImage logo;

	// This function runs when the game starts up.  Create objects in here.
	private void on_init() {
		// Initialize objects
		player = new Player(this);
		monster = new Monster(this);
		world = new World(this);
	}

	// This function runs whenever a key is pressed - input is handled here
	private void on_keypress() {
		if(key == CODED) {
			if(keyCode == UP)
				player.y -= 5;
			else if (keyCode == DOWN)
				player.y += 5;
			else if (keyCode == RIGHT)
				player.x += 5;
			else if (keyCode == LEFT)
				player.x -= 5;
		}	
	}

	// This function runs every frame-game logic & rendering happens in here
	private void on_frame() {
		world.loop();
		player.loop();
		monster.loop(player);
	}

	/**
	 *  Background Functions
	**/

	public void keyPressed() {
		on_keypress();
	}

	public void settings() {
		size(640, 480);
		logo = load_png("rahscs_logo");
	}

	public void draw() {
		switch(loading) {
			case 0:
				textSize(32);
				background(255,127,0);
				on_frame();
				break;
			case 1:
				on_init();
			default:
				float ih = width * 0.5625f;
				background(127,127,255);
				image(logo, 0, (height - ih) / 2.0f, width, ih);
				loading--;
		}
	}

	// Functions for ease-of-use

	public PImage load_png(String image) {
		PImage pimage = null;
		try {
			byte[] buffer = new byte[1024];
			int read;
			File tempFile = File.createTempFile("app", ".png");
			InputStream in = getClass().getResourceAsStream("/"
				+ image + ".png");
			OutputStream out = new FileOutputStream(tempFile);

			while((read = in.read(buffer)) != -1) {
				out.write(buffer, 0, read);
			}
			in.close();
			out.close();
			// Load the image.
			pimage = loadImage(tempFile.toPath().toString());
		} catch ( Exception e) {
			System.out.println("Couldn't load image " + image);
			System.exit(-1);
		}
		return pimage;
	}

	// Main Function
	public static void main(String args[]) {	
		PApplet.main(new String[]{ Applet.class.getName() });
	}
}
