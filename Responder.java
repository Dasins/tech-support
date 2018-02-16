import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael KÃ¶lling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder
{
    Random generadorAleatorio;
    ArrayList<String> respuestasPorDefecto;
    HashMap<HashSet<String>,String> respuestas;
    
    /**
     * Construye un Responder
     */
    public Responder()
    {
        generadorAleatorio = new Random();
        respuestasPorDefecto = new ArrayList<>();
        respuestas = new HashMap<>();
        anadirRespuestasPorDefecto();
        anadirRespuestas();
    }
    
    /**
     * Establece las respuestas por defecto para el robot del servicio tecnico.
     */
    private void anadirRespuestasPorDefecto() {
        respuestasPorDefecto.add("Se ha detectado un uso inadecuado del robot del servicio tecnico.\n\n" + 
                                 "Le informamos que hemos anadido una nueva penalizacion en caso de uso inadecuado del sistema\n" + 
                                 "Si esta incidencia vuelve a repetirse,\n pondremos un punto negativo en su hoja de usuario," + 
                                 "luego, le mataremos.");
        respuestasPorDefecto.add("Enviaremos a un técnico entubador a reanimarlo con bálsamo péptido y adrenalina.");
        respuestasPorDefecto.add("Nuestros monos estan trabajando en ello");
        respuestasPorDefecto.add("Su respuesta sera procesada por nuestro buzon de spam");
        respuestasPorDefecto.add("No le entiendo, por favor, utilice las manos para escribir su consulta");
        respuestasPorDefecto.add("Hemos detectado numerosas incorrecciones linguisticas. Le rogamos retire a su mascota del teclado.");
        respuestasPorDefecto.add("Pruebe a consultarlo en Google");
        respuestasPorDefecto.add("Muy interesante, cuenteme mas...");
        respuestasPorDefecto.add("Repita por favor, olvide prestarle atencion");
        respuestasPorDefecto.add("Gracias por ayudarnos a ayudarlo a ayudarnos");    
    }
        
    /**
     * Anade respuestas  al servicio tecnico
     */
    private void anadirRespuestas(){
        HashSet<String> set1 = new HashSet<>();
        set1.add("ruido");
        set1.add("ventilador");
        
        HashSet<String> set2 = new HashSet<>();
        set2.add("ruido");
        
        HashSet<String> set3 = new HashSet<>();
        set3.add("ventilador");
        
        HashSet<String> set4 = new HashSet<>();
        set4.add("internet");
        set4.add("conecta");
        
        respuestas.put(set1,"Es probable que su ventilador este obstruido, preparase para una batalla epica contra la suciedad");
        respuestas.put(set2,"El ruido que escucha puede ser producto de unos vecinos pocos civicos");
        respuestas.put(set3,"Si el ventilador se ha detenido, pruebe a girarlo de manera manual");
        respuestas.put(set4,"Mantenga el cable o su dispositivo WiFi elevado unos 2.5m sobre el suelo para restablecer la conexion");
    }
    
    /**
     * Generate a response.
     * @return A string that should be displayed as the response
     */
    public String generateResponse(HashSet<String> frase)
    {
        String respuesta = "";
        respuesta = respuestas.get(frase);
        if (respuesta == null) {
            if(respuestasPorDefecto.size() > 0){
                int index = generadorAleatorio.nextInt(respuestasPorDefecto.size());
                respuesta = respuestasPorDefecto.remove(index);
            }
            else {
                respuesta = "Lo siento, me he quedado sin palabras";
            }
        }
        return respuesta;
    }
}
