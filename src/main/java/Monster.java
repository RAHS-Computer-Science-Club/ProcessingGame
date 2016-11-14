package ProcessingGame.src;

import processing.core.*;

public class Monster extends LivingBeing {

	boolean right = false;

	public Monster(Applet app) {
		super(app, 0, 0, "Giant.png");
	}

	public void loop(Player player) {
		if(right) {
			if(x > 500) right = false;
			x+=2;
		}else{
			if(x < 50) right = true;
			x-=2;
		}
		if(player.x > x - 100 && player.x < x + 100 &&
			player.y > y - 100 && player.y < y + 100)
		{
			player.hurt = true;
		}
		m.image(img, x, y);
	}
}
