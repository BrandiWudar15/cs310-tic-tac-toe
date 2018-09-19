package edu.jsu.mcis;

public class TicTacToeView {

    private TicTacToeModel model;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
    }
	
    public void viewModel() {
        
        /* Print the board to the console (see examples) */
        StringBuilder output = new StringBuilder();

        int width = model.getWidth();

        output.append("\n\n  ");

        for (int row = 0; row < width; row++) {
            output.append(row);
        }

        output.append("\n\n");

        for (int row = 0; row < width; row++) {

            output.append(row).append(" ");

            for (int col = 0; col < width; col++) {
                output.append(model.getMark(row,col));
            }

            output.append("\n");

        }

        System.out.println(output.toString());

    }

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */

        if(model.isXTurn() == true)
        {
                   
           System.out.println();
           System.out.println();
           System.out.println("Player 1 (X) Move");
           System.out.println("Enter the row and column numbers, separated by a space: ");
        }
        else
        {
                   
            System.out.println();
            System.out.println();
            System.out.println("Player 2 (O) Move");
            System.out.println("Enter the row and column numbers, separated by a space: ");
        }

    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */
        
        System.out.println("Invalid input");

   

    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}