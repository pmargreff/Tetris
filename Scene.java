import java.util.Random;
import java.awt.Point;
import java.awt.geom.Point2D;

/**
 * This class is used to define the background in game, or in
 * everthing that don't be a piece is a background scene
 */
public class Scene {

    private final int width_, height_;
    private boolean field_[][];
    private final int cellSize_;
    private int score_ = 0;
    private int countKill[]; 
    /**
     *
     * @param width Use the windows width
     * @param height Use the windows height
     */
    Scene(int width, int height, int cellSize) {
        this.width_ = width;
        this.height_ = height;
        this.cellSize_ = cellSize;

        this.countKill = new int[width];
        this.field_ = new boolean[width][height];
    }
 
    /**
     * Try destroy line
     */
    public void destroyCheck() {
        
        for(int i = 0; i < width_; i++){
            if(this.countKill[i] >= this.width_ / this.cellSize_){
                lineDestroy(i);
            }
        }
    }

    
    /**
     * Destroy the line that will be destroied
     * @param line The line that will be destroied 
     */
    public void lineDestroy(int line) {
        for (int i = 0; i < width_; i++) {
//            field_[line][i] = false;
        }
        
        scoreCounter();
    }

    /**
     * create the new peace with random format
     * @return Return the new Peace
     */
    public Piece creatPiece() {
        Piece newPiece;
        int number;
        Random generator = new Random();
        number = generator.nextInt(7);
        switch (number) {
            case 0:
                newPiece = new Piece1(width_, height_);
                break;

            case 1:
                newPiece = new Piece2(width_, height_);
                break;

            case 2:
                newPiece = new Piece3(width_, height_);
                break;

            case 3:
                newPiece = new Piece4(width_, height_);
                break;

            case 4:
                newPiece = new Piece5(width_, height_);
                break;

            case 5:
                newPiece = new Piece6(width_, height_);
                break;

            case 6:
                newPiece = new Piece7(width_, height_);
                break;

            default:
                newPiece = new Piece3(width_, height_);
                break;
        }
        return newPiece;
    }
    
    /**
     * Get the piece and append it to background scene
     * @param part Piece that will be append
     */
    public void getPiece(Piece part) {
        int x, y;
        for(int i = 0; i < part.getSize(); i++){
            Point tmp = new Point(part.getPoint(i));
            
            x = (int) tmp.getX();
            y = (int) tmp.getY();
            
            this.countKill[y]++;
            field_[x][y + 10] = true;
        }
        
        
        
    }
    
    /**
     * Test if the Piece need be append to the background scene
     * @param testPiece Piece that will be test
     * @return Return true if will be append and false if isn't
     */
    public boolean checkGet(Piece testPiece) {
        boolean appendPiece = false;
        
        for (int i = 0; i < testPiece.getSize(); i++) {
            
            Point2D tmp = testPiece.getPoint(i);
            int x = (int) tmp.getX();
            int y = (int) tmp.getY();

            if (y < height_) {
           
                if ((y <= 0) || (field_[x][y] == true)) { 
                    return true;
                }
            }
            
        }

        return appendPiece;
    }
    
    /**
     * Get the window width
     * @return The window width
     */
    public int getWidth(){
        int width = this.width_;
        
        return width;
    }
    
    /**
     * Get he window height
     * @return The window height
     */
    public int getHeight(){
        int height = this.height_;
        
        return height;
    }
    
    /**
     * Get the cell value in field
     * @param x The field line
     * @param y The field column
     * @return Return the field value
     */
    public boolean getCell(int x, int y){
        return field_[x][y];
    }
    
    /**
     * Get the cell value in the place that piece will be
     * @param x Get the current line
     * @param y Get the current column
     * @return Return the field value
     */
    public boolean getCellAhead(int x, int y){
        if(y < getHeight() && y > cellSize_ + 1){
            return field_[x][y - 10];
        }
        
        return field_[x][y];
    }
    
    /**
     * 
     * @param void
     * increase the score point for each call of lineDestroy method
     */
    private void scoreCounter(){
        score_++;
    }
}
