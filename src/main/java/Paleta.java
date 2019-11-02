import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Paleta {

    private int x, y;
    static final int ANCHO = 10, ALTO = 40;

    public Paleta(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Rectangle2D getPaleta() {
        return new Rectangle2D.Double(x, y, ANCHO, ALTO);
    }

    public void moverP1(Rectangle limites) {
        if (EventoTeclado.w && y > limites.getMinY()) {
            y--;
        }
        if (EventoTeclado.s && y < limites.getMaxY()-ALTO) {
            y++;
        }
    }

    public void moverP2(Rectangle limites) {
        if (EventoTeclado.up && y > limites.getMinY()) {
            y--;
        }
        if (EventoTeclado.down && y < limites.getMaxY()-ALTO) {
            y++;
        }
    }
}