package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;

public class TicTacToeView extends JPanel implements ActionListener {
    
    TicTacToeModel model;

    private JButton[][] squares;
    private JPanel squaresPanel;
    private JLabel resultLabel;

    public TicTacToeView(TicTacToeModel model) {

        this.model = model;

        int width = model.getWidth();

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        squares = new JButton[width][width];
        squaresPanel = new JPanel(new GridLayout(width,width));
        resultLabel = new JLabel();
        resultLabel.setName("ResultLabel");
        
        for (int row = 0; row < width; row++)
        {
            
            for (int col = 0; col < width; col++)
            {
                
                squares[row][col] = new JButton(); 
                squares[row][col].addActionListener(this);
                squares[row][col].setName("Square" + row + col);
                squares[row][col].setPreferredSize(new Dimension(64,64));
                squaresPanel.add(squares[row][col]);
                
            }
            
        }

        this.add(squaresPanel);
        this.add(resultLabel);
        
        
        resultLabel.setText("Welcome to Tic-Tac-Toe!");
        updateSquares();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        
        /* Handle button clicks.  Extract the row and col values from the name
           of the button that was clicked, then make the mark in the grid using
           the Model's "makeMark()" method.  Finally, use the "updateSquares()"
           method to refresh the View.  If the game is over, show the result
           (from the Model's "getResult()" method) in the result label. */
        
        String name = ((JButton) event.getSource()).getName(); // Get button name      
        String array1[]= name.split("Square");
        
        
            
            if(array1[1].length() == 2)
            {
                String rowString = array1[1].substring(0,1);
                String colString = array1[1].substring(1);
                int rowInt = Integer.parseInt(String.valueOf(rowString));
                int colInt = Integer.parseInt(String.valueOf(colString));
                model.makeMark(rowInt, colInt);
            }
            else if(array1[1].length() == 3)
            {
                String rowString = array1[1].substring(0,2);
                String colString = array1[1].substring(2);
                int rowInt = Integer.parseInt(String.valueOf(rowString));
                int colInt = Integer.parseInt(String.valueOf(colString));
                
                if(model.isValidSquare(rowInt, colInt) == true)
                {
                    model.makeMark(rowInt, colInt);
                }
                else
                {
                    rowString = array1[1].substring(0,1);
                    colString = array1[1].substring(1,3);
                    rowInt = Integer.parseInt(String.valueOf(rowString));
                    colInt = Integer.parseInt(String.valueOf(colString));
                    model.makeMark(rowInt, colInt);
                }
            }
            else
            {
                String rowString = array1[1].substring(0,2);
                String colString = array1[1].substring(2,4);
                int rowInt = Integer.parseInt(String.valueOf(rowString));
                int colInt = Integer.parseInt(String.valueOf(colString));
                model.makeMark(rowInt, colInt);
            }
        
            
        
        updateSquares();
        
        
    }
        
    public void updateSquares() {

        /* Loop through all View buttons and (re)set the text of each button
           to reflect the grid contents (use the Model's "getMark()" method). */
            for(int x = 0; x < model.getWidth(); x++)
            {
                for (int y = 0; y < model.getWidth(); y++)
                {
                    squares[x][y].setText((model.getMark(x,y)).toString());
                }
            }

            if(model.isGameover())
        {
           
            showResult(model.getResult().toString());
            
            
        }

        

    }
        
    public void showResult(String message) 
    {
        
        resultLabel.setText(message);
        
        
    }

}