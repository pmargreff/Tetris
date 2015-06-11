
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author gilberto
 */
public class Piece6 extends Piece {

    private ArrayList<Point> body_ = new ArrayList<Point>();

    Piece6(int width, int height) {
        super(width, height);

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 1; j++) {

                if ((i != -1 && j != 0) || (i != 1 && j != -1)) {
                    Point tmp = new Point((width / 2) + i, height + j);
                    body_.add(tmp);
                }
            }
        }
    }
}
