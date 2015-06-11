
import java.awt.Point;
import java.util.ArrayList;

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
public class Piece4 extends Piece{
    
    private ArrayList<Point> body_ = new ArrayList<Point>();
    
    Piece4(int width, int height){
        
        Point tmp = new Point((width/2), height);
        body_.add(tmp);
        
        for (int i = -1; i < 2; i++) {
           tmp = new Point((width/2)+i, height+1);
           body_.add(tmp);
        }
    }
}
