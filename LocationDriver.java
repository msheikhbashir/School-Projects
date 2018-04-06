package Battleship1;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class LocationDriver {

    public static void main(String[] args){

        char[][] board = new char[5][5];
        char openWater = 'O';

        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++)
                board[i][j]= openWater;
        }

        dispalyBoard(board);


        ArrayList<Location> ships = new ArrayList<Location>();
        for(int i = 0; i < 4; i++)
        {
            int row = rand.nextInt(5);
            int col = rand.nextInt(5);
//            System.out.print(row);
//            System.out.println(col);
            Location shipLoc = new Location (row,col);
            ships.add(shipLoc);
        }


        int remaining = 4;
        while (remaining > 0 && ships.size()>0){

            System.out.println("Turn " +remaining+ " of 4" );
            System.out.println(ships.size()+ " ships remaining to sunk." );
            System.out.println("Guess a row ");
            int row = input.nextInt();
            System.out.println("Guess a column ");
            int column = input.nextInt();
            if ( row<0 || column<0 || row>4 || column>4){
                System.out.println("That's not even in the ocean");

            }else if(board[row][column] != 'O'){
                System.out.println("Choose another location");
            }else if (proc(board,ships,row, column)){
                System.out.println("You sunk my battleship!");
            }else{
                board[row][column] = 'X';
                System.out.println("You've missed my battleship.");
            }
            dispalyBoard(board);
            remaining--;
        }
        while (ships.size()>0){
            proc(board,ships,ships.get(0).getRow(),ships.get(0).getColumn());
        }
        System.out.println("Game Over");
        dispalyBoard(board);
    }

    public static boolean proc(char[][] board,ArrayList<Location>ships,int row, int col){
        int match = -1;
        for(int i=0; i<ships.size(); i++){
            Location location = ships.get(i);

            if (location.getRow()== row && location.getColumn() == col){
                match=i ;
                break;
            }
        }
        if (match!= -1){
            ships.remove(match);
            board[row][col] ='*';
            return true;
        }
        return false;
    }

    public static void dispalyBoard(char[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
