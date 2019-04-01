package tictactoe;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList> board = new ArrayList<>();
        ArrayList<String> row1 = new ArrayList<>();
        ArrayList<String> row2 = new ArrayList<>();
        ArrayList<String> row3 = new ArrayList<>();
        row1.add("O");
        row1.add(" ");
        row1.add("O");

        row2.add("X");
        row2.add("X");
        row2.add("O");

        row3.add(" ");
        row3.add("X");
        row3.add("X");

        board.add(row1);
        board.add(row2);
        board.add(row3);

        for (ArrayList<String> row : board) {
            for(String s: row){
                System.out.print(s + " ");
            }
            System.out.println("");

        }








    }
}
