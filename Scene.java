
import java.util.Collections;
import java.awt.Point;

/**
 *
 * @author pmargreff
 * This class is used to define the background 
 * in game, or in others words, everthing that don't be
 * a piece is a background scene
 */
public class Scene {

    private final int width_, height_;
    private boolean field_[][];
    private int cellSize_;

    /**
     * 
     * @param width
     * @param height 
     * use size of screen to calculate 
     * the array size
     */
    
    Scene(int width, int height) {
        this.width_ = width;
        this.height_ = height;

        this.field_ = new boolean[width][height];
    }

    /**
     * 
     * @param field 
     * Check if the lines is full
     * and if it in true call lineDesntroy method
     */
    public void linesCheck(boolean field[][]) {

        for (int i = 0; i < height_; i = +cellSize_) {

            Flag destroy = new Flag(true);

            for (int j = 0; j < height_; j = +cellSize_) {
                if (!field[i][j]) {

                    destroy.setValue(false);

                }

                if (destroy.getValue()) {
                    lineDestroy(i);
                }
            }
        }
    }

    /**
     * 
     * @param line 
     * move all lines to override the full line
     * it's do moving line n to n-1 from line that
     * should be override
     */
    public void lineDestroy(int line) {
        for (int i = line; i < height_; i = +cellSize_) {
            for (int j = 0; j < width_; j = +cellSize_) {

                field_[i][j] = field_[i + cellSize_][j];
            }
        }
    }
    
    /**
     * 
     * @param part
     * attach the piece with the cene
     */
    public void getPiece(Piece part) {
        int column, line;
        for (int i = 0; i < part.size(); i++) {
            Point tmp = new Point(part.get(i));
            line = (int) tmp.getX();
            column = (int) tmp.getY();
            field_[line][column] = true;
        }
    }
}
