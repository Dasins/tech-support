import java.util.Random;
import java.util.ArrayList;

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
    ArrayList<String> respuestas;
    
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        generadorAleatorio = new Random();
        respuestas = new ArrayList<>();
        anadirRespuestas();
    }
    
    /**
     * Anade respuestas aleatorias al servicio tecnico
     */
    private void anadirRespuestas(){
        respuestas.add("Nuestros monos estan trabajando en ello");
        respuestas.add("Su respuesta sera procesada por nuestro buzon de spam");
        respuestas.add("Todos nuestros teleoperadores estan ignorandole");
        respuestas.add("No le entendido, por favor, aprenda a escribir");
        respuestas.add("Pidale a su mascota que deje el teclado");
        respuestas.add("Pruebe a consultarlo en Google");
        respuestas.add("Muy interesante, cuenteme mas...");
        respuestas.add("Repita por favor, no le estaba escuchando");
        respuestas.add("Pruebe mas tarde, es la hora del cafe");
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse()
    {
        int index = generadorAleatorio.nextInt(respuestas.size());
        return respuestas.get(index);
    }
}
