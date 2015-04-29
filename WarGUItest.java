import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WarGUItest extends JFrame 
{
   //declare variables
   War game;
   String player1CardPic;
   private String player1CardPicture;
   private String player2CardPicture;
   JButton playCardButton;
   private static final String BLANK = "cardPics/back.jpg";    
    private ImageIcon blankCard;                             
    private ImageIcon blankCard2;
    private ImageIcon blank;                                    
    private ImageIcon playerCard;                               
    private ImageIcon computerCard;                             

    private JLabel blankCardLabelLeft;                             
    private JLabel blankCardLabelRight;
    private JLabel playerCardLabel;                             
    private JLabel computerCardLabel;                           

    private JPanel buttonPanel;                                 
    private JPanel rightDeckPanel;                              
    private JPanel leftDeckPanel;                               
    private JPanel cardsPanel;                                  
                                

    private final int WINDOW_WIDTH = 1000;                     
    private final int WINDOW_HEIGHT = 500;                     


public WarGUItest()
{
   game = new War();
   
    setLayout(new BorderLayout());
    setTitle("WAR! Card Game");
    setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    buildButtonPanel();
    
    add(buttonPanel, BorderLayout.PAGE_END);

    buildDecksPanel();
    add(leftDeckPanel, BorderLayout.LINE_START);
    add(rightDeckPanel, BorderLayout.LINE_END);

    buildCardsPanel();
    add(cardsPanel, BorderLayout.CENTER);

   
    setVisible(true);

    
    }

    private void buildButtonPanel(){
        //battle button
        playCardButton = new JButton("Battle!");
        playCardButton.setPreferredSize(new Dimension(200,100));

        //button listener
        playCardButton.addActionListener(new PlayCardListener());

        //Add to panel
        buttonPanel = new JPanel();
        buttonPanel.add(playCardButton);
        
        buttonPanel.setBackground(Color.blue);
    }

 
    private void buildCardsPanel(){
        
        blank = new ImageIcon();

        //display blank cards
        playerCardLabel = new JLabel(blank);
        computerCardLabel = new JLabel(blank);

        //add label
        cardsPanel = new JPanel();
        cardsPanel.add(playerCardLabel);
        cardsPanel.add(computerCardLabel);
        //set color
        cardsPanel.setBackground(Color.red);
        //set size
        cardsPanel.setPreferredSize(new Dimension(700, 700));
    }

    private void buildDecksPanel(){
        //create image icon
        blankCard = new ImageIcon(BLANK);
        blankCard2 = new ImageIcon(BLANK);

        //display image icons
        blankCardLabelLeft = new JLabel();
        blankCardLabelLeft.setIcon(blankCard);
        blankCardLabelRight = new JLabel();
        blankCardLabelRight.setIcon(blankCard);

        //add lables
        rightDeckPanel = new JPanel();
        rightDeckPanel.setPreferredSize(new Dimension(180,250));
        rightDeckPanel.add(blankCardLabelRight);
        leftDeckPanel = new JPanel();
        leftDeckPanel.setPreferredSize(new Dimension(180,250));
        leftDeckPanel.add(blankCardLabelLeft);

       //set colors
        leftDeckPanel.setBackground(Color.blue);
        rightDeckPanel.setBackground(Color.blue);
    }

       private class PlayCardListener implements ActionListener{
        public void actionPerformed(ActionEvent e){

                 game.Battle();
             
        
                 // player1CardPicture = player1Card.toString();
//                  playerCard = new ImageIcon(player1CardPicture);
//                  playerCardLabel.setIcon(playerCard);
//                      
//                  player2CardPicture = player2Card.toString();    
//                  computerCard = new ImageIcon(player2CardPicture.toString());
//                  computerCardLabel.setIcon(computerCard);
// 
               
                  
}
      }    
        
    
    public static void main(String[] args) {
    
        WarGUItest guiGame = new WarGUItest();
        
    }

}