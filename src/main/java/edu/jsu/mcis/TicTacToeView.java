package edu.jsu.mcis;

public class TicTacToeView {

    private TicTacToeModel model;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
    }
	
    public void viewModel() {
        
        /* Print the board to the console (see examples) */
       
       System.out.println(model);

    }

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */



    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        System.out.println("Input is invalid");

    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}