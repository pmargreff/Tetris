
/**
 *
 * @author pmargreff
 */
public class Scene {

    private final int width_, height_;
    private boolean field_[][];
    private int cellSize_;

    Scene(int width, int height) {
        this.width_ = width;
        this.height_ = height;

        this.field_ = new boolean[width][height];
    }

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

    public void lineDestroy(int line) {
        for (int i = line; i < height_; i = +cellSize_) {
            for (int j = 0; j < width_; j = +cellSize_) {

                field_[i][j] = field_[i+cellSize_][j];
            }
        }
    }
    
    //todo
    public void getPiece(Piece piece){
        
    }
}
