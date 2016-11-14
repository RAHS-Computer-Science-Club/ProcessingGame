package ProcessingGame.src;

import processing.core.*;
import java.net.URL;
import java.io.*;

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
		load_image("Grass", GRASS);
		load_image("House", HOUSE);
	}

	private void load_image(String image, int tile) {
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
			img[tile] = m.loadImage(tempFile.toPath().toString());
		} catch ( Exception e) {
			System.out.println("Couldn't load image " + image);
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
