package Chess.Figure;

import Chess.ChessBoard.ChessBoard;
import Chess.ChessFigure;

public class Pawn extends ChessFigure {
    boolean isFirstStep;

    public Pawn(boolean colorIsWhite) {
        super(colorIsWhite, colorIsWhite ? '\u2659' : '\u265f');
        this.isFirstStep = true;
    }

    @Override
    public boolean canMove(int[] xy, ChessFigure[][] chessBoard) {
        if(xy[0] == xy[2] && xy[1] - xy[3] == (!colorIsWhite ? 1 : -1) && chessBoard[xy[3]][xy[2]] == null) {
            if(xy[3]==0||xy[3]==8){
                ChessBoard.PawnToQueen(chessBoard, xy);
            }
            this.isFirstStep = false;
            return true;}
        else if(Math.abs(xy[0] - xy[2]) == 1 && xy[1] - xy[3] == (!colorIsWhite ? 1 : -1) && chessBoard[xy[3]][xy[2]] != null) {
            if(xy[3]==0||xy[3]==8){
                ChessBoard.PawnToQueen(chessBoard, xy);
            }
            this.isFirstStep = false;
            return true;}
        else if(this.isFirstStep == true && xy[0] == xy[2] && xy[1] - xy[3] == (!colorIsWhite ? 2 : -2) && chessBoard[xy[3]][xy[2]] == null && chessBoard[(xy[1]+xy[3])/2][(xy[0]+xy[2])/2] == null) {this.isFirstStep = false; return true;}
        return false;
    }
}
