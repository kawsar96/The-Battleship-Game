package game;
public class Main {
    /**
     * Main method to start the game by creating a GameController instance and calling startGame().
     * @param args Command-line arguments.
     */
	//hiding the complexity of the code form main function
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.startGame();
    }
}

