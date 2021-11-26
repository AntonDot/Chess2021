package Chess.ChessBoard;

import Chess.ChessFigure;
import Chess.Figure.*;

public class ChessBoard {
    private ChessFigure[][] chessBoard;
    private boolean StepIsWhite = true;
    private int[] xy;
    public ChessBoard() {
        this.chessBoard = new ChessFigure[8][8];
        for (int i = 0; i < chessBoard.length; i++) {
            chessBoard[1][i] = new Pawn(true);
            chessBoard[6][i] = new Pawn(false);
        }
        chessBoard[0][0] = new Rook(true);
        chessBoard[0][7] = new Rook(true);
        chessBoard[0][1] = new Knight(true);
        chessBoard[0][6] = new Knight(true);
        chessBoard[0][2] = new Bishop(true);
        chessBoard[0][5] = new Bishop(true);
        chessBoard[7][0] = new Rook(false);
        chessBoard[7][7] = new Rook(false);
        chessBoard[7][1] = new Knight(false);
        chessBoard[7][6] = new Knight(false);
        chessBoard[7][2] = new Bishop(false);
        chessBoard[7][5] = new Bishop(false);
        chessBoard[0][3] = new King(true);
        chessBoard[7][3] = new King(false);
        chessBoard[0][4] = new Queen(true);
        chessBoard[7][4] = new Queen(false);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chessBoard.length; i++) {
            result.append(8 - i).append("|");
            for (ChessFigure cf : chessBoard[7 - i])
                result.append(cf != null ? cf : "\u001B[30m♟\u001B[39m");
            result.append("\n");
        }
        return result.toString();
    }

    public boolean canMove(int[] xy) {
        this.xy = xy;
        if ((chessBoard[xy[1]][xy[0]] == null ||
                chessBoard[xy[3]][xy[2]] == null ? false : chessBoard[xy[3]][xy[2]].isColorIsWhite() == chessBoard[xy[1]][xy[0]].isColorIsWhite())
                ||
                chessBoard[xy[1]][xy[0]].isColorIsWhite() == StepIsWhite)
            return false;
        else {
            StepIsWhite = (StepIsWhite==true ? false : true);
            return chessBoard[xy[1]][xy[0]].canMove(xy, chessBoard);
        }

    }

    public void move(int[] xy) {
        chessBoard[xy[3]][xy[2]] = chessBoard[xy[1]][xy[0]];
        chessBoard[xy[1]][xy[0]] = null;
    }

    static public void PawnToQueen(ChessFigure[][] chessBoard, int[]xy){
        chessBoard[xy[1]][xy[0]] = new Queen(chessBoard[xy[1]][xy[0]].isColorIsWhite());
    }

}
