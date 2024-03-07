
import java.util.Scanner;
import java.util.Stack;
    

public class Laberinto {
    private static final int FILAS = 5;
    private static final int COLUMNAS = 5;
    private static final char MURO = '#';
    private static final char SALIDA = 'S';
    private static final char CAMINO = '.';
     
    
    private static final int[][] DIRECCIONES = {
            {-1, 0}, // Arriba
            {1, 0},  // Abajo
            {0, -1}, // Izquierda
            {0, 1}   // Derecha
    };
    
    private char[][] laberinto;
    private Stack<Integer> movimientos;
    public Laberinto() {
        laberinto = new char[][] {
            {'#', '#', '#', '#', '#'},
            {'#', '.', '.', '.', '#'},
            {'#', '#', '#', '.', '#'},
            {'#', '#', '#', '.', '#'},
            {'#', '#', '#', 'S', '#'}
        };
        movimientos = new Stack<>();
    }

    public void jugar() {
    Scanner sc = new Scanner(System.in);
    int jugadorX = 1;
    int jugadorY = 1;

    while (true) {
        laberinto[jugadorX][jugadorY] = CAMINO; // Marcar la posición actual del jugador como camino
        
        mostrarLaberinto(); // Mostrar el laberinto con la nueva posición del jugador
        System.out.print("Ingrese su movimiento (W - Arriba, S - Abajo, A - Izquierda, D - Derecha, B - Retroceder): ");
        char movimiento = sc.nextLine().toUpperCase().charAt(0);

        if (movimiento == 'B' && !movimientos.isEmpty()) {
            int direccion = movimientos.pop();
            jugadorX -= DIRECCIONES[direccion][0];
            jugadorY -= DIRECCIONES[direccion][1];
            System.out.println("Te has movido a la posición (" + jugadorX + ", " + jugadorY + ").");
        } else {
            int nuevaX = jugadorX;
            int nuevaY = jugadorY;

            switch (movimiento) {
                case 'W':
                    nuevaX--;
                    break;
                case 'S':
                    nuevaX++;
                    break;
                case 'A':
                    nuevaY--;
                    break;
                case 'D':
                    nuevaY++;
                    break;
                default:
                    System.out.println("Movimiento inválido.");
                    continue;
            }

            if (esMovimientoValido(nuevaX, nuevaY)) {
                if (laberinto[nuevaX][nuevaY] == SALIDA) {
                    System.out.println("¡Felicidades, has encontrado la salida!");
                    break;
                }
                movimientos.push(getDireccion(jugadorX, jugadorY, nuevaX, nuevaY));
                jugadorX = nuevaX;
                jugadorY = nuevaY;
                System.out.println("Te has movido a la posición (" + jugadorX + ", " + jugadorY + ").");
            } else {
                System.out.println("Movimiento inválido.");
            }
        }
    }
    sc.close();
}

    private boolean esMovimientoValido(int x, int y) {
        return x >= 0 && x < FILAS && y >= 0 && y < COLUMNAS && laberinto[x][y] != MURO;
    }

    private void mostrarLaberinto() {
        for (char[] fila : laberinto) {
            for (char celda : fila) {
                System.out.print(celda + " ");
            }
            System.out.println();
        }
    }

    private int getDireccion(int x1, int y1, int x2, int y2) {
        for (int i = 0; i < DIRECCIONES.length; i++) {
            if (x2 == x1 + DIRECCIONES[i][0] && y2 == y1 + DIRECCIONES[i][1]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Laberinto laberinto = new Laberinto();
        laberinto.jugar();
    }
}
