import java.applet.AudioClip;
import java.awt.geom.Rectangle2D;

public class Pelota {

    private static final int TAMX = 15;
    private static final int TAMY = 15;
    private double x = 0;
    private static double y = 0;
    private double dx = 1;
    private double dy = 1;

    private Integer score1 = 0, score2 = 0;
    public static boolean finJuego = false;

    Audio audio = new Audio();
    AudioClip rebote_1=audio.getAudio("rebote_pelota1.wav");
    AudioClip rebote_2=audio.getAudio("rebote_pelota2.wav");
    AudioClip falta=audio.getAudio("falta.wav");


    //retorna la pelota (Rectangle2D implementa la interface Shape)
    public Rectangle2D getShape() {
        return new Rectangle2D.Double(x, y, TAMX, TAMY);
    }

    public void moverPelota(Rectangle2D limites, boolean colisionR1, boolean colisionR2) {
        x += dx;
        y += dy;



        if (colisionR1) {
            dx = -dx;
            x = 20;
            rebote_1.play();
        }
        if (colisionR2) {
            dx = -dx;
            x = 755;
            rebote_1.play();
        }

        if (x < limites.getMinX()) {
            score2++; //el puntaje del jugador2 aumenta en uno

            x = limites.getCenterX();
            y = limites.getCenterY();
            dx = -dx;
            falta.play();
        }

        if (x + TAMX >= limites.getMaxX()) {
            score1++; //el puntaje del jugador1 aumenta en uno

            x = limites.getCenterX();
            y = limites.getCenterY();
            dx = -dx;
            audio.getAudio("/falta.wav").play();
        }

        if (y < limites.getMinY()) {

            y = limites.getMinY();

            dy = -dy;
            rebote_2.play();
        }

        if (y + TAMY >= limites.getMaxY()) {

            y = limites.getMaxY() - TAMY;

            dy = -dy;
            rebote_2.play();
        }

    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }
}
