import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EjemploLeerCVS{
    public static void main(String[] args) {
        EjemploLeerCVS.leer(); 
    }

    public static void leer() {
        int contar = 0;
        String palabraBuscar = "CATEGORY"; // Se puede cambiar esta palabra por otra
        List<String> contenidoArchivo = new ArrayList<>(); // Lista para almacenar el contenido temporalmente

        try {
            int c = 0;
            String linea;
            // Abrir el archivo CVS para leer
            BufferedReader leer = new BufferedReader(new FileReader("ArchivoCSV\\Catalog_v2.csv"));
            // Crear y abrir el archivo que vamos a escribir
            BufferedWriter escribir = new BufferedWriter(new FileWriter("ArchivoCSV\\Catalog_v2.txt"));

            while((linea = leer.readLine())!= null && c<2255){
                //System.out.print((c+1) + ".-" + linea);
                String [] contenido = linea.split(",");
                if (contenido[0].equals(palabraBuscar)){
                    //System.out.println(contenido[0] + ": " + contenido[1]); //Imprimir en consola
                    contenidoArchivo.add(contenido[0] + "," + contenido[1]); // Agrega coincidencias a la lista,, Solo 1 y 2
                    //contenidoArchivo.add(linea); // Agrega coincidencias a la lista, Todo la linea
                    contar ++; // Contar cuantos se encontraron
                }
                c++;
            }

            // Escribir el total de veces que se encontró
            System.out.println(palabraBuscar + ", "+ contar); //Imprimir en consola
            escribir.write(palabraBuscar + ", " + contar); // Escribir en arvhivo
            escribir.newLine();

            // Escribir el contenido almacenado en la lista
            for (String lineaContenido : contenidoArchivo) {
                escribir.write(lineaContenido);
                escribir.newLine();
            }

            leer.close();
            escribir.close();

        }catch(FileNotFoundException ex){
            System.err.println("No encontre el archivo");
        }catch(IOException ex){
            System.err.println("No puedo leer");
        }
    }
}