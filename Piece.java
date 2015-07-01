
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author pmargreff
 */
public class Piece {

    protected static int cellSize_;
    protected static int width_, height_;

    //TODO: fazer com que a cor se torne um atributo da peça
    Piece(int width, int height) {
        cellSize_ = 10;
        width_ = width;
        height_ = height;
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
        if (direction == 37 && checksBorders(direction)) {
            for (int i = 0; i < body_.size(); i++) {
                Point tmp = new Point(body_.get(i));
                tmp.setLocation(tmp.getX() - cellSize_, tmp.getY());
                body_.set(i, tmp);
            }
        }

        //move right
        if (direction == 39 && checksBorders(direction)) {
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
     * @param direction
     * @return a boolean - true if is inside false if isn't
     */
    public static boolean checksBorders(int direction) {
//        boolean isInside = true;
        if (direction == 39) {
            for (int i = 0; i < body_.size(); i++) {
                Point tmp = new Point(body_.get(i));
                if (tmp.getX() + cellSize_ >= width_) {
                    return false;
                }

            }
        } else if(direction == 37){
             for (int i = 0; i < body_.size(); i++) {
                Point tmp = new Point(body_.get(i));
                if (tmp.getX() - cellSize_ <= 0) {
                    return false;
                }    
             }
        }

        return true;
    }

    public void destroyPiece() {
        body_.removeAll(body_);
    }

    public int getSize() {
        return body_.size();
    }

    public Point getPoint(int index) {
        return body_.get(index);
    }

    //tentar com que classe seja obrigatória
//    public static void turn() {
//        System.out.println("Mãe");
//    }
}
