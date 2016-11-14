package ProcessingGame.src;

import processing.core.*;

public class Player extends LivingBeing {

	boolean hurt = false;

	public Player(Applet app) {
		super(app, 0, 120, "person_ready");
	}

	public void loop() {
		m.image(img, x, y);
		if(hurt) {
			m.text("Ouch", x, y);
			hurt = false;
		}
	}
}
