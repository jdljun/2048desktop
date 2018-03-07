package mygame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;

public class UI extends JFrame{
	private Container c;
	private JLabel[] label=new JLabel[16];
	public JPanel jp;
	private JPanel pj;
	
	public UI(){
		
		c=getContentPane();
		setLayout(new BorderLayout());
		
		pj=new JPanel(null);
		pj.setBackground(new Color(140,140,140));
		Button b1=new Button("重新开始");
		b1.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}            
            public void mousePressed(MouseEvent e) {
            	setVisible(false);// 本窗口隐藏
            	UI ui=new UI();     //产生新窗口
        		ui.jp.addKeyListener(new operation(ui));
        		dispose();  //销毁本窗口
            }             
            public void mouseExited(MouseEvent e) {}          
            public void mouseEntered(MouseEvent e) {}         
            public void mouseClicked(MouseEvent e) { }    
		});

		b1.setFont(new Font (Font.DIALOG, Font.BOLD, 20));
		b1.setBounds(50, 170, 120, 70);
		Button b2=new Button("退出游戏");
		b2.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}            
            public void mousePressed(MouseEvent e) {
        		dispose();  //销毁本窗口
            }             
            public void mouseExited(MouseEvent e) {}          
            public void mouseEntered(MouseEvent e) {}         
            public void mouseClicked(MouseEvent e) { }    
		});
		b2.setFont(new Font (Font.DIALOG, Font.BOLD, 20));
		b2.setBounds(50, 410, 120, 70);
		pj.add(b1);
		pj.add(b2);
		c.add(BorderLayout.EAST,pj);
		pj.setPreferredSize(new Dimension(182,650));
		
		jp=new JPanel(new GridLayout(4,4,15,15));
		jp.setBackground(new Color(140,140,140));
		for(int i=0;i<4;i++) 
			for(int j=0;j<4;j++) {
				label[i*4+j]=new JLabel("",SwingConstants.CENTER);
				//Border b=BorderFactory.createLineBorder(new Color(170,170,170));
				//label[i*4+j].setBorder(b);
				label[i*4+j].setFont(new Font (Font.DIALOG, Font.BOLD, 60));
			    label[i*4+j].setBackground(new Color(200,200,200));
			    label[i*4+j].setOpaque(true);
				jp.add(label[i*4+j]);
			}
		c.add(BorderLayout.WEST,jp);
		jp.setPreferredSize(new Dimension(650,650));
		//jp.addKeyListener(new operation());
		jp.setFocusable(true); //键盘监听事件只有获得焦点才能有用，默认焦点给第一个创建的可以获得焦点的组件
		
		//setSize(850,650);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		setBounds((width - 850) / 2,
                (height - 650) / 2, 850,650);
		setTitle("2048");
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		
	}
	
	public void UIchange(int[] mux) {
		for(int i=0;i<4;i++) 
			for(int j=0;j<4;j++) {
				if(mux[i*4+j]==0){
					label[i*4+j].setText("");
					label[i*4+j].setBackground(new Color(170,170,170));
				    label[i*4+j].setOpaque(true);
				}
					
				else {
					label[i*4+j].setText(""+mux[i*4+j]);
					if(mux[i*4+j]==2) 
						label[i*4+j].setBackground(new Color(200,200,200));
					if(mux[i*4+j]==4) 
						label[i*4+j].setBackground(new Color(220,220,180));
					if(mux[i*4+j]==8) 
						label[i*4+j].setBackground(new Color(240,240,50));
					if(mux[i*4+j]==16) 
						label[i*4+j].setBackground(new Color(255,200,20));
					if(mux[i*4+j]==32) 
						label[i*4+j].setBackground(new Color(200,50,20));
					if(mux[i*4+j]==64) 
						label[i*4+j].setBackground(new Color(150,100,40));
					if(mux[i*4+j]==128) 
						label[i*4+j].setBackground(new Color(100,150,50));
					if(mux[i*4+j]==256) 
						label[i*4+j].setBackground(new Color(50,200,50));
					if(mux[i*4+j]==512) 
						label[i*4+j].setBackground(new Color(50,150,150));
					if(mux[i*4+j]==1024) 
						label[i*4+j].setBackground(new Color(50,100,200));
					if(mux[i*4+j]==2048) 
						label[i*4+j].setBackground(new Color(50,50,250));
					if(mux[i*4+j]==4096) 
						label[i*4+j].setBackground(new Color(50,50,250));
				}
					
			}
		
	}
	
	public static void main(String[] args) {
		UI ui=new UI();  //生成UI实例
		ui.jp.addKeyListener(new operation(ui));//为UI实例添加键盘监听事件
		
	}
}
