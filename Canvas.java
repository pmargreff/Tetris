
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import java.awt.image.BufferedImage;

public class Canvas extends TimerTask {

    //The window in which everything is shown.
    private BufferedImageDrawer buffid;

    //The background image
    private BufferedImage bg;

    public static Piece unit;
//    public static Snake snake = new Snake(600, 600);
    public Scene bgScene;

    /**
     * Constructor
     *
     * @param bid The buffered image to be drawn
     * @param backGround The background (buffered) image
     * @param height Width of the window
     * @param delay Defines after how many milliseconds the image/frame is is
     * updated (needed for the synchronisation of the clock).
     */
    Canvas(BufferedImageDrawer bid, BufferedImage backGround,
            int height, int width, int delay) {
        buffid = bid;
        buffid.addKeyListener(bid);
        //The lines should have a thickness of 3.0 instead of 1.0.
        buffid.g2dbi.setStroke(new BasicStroke(7.0f));

        //Use of antialiasing to have nicer lines.
        buffid.g2dbi.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        /*yUp defines a translation allowing the specification of objects in "real"
         coordinates where the y-axis points upwards and the origin of the coordinate
         system is located in the lower left corner of the window.
         */
        AffineTransform yUp = new AffineTransform();
        yUp.setToScale(1, -1);
        AffineTransform translate = new AffineTransform();
        translate.setToTranslation(0, height);
        yUp.preConcatenate(translate);

        //Apply the transformation to the Graphics2D object to draw everything
        //in "real" coordinates.
        buffid.g2dbi.transform(yUp);

//        buffid.g2dbi.setPaint(Color.black);
        buffid.g2dbi.setPaint(Color.white);
        bg = backGround;
        bgScene = new Scene(width, height); //cria a nova imagem que fica no fundo

        unit = bgScene.creatPiece();

    }

    //This method is called in regular intervals. This method computes
    //the updated image/frame and calls the repaint method to draw the
    //updated image on the window.
    @Override
    public void run() {

        //Draw the background.
        buffid.g2dbi.drawImage(bg, 0, 0, null);
        boolean pFlag = true;

        unit.down();

        if (bgScene.checkGet(unit)) {
            bgScene.getPiece(unit);
            unit.destroyPiece();
            unit = bgScene.creatPiece();
            
        }
        //desenha o scenário
        for (int i = 0; i < bgScene.getHeight(); i++){
            for(int j = 0; j < bgScene.getWidth(); j++){
                if (bgScene.getCell(i, j) == true){
                    Rectangle2D.Double quad = new Rectangle2D.Double(i, j, 0, 0);
                    buffid.g2dbi.draw(quad);
            
                }
            }
        }
        for (int i = 0; i < unit.getSize(); i++) {
            Rectangle2D.Double quad = new Rectangle2D.Double(unit.getPoint(i).getX(), unit.getPoint(i).getY(), 0, 0);
            buffid.g2dbi.draw(quad);
//            System.out.println(unit.getPoint(i).getX() + " " + unit.getPoint(i).getY());

        }

        

        buffid.repaint();

    }

    public static void main(String[] argv) {

        //Width of the window
        int width = 600;
        //Height of the window
        int height = 600;

        //Specifies (in milliseconds) when the frame should be updated.
        int delay = 200;

        //The BufferedImage to be drawn in the window.
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //The background.
        BufferedImage backGround = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2dBackGround = backGround.createGraphics();

        //The lines should have a thickness of 3.0 instead of 1.0.
        g2dBackGround.setStroke(new BasicStroke(7.0f));

        //The background is painted white first.
        g2dBackGround.setPaint(Color.black);
        g2dBackGround.fill(new Rectangle(0, 0, width, height));

        g2dBackGround.setPaint(Color.white);

        //The window in which everything is drawn.
        BufferedImageDrawer bid = new BufferedImageDrawer(bi, width, height);

        //The TimerTask in which the repeated computations drawing take place.
        Canvas dbce = new Canvas(bid,
                backGround,
                height, width,
                delay);

        Timer t = new Timer();
        t.scheduleAtFixedRate(dbce, 0, delay);

    }

}
