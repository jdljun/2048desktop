package mygame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class operation implements KeyListener{

	board b;
	UI ui;
	
	public operation() {
		
	}
	public operation( UI ui) {
		b=new board();
		this.ui=ui;
		ui.UIchange(b.get_mux_b());
	}
	
	@Override
	
	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();
		switch(key) {
			case KeyEvent.VK_UP :
				b.up();
				break;
			case KeyEvent.VK_DOWN :
				b.down();
				break;
			case KeyEvent.VK_LEFT :
				b.left();
				break;
			case KeyEvent.VK_RIGHT :
				b.right();
				break;
			default: break;	
		}
		if(b.notchange) 
			ui.dispose();
		else
			ui.UIchange(b.get_mux_b());
		
	}

	public void keyPressed(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
}
