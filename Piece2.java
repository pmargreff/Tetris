import java.awt.Point;
import java.util.ArrayList;


/**
 *
 * @author gilberto
 */
public class Piece2 extends Piece {

    Piece2(int width, int height) {
        super(width, height);
        int j = 1;

        for (int i = 0; i < 4; i++) {

            if (i <= 1) {
                Point tmp = new Point(width / 2, height + i);
                body_.add(tmp);
            } else {

                Point tmp = new Point((width / 2) + j, height + 1);
                body_.add(tmp);

                j++;
            }

        }

    }

}
