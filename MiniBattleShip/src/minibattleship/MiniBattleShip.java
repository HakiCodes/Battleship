/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minibattleship;
import java.util.Scanner;
/**
 *
 * @author nokolie23
 */
public class MiniBattleShip {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int turn = 0;
        int hitNum = 0;
        Scanner in = new Scanner(System.in);
        
        String[][] board = new String[5][6];
        String[][] hits = new String[5][6];
        //board fill
        for(int r = 0; r < board.length; r++)
        {
            for(int c = 0; c < board[0].length; c++)
            {
                board[r][c] = "-"; 
            }
        }
        
        //hits fill, fills the board with M for misses
        for(int r = 0; r < hits.length; r++)
        {
            for(int c = 0; c < hits[0].length; c++)
            {
                hits[r][c] = "M"; 
            }
        }
        
        //ship placement, controls which M spaces are actually hits
        for(int x = 0; x < board[0].length; x++)
        {
            int r = (int)(Math.random() * board.length);
            int c = (int)(Math.random() * board[0].length);
            if(hits[r][c].equals("H"))
            {
                x--;
            }
            else
            {
                hits[r][c] = "H";
            }
            
        }
        
        //output loop, outputs the board
        System.out.println("   0  1  2  3  4  5");
        for(int r = 0; r < board.length; r++)
        {
            System.out.print(r + " ");
            for(int c = 0; c < board[0].length; c++)
            {
                System.out.print("[" + board[r][c] + "]");
            }
            System.out.println("");
        }
        
        //Testing output of M's and H's
        System.out.println("   0  1  2  3  4  5");
        for(int r = 0; r < hits.length; r++)
        {
            System.out.print(r + " ");
            for(int c = 0; c < hits[0].length; c++)
            {
                System.out.print("[" + hits[r][c] + "]");
            }
            System.out.println("");
        } 
    
        //THE GAME
        // The user gets 20 guesses to get all 6 ships (hits). If they get all 6 they win
        // The display should be updates with the "H" or "M" that the grid contains to show the user the result of their guess.
        // If the user fails to guess all 6 within their 20 guesses, they lose.
        
        while(turn < 21 && hitNum < 6)
        {
            System.out.println("Which row?");
            int guessRow = in.nextInt();
            System.out.println("Which column?");
            int guessColumn = in.nextInt();
            System.out.println(guessRow);
            
            if(hits[guessRow][guessColumn].equals("H"))
            {
                System.out.println("It's a hit!");
                board[guessRow][guessColumn] = hits[guessRow][guessColumn];
                hitNum++;
                System.out.println("   0  1  2  3  4  5");
                for(int r = 0; r < board.length; r++)
                {
                    System.out.print(r + " ");
                    for(int c = 0; c < board[0].length; c++)
                {
                    System.out.print("[" + board[r][c] + "]");
                }
                    System.out.println("");
                }
            }
            else
            {
                System.out.println("It's a miss...");
                board[guessRow][guessColumn] = hits[guessRow][guessColumn];
                for(int r = 0; r < board.length; r++)
                {
                    System.out.print(r + " ");
                    for(int c = 0; c < board[0].length; c++)
                {
                    System.out.print("[" + board[r][c] + "]");
                }
                    System.out.println("");
                }
            }
            turn++;
            System.out.println("");
            if(turn == 5)
            {
                System.out.println("15 guesses left!");
            }
            else if(turn == 10)
            {
                System.out.println("10 guesses left!");
            }
            else if(turn == 15)
            {
                System.out.println("5 guesses left!");
            }
            else if(turn == 20)
            {
                System.out.println("Last guess!!");
            }
            
            if(hitNum == 6 && turn < 21)
            {
                System.out.println("You win!");
            }
            else if(turn == 21)
            {
                System.out.println("No more guesses. You lose.");
            }
        }
        
   }
}
    