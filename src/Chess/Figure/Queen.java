package Chess.Figure;
import Chess.ChessFigure;
public class Queen extends ChessFigure {


    public Queen(boolean colorIsWhite) {
        super(colorIsWhite, colorIsWhite ? '\u2655' : '\u265b');

    }

    @Override
    public boolean canMove(int[]xy, ChessFigure[][] chessBoard) {
        if(Math.abs(xy[0]-xy[2])==Math.abs(xy[1]-xy[3])){
            int i2 = (xy[0]<xy[2] ? xy[0] : xy[2])+1;
            for(int i = (xy[1]<xy[3] ? xy[1] : xy[3])+1; i <=(xy[1]<xy[3] ? xy[3] : xy[1])-1; i++){

                if(chessBoard[i][i2] == null ){i2++;continue;}
                else{return false;}
            }
        }
        else if((Math.abs(xy[0] - xy[2]) != 0 && Math.abs(xy[1] - xy[3]) != 0)){return false;}
        else if(Math.abs(xy[0] - xy[2]) == 0){
            for(int i = (xy[1]<xy[3] ? xy[1] : xy[3])+1; i <(xy[1]<xy[3] ? xy[3] : xy[1])-1; i++){
                if(chessBoard[i][xy[0]] == null ){continue;}
                else{return false;}
            }
            return true;
        }
        else{
            for(int i = xy[0]+1<xy[2]-1 ? xy[0]+1 : xy[2]-1; i <(xy[0]+1<xy[2]-1 ? xy[2]-1 : xy[0]+1); i++){
                if(chessBoard[xy[1]][i] == null ){continue;}
                else{return false;}
            }
            return true;
        }
        return true;
    }
}
