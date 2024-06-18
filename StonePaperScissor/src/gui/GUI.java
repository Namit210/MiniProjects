package gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;




public class GUI {
	
	static JButton sB, pB, scB;
	public static void main(String[] args) {
		JFrame frame = new JFrame("Stone/Paper/Scissor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.white);
		
		frame.setSize(700,400);
		frame.setLayout(null);
		frame.setVisible(true);
		
		ImageIcon stone = new ImageIcon("src/images/stone.jpg");
		ImageIcon paper = new ImageIcon("src/images/paper.jpeg");
		ImageIcon scissor = new ImageIcon("src/images/scissor.jpg");
		
		Image stoneimg = stone.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);
		Image paperimg = paper.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);
		Image scissorimg = scissor.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);
			
		 sB = new JButton(new ImageIcon(stoneimg));
		 pB = new JButton(new ImageIcon(paperimg));
		 scB = new JButton(new ImageIcon(scissorimg));
		
		sB.setBounds(80,100,100, 100);
		pB.setBounds(280,100,100, 100);
		scB.setBounds(480,100,100, 100);
		
		

		
		frame.add(sB);
		frame.add(pB);
		frame.add(scB);
		
		
		JLabel text = new JLabel("What is Your Choice?");
		text.setBounds(20,40,400,40);
		text.setFont(new Font("Raleway",Font.BOLD,20));
		frame.add(text);
		
		JLabel response = new JLabel("");
		response.setBounds(20,220,800,40);
		response.setFont(new Font("Raleway",Font.BOLD,20));
		frame.add(response);
		
		JLabel response2 = new JLabel("");
		response2.setBounds(20,260,800,40);
		response2.setFont(new Font("Raleway",Font.BOLD,20));
		frame.add(response2);

	
		sB.addActionListener(new ActionListener() {
			
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	int k = rand();
                response.setText("My choice is "+choice(k));
                response2.setText(respond(1,k));
            }
        });
		
		pB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int k =rand();
				 response.setText("My choice is "+choice(k));
				 response2.setText(respond(2,k));
			}
		});
		
		scB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int k = rand();
				 response.setText("My choice is "+choice(k));
				 response2.setText(respond(3,k));
			}
		});

	}
	
	static String choice(int n) {
        switch (n) {
            case 1:
                return "Stone";

            case 2:
                return "Paper";

            case 3:
                return "Scissor";

            default:
                System.out.println("Something is wrong with the code");
                return "Error";
        }
    }
	
	static int rand() {
		return (int)(Math.random()*100)%3+1;
	}
	
	 static int game(int n, int k) {
	        if (k == n)
	            return 2;
	        else if (k == 1 && n == 2 || k == 2 && n == 3 || k == 3 && n == 1)
	            return 1;
	        else
	            return 0;
	    }
	
	 static String respond(int n, int k) {
		 switch (game(n,k))
		    {
		    case 0:
		        return("I won the match :-)\nBetter luck next time!");
		        
		    
		    case 1:
		        return("Congrats! You won this match");
		        
		    
		    case 2:
		        return("That's DRAW\nLet's play it again!");
		       
		    
		    default:
		        return("Something is wrong with the code!");
		        
		    }
	 }

}
