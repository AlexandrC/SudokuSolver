package game.boardExample;

public class BoardPostion {
    public static int row;
    public static int column;
    public BoardPostion(int row, int column){
        BoardPostion.row =row;
        BoardPostion.column = column;
    }


    public int getRow() {
        return row;
    }


    public int getColumn() {
        return column;
    }
}
