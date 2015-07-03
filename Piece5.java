
import java.awt.Point;

/**
 *
 * @author gilberto
 */
public class Piece5 extends Piece {

    static int flag_ = 0;

    Piece5(int width, int height) {
        super(width, height);

        flag_ = 0;

        for (int i = 1; i > -3; i--) {
            if (i >= 0) {
                Point tmp = new Point((width / 2), height - i * cellSize_);
                body_.add(tmp);
            } else {
                Point tmp = new Point((width / 2) - i * cellSize_, height - cellSize_);
                body_.add(tmp);
            }
        }
    }

    /**
     * Turn the piece in opposite clockwise direction Set one vector for 'x' and
     * one vector for 'y' and change the flag
     */
    public static void turn() {
        Point ref = new Point(body_.get(0)); //reference point
        Point tmp = new Point(ref);
        int x[] = new int[3];
        int y[] = new int[3];

        switch (flag_) {

            case 0:

                x[0] = 0;
                y[0] = 1;

                x[1] = -1;
                y[1] = 0;

                x[2] = -2;
                y[2] = 0;

                flag_ = 1;

                break;

            case 1:

                x[0] = -1;
                y[0] = 0;

                x[1] = 0;
                y[1] = -1;

                x[2] = 0;
                y[2] = -2;

                flag_ = 2;

                break;

            case 2:

                x[0] = 0;
                y[0] = -1;

                x[1] = 1;
                y[1] = 0;

                x[2] = 2;
                y[2] = 0;

                flag_ = 3;

                break;

            case 3:

                x[0] = 1;
                y[0] = 0;

                x[1] = 0;
                y[1] = 1;

                x[2] = 0;
                y[2] = 2;

                flag_ = 0;

                break;
        }

        //reference 'ref' to calculate and  set the new cell of piece
        tmp.setLocation((ref.getX() + x[0] * cellSize_), (ref.getY() + y[0] * cellSize_));
        body_.set(1, tmp);

        tmp.setLocation((ref.getX() + x[1] * cellSize_), (ref.getY() + y[1] * cellSize_));
        body_.set(2, tmp);

        tmp.setLocation((ref.getX() + x[2] * cellSize_), (ref.getY() + y[2] * cellSize_));
        body_.set(3, tmp);

    }
}
