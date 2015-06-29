import java.awt.Point;

/**
 *
 * @author gilberto
 */
public class Piece7 extends Piece {

    
    int flag_;
    
 Piece7(int width, int height) {
        super(width, height);
        
        flag_ = 0;

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 1; j++) {

                if ((i != -1 && j != -1) || (i != 1 && j != 0)) {
                    Point tmp = new Point((width / 2) + i  * cellSize_, height + j  * cellSize_);
                    body_.add(tmp);
                }
            }
        }
    }
 
 /**
     * Turn the piece in opposite clockwise direction
     * Set one vector for 'x' and one vector for 'y'
     * and change the flag
     */
    
    public void Turn(){
        Point ref = new Point(body_.get(2)); //reference point
        Point tmp = new Point(ref); 
        int x[] = new int[3];
        int y[] = new int[3];
        
        switch (flag_){
            
            case 0:
                
                x[0] = -1;
                y[0] = 0;
                
                x[1] = 0;
                y[1] = -1;
                
                x[2] = 1;
                y[2] = -1;
                
                flag_ = 1;
                
            break;
                
            case 1:
            
               x[0] = 0;
               y[0] = -1;
               
               x[1] = 1;
               y[1] = 0;
               
               x[2] = 1;
               y[2] = 1;
            
               flag_ = 2; 
                
            break;
                
            case 2:
                
                x[0] = 1;
                y[0] = 0;
                
                x[1] = 0;
                y[1] = 1;
                
                x[2] = -1;
                y[2] = 1;
               
                flag_ = 3;
                
            break;
                
            case 3:
               
                x[0] = 0;
                y[0] = 1;
                
                x[1] = -1;
                y[1] = 0;
                
                x[2] = -1;
                y[2] = -1;
            
                flag_ = 0;
                        
            break;
        }
        
        //reference 'ref' to calculate and  set the new cell of piece
        tmp.setLocation((ref.getX() + x[0]  * cellSize_), (ref.getY() + y[0]  * cellSize_));
        body_.set(0, tmp);

        tmp.setLocation((ref.getX() + x[1] * cellSize_), (ref.getY() + y[1]  * cellSize_));
        body_.set(1, tmp);

        tmp.setLocation((ref.getX() + x[2]  * cellSize_), (ref.getY() + y[2]  * cellSize_));
        body_.set(3, tmp);
    
    }
}
