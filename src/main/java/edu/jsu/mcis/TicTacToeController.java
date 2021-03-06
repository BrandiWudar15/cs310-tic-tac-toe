package edu.jsu.mcis;

import java.util.Scanner;

public class TicTacToeController {

    private TicTacToeModel model;
    private TicTacToeView view;
    private Scanner keyboard;
    
    /* CONSTRUCTOR */

    public TicTacToeController(TicTacToeModel model, TicTacToeView view) {
        
        /* Initialize model and view */

        this.model = model;
        this.view = view;
        
        /* Initialize scanner (for console keyboard) */
        
        keyboard = new Scanner(System.in);

    }

    public void controlModel() {
        
        /* Prompt player for next move using view's showNextMovePrompt() */
        int x,y;
        
        view.showNextMovePrompt();

        x = keyboard.nextInt();
        y = keyboard.nextInt();

        if((model.isValidSquare(x,y) == true) && (model.isSquareMarked(x,y) == false))
        {
            model.makeMark(x,y);
        }
        else
        {
            view.showInputError();
            x = keyboard.nextInt();
            y = keyboard.nextInt();
        }
        
        
        /* Receive and validate input, which should be read at the keyboard as
           two integers, the row and the column (for example, "1 1" for the
           center square of a 3 x 3 grid).  Make mark if input is valid, or show
           error message using view's showInputError() if input is invalid. */
        
           
        
    }

}