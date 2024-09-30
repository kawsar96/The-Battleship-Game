package game;
class GameController {
	//creating one private instance of the game for one game play...abstraction
	//hiding code implementation from the user....encapsulation
	//all methods are encapsulated in Game.java
    private Game game;

    /**
     * Constructs a GameController with the specified Game instance.
     * @param game The Game instance to be managed by the controller.
     */
    public GameController() {
        game = new Game();
    }

    /**
     * Starts the game by setting up the game and initiating gameplay.
     * @return True if the game was started successfully, false otherwise.
     */
    public void startGame() {
        game.setupGame();
        game.playGame();
    }
}