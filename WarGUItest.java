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
        int y = 6;
        LinkedList<Card> player1Cards = new LinkedList<Card>();
        LinkedList<Card> player2Cards = new LinkedList<Card>();
   while (y == 6){
           //this creates a deck
    List<Card> deck = new ArrayList<Card>( );

    for ( int i = 0; i < 4; i++ ) {
      for ( int j = 2; j < 15; j++ ) {
        deck.add( new Card( i, j ) );
      }
    }
   
   //shuffles the deck
    Collections.shuffle( deck, new Random( System.nanoTime( ) ) );

// adds cards to player's hands
     player1Cards = new LinkedList<Card>( );
    player1Cards.addAll( deck.subList( 0, 25 ) );

     player2Cards = new LinkedList<Card>( );
    player2Cards.addAll( deck.subList( 26, deck.size( ) ) );
    y = 7;
    }
             
           //  while (player1Cards.size() != 0 && player2Cards.size() !=0) {
    
            //while they still have cards, pop the top
               Card player1Card = player1Cards.pop();
               Card player2Card = player2Cards.pop();
         
               System.out.println("Player 1: " + player1Card.toString());
               System.out.println("Player 2: " + player2Card.toString());
               
                 player1CardPicture = player1Card.toString();
                 playerCard = new ImageIcon(player1CardPicture);
                 playerCardLabel.setIcon(playerCard);
                     
                 player2CardPicture = player2Card.toString();    
                 computerCard = new ImageIcon(player2CardPicture.toString());
                 computerCardLabel.setIcon(computerCard);

               
                  //battle, player 1 wins
                     if (player1Card.getCard() > player2Card.getCard())
                     {
                       player1Cards.addLast(player2Card);
                       player1Cards.addLast(player1Card);
                     //battle, p2 wins
                     } else if (player1Card.getCard() < player2Card.getCard()) 
                     {
                       player2Cards.addLast(player2Card);
                       player2Cards.addLast(player1Card);
                     } else {
                     // WAR occurs
                       System.out.println("War");
                       List<Card> warCards1 = new ArrayList<Card>();
                       List<Card> warCards2 = new ArrayList<Card>();
                       for ( int i = 0; i < 3; i++ ) {
                         if(player1Cards.size()==0 || player2Cards.size()==0)
                         {
                           break;
                         }
                         warCards1.add( player1Cards.pop());
                         warCards2.add( player2Cards.pop());
                       }
                       
                       System.out.println("Player 1 war: " + warCards1.get(0).toString( ));
                       System.out.println("Player 2 war: " + warCards2.get(0).toString());
                       if ( warCards1.get( 0 ).getCard( ) > warCards2.get(0).getCard()) 
                       {
                         player1Cards.addAll(warCards2);
                         player1Cards.addAll(warCards1);
                         System.out.println( "Player 1 wins the war" );
                       } else {
                         player2Cards.addAll(warCards2);
                         player2Cards.addAll(warCards1);
                         System.out.println( "Player 2 wins the war" );
                       }
                     }


}
      }    
        
    
    public static void main(String[] args) {
    
        WarGUItest guiGame = new WarGUItest();
        
    }

}