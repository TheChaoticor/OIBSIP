import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TASK_GUESS_the_NUMBER {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String inpt=JOptionPane.showInputDialog("Input number of times you want to play the game");
		int T=Integer.parseInt(inpt);
		int c=0;
		while(T-->0) {
			
			String input=JOptionPane.showInputDialog("Input any number from 1-100");
			int usg=Integer.parseInt(input);
			
			int ran=(int)(Math.random()*(100-1)+1);
			JFrame f = new JFrame();
			if(usg>ran) {
				JOptionPane.showMessageDialog(f,"Your Number is Greater than the Computer");
				
			}
			else if(usg<ran){
				JOptionPane.showMessageDialog(f,"Your Number is Lower than the Computer");
				
			}
			else {
				JOptionPane.showMessageDialog(f,"Correct Guess");
				c++;
				JOptionPane.showMessageDialog(f,"Score  "+c);
			}
			}
		
		
	}

}
