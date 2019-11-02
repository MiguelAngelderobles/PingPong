import javax.swing.*;

public class Ventana extends JFrame {
    private int ancho = 800, alto = 500;
    private Tablero tablero;

    public Ventana(){
        setTitle("Pong");
        setSize(ancho, alto);
        setLocationRelativeTo(null); //ubicando la ventana en el centro de la pantalla
        setResizable(false);
        tablero = new Tablero();
        add(tablero);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(new EventoTeclado());
        new ManejoGraficos(tablero).start();

    }
}
