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
    private static JTable table2;
    private static JTable table_1;
    
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
    static int totalScore = 0;
    
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
        newGame.setBounds(277,282,158,67);
        newGame.setHorizontalAlignment(JTextField.CENTER);
        newGame.setFocusPainted(false);
        newGame.addActionListener(new ProjectSetup());
        panel.add(newGame);
        
        
        
        remaining.setHorizontalTextPosition(SwingConstants.CENTER);
        remaining.setHorizontalAlignment(SwingConstants.CENTER);
        remaining.setBounds(221, 134, 270, 44);
        panel.add(remaining);
        
        
        for (int i = 0;i<6;i++) 
        { 
        	btn_ch[i] = new JButton("0");
        	btn_ch[i].addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            	}
            });
        	btn_ch[i].setBounds(126, 78+i*20, 74, 19);
        	btn_ch[i].setFocusPainted(false);
            panel.add(btn_ch[i]);
            
            lb_ch[i] = new JLabel(Integer.toString(i+1));
            lb_ch[i].setHorizontalAlignment(SwingConstants.RIGHT);
            lb_ch[i].setHorizontalTextPosition(SwingConstants.CENTER);
            lb_ch[i].setBounds(0, 80+i*20, 116, 14);
            panel.add(lb_ch[i]);
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

        	btn_2[i] = new JButton("0");
        	btn_2[i].addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            	}
            });
        	btn_2[i].setBounds(126, 220+i*20, 74, 19);
        	btn_2[i].setFocusPainted(false);
            panel.add(btn_2[i]);
            
            lb_2[i] = new JLabel(data[i]);
            lb_2[i].setHorizontalAlignment(SwingConstants.RIGHT);
            lb_2[i].setHorizontalTextPosition(SwingConstants.CENTER);
            lb_2[i].setBounds(0, 220+i*20, 116, 14);
            panel.add(lb_2[i]);
        }
        
        total.setText(String.format("Your total score is: %2d", totalScore));
        total.setHorizontalAlignment(SwingConstants.RIGHT);
        total.setHorizontalTextPosition(SwingConstants.CENTER);
        total.setBounds(0, 420, 200, 14);
        panel.add(total);
        
        
        
        
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
        	 System.exit(0);
        }
        else if(e.getSource()==rollDices)
        {
        		 for (int i = 0;i<5;i++) {
        			 if(!dice[i].isEnabled()) {
            			 dice_number[i]=(int) (Math.random()*6+1);
        				 dice[i].setEnabled(true);
        				 dice[i].setText(Integer.toString(dice_number[i]));
        			 }
        		 }
        		 rolls--;
    			 if(rolls==0) {
    				 for(int i = 0;i<5;i++) {
    			        dice[i].setEnabled(false);
    			     }
    			 }
    			 rollDices.setEnabled(false);
    			 remaining.setText(String.format("You have %2d remaining rolls", rolls));
    			 calculate_results();
    			 return;
        }
        for(int i = 0;i<5;i++) {
        	if(e.getSource()==dice[i]) {
        		dice[i].setEnabled(false);
        		dice[i].setText(null);
        		rollDices.setEnabled(true);
        		return;
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
    	
    	/// Combinations part
    	
    	/// Pair
    	for(int i = 3; i >= 0; i--)
    	{
    		if(whatNumbers[i] == whatNumbers[i + 1])
    		{
    			btn_2[0].setText(Integer.toString(whatNumbers[i]*2));
    			break;
    		}
    	}
    	
    	/// 2 Pairs
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
    	
    	/// Triple
    	for(int i = 2; i >= 0; i--)
    	{
    		if(whatNumbers[i] == whatNumbers[i + 2])
    		{
    			btn_2[2].setText(Integer.toString(whatNumbers[i]*3));
    		}
    	}
    	
    	/// Square
    	for(int i = 1; i >= 0; i--)
    	{
    		if(whatNumbers[i] == whatNumbers[i + 3])
    		{
    			btn_2[3].setText(Integer.toString(whatNumbers[i]*4));
    		}
    	}
    	
    	///Full
    	if(whatNumbers[0] == whatNumbers[2] && whatNumbers[3] == whatNumbers[4])
    	{
    		btn_2[4].setText(Integer.toString(whatNumbers[0]*3 + whatNumbers[3]*2));
    	}
    	else 
    	{
    		if(whatNumbers[0] == whatNumbers[1] && whatNumbers[2] == whatNumbers[4])
    		{
    			btn_2[4].setText(Integer.toString(whatNumbers[0]*2 + whatNumbers[2]*3));
    		}
    	}
    	
    	///Small Bucket
    	if(whatNumbers[0] == 1 && whatNumbers[1] == 2 && whatNumbers[2] == 3 && whatNumbers[3] == 4 && whatNumbers[4] == 5)
    	{
    		btn_2[5].setText("15");
    	}
    	
    	///Big Bucket
    	if(whatNumbers[0] == 2 && whatNumbers[1] == 3 && whatNumbers[2] == 4 && whatNumbers[3] == 5 && whatNumbers[4] == 6)
    	{
    		btn_2[6].setText("20");
    	}
    	
    	///Chance
    	btn_2[7].setText(Integer.toString(whatNumbers[0] + whatNumbers[1] + whatNumbers[2] + whatNumbers[3] + whatNumbers[4]));
    	
    	///General
    	if(whatNumbers[0] == whatNumbers[4])
    	{
    		btn_2[8].setText(Integer.toString(whatNumbers[0]*5 + 50));
    	}
    	
    }
}


