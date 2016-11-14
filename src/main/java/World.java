package ProcessingGame.src;

import processing.core.*;

public class World {
	Applet m;

	public final int GRASS = 0;
	public final int HOUSE = 1;
	public final int TILE_MAX = 2;

	int world[][] = new int[10][8];
	PImage img[] = new PImage[TILE_MAX];

	public World(Applet app) {
		int i, j;

		m = app;
		// Generate The World - Fill with grass
		for(i = 0; i < 10; i++) {
			for(j = 0; j < 8; j++) {
				world[i][j] = GRASS;
			}
		}
		// Generate A House at 2/2
		world[2][2] = HOUSE;
		// Load graphics for tiles
		load_image("Grass.png", GRASS);
		load_image("House.png", HOUSE);
	}

	private void load_image(String image, int tile) {
		try {
			img[tile] = m.loadImage(image);
		} catch ( Exception e) {
			System.out.println("Couldn't find image " + image);
			System.exit(-1);
		}
	}

	public void loop() {
		int i, j;

		// Draw 1st layer - the ground
		for(i = 0; i < 10; i++) {
			for(j = 0; j < 8; j++) {
				m.image(img[world[i][j]], 100 * i, 100 * j);
			}
		}
		// Draw 2nd layer - the structures.
		for(i = 0; i < 10; i++) {
			for(j = 0; j < 8; j++) {
				if(world[i][j] == HOUSE) {
					m.image(img[GRASS], 100 * i, 100 * j);
					m.image(img[HOUSE], 100 * i, 100 * j);
				}
			}
		}
	}
}
