package ProcessingGame.src;

import processing.core.*;

/**
 * A simple program that shows an orange screen.
 */
public class Applet extends PApplet {
	Player player;
	Monster monster;
	World world;

	public void keyPressed() {
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

	public void settings() {
		size(640, 480);
		player = new Player(this);
		monster = new Monster(this);
		world = new World(this);
	}

	public void draw() {
		background(255,127,0);
		world.loop();
		player.loop();
		monster.loop(player);
	}
}
