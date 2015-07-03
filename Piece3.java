
import java.awt.Point;

/**
 *
 * @author gilberto
 */
public class Piece3 extends Piece {

    static int flag_ = 0;

    Piece3(int width, int height) {
        super(width, height);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Point tmp = new Point((width / 2) + i * cellSize_, height + j * cellSize_);
                body_.add(tmp);
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
