public class ManejoGraficos extends Thread {

    private final Tablero tablero;

    public ManejoGraficos(Tablero tablero) {
        this.tablero = tablero;
    }

    @Override
    public void run() {
        while (!Pelota.finJuego) {
            tablero.repaint();
            try {
                //Paint Velocity
                Thread.sleep(6);
            } catch (Exception ex) {
                System.out.println("error  " + ex.getMessage());
            }
        }
    }
}
