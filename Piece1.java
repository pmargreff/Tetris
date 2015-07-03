
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author gilberto
 */
public class Piece1 extends Piece {

    static int flag_ = 0;

    Piece1(int width, int height) {
        super(width, height);
        for (int j = 0; j < 4; j++) {
            Point tmp = new Point(width / 2, height + j * cellSize_);
            body_.add(tmp);
        }
    }

    /**
     * Turn the piece in opposite clockwise direction Set one vector for 'x' and
     * one vector for 'y' and change the flag
     */
    public static void turn() {
//        Point ref = new Point(body_.get(1)); //reference point
        Point tmp = new Point();
//        ArrayList<Point> body = new ArrayList<>();
        double x = body_.get(0).getX();
        double y = body_.get(0).getY();
        
        body_.removeAll(body_);
        
        for (int i = 0; i < 4; i++) {
            tmp.setLocation(12 * i + x, y);
            body_.add(i, tmp);
            System.out.println("Teste");
        }
        
        int test = 0;
    }
}
