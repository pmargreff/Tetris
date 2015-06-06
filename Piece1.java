import java.awt.Point;
import java.util.ArrayList;


/**
 *
 * @author gilberto
 */
public class Piece1 extends Piece {

    Piece1(int width, int height) {
        super(width, height);
        for (int j = 0; j < 4; j++) {
            Point tmp = new Point(width / 2, height + j);
            body_.add(tmp);
        }

    }

}
