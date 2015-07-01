
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author pmargreff
 */

public abstract class Piece {

    protected static int cellSize_;
    private final int width_, height_;

    //TODO: fazer com que a cor se torne um atributo da peça
    Piece(int width, int height) {
        cellSize_ = 10;
        this.width_ = width;
        this.height_ = height;
    }

    static ArrayList<Point> body_ = new ArrayList<>();

    /**
     * 37 = left 39 = right 40 = down
     *
     * @param direction move piece to selected direction
     */
    //TODO: tentar fazer o método mais curto
    public static void move(int direction) {
        //move left
        if (direction == 37) {
            for (int i = 0; i < body_.size(); i++) {
                Point tmp = new Point(body_.get(i));
                tmp.setLocation(tmp.getX() - cellSize_, tmp.getY());
                body_.set(i, tmp);
            }
        }

        //move right
        if (direction == 39) {
            for (int i = 0; i < body_.size(); i++) {
                Point tmp = new Point(body_.get(i));
                tmp.setLocation(tmp.getX() + cellSize_, tmp.getY());
                body_.set(i, tmp);
            }
        }

        //move down
        if (direction == 40) {
            for (int i = 0; i < body_.size(); i++) {
                Point tmp = new Point(body_.get(i));
                tmp.setLocation(tmp.getX(), tmp.getY() - cellSize_);
                body_.set(i, tmp);
            }
        }
    }

    /**
     * move down twice
     */
    public void down() {
        move(40);
//        move(40);
    }

    /**
     * checks if piece is inside of field
     *
     * @return a boolean - true if is inside false if isn't
     */
    public boolean checksBorders() {
        boolean isInside = true;

        for (int i = 0; i < body_.size(); i++) {
            Point tmp = new Point(body_.get(i));
            if ((tmp.getX() <= 0) || (tmp.getY() <= 0)) {
                isInside = false;
            } else if ((tmp.getY() >= width_ || tmp.getX() >= height_)) {
                isInside = false;
            }
        }

        return isInside;
    }

    public int getSize() {
        return body_.size();
    }

    public Point getPoint(int index) {
        return body_.get(index);
    }

    public void turn() {

    }
}
