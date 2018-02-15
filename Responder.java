import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;

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
    HashMap<String,String> respuestas;
    
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
        respuestas.put("lento","Si nota que su equipo funciona con lentitud, pruebe a animarlo. Eso le dara confianza");
        respuestas.put("hardware","No encontramos ninguna anomalia en el hardware. Por favor, revise su software?");
        respuestas.put("software","No encontramos ninguna anomalia en el software, Por favor, revise su hardware");
        respuestas.put("precio","El precio de la reparacion se determina con una moneda: Cara el pulmon izquierdo, cruz el derecho");
        respuestas.put("reclamacion","En estos momentos no podemos tramitar su reclamacion debido a una desgana generalizada.");
        respuestas.put("virus","Pruebe con paracetamol y mucha agua");
        respuestas.put("internet","while(internet == false){router.restart()}");
    }
    
    /**
     * Generate a response.
     * @return A string that should be displayed as the response
     */
    public String generateResponse(String palabra)
    {
        String respuesta;
        if(respuestas.containsKey(palabra)){
            respuesta = respuestas.get(palabra);
        }
        else {
            int index = generadorAleatorio.nextInt(respuestasPorDefecto.size());
            respuesta = respuestasPorDefecto.get(index);
        }
        return respuesta;
    }
}
