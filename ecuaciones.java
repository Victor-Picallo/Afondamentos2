package Ecuaciones;

public class ecuaciones {

    // ax + by = e a b matriz de coeficientes "x" "y"
    // cs + dy = f c d

    // Vectir columna de terminos independientes "e" "f"

    public static double[][] pedirMatrizCoeficientes2x2() {
        double[][] matrizCoeficientes = new double[2][2];
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("Introduce el coeficiente en la posición [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrizCoeficientes[i][j] = scanner.nextDouble();
            }
        }
        return matrizCoeficientes;

    }

    public static double[] pedirTerminosIndependientes2x1() {
        double[] terminosIndependientes = new double[2];
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            System.out.print("Introduce el término independiente de la ecuación " + (i + 1) + ": ");
            terminosIndependientes[i] = scanner.nextDouble();
        }
        return terminosIndependientes;
    }

    public static double determinante2x2(double[][] matriz) {
        return matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
    }

    public static double determinanteX(double[][] matrizCoeficientes, double[] terminosIndependientes) {
        double det = determinante2x2(matrizCoeficientes);
        if (det == 0) {
            throw new IllegalArgumentException("El sistema de ecuaciones no tiene solución única.");
        }
        double x = (terminosIndependientes[0] * matrizCoeficientes[1][1]
                - matrizCoeficientes[0][1] * terminosIndependientes[1]) / det;
        return x;
    }

    public static double determinanteY(double[][] matrizCoeficientes, double[] terminosIndependientes) {
        double det = determinante2x2(matrizCoeficientes);
        if (det == 0) {
            throw new IllegalArgumentException("El sistema de ecuaciones no tiene solución única.");
        }
        double y = (matrizCoeficientes[0][0] * terminosIndependientes[1]
                - terminosIndependientes[0] * matrizCoeficientes[1][0]) / det;
        return y;
    }

    public static void mostrarSoluciones(double[][] matrizCoeficientes, double[] terminosIndependientes) {
        double solucionX = determinanteX(matrizCoeficientes, terminosIndependientes);
        double solucionY = determinanteY(matrizCoeficientes, terminosIndependientes);
        System.out.println("La solución del sistema de ecuaciones es:");
        System.out.println("x = " + solucionX);
        System.out.println("y = " + solucionY);
    }

    public static double[] resolverEcuacion2x2(double[][] matrizCoeficientes, double[] terminosIndependientes) {
        double det = determinante2x2(matrizCoeficientes);
        if (det == 0) {
            throw new IllegalArgumentException("El sistema de ecuaciones no tiene solución única.");
        }
        double x = (terminosIndependientes[0] * matrizCoeficientes[1][1]
                - matrizCoeficientes[0][1] * terminosIndependientes[1]) / det;
        double y = (matrizCoeficientes[0][0] * terminosIndependientes[1]
                - terminosIndependientes[0] * matrizCoeficientes[1][0]) / det;
        return new double[] { x, y };
    }

    /*
     * Tres ecuaciones y tres incognitas
     * a1x + b1y + c1z = d1
     * a2x + b2y + c2z = d2
     * a3x + b3y + c3z = d3
     */
    // Matriz de coeficientes 3x3
    public static double[][] pedirMatrizCoeficientes3x3() {
        double[][] matriz = new double[3][3];
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese los coeficientes de la fila " + (i + 1) +
                    "separados por espacio en blanco: ");
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = scanner.nextDouble();
            }
        }

        return matriz;

    }


    // Vector columna de terminos independientes 3x1
    public static double[] pedirTerminosIndependientes3x1() {
        double[] terminosIndependientes = new double[3];
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.print("Introduce el término independiente de la ecuación " + (i + 1) + ": ");
            terminosIndependientes[i] = scanner.nextDouble();
        }
        return terminosIndependientes;
    }

    public static double determinante3x3(double[][] matriz) {
        return    matriz[0][0] * (matriz[1][1] * matriz[2][2] - matriz[1][2] * matriz[2][1])
                - matriz[0][1] * (matriz[1][0] * matriz[2][2] - matriz[1][2] * matriz[2][0])
                + matriz[0][2] * (matriz[1][0] * matriz[2][1] - matriz[1][1] * matriz[2][0]);
    }

    // Determinante para x y z
    public static double deteterminanteX3(double[][] Matriz, double[] terminos){
        double x = (terminos[0] * (Matriz[1][1] * Matriz[2][2] - Matriz[1][2] * Matriz[2][1])
                - Matriz[0][1] * (terminos[1] * Matriz[2][2] - Matriz[1][2] * terminos[2])
                + Matriz[0][2] * (terminos[1] * Matriz[2][1] - Matriz[1][1] * terminos[2]));
        return x;
    }

    public static double deteterminanteY3(double[][] Matriz, double[] terminos){
        double y = (Matriz[0][0] * (terminos[1] * Matriz[2][2] - Matriz[1][2] * terminos[2])
                - terminos[0] * (Matriz[1][0] * Matriz[2][2] - Matriz[1][2] * Matriz[2][0])
                + Matriz[0][2] * (Matriz[1][0] * terminos[2] - terminos[1] * Matriz[2][0]));
        return y;
    }

    public static double deteterminanteZ3(double[][] Matriz, double[] terminos){
        double z = (Matriz[0][0] * (Matriz[1][1] * terminos[2] - terminos[1] * Matriz[2][1])
                - Matriz[0][1] * (Matriz[1][0] * terminos[2] - terminos[1] * Matriz[2][0])
                + terminos[0] * (Matriz[1][0] * Matriz[2][1] - Matriz[1][1] * Matriz[2][0]));
        return z;
    }

    public static double[][] pedirMatrizCoeficientes3x3UnoAUno() {
        double[][] matrizCoeficientes = new double[3][3];
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Introduce el coeficiente en la posición [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrizCoeficientes[i][j] = scanner.nextDouble();
            }
        }
        return matrizCoeficientes;
    }

    public static double[][] pedirTerminosIndependientes3x1UnoAUno() {
        double[][] terminosIndependientes = new double[3][1];
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.print("Introduce el término independiente de la ecuación " + (i + 1) + ": ");
            terminosIndependientes[i][0] = scanner.nextDouble();
        }
        return terminosIndependientes;
    }

    public static double[] resolverEcuaciones3x3(double[][] matrizCoeficientes, double[] terminosIndependientes) {
        double det = determinante3x3(matrizCoeficientes);
        if (det == 0) {
            throw new IllegalArgumentException("El sistema de ecuaciones no tiene solución única.");
        }
        double x = deteterminanteX3(matrizCoeficientes, terminosIndependientes) / det;
        double y = deteterminanteY3(matrizCoeficientes, terminosIndependientes) / det;
        double z = deteterminanteZ3(matrizCoeficientes, terminosIndependientes) / det;
        return new double[] { x, y, z };
    }

    public static void mostrarSoluciones3x3(double[][] matrizCoeficientes, double[] terminosIndependientes) {
        double solucionX = deteterminanteX3(matrizCoeficientes, terminosIndependientes) / determinante3x3(matrizCoeficientes);
        double solucionY = deteterminanteY3(matrizCoeficientes, terminosIndependientes) / determinante3x3(matrizCoeficientes);
        double solucionZ = deteterminanteZ3(matrizCoeficientes, terminosIndependientes) / determinante3x3(matrizCoeficientes);
        System.out.println("La solución del sistema de ecuaciones es:");
        System.out.println("x = " + solucionX);
        System.out.println("y = " + solucionY);
        System.out.println("z = " + solucionZ);
    }

}





