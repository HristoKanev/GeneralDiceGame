package project11klas;

import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
    static JLabel[] lb_2 = new JLabel[10];
    static String[] data ={"pair","2 pairs","triple","square","full","small bucket","big bucket","chance","general", "total"};
    static JButton[] btn_2 = new JButton[10];
    
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
        
        for (int i = 0;i<10;i++) 
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
    	//TODO
    }
}