import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder
{
    Random generadorAleatorio;
    ArrayList<String> respuestasDefault;
    HashMap<String,String> respuestas;
    
    /**
     * Construye un Responder
     */
    public Responder()
    {
        generadorAleatorio = new Random();
        respuestasDefault = new ArrayList<>();
        respuestas = new HashMap<>();
        anadirRespuestas();
    }
    
    /**
     * Anade respuestas  al servicio tecnico
     */
    private void anadirRespuestas(){
        respuestasDefault.add("Nuestros monos estan trabajando en ello");
        respuestasDefault.add("Su respuesta sera procesada por nuestro buzon de spam");
        respuestasDefault.add("Todos nuestros teleoperadores estan ignorandole");
        respuestasDefault.add("No le entiendo, por favor, aprenda a escribir");
        respuestasDefault.add("Pidale a su mascota que deje el teclado");
        respuestasDefault.add("Pruebe a consultarlo en Google");
        respuestasDefault.add("Muy interesante, cuenteme mas...");
        respuestasDefault.add("Repita por favor, no le estaba escuchando");
        respuestasDefault.add("Pruebe mas tarde, es la hora del cafe");
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
            int index = generadorAleatorio.nextInt(respuestasDefault.size());
            respuesta = respuestasDefault.get(index);
        }
        return respuesta;
    }
}
