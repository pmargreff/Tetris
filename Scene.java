
import java.util.Random;
import java.awt.Point;
import java.awt.geom.Point2D;

/**
 *
 * @author pmargreff This class is used to define the background in game, or in
 * others words, everthing that don't be a piece is a background scene
 */
public class Scene {

    private final int width_, height_;
    private boolean field_[][];
    private int cellSize_;

    /**
     *
     * @param width
     * @param height use size of screen to calculate the array size
     */
    Scene(int width, int height) {
        this.width_ = width;
        this.height_ = height;

        this.field_ = new boolean[width][height];
    }
    /**
     *
     * @param field Check if the lines is full and if it in true call
     * lineDesntroy method
     */
    public void destroyCheck(boolean field[][]) {

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

    /**
     *
     * @param line move all lines to override the full line it's do moving line
     * n to n-1 from line that should be override
     */
    public void lineDestroy(int line) {
        for (int i = line; i < height_; i = +cellSize_) {
            for (int j = 0; j < width_; j = +cellSize_) {

                field_[i][j] = field_[i + cellSize_][j];
            }
        }
    }

    /**
     *
     * @param part attach the piece with the cene
     */
    //TODO: CORRIGIR PARA PEÇA EM FORMATO DE I
    public void getPiece(Piece part) {
        int x, y;
        for(int i = 0; i < part.getSize(); i++){
            Point tmp = new Point(part.getPoint(i));
//            int x, y;
            x = (int) tmp.getX();
            y = (int) tmp.getY();
            field_[x][y] = true;
        }
        
    }

    public Piece creatPiece() {
        Piece newPiece;
        int number;
        Random generator = new Random();
        number = generator.nextInt(7);
//        number = 8;
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

            //procurar qual classe gera o peça em formato de i e fazer com que essa seja a padrão    
            default:
                newPiece = new Piece3(width_, height_);
                break;
        }
        return newPiece;
    }

    //testa se a peça deve fazer parte do cenário
    public boolean checkGet(Piece testPiece) {
        boolean appendPiece = new Boolean(false);
        for (int i = 1; i < testPiece.getSize(); i++) {
            Point2D tmp = testPiece.getPoint(i);
            int x = (int) tmp.getX();
            int y = (int) tmp.getY();

            if (y < height_) {
           
                if (y == 0 + 10|| (getCell(x, y - 10) == true)) { //10 tem que ser substituido por cellSize
                    System.out.println(y);
                    appendPiece = true;
                    return appendPiece;
                }
            }
        }

        return appendPiece;
    }
    
    public int getWidth(){
        int width = this.width_;
        
        return width;
    }
    
    public int getHeight(){
        int height = this.height_;
        
        return height;
    }
    
    public boolean getCell(int x, int y){
        return field_[x][y];
    }
}
