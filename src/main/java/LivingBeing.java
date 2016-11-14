package ProcessingGame.src;

import processing.core.*;

public class LivingBeing {
	Applet m;
	PImage img;
	int x;
	int y;

	public LivingBeing(Applet app, int xx, int yy, String image) {
		m = app;
		x = xx;
		y = yy;
		img = m.load_png(image);
	}

}
