public class AlarmaCorrer {

    public static void main(String[] args) {

        // 31.40625 + 3.140625

        boolean sumar = false;
        float distancia = 5000f;

        comparasion();

        // metodo16bits(sumar, distancia);
        // metodo32bits();
        // metodo64bits();
    }

    private static void comparasion() {
        float pi = Float16.toFloat16(3.140625f);
        float mult = 0f;
        float suma = 0f;

        for (int i = 0 + 1; i < 1411; i++) {
            suma = Float16.toFloat16(suma + pi);
            mult = Float16.toFloat16(i * pi);

            String binsum = Integer.toBinaryString(Float16.encode(suma));
            String binmult = Integer.toBinaryString(Float16.encode(mult));

            {
                System.out.println("");

                System.out.println("----------------------------");
                System.out.println("iteracion: " + i);

                int exponente = 0;
                exponente = Integer.parseInt(binsum.substring(0, 5), 2) - 15;

                System.out.println("exponente: " + exponente);
                System.out.println("");
                System.out.printf("Suma: \nValor: %f\n", suma);
                System.out.println("Binario: " + toFormat(binsum));

                System.out.println("=========================");

                System.out.printf("Multiplicacion: \nValor: %f\n", mult);
                System.out.println("Binario: " + toFormat(binmult));

                System.out.println("----------------------------");
                System.out.println("");
            }

            if (!binmult.equals(binsum) && i != 0) {
                break;
            }
        }

    }

    private static void metodo16bits(boolean suma, float DistanciaAlarma) {

        DistanciaAlarma = Float16.toFloat16(DistanciaAlarma); // 5K o 10K

        float pi = Float16.toFloat16(3.14159265f);
        float DistanciaMedida = 0;
        float Radio = Float16.toFloat16(0.5f); // en metros
        float PerimetroRueda = Float16.toFloat16(2 * pi * Radio);
        // float DistanciaAlarma = Float16.toFloat16(5000f); // 5K o 10K
        short NumeroGirosLlanta = 0;

        float delta = Float16.toFloat16(pi);

        String datosExportar = "Iteracion;Delta;Distancia\n";
        String nombre = DistanciaAlarma + "-" + (suma ? ("Suma") : ("Multiplicacion")) + "_16bits";

        System.out.println("");

        while (true) {

            float deltaActual = suma ? (Float16.toFloat16(PerimetroRueda + DistanciaMedida) -
                    DistanciaMedida) : (Float16.toFloat16(PerimetroRueda * NumeroGirosLlanta) / NumeroGirosLlanta);

            if (delta != deltaActual && NumeroGirosLlanta != 0) {
                delta = deltaActual;

                String bin = Integer.toBinaryString(Float16.encode(DistanciaMedida));
                int exponente = 0;

                if (!"0".equals(bin))
                    exponente = Integer.parseInt(bin.substring(0, 5), 2) - 15;

                System.out.println("delta: " + delta);
                System.out.println("Exp: " + exponente);
                System.out.println("Bin: " + toFormat(bin));
                System.out.println("DistanciaMedida: " + DistanciaMedida);
                System.out.println("NumeroGirosLlanta: " + NumeroGirosLlanta);
                System.out.println("");

                datosExportar += NumeroGirosLlanta + ";" + delta + ";" + DistanciaMedida + "\n";
            }

            NumeroGirosLlanta = Short.valueOf("" + (NumeroGirosLlanta + 1));
            DistanciaMedida = suma ? (Float16.toFloat16(DistanciaMedida + PerimetroRueda))
                    : (Float16.toFloat16(NumeroGirosLlanta * PerimetroRueda));

            if (DistanciaMedida >= DistanciaAlarma) {
                System.out.println("=16=bits=================");
                System.out.printf("¡Alarma!\n");
                System.out.printf("DistanciaMedida: %f\n", DistanciaMedida);
                System.out.printf("NumeroGirosLlanta: %d\n", NumeroGirosLlanta);
                System.out.println("========================");

                break;
            }

            if (NumeroGirosLlanta == Short.MAX_VALUE) {
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

    private static void metodo32bits(boolean suma) {

        float pi = (3.14159265f);

        float DistanciaMedida = 0;
        float Radio = (0.5f); // en metros
        float PerimetroRueda = (2 * pi * Radio);
        float DistanciaAlarma = (5000f); // 5K o 10K
        short NumeroGirosLlanta = 0;

        float delta = (pi);

        String datosExportar = "Iteracion;Delta;Distancia\n";
        String nombre = DistanciaAlarma + "-" + (suma ? ("Suma") : ("Multiplicacion")) + "_32bits";

        System.out.println("");

        while (true) {

            float deltaActual = suma ? ((PerimetroRueda + DistanciaMedida) -
                    DistanciaMedida) : ((PerimetroRueda * NumeroGirosLlanta) / NumeroGirosLlanta);

            if (delta != deltaActual) {
                delta = deltaActual;

                System.out.println("delta: " + delta);
                System.out.println("DistanciaMedida: " + DistanciaMedida);
                System.out.println("NumeroGirosLlanta: " + NumeroGirosLlanta);
                System.out.println("");

                datosExportar += NumeroGirosLlanta + ";" + delta + ";" + DistanciaMedida + "\n";
            }

            if (DistanciaMedida >= DistanciaAlarma) {
                System.out.println("=32=bits=================");
                System.out.printf("¡Alarma!\n");
                System.out.printf("DistanciaMedida: %f\n", DistanciaMedida);
                System.out.printf("NumeroGirosLlanta: %d\n", NumeroGirosLlanta);
                System.out.println("========================");

                break;
            }

            NumeroGirosLlanta = Short.valueOf("" + (NumeroGirosLlanta + 1));
            DistanciaMedida = suma ? ((DistanciaMedida + PerimetroRueda))
                    : ((NumeroGirosLlanta * PerimetroRueda));

            if (NumeroGirosLlanta == (3.4028235E38) - 1) {
                System.out.println("=32=bits================");
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

    private static void metodo64bits(boolean suma) {

        double pi = (3.14159265);

        double DistanciaMedida = 0;
        double Radio = (0.5); // en metros
        double PerimetroRueda = (2 * pi * Radio);
        double DistanciaAlarma = (5000); // 5K o 10K
        short NumeroGirosLlanta = 0;

        double delta = (pi);

        String datosExportar = "Iteracion;Delta;Distancia\n";
        String nombre = DistanciaAlarma + "-" + (suma ? ("Suma") : ("Multiplicacion")) + "_64bits";

        System.out.println("");

        while (true) {

            double deltaActual = suma ? ((PerimetroRueda + DistanciaMedida) -
                    DistanciaMedida) : ((PerimetroRueda * NumeroGirosLlanta) / NumeroGirosLlanta);

            if (delta != deltaActual) {
                delta = deltaActual;

                System.out.println("delta: " + delta);
                System.out.println("DistanciaMedida: " + DistanciaMedida);
                System.out.println("NumeroGirosLlanta: " + NumeroGirosLlanta);
                System.out.println("");

                datosExportar += NumeroGirosLlanta + ";" + delta + ";" + DistanciaMedida + "\n";
            }

            if (DistanciaMedida >= DistanciaAlarma) {
                System.out.println("=64=bits=================");
                System.out.printf("¡Alarma!\n");
                System.out.printf("DistanciaMedida: %f\n", DistanciaMedida);
                System.out.printf("NumeroGirosLlanta: %d\n", NumeroGirosLlanta);
                NumeroGirosLlanta = Short.valueOf("" + (NumeroGirosLlanta + 1));
                System.out.println("========================");

                break;
            }

            DistanciaMedida = suma ? ((DistanciaMedida + PerimetroRueda))
                    : ((NumeroGirosLlanta * PerimetroRueda));

            if (NumeroGirosLlanta == (1.7976931348623157E308) - 1) {
                System.out.println("=64=bits================");
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
}