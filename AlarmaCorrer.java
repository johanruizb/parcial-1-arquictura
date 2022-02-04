public class AlarmaCorrer {

    public static void main(String[] args) {

        /*
         * System.out.println("");
         * System.out.println("8188 + 3.14159265: " + (Float16.toFloat16(8188.0f +
         * Float16.toFloat16(3.14159265f))));
         * System.out.println("");
         * System.out.println("8192.999 + 3.14159265: " + (Float16.toFloat16(8192.999f +
         * Float16.toFloat16(3.14159265f))));
         * System.out.println("");
         */
        metodo16bits();
        // metodo32bits();
        // metodo64bits();
    }

    private static void metodo16bits() {
        Float_16 f = new Float_16();
        float pi =f.float16(3.14159265f);
        float DistanciaMedida = 0f;
        float Radio = f.float16(0.5f); // en metros
        float PerimetroRueda = f.float16(2 * pi * Radio);
        float DistanciaAlarma = f.float16(10000f); // 5K o 10K
        short NumeroGirosLlanta = 0;
        float delta = pi;
        while (true) {
            DistanciaMedida = f.float16(DistanciaMedida + PerimetroRueda);
            System.out.println(f.getExp());
            if((f.float16(DistanciaMedida + PerimetroRueda)-DistanciaMedida) == 0.0){
                break;
            }
            NumeroGirosLlanta++;
            if(DistanciaMedida == DistanciaAlarma){
                System.out.println("Termino");
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
        int NumeroGirosLlanta = 0;

        float delta = (pi);

        while (true) {
            NumeroGirosLlanta = NumeroGirosLlanta + 1;
            DistanciaMedida = (DistanciaMedida + PerimetroRueda);

            if (delta != (PerimetroRueda + DistanciaMedida) - DistanciaMedida) {
                delta = (PerimetroRueda + DistanciaMedida) - DistanciaMedida;
                System.out.println("delta: " + delta);
                System.out.println("DistanciaMedida: " + DistanciaMedida);
                System.out.println("NumeroGirosLlanta: " + NumeroGirosLlanta);
                System.out.println("");
            }

            if (DistanciaMedida >= DistanciaAlarma) {
                System.out.println("=32=bits=================");
                System.out.printf("¡Alarma!\n");
                System.out.printf("DistanciaMedida: %f\n", DistanciaMedida);
                System.out.printf("NumeroGirosLlanta: %d\n", NumeroGirosLlanta);
                System.out.println("========================");

                break;
            }

            if (NumeroGirosLlanta == 32767) {
                System.out.printf("DistanciaMedida: %f\n", DistanciaMedida);
                System.out.printf("NumeroGirosLlanta: %d\n", NumeroGirosLlanta);
                break;
            }
        }
        System.out.println("");
    }

    private static void metodo64bits() {
        float pi = 3.14159265f;

        double DistanciaMedida = 0;
        double Radio = (0.5); // en metros
        double PerimetroRueda = (2 * pi * Radio);
        double DistanciaAlarma = (5000); // 5K o 10K
        int NumeroGirosLlanta = 0;

        while (true) {
            NumeroGirosLlanta = NumeroGirosLlanta + 1;
            DistanciaMedida = (DistanciaMedida + PerimetroRueda);
            if (DistanciaMedida >= DistanciaAlarma) {
                System.out.println("=64=bits=================");
                System.out.printf("¡Alarma!\n");
                System.out.printf("DistanciaMedida: %f\n", DistanciaMedida);
                System.out.printf("NumeroGirosLlanta: %d\n", NumeroGirosLlanta);
                System.out.println("========================");

                break;
            }

            if (NumeroGirosLlanta == 32767) {
                System.out.printf("DistanciaMedida: %f\n", DistanciaMedida);
                System.out.printf("NumeroGirosLlanta: %d\n", NumeroGirosLlanta);
                break;
            }
        }
        System.out.println("");
    }

}
