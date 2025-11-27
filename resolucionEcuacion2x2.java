package Ecuaciones;

public class resolucionEcuacion2x2 {

    public static void main(String[] args) {

        ecuaciones ec = new ecuaciones();

        double[][] Matriz = ec.pedirMatrizCoeficientes2x2();
        double[] TerminosIndependientes = ec.pedirTerminosIndependientes2x1();

        ec.mostrarSoluciones(Matriz, TerminosIndependientes);

    }
}
