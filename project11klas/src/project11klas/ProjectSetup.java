package project11klas;

import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JFormattedTextField;



public class ProjectSetup implements ActionListener {


    
    
    private static JButton newGame;
    private static JButton rollDices;
    private static JButton exit;
    
    public static void main(String[] args) {
        Run();
    }
    

    
    static JButton[] dice = new JButton[5];
    static int[] dice_number = new int[5];
    static int rolls = 3;
    static JLabel remaining = new JLabel(String.format("You have %2d remaining rolls", rolls));
    
    static JButton[] btn_ch = new JButton[6];
    static JLabel[] lb_ch = new JLabel[6];
    static JLabel[] lb_2 = new JLabel[9];
    static String[] data ={"pair","2 pairs","triple","square","full","small bucket","big bucket","chance","general"};
    static JButton[] btn_2 = new JButton[9];
    static JLabel total = new JLabel();
    static JLabel gameOver = new JLabel();
    static int totalScore = 0;
    static boolean areDicesThrown = false;
    static int combinationsUsed = 0;
    static boolean[] combinationsSelected = new boolean[15];
    
    public static void Run(){
        JFrame frame = new JFrame("mainMenu");
        frame.setSize(534,550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.getContentPane().add(panel);
        JLabel title = new JLabel("General - dice game",SwingConstants.CENTER);
        title.setBounds(10,10,498,40);
        title.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
        panel.add(title);

       
        
        rollDices = new JButton("Roll");
        rollDices.setBounds(277,174,158,44);
        rollDices.setHorizontalAlignment(JTextField.CENTER);
        rollDices.setFocusPainted(false);
        rollDices.addActionListener(new ProjectSetup ());
        panel.add(rollDices);
        
        newGame = new JButton("New game");
        newGame.setBounds(277,262,158,67);
        newGame.setHorizontalAlignment(JTextField.CENTER);
        newGame.setFocusPainted(false);
        newGame.addActionListener(new ProjectSetup());
        panel.add(newGame);
        
        exit = new JButton("Exit");
        exit.setHorizontalAlignment(SwingConstants.CENTER);
        exit.setFocusPainted(false);
        exit.setBounds(277, 367, 158, 67);
        exit.addActionListener(new ProjectSetup());
        panel.add(exit);
        
        remaining.setHorizontalTextPosition(SwingConstants.CENTER);
        remaining.setHorizontalAlignment(SwingConstants.CENTER);
        remaining.setBounds(221, 134, 270, 44);
        panel.add(remaining);
        
        
        for (int i = 0;i<6;i++) 
        { 
        	btn_ch[i] = new JButton();
        	btn_ch[i].addActionListener(new ProjectSetup());
        	btn_ch[i].setBounds(126, 78+i*20, 74, 19);
        	btn_ch[i].setFocusPainted(false);
        	btn_ch[i].setEnabled(false);
            panel.add(btn_ch[i]);
            
            lb_ch[i] = new JLabel(Integer.toString(i+1));
            lb_ch[i].setHorizontalAlignment(SwingConstants.RIGHT);
            lb_ch[i].setHorizontalTextPosition(SwingConstants.CENTER);
            lb_ch[i].setBounds(0, 80+i*20, 116, 14);
            panel.add(lb_ch[i]);
            
            combinationsSelected[i]=false;
        }
        
        for (int i = 0;i<5;i++) 
        { 
        	dice[i]=new JButton();
        	dice[i].setMargin(new Insets(0,0,0,0));
        	dice[i].setFont(new Font("Tahoma", Font.PLAIN, 33));
        	dice[i].setHorizontalAlignment(SwingConstants.CENTER);
        	dice[i].setEnabled(false);
        	dice[i].setFocusPainted(false);
        	dice[i].setBounds(221+i*56, 77, 46, 46);
            dice[i].addActionListener(new ProjectSetup());
            panel.add(dice[i]);
        }
        
        for (int i = 0;i<9;i++) 
        { 

        	btn_2[i] = new JButton();
        	btn_2[i].addActionListener(new ProjectSetup());
        	btn_2[i].setBounds(126, 220+i*20, 74, 19);
        	btn_2[i].setFocusPainted(false);
        	btn_2[i].setEnabled(false);
            panel.add(btn_2[i]);
            
            lb_2[i] = new JLabel(data[i]);
            lb_2[i].setHorizontalAlignment(SwingConstants.RIGHT);
            lb_2[i].setHorizontalTextPosition(SwingConstants.CENTER);
            lb_2[i].setBounds(0, 220+i*20, 116, 14);
            panel.add(lb_2[i]);
            
            combinationsSelected[i+6]=false;
        }
        
        total.setText(String.format("Total score: %2d", totalScore));
        total.setHorizontalAlignment(SwingConstants.RIGHT);
        total.setHorizontalTextPosition(SwingConstants.CENTER);
        total.setBounds(0, 420, 200, 14);
        panel.add(total);
        
        gameOver.setFont(new Font("Tahoma", Font.PLAIN, 24));
        gameOver.setText(String.format("Game Over! Your total score is: %2d", totalScore));
        gameOver.setBounds(81, 445, 439, 40);
        gameOver.setVisible(false);
        panel.add(gameOver);
        
        frame.setFocusable(true);
        frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getExtendedKeyCode()== KeyEvent.VK_ESCAPE)
					 System.exit(0);
					
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
        	
        });

        frame.setVisible(true);
    }
   
   
    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource()==newGame)
        {
        	rolls = 3;
    		remaining.setText(String.format("You have %2d remaining rolls", rolls));
    		totalScore = 0;
    		total.setText(String.format("Total score: %2d", totalScore));
    		for(int j = 0; j < 5; j++)
    		{
    			dice[j].setText(null);
    			dice[j].setEnabled(false);
            	dice[j].setFocusPainted(false);
    		}
    		rollDices.setEnabled(true);
    		areDicesThrown = false;
    		for(int j = 0; j < 6; j++)
    		{
    			btn_ch[j].setText(null);
    			btn_ch[j].setEnabled(false);
    			combinationsSelected[j]=false;
    		}
    		for(int j = 0; j < 9; j++)
    		{
    			btn_2[j].setText(null);
    			btn_2[j].setEnabled(false);
    			combinationsSelected[j+6]=false;
    		}
    		combinationsUsed = 0;
    		gameOver.setVisible(false);
        }
        else
        {
        	if(e.getSource() == exit)
        	{
        		System.exit(0);
        	}
        	else
        	{
			    if(e.getSource()==rollDices)
			    {
		    		 for (int i = 0;i<5;i++) {
		    			 if(!dice[i].isEnabled()) {
		        			 dice_number[i]=(int) (Math.random()*6+1);
		    				 dice[i].setEnabled(true);
		    				 dice[i].setText(Integer.toString(dice_number[i]));
		    			 }
		    		 }
		    		 areDicesThrown = true;
		    		 rolls--;
					 if(rolls==0) {
						 for(int i = 0;i<5;i++) {
					        dice[i].setEnabled(false);
					     }
					 }
					 rollDices.setEnabled(false);
					 remaining.setText(String.format("You have %2d remaining rolls", rolls));
					 for(int j = 0; j < 9; j++)
					 {
						 if(btn_2[j].isEnabled() == true)
						 {
							 btn_2[j].setText("0");
						 }
					 }
					 calculate_results();
					 return;
			    }
			    else
			    {
				    for(int i = 0;i<5;i++) {
				    	if(e.getSource()==dice[i]) {
				    		dice[i].setEnabled(false);
				    		dice[i].setText(null);
				    		rollDices.setEnabled(true);
				    		return;
				    	}
				    }
				    
				    for(int i = 0; i < 6; i++)
				    {
				    	if(e.getSource() == btn_ch[i] && areDicesThrown == true) 
				    	{
				    		combinationsSelected[i]=true;
				    		rolls = 3;
				    		remaining.setText(String.format("You have %2d remaining rolls", rolls));
				    		totalScore += Integer.parseInt(btn_ch[i].getText());
				    		total.setText(String.format("Total score: %2d", totalScore));
				    		for(int j = 0; j < 5; j++)
				    		{
				    			dice[j].setText(null);
				    			dice[j].setEnabled(false);
				            	dice[j].setFocusPainted(false);
				    		}
				    		rollDices.setEnabled(true);
				    		areDicesThrown = false;
				    		for(int j = 0; j < 6; j++)
				    		{
				    			btn_ch[j].setEnabled(false);
				    			if(!combinationsSelected[j])
				    			{
				    				btn_ch[j].setText(null);
				    			}
				    		}
				    		for(int j = 0; j < 9; j++)
				    		{
				    			btn_2[j].setEnabled(false);
				    			if(!combinationsSelected[j+6])
				    			{
				    				btn_2[j].setText(null);
				    			}
				    		}
				    		combinationsUsed++;
				    		if(combinationsUsed == 15)
				    		{
				    			gameOver.setText(String.format("Game Over! Your total score is: %2d", totalScore));
				    			gameOver.setVisible(true);
				    			rollDices.setEnabled(false);
				    		}
				    		return ;
				    	}
				    }
				    
				    for(int i = 0; i < 9; i++)
				    {
				    	if(e.getSource() == btn_2[i] && areDicesThrown == true) 
				    	{
				    		combinationsSelected[i+6]=true;
				    		rolls = 3;
				    		remaining.setText(String.format("You have %2d remaining rolls", rolls));
				    		totalScore += Integer.parseInt(btn_2[i].getText());
				    		total.setText(String.format("Total score: %2d", totalScore));
				    		for(int j = 0; j < 5; j++)
				    		{
				    			dice[j].setText(null);
				    			dice[j].setEnabled(false);
				            	dice[j].setFocusPainted(false);
				    		}
				    		rollDices.setEnabled(true);
				    		areDicesThrown = false;
				    		for(int j = 0; j < 6; j++)
				    		{
				    			btn_ch[j].setEnabled(false);
				    			if(!combinationsSelected[j+6])
				    			{
				    				btn_ch[j].setText(null);
				    			}
				    		}
				    		for(int j = 0; j < 9; j++)
				    		{
				    			btn_2[j].setEnabled(false);
				    			if(!combinationsSelected[j+6])
				    			{
				    				btn_2[j].setText(null);
				    			}
				    		}
				    		combinationsUsed++;
				    		if(combinationsUsed == 15)
				    		{
				    			gameOver.setText(String.format("Game Over! Your total score is: %2d", totalScore));
				    			gameOver.setVisible(true);
				    			rollDices.setEnabled(false);
				    		}
				    		return ;
				    	}
				    }
				    
			    }
		    }
        }
       
        
    }
    
    public void calculate_results() {
    	
    	int whatNumbers[] = new int[5];
    	
    	for(int i = 0; i < 5; i++)
    	{
    		whatNumbers[i] = dice_number[i];
    	}
    	
    	//Arrays.sort(whatNumbers);
    	
    	/// Bubble sort
    	
    	for (int i = 0; i < 5 - 1; i++)
    	{
            for (int j = 0; j < 5 - i - 1; j++)
            {
                if (whatNumbers[j] > whatNumbers[j + 1]) {
                    int temp = whatNumbers[j];
                    whatNumbers[j] = whatNumbers[j + 1];
                    whatNumbers[j + 1] = temp;
                }
            }
    	}
    	
    	/// Mandatory part
    	
    	for(int i = 1; i <= 6; i++) 
    	{
    		if(!combinationsSelected[i - 1])
    		{
    			btn_ch[i-1].setEnabled(true);
				int numberOfThis = 0;
				for(int j = 0; j < 5; j++)
				{
					if(whatNumbers[j] == i)
					{
						numberOfThis++;
					}
				}
				
				if(numberOfThis < 3)
				{
					btn_ch[i - 1].setText("-25");
				}
				else 
				{
					btn_ch[i - 1].setText(Integer.toString((numberOfThis - 3)*i));
				}
    		}
    	
    	}
    	
    	/// Combinations part
    	
    	/// Pair
    	if(!combinationsSelected[6])
    	{
			btn_2[0].setEnabled(true);
			btn_2[0].setText("0");
	    	for(int i = 3; i >= 0; i--)
	    	{
	    		if(whatNumbers[i] == whatNumbers[i + 1])
	    		{
	    			btn_2[0].setText(Integer.toString(whatNumbers[i]*2));
	    		}
	    	}
    	}
    	
    	/// 2 Pairs
    	if(!combinationsSelected[7])
    	{
    		btn_2[1].setEnabled(true);
    		btn_2[1].setText("0");
	    	for(int i = 3; i >= 0; i--)
	    	{
	    		if(whatNumbers[i] == whatNumbers[i + 1])
	    		{
	    			for(int j = i - 2; j >= 0; j--)
	    			{
	    				if(whatNumbers[j] == whatNumbers[j + 1])
	    				{
	    					btn_2[1].setText(Integer.toString(whatNumbers[i]*2 + whatNumbers[j]*2));
	    				}
	    				
	    			}
	    		}
	    	}
    	}
    	
    	/// Triple
    	if(!combinationsSelected[8])
    	{
    		btn_2[2].setEnabled(true);
    		btn_2[2].setText("0");
	    	for(int i = 2; i >= 0; i--)
	    	{
	    		if(whatNumbers[i] == whatNumbers[i + 2])
	    		{
	    			btn_2[2].setText(Integer.toString(whatNumbers[i]*3));
	    		}
	    	}
    	}
    	
    	/// Square
    	if(!combinationsSelected[9])
    	{
			btn_2[3].setEnabled(true);
    		btn_2[3].setText("0");
	    	for(int i = 1; i >= 0; i--)
	    	{
	    		if(whatNumbers[i] == whatNumbers[i + 3])
	    		{
	    			btn_2[3].setText(Integer.toString(whatNumbers[i]*4));
	    		}
	    	}
    	}
    	
    	///Full
    	if(!combinationsSelected[10])
    	{
			btn_2[4].setEnabled(true);
			btn_2[4].setText("0");
	    	if(whatNumbers[0] == whatNumbers[2] && whatNumbers[3] == whatNumbers[4])
	    	{
	    		btn_2[4].setText(Integer.toString(whatNumbers[0]*3 + whatNumbers[3]*2));
	    	}
	    	else if(whatNumbers[0] == whatNumbers[1] && whatNumbers[2] == whatNumbers[4])
	    	{
	    		btn_2[4].setText(Integer.toString(whatNumbers[0]*2 + whatNumbers[2]*3));
	    	}
    	}
    	
    	///Small Bucket
    	if(!combinationsSelected[11])
    	{
			btn_2[5].setEnabled(true);
			btn_2[5].setText("0");
	    	if(whatNumbers[0] == 1 && whatNumbers[1] == 2 && whatNumbers[2] == 3 && whatNumbers[3] == 4 && whatNumbers[4] == 5)
	    	{
	    		btn_2[5].setText("15");
	    	}
    	}
    	
    	///Big Bucket
    	if(!combinationsSelected[12])
    	{
			btn_2[6].setEnabled(true);
			btn_2[6].setText("0");
	    	if(whatNumbers[0] == 2 && whatNumbers[1] == 3 && whatNumbers[2] == 4 && whatNumbers[3] == 5 && whatNumbers[4] == 6)
	    	{
	    		btn_2[6].setText("20");
	    	}
    	}
    	
    	///Chance
    	if(!combinationsSelected[13])
    	{
			btn_2[7].setEnabled(true);
    		btn_2[7].setText(Integer.toString(whatNumbers[0] + whatNumbers[1] + whatNumbers[2] + whatNumbers[3] + whatNumbers[4]));
    	}
    	
    	///General
    	if(!combinationsSelected[14])
    	{
			btn_2[8].setEnabled(true);
			btn_2[8].setText("0");
	    	if(whatNumbers[0] == whatNumbers[4])
	    	{
	    		btn_2[8].setText(Integer.toString(whatNumbers[0]*5 + 50));
	    	}
    	}
    	
    }
}


