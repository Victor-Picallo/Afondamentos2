package Ecuaciones;

public class cramer3x3 {
    public static void main(String[] args) {
        System.out.println("**3 Icongnitas 3 Ecuaciones\n");

        // Pide coeficientes uno a uno utilizando el método de la clase ecuaciones
        double[][] coeficientes = ecuaciones.pedirMatrizCoeficientes3x3UnoAUno();

        // Pide términos independientes uno a uno utilizando el método de la clase ecuaciones
        double[] independientes = ecuaciones.pedirTerminosIndependientes3x1UnoAUno();

        // Calcula y muestra las soluciones
        try {
            ecuaciones.mostrarSoluciones3x3(coeficientes, independientes);
        } catch (IllegalArgumentException e) {
            System.out.println("No existe solución única para el sistema ingresado.");
        }
    }
}
