/**
 * En este documento se realiza el desarrollo de la asignacion del parcial 1.
 * Emplearemos los temas de representacion en coma flotante de 16bits desde el
 * lenguaje Java usando float modificado para funcionar a 16
 * bits.
 * 
 * Nota: Ejecutado usando Java (TM) by Red Hat
 *
 * Codigo fuente: https://github.com/johanruizb/parcial-1-arquictura.git
 *
 * Modificado por: Johan Ruiz - johan.andres.ruiz@correounivalle.edu.co,
 * Ingrid Echeverri - ingrid.echeverri@correounivalle.edu.co,
 * Victor Alomia - victor.alomia@correounivalle.edu.co
 * 
 * Fecha: 05/02/2022
 */

public class AlarmaCorrer {

    /**
     * Funcion principal el ejecuta el metodo que puede simular la arquitectura de
     * 16 bits, o otros metodos que usan las variables de float (32 bits) y double
     * (64 bits)
     * 
     * @param args
     */
    public static void main(String[] args) {
        metodo16bits();
        // metodo32bits();
        // metodo64bits();
    }

    /**
     * Metodo encargado de simular los 16bits apoyandose en una clase creada por la
     * compañera Ingrid Echeverri, para realizar los calculos necesarios del
     * programa
     * 
     */

    private static void metodo16bits() {
        Float_16 f = new Float_16();
        float pi = f.float16(3.14159265f);
        float DistanciaMedida = 0f;
        float Radio = f.float16(0.5f); // en metros
        float PerimetroRueda = f.float16(2 * pi * Radio);
        float DistanciaAlarma = f.float16(10000f); // 5K o 10K
        float NumeroGirosLlanta = 0;
        System.out.println("");
        System.out.println("16 BITS");

        while (true) {
            // Cancelación
            if ((f.float16(DistanciaMedida + PerimetroRueda) - DistanciaMedida) == 0.0) {
                System.out.println("Vuelta: " + NumeroGirosLlanta);
                break;
            }

            NumeroGirosLlanta++;
            DistanciaMedida = f.float16(DistanciaMedida + PerimetroRueda);

            if (DistanciaMedida >= DistanciaAlarma) {
                System.out.println("Distancia Medida: " + DistanciaMedida);
                System.out.println("Iteraciones: " + NumeroGirosLlanta);
                System.out.println("Distancia Real: " + NumeroGirosLlanta * 3.14159265f);
                break;
            }
        }
        System.out.println("");
    }

    /**
     * Metodo encargado de usar las variables de 32bits para realizar los calculos
     * necesarios del programa
     * 
     */

    private static void metodo32bits() {
        float pi = 3.14159265f;

        float DistanciaMedida = 0;
        float Radio = (0.5f); // en metros
        float PerimetroRueda = (2 * pi * Radio);
        float DistanciaAlarma = (10000f); // 5K o 10K
        double NumeroGirosLlanta = 0;
        System.out.println("32 BITS");
        while (true) {
            // Cancelación
            if ((DistanciaMedida + PerimetroRueda) - DistanciaMedida == 0.0) {
                System.out.println("Vuelta: " + NumeroGirosLlanta);
                break;
            }

            NumeroGirosLlanta++;
            DistanciaMedida = DistanciaMedida + PerimetroRueda;

            if (DistanciaMedida >= DistanciaAlarma) {
                System.out.println("Distancia Medida: " + DistanciaMedida);
                System.out.println("Iteraciones: " + NumeroGirosLlanta);
                System.out.println("Distancia Real: " + NumeroGirosLlanta * 3.14159265f);
                break;
            }
        }
    }

    /**
     * Metodo encargado de usar las variables de 64bits para realizar los calculos
     * necesarios del programa
     * 
     */
    private static void metodo64bits() {
        double pi = 3.14159265f;
        double DistanciaMedida = 0;
        double Radio = (0.5); // en metros
        double PerimetroRueda = (2 * pi * Radio);
        double DistanciaAlarma = (5000); // 5K o 10K
        double NumeroGirosLlanta = 0;
        System.out.println("64 BITS");
        System.out.println("Valor de PI: " + pi);
        while (true) {
            NumeroGirosLlanta++;
            DistanciaMedida = DistanciaMedida + PerimetroRueda;

            if (DistanciaMedida >= DistanciaAlarma) {
                System.out.println("Distancia Medida: " + DistanciaMedida);
                System.out.println("Iteraciones: " + NumeroGirosLlanta);
                System.out.println("Distancia Real: " + NumeroGirosLlanta * 3.14159265f);
                break;
            }
        }
    }

}