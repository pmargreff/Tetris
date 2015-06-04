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

public class Piece5 extends Piece{
    
    private ArrayList<Point> body_ = new ArrayList<Point>();
    
    Piece5(int width, int height){
        
        for (int i = 1; i > -3; i--) {
            if(i>=0){
                Point tmp = new Point((width/2), height+i);
                body_.add(tmp);
            }
            else{
                Point tmp = new Point((width/2)+i, height+1);
                body_.add(tmp);
            }
        }
    }
}
