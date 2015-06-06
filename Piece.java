import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 /**
 *
 * @author pmargreff
 */
public abstract class Piece {
    private final int cellSize_;
    private final int width_, height_;
    
    Piece(int width,int height){
        this.cellSize_ = 5;
        this.width_ = width;
        this.height_ = height;
    }
    
    ArrayList<Point> body_ = new ArrayList<>();
    
    /**
     * 37 = left
     * 39 = right
     * 40 = down
     * @param direction
     * move piece to selected direction
     */
    //TODO: tentar fazer o método mais curto
    public void move(int direction){
        
        //move left
        if (direction == 37){
            for(int i = 0; i < body_.size(); i++){
                
                Point tmp = new Point(body_.get(i));
                tmp.setLocation(tmp.getX() - cellSize_, tmp.getY());
                body_.add(i, tmp);
                
            }
        }
        
        //move right
        if (direction == 39){
            for(int i = 0; i < body_.size(); i++){
                
                Point tmp = new Point(body_.get(i));
                tmp.setLocation(tmp.getX() + cellSize_, tmp.getY());
                body_.add(i, tmp);
                
            }
        }
        
        //move down
        if (direction == 40){
            for(int i = 0; i < body_.size(); i++){
                
                Point tmp = new Point(body_.get(i));
                tmp.setLocation(tmp.getX(), tmp.getY() - cellSize_);
                body_.add(i, tmp);
                
            }
        }        
    }
    
    /**
     * move down twice
     */
    public void down(){
        move (40);
        move (40);
    }
    
    /**
     * checks if piece is inside of field
     * @return a boolean - true if is inside false if isn't
     */
    public boolean checksBorders(){
        boolean isInside = true;
        
        for (int i = 0; i < body_.size(); i++){
            Point tmp = new Point(body_.get(i));
            if ((tmp.getX() <= 0) || (tmp.getY() <= 0)){
                isInside = false;
            } else if ((tmp.getY() >=  width_ || tmp.getX() >= height_)){
                isInside = false;
            }
        }
        
        return isInside;
    }
    
    
}
