package edu.jsu.mcis;

import javax.lang.model.util.ElementScanner6;

public class TicTacToeModel {
    
    private static final int DEFAULT_WIDTH = 3;
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("Tie"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    private Mark[][] grid; /* Game grid */
    private boolean xTurn; /* True if X is current player */
    private int width;     /* Size of game grid */
    private int turnCount = 1;
    
    /* DEFAULT CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        /* No arguments (call main constructor; use default size) */
        
        this(DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create grid (width x width) as a 2D Mark array */

        
        grid = new Mark[width][width];

        /* Initialize grid by filling every square with empty marks */
        for(int x = 0; x < (width); ++x)
        {
            for(int i = 0; i < (width); ++i)
            {
                grid[x][i] = Mark.EMPTY;
            }
        }
        
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */

           boolean boolMark = false;
        
            if((isValidSquare(row, col) == true) && (isSquareMarked(row, col) == false) && (turnCount % 2 == 0 ))
            {
                xTurn = false;
                grid[row][col] = Mark.O;
                boolMark = true;
            }
            else if((isValidSquare(row, col) == true) && (isSquareMarked(row, col) == false) && (turnCount % 2 != 0 ))
            {
                xTurn = true;
                grid[row][col] = Mark.X;
                boolMark = true;
            } 
            else
            {
                boolMark = false;
            }

        turnCount++;
        return boolMark;
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return true if specified location is within grid bounds */
        
        if((row < width & row >= 0) && (col < width & col >= 0))
        {
            return true;
        }
        else
        {
            return false;
        }
       
        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return true if square at specified location is marked */
        
        if((isValidSquare(row, col) == true) && (grid[row][col] == Mark.EMPTY))
        {
            return false;
        }
        else
        {
            return true; 
        }   
    
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return mark from the square at the specified location */
        if(isValidSquare(row, col) == true)
        {
            return grid[row][col];
        }
        else    
        {
            return null;
        }
        

    }
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
        
        if(isMarkWin(Mark.X) == true)
        {
            return Result.X;
        }
        else if(isMarkWin(Mark.O) == true)
        {
            return Result.O;
        }
        else if(isTie() == true)
        {
            return Result.TIE;
        }
        else
        {
            return Result.NONE;
        }


    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner. Returns true if winner. */
         
         int c = 0;
         boolean winner = false;

            //checks rows
           for(int i = 0; i < width; ++i)
           {
               c = 0;
                for(int j = 0; j < width; ++j)
                {
                    if(grid[i][j] == mark){  
                       c++;  
                    }

                    if(c == width)
                    {
                        winner = true;
                    }
                }
           }

            //check columns
            for(int i = 0; i < width; ++i)
            {
               c = 0;
                for(int j = 0; j < width; ++j){
                    if(grid[j][i] == mark){  
                       c++;
                    }
                    if(c == width)
                    {
                        winner = true;
                    }
                }               
           }
           
            //check left diagonal
          int count = 0;
          for(int d = 0; d < width; ++d)
          {
              if(grid[d][d] == mark)
              {
                  count++; 
              }
              else
              {
                  continue;
              }
          }

          if(count == width)
              {
                  winner = true;
              }
    

            //Check right diagonal
         int countAgain = 0;
         for(int d = 0; d < width; ++d)
         {
              if(grid[d][width-d-1] == mark)
              {
                  countAgain++;
              }
              else
              {
                  continue;
              }
         }

          if(countAgain == width)
              {
                  winner = true;
              }
          
      return winner;

    }
	
    private boolean isTie() {

        boolean tie = false;
        
        /* Check the squares of the board to see if the game is a tie.  */
        int counter = 0;

        for(int i = 0; i < width; i++)
        {
            for(int j = 0; j < width; j++)
            {
                if(grid[i][j] != Mark.EMPTY)
                {
                    counter++;
                }          
            }
        }

        if(counter == (width * width))
        {
            tie = true;
        }
        
  
      return tie;
        
    }

    public boolean isGameover() {
        
        /* Return true if the game is over */
        
        return Result.NONE != getResult();
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }



    
}