public class AlarmaCorrer {

    public static void main(String[] args) {
        metodo16bits();
        //metodo32bits();
        //metodo64bits();
    }

    private static void metodo16bits() {
        Float_16 f = new Float_16();
        float pi = f.float16(3.14159265f);
        float DistanciaMedida = 0f;
        float Radio = f.float16(0.5f); // en metros
        System.out.println(Radio);
        float PerimetroRueda = f.float16(2 * pi * Radio);
        float DistanciaAlarma = f.float16(10000f); // 5K o 10K
        float NumeroGirosLlanta = 0;
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
    }

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


