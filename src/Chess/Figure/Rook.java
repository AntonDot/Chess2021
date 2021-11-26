package Chess.Figure;

import Chess.ChessBoard.ChessBoard;
import Chess.ChessFigure;
import sun.applet.Main;

public class Rook extends ChessFigure {


    public Rook(boolean colorIsWhite) {
        super(colorIsWhite, colorIsWhite ? '\u2656' : '\u265c');

    }

    @Override
    public boolean canMove(int[] xy, ChessFigure[][] chessBoard) {

             if(xy[0] != xy[2] && xy[1] != xy[3]){return false;}
             else if(xy[0] - xy[2] == 0){
                for(int i = (xy[1]<xy[3] ? xy[1] : xy[3])+1; i <=(xy[1]<xy[3] ? xy[3] : xy[1])-1; i++){
                    if(chessBoard[i][xy[0]] == null ){continue;}
                    else{return false;}
                }
                return true;
             }
             else{
                 for(int i = xy[0]+1<xy[2]-1 ? xy[0]+1 : xy[2]-1; i <=(xy[0]+1<xy[2]-1 ? xy[2]-1 : xy[0]+1); i++){
                     if(chessBoard[xy[1]][i] == null ){continue;}
                     else{return false;}
                 }
                 return true;
             }

    }
}
