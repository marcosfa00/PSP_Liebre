import java.util.Random;

class Liebre extends Thread {
        private static final int SALIDA = 1;
        private static final int GRAN_SALTO = 9;
        private static final int SALTO_PEQUENO = 1;
        private static final int ESCORREGON_GRANDE = 12;
        private static final int ESCORREGON_PEQUENO = 2;
        private static final int PROBABILIDAD_DORMIR = 20;
        private static final int PROBABILIDAD_GRAN_SALTO = 20;
        private static final int PROBABILIDAD_ESCORREGON_GRANDE = 10;
        private static final int PROBABILIDAD_SALTO_PEQUENO = 30;
        private static final int PROBABILIDAD_ESCORREGON_PEQUENO = 20;

        private int posicion = SALIDA;
        private static boolean carreraFinalizada = false;

        @Override
        public void run() {
            while (!carreraFinalizada) {
                avanzar();
                if (posicion >= Carrera.META) {
                    System.out.println("La liebre ha llegado a la meta. ¡Gana la liebre!");
                    carreraFinalizada = true;
                }
            }
        }

        private void avanzar() {
            int numeroAleatorio = generarNumeroAleatorio();
            if (numeroAleatorio <= PROBABILIDAD_DORMIR) {
                // Dormir
            } else if (numeroAleatorio <= PROBABILIDAD_DORMIR + PROBABILIDAD_GRAN_SALTO) {
                posicion += GRAN_SALTO;
            } else if (numeroAleatorio <= PROBABILIDAD_DORMIR + PROBABILIDAD_GRAN_SALTO + PROBABILIDAD_ESCORREGON_GRANDE) {
                posicion -= ESCORREGON_GRANDE;
                if (posicion < SALIDA) {
                    posicion = SALIDA;
                }
            } else if (numeroAleatorio <= PROBABILIDAD_DORMIR + PROBABILIDAD_GRAN_SALTO + PROBABILIDAD_ESCORREGON_GRANDE + PROBABILIDAD_SALTO_PEQUENO) {
                posicion += SALTO_PEQUENO;
            } else {
                posicion -= ESCORREGON_PEQUENO;
                if (posicion < SALIDA) {
                    posicion = SALIDA;
                }
            }

            imprimirPosicion('L', posicion);
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

