package Battleship1;

public class Location {

    private int row;
    private int column;


    //constructor
    public Location(int row, int column){
        this.row = row;
        this.column = column;
    }

    //setters
    public void setRow(int row){
        this.row = row;
    }

    public void setColumn(int Column){
        this.column = column;
    }

    //getters
    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
    }

}
