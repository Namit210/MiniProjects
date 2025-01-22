package logics;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import gui.GUI;

public class Actions implements ActionListener{
	
	Button b;
	public Actions(Button b) {
		this.b = b;
		
	}
	
	private static String evaluate(String s) {
        String[] newS = s.split(" ");
        // Logic
        double num = 0;
        String op = null;

      
        boolean firstNumber = true;

        for (String string : newS) {
            try {
                double a = Double.parseDouble(string);

              
                if (firstNumber) {
                    num = a;
                    firstNumber = false;
                } else {
                    switch (op) {
                        case "+":
                            num = num + a;
                            break;
                        case "-":
                            num = num - a;
                            break;
                        case "*":
                            num = num * a;
                            break;
                        case "%":
                        	num = num % a;
                        	break;
                        case "/":
                            if (a != 0) {
                                num = num / a;
                            } else {
                                return("Error: Division by zero.");
                            }
                            break;
                    }
                }
            } catch (Exception e) {
                
                op = string;
            }
       	}
        
        return String.valueOf(num);
       }

	@Override
	public void actionPerformed(ActionEvent e) {
		String s=null;
		switch(b.getLabel()) {
		case "AC": 
			break;
		case "del":
			s = GUI.tf.getText();
			if(s.length()>0)
			s=s.substring(0,s.length()-1);
			break;
		case "=":s=evaluate(GUI.tf.getText());
			break;
		case "X":s = GUI.tf.getText()+" * ";
			break;
			
		case "%": case "/": case "-": case "+":
			s = GUI.tf.getText()+" "+b.getLabel()+" ";
			break;
		default:
			s = GUI.tf.getText()+b.getLabel();
			
		}
		GUI.tf.setText(s);
		
		
		
	}

}
