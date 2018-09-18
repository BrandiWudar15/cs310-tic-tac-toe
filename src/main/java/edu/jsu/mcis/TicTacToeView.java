package edu.jsu.mcis;

public class TicTacToeView {

    private TicTacToeModel model;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
    }
	
    public void viewModel() {
        
        /* Print the board to the console (see examples) */

        int width = model.getWidth();
        Enum[][] grid = new Enum[width][width];

        for(int j = 0; j < width ; ++j)
        {
            for(int k = 0; k < width ; ++k)
            {
                grid[j][k] = model.getMark(j,k);
            }
        }
        
        System.out.print("  ");
        for(int g = 0; g < width; ++g)
        {
            System.out.print(g);
        }
            System.out.println();
       
       for(int x = 0; x < width; ++x )
       {
           System.out.print(x + " ");
 

           for(int y = 0; y < width; ++y)
           {
               System.out.print(grid[x][y]);
           }

           System.out.println();
       }
       

    }

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */

    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        if(model.isValidSquare)

    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}