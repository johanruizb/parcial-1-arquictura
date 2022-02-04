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
        float pi = Float16.toFloat16(3.14159265f);

        float DistanciaMedida = 0;
        float Radio = Float16.toFloat16(0.5f); // en metros
        float PerimetroRueda = Float16.toFloat16(2 * pi * Radio);
        float DistanciaAlarma = Float16.toFloat16(5000f); // 5K o 10K
        short NumeroGirosLlanta = 0;

        float delta = Float16.toFloat16(pi);

        String datosExportar = "Iteracion;Delta;Distancia\n";
        String nombre = DistanciaAlarma + "- Multiplicacion" + "_16bits";

        System.out.println("");

        while (true) {

            NumeroGirosLlanta = Short.valueOf("" + (NumeroGirosLlanta + 1));
            // float deltaActual = Float16.toFloat16(PerimetroRueda + DistanciaMedida) -
            // DistanciaMedida;
            // DistanciaMedida = Float16.toFloat16(DistanciaMedida + PerimetroRueda);
            float deltaActual = Float16.toFloat16(PerimetroRueda * NumeroGirosLlanta) / NumeroGirosLlanta;
            DistanciaMedida = Float16.toFloat16(NumeroGirosLlanta * PerimetroRueda);

            if (delta != deltaActual) {
                delta = deltaActual;

                String bin = Integer.toBinaryString(Float16.encode(DistanciaMedida));

                int exponente = Integer.parseInt(bin.substring(0, 5), 2) - 15;

                System.out.println("delta: " + delta);
                System.out.println("Exp: " + exponente);
                System.out.println("Bin: " + toFormat(bin));
                System.out.println("DistanciaMedida: " + DistanciaMedida);
                System.out.println("NumeroGirosLlanta: " + NumeroGirosLlanta);
                System.out.println("");

                datosExportar += NumeroGirosLlanta + ";" + delta + ";" + DistanciaMedida + "\n";
            }

            if (DistanciaMedida >= DistanciaAlarma) {
                System.out.println("=16=bits=================");
                System.out.printf("¡Alarma!\n");
                System.out.printf("DistanciaMedida: %f\n", DistanciaMedida);
                System.out.printf("NumeroGirosLlanta: %d\n", NumeroGirosLlanta);
                System.out.println("========================");

                break;
            }

            if (NumeroGirosLlanta == 32767) {
                System.out.println("=16=bits================");
                System.out.println("¡Short ha alcanzado el limite de " + Short.MAX_VALUE + "!");
                System.out.printf("DistanciaMedida: %f\n", DistanciaMedida);
                System.out.printf("NumeroGirosLlanta: %d\n", NumeroGirosLlanta);
                System.out.println("========================");
                break;
            }
        }
        System.out.println("");

        ExportarDatos.exportar(nombre, datosExportar);

    }

    private static String toFormat(String bin) {

        String temp = "0";

        for (int i = 0; i < bin.length(); i++) {
            if (i == 0 || i == 5)
                temp += " ";
            temp += bin.charAt(i);
        }

        return temp;
    }

    private static String toBin(int encode) {

        String resultado = "";
        for (int i = 0; i < 16; i++) {

            // if (i >= 0 && i <= 4)
            resultado += (encode % 2);
            encode = encode / 2;

            if (encode == 0)
                break;
        }

        StringBuilder strb = new StringBuilder(resultado);
        resultado = strb.reverse().toString();
        resultado = resultado.substring(0, 5);

        return resultado;
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
