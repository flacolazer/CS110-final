import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.*;

public class WarGUI extends JFrame
{
   War game;
   JButton playCardButton;
   private static final String BLANK = "cardPics/back.jpg";    //Path to image of card backside.
    private ImageIcon blankCard;                                //Icon which displays image of card back.
    private ImageIcon blankCard2;
    private ImageIcon blank;                                    //Actually nothing, just a placeholder.
    private ImageIcon playerCard;                               //Holds path to the current card being played by the player.
    private ImageIcon computerCard;                             //Holds path to the current card being played by the computer.

    private JLabel blankCardLabelLeft;                          //Label which holds the imageIcon for the back-side of a card.
    private JLabel blankCardLabelRight;
    private JLabel playerCardLabel;                             //Label which holds the ImageIcon for the player's current card selection.
    private JLabel computerCardLabel;                           //Label which holds the ImageIcon for the computer's current card selection.

    private JTextField playerCardsLeft;
    private JTextField computerCardsLeft;

    private JPanel buttonPanel;                                 //Holds the "playCard" button which results in both players drawing cards.
    private JPanel rightDeckPanel;                              //Holds the "blankCardLabel" JLabel, stimulates the decks of the player.
    private JPanel leftDeckPanel;                               //Holds the "blankCardLabel" JLabel, stimulates the decks of the computer.
    private JPanel cardsPanel;                                  //Holds both the "playerCardLabel" and "computerCardLabel", where gameplay occurs.
    private JPanel counterPanel;                                //Holds the counters which show how many cards each player has left in their decks.

    private final int WINDOW_WIDTH = 1000;                      //For sizing the JFrame
    private final int WINDOW_HEIGHT = 500;                      //For sizing the JFrame
    private String war = "false";  


public WarGUI()
{
   game = new War();
   
    setLayout(new BorderLayout());
    setTitle("WAR! Card Game");
    setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    buildButtonPanel();
    //Adds it to the JFrame content pane, in the bottom position "PAGE_END"
    add(buttonPanel, BorderLayout.PAGE_END);

    buildDecksPanel();
    add(leftDeckPanel, BorderLayout.LINE_START);
    add(rightDeckPanel, BorderLayout.LINE_END);


    buildCounterPanel();
    add(counterPanel, BorderLayout.PAGE_START);

    buildCardsPanel();
    add(cardsPanel, BorderLayout.CENTER);

    //Once the correct panels have been added, reveal the JFrame to the player.
    setVisible(true);

  
    }

    private void buildButtonPanel(){
        //Create the two buttons which control gameplay.
        playCardButton = new JButton("Play Card");
        playCardButton.setPreferredSize(new Dimension(200,100));

        //Add event listeners for the buttons.
        playCardButton.addActionListener(new PlayCardListener());

        //Add the buttons to the panel.
        buttonPanel = new JPanel();
        buttonPanel.add(playCardButton);
        //Set the panel color to a nice blueish color which is not one of the standard colors available.
        buttonPanel.setBackground(new Color(14, 138, 210));
    }

    /**
     * This method is called just once in the JFrame constructor. It constructs the cardsPanel, which houses the main playing
     * area for both players. The cards are displayed using an ImageIcon, but initially these icons are set to nothing
     * because the players have yet to put any cards down.
     *
     */
    private void buildCardsPanel(){
        //A blank ImageIcon which is a place holder for the cards later.
        blank = new ImageIcon();

        //Adds the ImageIcon place holder to a label, allowing addition to the cardsPanel. The player's cards are displayed
        //on the left, the computer's are displayed on the right.
        playerCardLabel = new JLabel(blank);
        computerCardLabel = new JLabel(blank);

        //Adds the two labels to the cardsPanel, then sets the color and dimensions of the playing area.
        cardsPanel = new JPanel();
        cardsPanel.add(playerCardLabel);
        cardsPanel.add(computerCardLabel);
        cardsPanel.setBackground(new Color(89, 3, 67));
        cardsPanel.setPreferredSize(new Dimension(600, 600));
    }

    /**
     * This method is called just once in the JFrame constructor. It constructs two ImageIcons which are added to
     * labels, these labels are used to construct two panels. One panel on the right for the computer's deck, one on the left
     * for the player's deck. These image icons are static and are just images stimulating a deck (back of a card).
     *
     */
    private void buildDecksPanel(){
        //ImageIcons of back of a card.
        blankCard = new ImageIcon(BLANK);
        blankCard2 = new ImageIcon(BLANK);

        //back of card images are added to the labels.
        blankCardLabelLeft = new JLabel();
        blankCardLabelLeft.setIcon(blankCard);
        blankCardLabelRight = new JLabel();
        blankCardLabelRight.setIcon(blankCard);

        //Labels are added to their respective panels and the dimensions are
        //set. Then the panels are colored to match with the playing area.
        rightDeckPanel = new JPanel();
        rightDeckPanel.setPreferredSize(new Dimension(152,213));
        rightDeckPanel.add(blankCardLabelRight);
        leftDeckPanel = new JPanel();
        leftDeckPanel.setPreferredSize(new Dimension(152,213));
        leftDeckPanel.add(blankCardLabelLeft);

        //Match color with the playing area.
        leftDeckPanel.setBackground(new Color(89, 3, 67));
        rightDeckPanel.setBackground(new Color(89, 3, 67));
    }

    /**
     * This method is called just once in the JFrame constructor. It creates two textfields which display the number
     * of cards remaining in each players hands.
     *
     */
    private void buildCounterPanel(){

        //The text fields are set to 26 originally (half of deck) until the values are adjusted with gameplay.
        playerCardsLeft = new JTextField("Player's Cards: 26", 26);
        computerCardsLeft = new JTextField("Computer's Cards: 26", 26);

        //Makes the text fields not editable, not for input.
        playerCardsLeft.setEditable(false);
        computerCardsLeft.setEditable(false);

        //Adds the text fields to the counterPanel.
        counterPanel = new JPanel();
        counterPanel.add(playerCardsLeft);
        counterPanel.add(computerCardsLeft);
    }
   private class PlayCardListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //This is run on the last of three clicks involved in a war.
            if (war.equals("last")){
                //Find the image path for the cards that were involved in the war (the third and last card). Use
                //this path to update the imageIcon for the player/computer labels.
                playerCard = new ImageIcon(game.toString());
                playerCardLabel.setIcon(playerCard);

                computerCard = new ImageIcon(game.toString());
                computerCardLabel.setIcon(computerCard);

                //Signifies that the war is over, allows the object to change to false below without allowing new cards
                //to be drawn.
                war = "final";
            }

            //The second time the button is clicked during a war, this is the face down card. The cards involved in the war, as
            //well as the outcome of the war are already determined, but are not revealed to the player until the next button click.
            if (war.equals("true")){
                //Set the imageicons to the card backside, to stimulate playing a card face down. Updated as described above.
                playerCard = new ImageIcon(BLANK);
                playerCardLabel.setIcon(playerCard);

                computerCard = new ImageIcon(BLANK);
                computerCardLabel.setIcon(computerCard);

                war = "last";
            }

            //This code is run normally, unless there is a war. It draws two cards, calls a battle, updates the images.
            //Then it checks whether there was a rank match.
            // if (war.equals("false")){
//                 //Draw cards.
//                 Card playersCard = game.playerDraw();
//                 Card computersCard = game.computerDraw();
// 
//                 //Update the images.
//                 playerCard = new ImageIcon(playersCard.getCardPic());
//                 playerCardLabel.setIcon(playerCard);
// 
//                 computerCard = new ImageIcon(computersCard.getCardPic());
//                 computerCardLabel.setIcon(computerCard);
// 
//                 //Call a battle.
//                 game.battle(playersCard, computersCard);
// 
                //If the cards in the battle matched, then alert the user of a war, then DO NOT update the score counter.
                //Although the outcome of the war is already determined, it is not revealed until two more clicks.
           //      if (playersCard.equals(computersCard)){
//                     //Set war to true to allow tracking what stage of war.
//                     war = "true";
//                     JOptionPane.showMessageDialog(null, "WAR!");
//                 }

                //If there is not war going on, then update the score, otherwise do not.
               //  if (!war.equals("true")){
//                     playerCardsLeft.setText("Player's Cards: " + (game.getPlayersCardsRemaining() - 1));
//                     computerCardsLeft.setText("Computer's Cards: " + (game.getComputersCardsRemaining() - 1));
// 
//                 }
//             }

           //  //Signifies the final iteration of the war.
//             if (war.equals("final")){
//                 //Change war flag to false to allow normal gameplay for the next click.
//                 war = "false";
//                 //Finally update the scores, which have not been updated since the war started.
//                 playerCardsLeft.setText("Player's Cards: " + (game.getPlayersCardsRemaining() - 1));
//                 computerCardsLeft.setText("Computer's Cards: " + (game.getComputersCardsRemaining() - 1));
             }
        }
    
   

    /**
     * Main method which instantiates a JFrame (WarGameGUI class), this starts the GUI game.
     *
     */
    public static void main(String[] args) {
        WarGUI guiGame = new WarGUI();
    }


}