
import java.awt.Point;

/**
 *
 * @author gilberto
 */
public class Piece6 extends Piece {

    static int flag_ = 0;

    Piece6(int width, int height) {
        super(width, height);

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 1; j++) {

                if ((i != -1 && j != 0) || (i != 1 && j != -1)) {
                    Point tmp = new Point((width / 2) + i * cellSize_, height + j * cellSize_);
                    body_.add(tmp);
                }
            }
        }
    }

     /**
     * Turn the piece in opposite clockwise direction Set one vector for 'x' and
     * one vector for 'y' and change the flag
     */
    public static void turn() {

    }
}
