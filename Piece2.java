/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 *
 * @author gilberto
 */
public class Piece2 extends Piece {
    
    private ArrayList<Point> body_ = new ArrayList<Point>();
    
    Piece2(int width, int height){
         int j=1;
        
        for (int i = 0; i < 4; i++) {
            
            if(i<=1){
                Point tmp = new Point(width/2, height+i);
                body_.add(tmp);
            }
            
            else {
                
                Point tmp = new Point((width/2)+j, height+1);
                body_.add(tmp);
                
                j++;
            }
            
        }
        
    }
    
}
