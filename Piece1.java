import java.awt.Point;

/**
 *
 * @author gilberto
 */
public class Piece1 extends Piece {

    int flag_;
    
    Piece1(int width, int height) {
        super(width, height);
        for (int j = 1; j < 4; j++) {
            Point tmp = new Point(width / 2, height + j * cellSize_);
            body_.add(tmp);
        }
    }
    
    /**
     * Turn the piece in opposite clockwise direction
     * Set one vector for 'x' and one vector for 'y'
     * and change the flag
     */
    
    public void Turn(){
        Point ref = new Point(body_.get(1)); //reference point
        Point tmp = new Point(ref); 
        int h;
        int x[] = new int[3];
        int y[] = new int[3];
        
        switch (flag_){
            
            case 0:
                
                for (int i = 0; i < 3; i++) {
                    x[i] = 0;
                    if (i==0) y[i] = -1;
                    else y[i] = i;
                }
                
                flag_ = 1;
                
            break;
                
            case 1:
            
                for (int i = 0; i < 3; i++) {
                    y[i] = 0;
                    if (i<2) x[i] = i-2;
                    else x[i] = i-1;
                }
            
               flag_ = 2; 
                
            break;
                
            case 2:
                h=1;
                
                for (int i = 0; i < 3; i++) {
                    x[i] = 0;
                    if (i>0) y[i] = h - 1;
                    else y[i] = h;
                        
                    h--;
                }
                
                flag_ = 3;
                
            break;
                
            case 3:
                h = 2;
                
                for (int i = 0; i > 3 ; i++) {
                    y[i] = 0;
                    if(i>1) x[i] = h - 1;
                    else x[i] = h;
                    
                    h--;
                }
            
                flag_ = 0;
                        
            break;
        }
        
        //reference 'ref' to calculate and  set the new cell of piece
        tmp.setLocation((ref.getX() + x[0] * cellSize_), (ref.getY() + y[0] * cellSize_));
        body_.set(0, tmp);

        tmp.setLocation((ref.getX() + x[1] * cellSize_), (ref.getY() + y[1] * cellSize_));
        body_.set(2, tmp);

        tmp.setLocation((ref.getX() + x[2] * cellSize_), (ref.getY() + y[2]  * cellSize_));
        body_.set(3, tmp);
    
    }
    
}
