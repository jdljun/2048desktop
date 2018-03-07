package mygame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class gameover extends JFrame{
	
	public gameover() {}
	public gameover (int stcore){
		Container c=getContentPane();
		Label l=new Label("game over ! your score is "+stcore);
		//l.set
		l.setFont(new Font (Font.DIALOG, Font.BOLD, 60));
		c.add(l);
		setSize(910,280);
		setVisible(true);
		this.addWindowListener(new WindowAdapter(){
			   @Override
			   public void windowClosing(WindowEvent e)
			   {
				UI ui=new UI();
				ui.jp.addKeyListener(new operation(ui));
			    dispose();
			   }});
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
	}
}
