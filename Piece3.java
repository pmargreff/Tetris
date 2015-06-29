import java.awt.Point;

/**
 *
 * @author gilberto
 */
public class Piece3 extends Piece {

        Piece3(int width, int height) {
        super(width, height);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Point tmp = new Point((width / 2) + i  * cellSize_, height + j * cellSize_);
                body_.add(tmp);
            }
        }
    }
}
