package game;
import java.util.Scanner;

public class Game {

    /** Number of computer ships. */
    private static int computerShipNumber = 1;

    /** Number of player ships. */
    private static int playerShipNumber = 1;

    /** Number of grenades possessed by the player. */
    private static int playerGrenadeNumber = 1;

    /** Number of grenades possessed by the computer. */
    private static int computerGrenadeNumber = 1;

    /** Rows in the game grid. */
    private int row = 8;

    /** Columns in the game grid. */
    private int col = 8;

    /** Tracks the turn of the player. */
    private int playerTurn = 1;

    /** Tracks the turn of the computer. */
    private int computerTurn = 1;

    /** Main game grid. */
    String[][] grid = new String[row][col];

    /** Temporary grid for visualization. */
    String[][] tempGrid = new String[row][col];

    /**
     * Initializes the game and prints a welcome message.
     */
    public Game() {
        System.out.println("Hi, let’s play Battleship!");
        for(int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++) {
                grid[r][c] = "";
                tempGrid[r][c] = "_";
            }
        }
    }


    /**
     * Shows the current state of the game.
     */
    public void printGrid() {
        for(int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++) {
                System.out.print(grid[r][c]+"  ");
            }
            System.out.println();
        }
    }

    /**
     * function to show so far turns
     */
    public void printTempGrid() {
        for(int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++) {
                System.out.print(tempGrid[r][c]+" ");
            }
            System.out.println();
        }
    }

    Scanner sc = new Scanner(System.in);
    /**
     * Places player's ships on the game grid based on user input.
     */
    public void playerShip() {
        while(playerShipNumber <= 6) {
            System.out.print("Enter the coordinates of your ship #"+ playerShipNumber +": ");
            String coordinates = sc.next();

            //validating user input length
            //if length less or more than 2, will take input again
            //all other invalid input will be caught by else showing coordinates outside grid
            if(coordinates.length() == 2) {

                int row = (coordinates.charAt(1) - '0') - 1;
                char tempCol = Character.toLowerCase(coordinates.charAt(0));
                int col = tempCol - 'a';
                
                //execute if within grid range
                if (0 <= row && row <= 7 && 0 <= col && col <= 7) {
                    //if that coordinate is not used
                    if(grid[row][col] == "") {
                        grid[row][col] = "s";
                        playerShipNumber++;
                    }
                    //execute if coordinate is used before
                    else {
                        System.out.println("sorry, coordinates already used. try again.");
                    }
                }
                //execute if outside the grid range
                else {
                    System.out.println("sorry, coordinates outside the grid. try again.");
                }

            }
            else {
            	System.out.println("Invalid Input. Please try again.");
                playerShip();
            }
        }

    }

    /**
     * Allows the player to place grenades on the game grid based on user input.
     */
    public void playerGrenade() {
        while(playerGrenadeNumber <= 4) {
            System.out.print("Enter the coordinates of your grenade #"+ playerGrenadeNumber +": ");
            String coordinates = sc.next();

            //validating user input length
            //if length less or more than 2, will take input again
            //all other invalid input will be caught by else showing coordinates outside grid
            if(coordinates.length() == 2) {

                int row = (coordinates.charAt(1) - '0') - 1;
                char tempCol = Character.toLowerCase(coordinates.charAt(0));
                int col = tempCol - 'a';
                
                //execute if within grid range
                if (0 <= row && row <= 7 && 0 <= col && col <= 7) {
                    //if that coordinate is not used
                    if(grid[row][col] == "") {
                        grid[row][col] = "g";
                        playerGrenadeNumber++;
                    }
                    //execute if coordinate is used before
                    else {
                        System.out.println("sorry, coordinates already used. try again.");
                    }
                }
                //execute if outside the grid range
                else {
                    System.out.println("sorry, coordinates outside the grid. try again.");
                }
            }
            else {
            	System.out.println("Invalid Input. Please try again.");
                playerGrenade();
            }

        }
    }


    /**
     * Places computer ships randomly on the game grid.
     */
    public void computerShip() {
        //ship can not be more than 6
        while(computerShipNumber <= 6) {
            //initializing random numbers for rows and columns
            int row = (int)(Math.random() * (8 - 0) + 0);
            int col = (int)(Math.random() * (8 - 0) + 0);

            if (0 <= row && row <= 7 && 0 <= col && col <= 7) {
                //if that coordinate is not used
                if(grid[row][col] == "") {
                    grid[row][col] = "S";
                    computerShipNumber++;
                }
            }

        }
    }
    /**
     * Places computer grenades randomly on the game grid.
     */
    public void computerGrenade() {
        //grenades can not be more than 4
        while(computerGrenadeNumber <= 4) {
            int row = (int)(Math.random() * (8 - 0) + 0);
            int col = (int)(Math.random() * (8 - 0) + 0);
            
            if (0 <= row && row <= 7 && 0 <= col && col <= 7) {
                //if that coordinate is not used
                if(grid[row][col] == "") {
                    grid[row][col] = "G";
                    computerGrenadeNumber++;
                }
            }
        }
        //to check all the inputs...for testing purpose only.
       // printGrid();
    }

    /**
     * Manages the player's turn in the game.
     */
    public void PlayerPlaying() {

        //checking if not all of the ships are destroyed
        while(computerShipNumber != 1 && playerShipNumber != 1) {

            System.out.print("position of your rocket: ");
            String coordinates = sc.next();
            //validating user input length
            //if length less or more than 2, will take input again
            //all other invalid input will be caught by else showing coordinates outside grid
            if(coordinates.length() == 2) {
            int row = (coordinates.charAt(1) - '0') - 1;
            char tempCol = Character.toLowerCase(coordinates.charAt(0));
            int col = tempCol - 'a';

            //execute if within grid range
            if (0 <= row && row <= 7 && 0 <= col && col <= 7) {
                //execute if computer's ship is in that coordinate
                if(grid[row][col] == "S") {
                    //execute if the position is never called before
                    if(tempGrid[row][col] == "_") {
                        tempGrid[row][col] = "S";
                        computerShipNumber--;
                        System.out.println("ship hit.");
                        //System.out.println(computerShipNumber);
                    }
                    else {
                        System.out.println("position already called.");
                    }
                    //show current grid after this turn
                    printTempGrid();
                    //////////////////
                    //checking if player if player has 2 turns
                    if(playerTurn == 2) {
                        playerTurn--;
                        PlayerPlaying();
                    }
                    //////////
                    //computer's turn
                    ComputerPlaying();
                }
                //execute if player's ship is in that coordinate
                else if(grid[row][col] == "s") {
                    //execute if the position is never called before
                    if(tempGrid[row][col] == "_") {
                        tempGrid[row][col] = "s";
                        playerShipNumber--;
                        System.out.println("ship hit.");
                    }
                    else {
                        System.out.println("position already called.");
                    }
                    //show current grid after this turn
                    printTempGrid();

                    //checking if player if player has 2 turns
                    if(playerTurn == 2) {
                        playerTurn--;
                        PlayerPlaying();
                    }

                    //computer's turn
                    ComputerPlaying();
                }
                //execute if computer's grenade is in that coordinate
                else if(grid[row][col] == "G"){
                    //execute if the position is never called before
                    if(tempGrid[row][col] == "_") {

                        //if this executes computer will have two turns
                        computerTurn = 2;
                        ////////////////////
                        tempGrid[row][col] = "G";
                        //opponent play twice
                        System.out.println("boom! grenade.");
                    }
                    else {
                        System.out.println("position already called.");
                    }
                    //show current grid after this turn
                    printTempGrid();

                    //checking if player if player has 2 turns
                    if(playerTurn == 2) {
                        playerTurn--;
                        PlayerPlaying();
                    }

                    //computer's turn
                    ComputerPlaying();
                }
                else if(grid[row][col] == "g") {
                    //execute if the position is never called before
                    if(tempGrid[row][col] == "_") {

                        //if this executes computer will have two turns
                        computerTurn = 2;

                        tempGrid[row][col] = "g";
                        //opponent play twice
                        System.out.println("boom! grenade.");
                    }
                    else {
                        System.out.println("position already called.");
                    }
                    //show current grid after this turn
                    printTempGrid();

                    //checking if player if player has 2 turns
                    if(playerTurn == 2) {
                        playerTurn--;
                        PlayerPlaying();
                    }

                    //computer's turn
                    ComputerPlaying();
                }
                else if(grid[row][col] == "") {
                    tempGrid[row][col] = "*";
                    System.out.println("nothing.");

                    //show current grid after this turn
                    printTempGrid();

                    //checking if player if player has 2 turns
                    if(playerTurn == 2) {
                        playerTurn--;
                        PlayerPlaying();
                    }

                    //computer's turn
                    ComputerPlaying();
                }

            }
            //execute if outside the grid range
            else {
                System.out.println("sorry, coordinates outside the grid. try again.");
                //taking input again from player
                PlayerPlaying();
            }
        }
            else {
            	System.out.println("Invalid Input. Please try again.");
            	PlayerPlaying();
            }

        if(computerShipNumber == 1) {
            System.out.println("You Win!");
            printGrid();
            System.exit(0);
        }
        else {
            System.out.println("You Lost!");
            printGrid();
            System.exit(0);
        }
        }

    }


    /**
     * Manages the computer's turn in the game.
     */
    public void ComputerPlaying() {

        //checking if not all of the ships are destroyed
        while(computerShipNumber != 1 && playerShipNumber != 1) {
            int row = (int)(Math.random() * (8 - 0) + 0);
            int col = (int)(Math.random() * (8 - 0) + 0);
            int tempRow = row+1;
            char tempCol = (char)(col+65);
            System.out.println("position of my rocket: "+ tempCol+tempRow);
            //
            //proceed if the selected position is within the valid grid boundaries
            	if (0 <= row && row <= 7 && 0 <= col && col <= 7) {
            	//check if there's a computer's ship located at the specified coordinates
                if(grid[row][col] == "s") {
                    //check and proceed if the position is never called before
                    if(tempGrid[row][col] == "_") {
                        tempGrid[row][col] = "s";
                        playerShipNumber--;
                        System.out.println("ship hit.");
                    }
                    else {
                        System.out.println("position already called.");
                    }
                    //show current grid after this turn
                    printTempGrid();
                    ////////////
                    if(computerTurn == 2) {
                        computerTurn--;
                        ComputerPlaying();
                    }
                    ////////////
                    //player's turn
                    PlayerPlaying();
                }
                //execute if player's ship is in that coordinate
                else if(grid[row][col] == "S") {
                    //execute if the position is never called before
                    if(tempGrid[row][col] == "_") {
                        tempGrid[row][col] = "S";
                        computerShipNumber--;
                        System.out.println("ship hit.");
                    }
                    else {
                        System.out.println("position already called.");
                    }
                    //show current grid after this turn
                    printTempGrid();
                    //////////
                    if(computerTurn == 2) {
                        computerTurn--;
                        ComputerPlaying();
                    }
                    ////////////

                    //player's turn
                    PlayerPlaying();
                }
                //execute if computer's grenade is in that coordinate
                else if(grid[row][col] == "g"){
                    //execute if the position is never called before
                    if(tempGrid[row][col] == "_") {

                        //if this executes player will have two turns
                        playerTurn = 2;

                        tempGrid[row][col] = "g";
                        //opponent play twice
                        System.out.println("boom! grenade.");
                    }
                    else {
                        System.out.println("position already called.");
                    }
                    //show current grid after this turn
                    printTempGrid();
                    ////////
                    if(computerTurn == 2) {
                        computerTurn--;
                        ComputerPlaying();
                    }
                    ////////////
                    //player's turn
                    PlayerPlaying();
                }
                else if(grid[row][col] == "G") {
                    //execute if the position is never called before
                    if(tempGrid[row][col] == "_") {

                        //if this executes player will have two turns
                        playerTurn = 2;

                        tempGrid[row][col] = "G";
                        //opponent play twice
                        System.out.println("boom! grenade.");
                    }
                    else {
                        System.out.println("position already called.");
                    }
                    //show current grid after this turn
                    printTempGrid();
                    /////////
                    if(computerTurn == 2) {
                        computerTurn--;
                        ComputerPlaying();
                    }
                    ////////////
                    //player's turn
                    PlayerPlaying();
                }
                else if(grid[row][col] == "") {
                    tempGrid[row][col] = "*";
                    System.out.println("nothing.");
                    //show current grid after this turn
                    printTempGrid();
                    //////////
                    if(computerTurn == 2) {
                        computerTurn--;
                        ComputerPlaying();
                    }
                    ////////////
                    //player's turn
                    PlayerPlaying();
                }
            }
            //execute if outside the grid range
            else {
                System.out.println("sorry, coordinates outside the grid. try again.");
                //taking input again
                ComputerPlaying();
            }
        }
        if(computerShipNumber == 1) {
            System.out.println("You Win!");
            printGrid();
            System.exit(0);
        }
        else {
            System.out.println("You Lost!");
            printGrid();
            System.exit(0);
        }
    }
    /**
     * Initializes the game by deploying both player's and computer's ships and grenades on the grid.
     * Displays a message to signal the beginning of the gameplay.
     */
    public void setupGame() {
        playerShip();
        playerGrenade();
        computerShip();
        computerGrenade();
        System.out.println("All set! The computer has randomly positioned its ships and grenades. Let the game begin!");
    }

    /**
     * Initiates the game play by allowing the player to take their turn. 
     */
    public void playGame() {
        this.PlayerPlaying();
    }

}