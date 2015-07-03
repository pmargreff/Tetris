
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * The base to the other Pieces
 */
public abstract class Piece {

    /**
     * The width of cell that composed Pieces
     */
    protected static int cellSize_;
    
    /**
     * The width of window
     */
    protected static int width_;

    /**
     * The width of cell that composed Pieces
     */
    protected static int  height_;
    
    /**
     * Constructor the piece is dependent of Canvas size
     * @param width Screen width
     * @param height Screen height
     */
    Piece(int width, int height) {
        cellSize_ = 10;
        width_ = width;
        height_ = height;
    }

    static ArrayList<Point> body_ = new ArrayList<>();

    /**
     * Get the int that represent the direction to move
     * @param direction Integer that represents the direction
     */
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
     * Down the piece
     */
    public void down() {
        move(40);

    }

    /**
     * Checks if piece is inside of field
     *
     * @param direction Integer that represents the direction
     * @return Return true if is inside and false if isn't
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

    /**
     * Destroy the piece
     */
    public void destroyPiece() {
        body_.removeAll(body_);
    }

    /**
     * Get the points number that composes one piece
     * @return Return the points number
     */
    public int getSize() {
        return body_.size();
    }

    /**
     * Return the Point relative to index of Piere
     * @param index index of list
     * @return Returns the relative Point
     */
    public Point getPoint(int index) {
        return body_.get(index);
    }
}
