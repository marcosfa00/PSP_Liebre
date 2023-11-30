public class Carrera {
    public static final int META = 70;

    public static void main(String[] args) {
        System.out.println("Comienza la carrera!");

        Turtle tortuga = new Turtle();
        Liebre liebre = new Liebre();

        tortuga.start();
        liebre.start();
    }
}
