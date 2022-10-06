package ad.teis.persistencia;

import ad.teis.model.Persona;

import java.io.*;

public class DataIOPersistencia implements IPersistencia {


    @Override
    public void escribirPersona(Persona persona, String ruta) {

        if(persona != null) {

            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(ruta))) {
                dos.writeLong(persona.getId());
                dos.writeChars(persona.getDni());
                dos.writeInt(persona.getEdad());
                dos.writeFloat(persona.getSalario());


            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    @Override
    public Persona leerDatos(String ruta) {
        long id =0;
        String dni="";
        float salario=0;
        int edad=0;

        try (DataInputStream dis = new DataInputStream(new FileInputStream(ruta))){
            //System.out.println("ID: "+ dis.readLong());
            id= dis.readLong();
            //System.out.println("DNI: ");
            for(int i=0; i<9; i++){
                char contenedor=dis.readChar();
                dni+=contenedor;}

            //System.out.println("Edad: "+ dis.readInt());
            edad=dis.readInt();
            //System.out.println("Salario: "+dis.readFloat());
            salario=dis.readFloat();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Persona p = new Persona(id,dni, edad, salario);
        return p;
    }
}
