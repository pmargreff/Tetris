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
public class Piece1 extends Piece {
    
    private ArrayList<Point> body_ = new ArrayList<Point>();
    
    Piece1(int width, int height){
       
       for (int j = 0; j < 4; j++) {
            Point tmp = new Point(width/2, height+j);
            body_.add(tmp);
        }
        
        
    }
    
}
