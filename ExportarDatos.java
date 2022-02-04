import java.io.*;

public class ExportarDatos {
    public static void exportar(String nombre, String info) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("./" + nombre + ".csv", false);
            pw = new PrintWriter(fichero);
            pw.println(info);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}