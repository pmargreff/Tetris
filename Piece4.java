import java.awt.Point;

/**
 *
 * @author gilberto
 */
public class Piece4 extends Piece {

    static int flag_ = 0;
    
    Piece4(int width, int height) {
        super(width, height);

        Point tmp = new Point((width / 2), height);
        body_.add(tmp);

        for (int i = -1; i < 2; i++) {
            tmp = new Point((width / 2) - i  * cellSize_, height -  cellSize_);
            body_.add(tmp);
        }
    }
    
     /**
     * Turn the piece in opposite clockwise direction Set one vector for 'x' and
     * one vector for 'y' and change the flag
     */
    public static void turn(){
        
    }
}
