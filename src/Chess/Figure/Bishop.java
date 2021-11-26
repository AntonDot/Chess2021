package Chess.Figure;

import Chess.ChessFigure;

public class Bishop extends ChessFigure {


    public Bishop(boolean colorIsWhite) {
        super(colorIsWhite, colorIsWhite ? '\u2657' : '\u265d');

    }

    @Override
    public boolean canMove(int[] xy, ChessFigure[][] chessBoard) {
        if(Math.abs(xy[0]-xy[2])==Math.abs(xy[1]-xy[3])){
            int i2 = (xy[0]<xy[2] ? xy[0] : xy[2])+1;
            for(int i = (xy[1]<xy[3] ? xy[1] : xy[3])+1; i <=(xy[1]<xy[3] ? xy[3] : xy[1])-1; i++){

                if(chessBoard[i][i2] == null ){i2++;continue;}
                else{return false;}
            }
        }
        return true;
    }
}
