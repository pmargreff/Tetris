
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author gilberto
 */
public class Piece2 extends Piece {

    int flag_;

    Piece2(int width, int height) {
        super(width, height);
        int j = 1;

        flag_ = 0;

        for (int i = 0; i < 4; i++) {

            if (i <= 1) {
                Point tmp = new Point(width / 2, height + i);
                body_.add(tmp);
            } else {

                Point tmp = new Point((width / 2) + j, height + 1);
                body_.add(tmp);

                j++;
            }
        }
    }

    /**
     * Turn the piece in opposite clockwise direction
     * Set one vector for 'x' and one vector for 'y'
     * and change the flag
     */
    
    public void Turn() {
        Point ref = new Point(body_.get(1)); //reference point
        Point tmp = new Point(ref); 
        int x[] = new int[3];
        int y[] = new int[3];
        
        switch (flag_) {

            case 0:
                x[0] = -1;
                y[0] = -1;
                
                x[1] = -1;
                y[1] = 1;
                
                x[2] = -2;
                y[2] = 2;
                
                flag_ = 1;
                break;
            case 1:
                x[0] = 1;
                y[0] = -1;
                
                x[1] = -1;
                y[1] = -1;
                
                x[2] = -2;
                y[2] = -2;
                
                flag_ = 2;
                break;

            case 2:
                x[0] = 1;
                y[0] = 1;
                
                x[1] = 1;
                y[1] = -1;
                
                x[2] = 2;
                y[2] = -2;
                
                flag_ = 3;
                break;

            case 3:
                x[0] = -1;
                y[0] = 1;
                
                x[1] = 1;
                y[1] = 1;
                
                x[2] = 2;
                y[2] = 2;
                
                flag_ = 0;
                break;

        }

        //reference 'ref' to calculate and  set the new cell of piece
        tmp.setLocation((ref.getX() + x[0]), (ref.getY() - y[0]));
        body_.set(0, tmp);

        tmp.setLocation((ref.getX() + x[1]), (ref.getY() - y[1]));
        body_.set(2, tmp);

        tmp.setLocation((ref.getX() + x[2]), (ref.getY() - y[2]));
        body_.set(3, tmp);

    }
}
