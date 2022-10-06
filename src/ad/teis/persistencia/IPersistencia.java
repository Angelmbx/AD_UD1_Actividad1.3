package ad.teis.persistencia;

import ad.teis.model.Persona;

public interface IPersistencia {

    void escribirPersona(Persona persona, String ruta);
    Persona leerDatos(String ruta);


}
