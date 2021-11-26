import Chess.ChessBoard.ChessBoard;
import Chess.ChessFigure;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {


    private static ChessBoard chessBoard;
    private static boolean isLog;
    private static boolean isGameFinish;

    static {
        chessBoard = new ChessBoard();
        isLog = !false;
        isGameFinish = false;
    }

    public static void main(String[] args) {

        System.out.println("\u001B[40m");
        showField();
        while (!isGameFinish) {
            int[] coor = prepareCoordinate(inputData());
            if (coor != null) {
                if (chessBoard.canMove(coor))
                    chessBoard.move(coor);
            } else {
                showError();
                continue;
            }
            showField();
        }
    }

    static private void showError() {
        System.out.println("Что-то пошло не так. Повторите ваши действия");
    }

    static private void showField() {
        System.out.println(chessBoard);
    }

    /**
     * Ввод данных о ходе
     *
     * @return строка с координатами
     */
    private static String inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ход в виде \'e2e4\'");
        return sc.nextLine().toLowerCase(Locale.ROOT);
    }

    private static int[] prepareCoordinate(String input) {
        if (isLog) System.out.println(input);
        if (isLog) System.out.println(input);
        char[] data = input.toCharArray();
        if (isLog) System.out.println(Arrays.toString(data));
        int[] coor = {4, 1, 4, 3};
        //int[] coordinate = new int[4];
        if (data.length != 4) return null;
        else {
            int count = 0;
            if (data[0] >= 'a' && data[0] <= 'h') {
                coor[0] = data[0] - 'a';
                count++;
            }
            if (data[2] >= 'a' && data[2] <= 'h') {
                coor[2] = data[2] - 'a';
                count++;
            }
            if (data[1] >= '1' && data[1] <= '8') {
                coor[1] = data[1] - '1';
                count++;
            }
            if (data[3] >= '1' && data[3] <= '8') {
                coor[3] = data[3] - '1';
                count++;
            }
            if (isLog)
                System.out.println(Arrays.toString(coor));
            if (count != 4)
                return null;
        }
        return coor;
    }

}
