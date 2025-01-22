package gui;

import java.awt.*;
import java.awt.event.*;
import logics.*;


public class GUI {
	
	public static TextField tf;

	public static void main(String[] args) {
		Frame f = new Frame("Calculator");
		f.setSize(400,400);
		f.setLayout(null);
		f.setBackground(Color.WHITE);
		
		Button [][] button =  new Button [5][4];
		int x = 20, y;
		
		button[0][0] = new Button("AC");
		button[0][1] = new Button("%");
		button[0][2] = new Button("del");
		button[0][3] = new Button("/");
		
		button[1][0] = new Button("7");
		button[1][1] = new Button("8");
		button[1][2] = new Button("9");
		button[1][3] = new Button("X");
		
		button[2][0] = new Button("4");
		button[2][1] = new Button("5");
		button[2][2] = new Button("6");
		button[2][3] = new Button("-");
		
		button[3][0] = new Button("3");
		button[3][1] = new Button("2");
		button[3][2] = new Button("1");
		button[3][3] = new Button("+");
		
		button[4][0] = new Button("00");
		button[4][1] = new Button("0");
		button[4][2] = new Button(".");
		button[4][3] = new Button("=");
		
		for(int i = 0; i<button.length; i++) {
			y=100+50*(i+1);
			for(Button btn : button[i]) {
				btn.setBounds(x,y, 80, 40);
				x=x+90;
				btn.setBackground(Color.cyan);
				btn.addActionListener(new Actions(btn));
				f.add(btn);
			}
			x=20;
		}
		
		
		
		tf = new TextField(20);
		tf.setFont(new Font("Arial",Font.BOLD,25));
		tf.setBounds(40,80,320,50);
		f.add(tf);
		f.setVisible(true);
		
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
	}
    
}

