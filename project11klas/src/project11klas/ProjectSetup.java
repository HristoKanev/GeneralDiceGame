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
    private static JTable table;
    private static JTable table2;
    private static JTable table_1;
    
    public static void main(String[] args) {
        Run();
    }
    

    
    static JButton[] dice = new JButton[5];
    static int[] dice_number = new int[5];
    static int rolls = 3;
    static JLabel remaining = new JLabel(String.format("You have %2d remaining rolls", rolls));
    
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
        rollDices.addActionListener(new ProjectSetup ());
        panel.add(rollDices);
        
        newGame = new JButton("New game");
        newGame.setBounds(277,282,158,67);
        newGame.setHorizontalAlignment(JTextField.CENTER);
        newGame.addActionListener(new ProjectSetup());
        panel.add(newGame);
        
        String number1="5";
        String[] columns={"Number","Points"};
        String[] [] data ={{"1", number1}, {"2", number1},{"3", number1},{"4", number1},{"5", number1},{"6", number1}};
        table = new JTable(data,columns);
        
        String[] columns2={"Type","Points"};
        String[] [] data2 ={{"pair", number1}, {"2 pairs", number1},{"triple", number1},{"square", number1},{"full", number1},{"small bucket", number1},{"big bucket", number1},{"chance", number1},{"general", number1},{"total", number1}};
        table2 = new JTable(data2,columns2);
        table2.setBounds(28, 189, 183, 160);
        panel.add(table2);
       
        table.setFillsViewportHeight(true);
        table.setBounds(28, 77, 183, 101);
        
        panel.add(table);
        
        
        remaining.setHorizontalTextPosition(SwingConstants.CENTER);
        remaining.setHorizontalAlignment(SwingConstants.CENTER);
        remaining.setBounds(221, 134, 270, 44);
        panel.add(remaining);
        
        for (int i = 0;i<5;i++) 
        { 
        	dice[i]=new JButton();
        	dice[i].setMargin(new Insets(0,0,0,0));
        	dice[i].setFont(new Font("Tahoma", Font.PLAIN, 33));
        	dice[i].setHorizontalAlignment(SwingConstants.CENTER);
        	dice[i].setEnabled(false);
        	dice[i].setBounds(221+i*56, 77, 46, 46);
            dice[i].addActionListener(new ProjectSetup());
            panel.add(dice[i]);
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
    }
