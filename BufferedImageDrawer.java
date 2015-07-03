
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.*;

public class BufferedImageDrawer extends Frame implements KeyListener {

    //These image is drawn when the paint method is called.

    public BufferedImage bi;

    //This Graphics2D object can be used to draw on bi.
    public Graphics2D g2dbi;

    //The Graphics2D object used in the paint method.
    private Graphics2D g2d;

    /**
     * Constructor
     *
     * @param buffIm The image that will be at memory
     * @param width The width of windown
     * @param height The height of windown
     */
    public BufferedImageDrawer(BufferedImage buffIm, int width, int height) {
        bi = buffIm;
        g2dbi = bi.createGraphics();

        //Enables the closing of the window.
        addWindowListener(new MyFinishWindow());

        this.setTitle("Tetris Game");
        this.setSize(width, height);
        this.setVisible(true);
        this.setFocusable(true);

    }

    @Override
    public void paint(Graphics g) {
        update(g);
    }

    @Override
    public void update(Graphics g) {
        g2d = (Graphics2D) g;
        g2d.drawImage(bi, 0, 0, null);
    }

    @Override
    public void keyTyped(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() != 40) {
            Piece.move(e.getKeyCode());
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() != 40) {
            Piece.move(e.getKeyCode());
        }
    }

}
