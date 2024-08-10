public class Persona {
    private String nombre;
    Persona(String n){
        setNombre(n);
    }
    void setNombre(String n){
        nombre = n;
    }
    String getNombre(){
        return nombre;
    }
}
