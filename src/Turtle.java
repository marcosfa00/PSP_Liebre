import java.util.Random;

class Turtle extends Thread {
    private static final int SALIDA = 1;
    private static final int AVANCE_RAPIDO = 3;
    private static final int AVANCE_LUNGO = 6;
    private static final int AVANCE_LENTO = 1;
    private static final int PROBABILIDAD_AVANCE_RAPIDO = 50;
    private static final int PROBABILIDAD_ESCORREGON = 20;
    private static final int PROBABILIDAD_AVANCE_LENTO = 30;

    private int posicion = SALIDA;
    private static boolean carreraFinalizada = false;

    @Override
    public void run() {
        while (!carreraFinalizada) {
            avanzar();
            if (posicion >= Carrera.META) {
                System.out.println("La tortuga ha llegado a la meta. ¡Gana la tortuga!");
                carreraFinalizada = true;
            }
        }
    }

    private void avanzar() {
        int numeroAleatorio = generarNumeroAleatorio();
        if (numeroAleatorio <= PROBABILIDAD_AVANCE_RAPIDO) {
            posicion += AVANCE_RAPIDO;
        } else if (numeroAleatorio <= PROBABILIDAD_AVANCE_RAPIDO + PROBABILIDAD_ESCORREGON) {
            posicion -= AVANCE_LUNGO;
            if (posicion < SALIDA) {
                posicion = SALIDA;
            }
        } else {
            posicion += AVANCE_LENTO;
        }

        imprimirPosicion('T', posicion);
    }

    private int generarNumeroAleatorio() {
        Random rand = new Random();
        return rand.nextInt(100) + 1;
    }

    private void imprimirPosicion(char animal, int posicion) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= Carrera.META; i++) {
            if (i == posicion) {
                sb.append(animal);
            } else {
                sb.append("-");
            }
        }
        System.out.println(sb.toString());
    }
}
