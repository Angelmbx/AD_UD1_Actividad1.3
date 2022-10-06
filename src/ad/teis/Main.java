package ad.teis;

import ad.teis.model.Persona;
import ad.teis.persistencia.DataIOPersistencia;
import ad.teis.persistencia.IPersistencia;

public class Main {

    private static final String PERSONA_FILE ="persona.dat";

    public static void main(String[] args) {



        IPersistencia outra = new DataIOPersistencia();
        Persona manolo = new Persona(1,"123456789",18, 20000);

        outra.escribirPersona(manolo, PERSONA_FILE);

        outra.leerDatos(PERSONA_FILE);

        Persona personarecuperada= outra.leerDatos(PERSONA_FILE);
        System.out.println("Se ha recuperado: "+personarecuperada);

    }

}
