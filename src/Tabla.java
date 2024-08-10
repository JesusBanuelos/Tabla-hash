import java.util.HashMap;
import java.util.ArrayList;

public class Tabla {
    HashMap<Integer,ArrayList<Persona>> map = new HashMap<>();
    void ingresarMap(String name){
        Persona persona = new Persona(name);
        ArrayList<Persona> array = new ArrayList<>();
        int sum=0;
        int id = 0;
        //Ciclo for para sumar los valores ASCII
        for(int i=0; i<name.length(); i++){
            sum = sum + (int)name.charAt(i);
        }
        //Conseguir el valor del id que esta entre el 1 y 10
        id = (sum % 10) + 1;
        if(map.isEmpty()){
            array.add(persona);
            map.put(id,array);
        }
        else{
            boolean existe = false;
            for(HashMap.Entry<Integer,ArrayList<Persona>> entry : map.entrySet()){
                Integer key = entry.getKey();
                if(key == id){
                    existe = true;
                    ArrayList<Persona> value = entry.getValue();
                    array = value;
                    array.add(persona);
                    map.put(id,array);
                    break;
                }
            }
            if(existe == false){
                array.add(persona);
                map.put(id, array);
            }
        }
    }
    void imprimirTodo(){
        for(HashMap.Entry<Integer,ArrayList<Persona>> entry : map.entrySet()){
            Integer key = entry.getKey();
            ArrayList<Persona> value = entry.getValue();
            System.out.println("Valores con la llave: " + key);
            for(int i=0;i<value.size();i++){
                System.out.println(value.get(i).getNombre());
            }
            System.out.println();
        }
    }
    void imprimirPorLlave(int num){
        boolean encontrado = false;
        for(HashMap.Entry<Integer,ArrayList<Persona>> entry : map.entrySet()){
            Integer key = entry.getKey();
            if(key == num){
                encontrado = true;
                System.out.println("Valores para la llave: " + num + ":");
                ArrayList<Persona> value = entry.getValue();
                for(int i=0;i<value.size();i++){
                    System.out.println(value.get(i).getNombre());
                }
                break;
            }
        }
        if(encontrado==false){
            System.out.println("Llave no encontrada");
        }
    }
    void busqueda(String name){
        int sum=0;
        int id = 0;
        //Ciclo for para sumar los valores ASCII
        for(int i=0; i<name.length(); i++){
            sum = sum + (int)name.charAt(i);
        }
        //Conseguir el valor del id que esta entre el 1 y 10
        id = (sum % 10) + 1;
        boolean encontrado = false;
        Integer key = 0;
        for(HashMap.Entry<Integer,ArrayList<Persona>> entry : map.entrySet()){
            key = entry.getKey();
            if(id == key){
                encontrado = true;
                ArrayList<Persona> value = entry.getValue();
                busquedaBinaria(name,value,0,value.size()-1,key);
                break;
            }
        }
        if(encontrado == false){
            System.out.println("Usuario no encontrado");
        }
    }
    void busquedaBinaria(String name, ArrayList<Persona> value, int min, int max, int key){
        if(max < min){
            System.out.println("Usuario no encontrado");
        }
        else{
            int promedio = (min + max) / 2;
            if(value.get(promedio).getNombre().equals(name)){
                System.out.println("Usuario encontrado con la llave: " + key + " y posicion: " + promedio);
            }
            else if(value.get(promedio).getNombre().compareTo(name) < 0){
                min = promedio + 1;
                busquedaBinaria(name, value, min, max, key);
            }
            else if(value.get(promedio).getNombre().compareTo(name) > 0){
                max = promedio - 1;
                busquedaBinaria(name, value, min, max, key);
            }
        }
    }
    void ordenar(int llave){
        if(llave == 0){
            for(HashMap.Entry<Integer,ArrayList<Persona>> entry : map.entrySet()){
                ArrayList <Persona> value = entry.getValue();
                quicksort(value,0,value.size()-1);
            }
        }
        else{
            for(HashMap.Entry<Integer,ArrayList<Persona>> entry : map.entrySet()){
                Integer key = entry.getKey();
                ArrayList <Persona> value = entry.getValue();
                if(key == llave){
                    quicksort(value, 0, value.size()-1);
                    break;
                }
            }
        }
    }
    void quicksort(ArrayList<Persona> value, int inf, int sup){
        int i = inf;
        int j = sup;
        String x = value.get((inf + sup) / 2).getNombre();
        while (i<=j) {
            while (value.get(i).getNombre().compareTo(x) < 0) {
                i = i+1;
            }
            while (value.get(j).getNombre().compareTo(x) > 0) {
                j = j-1;
            }
            if(i<=j){
                String temp = value.get(i).getNombre();
                value.get(i).setNombre(value.get(j).getNombre());
                value.get(j).setNombre(temp);
                i = i + 1;
                j = j - 1;
            }
        }
        if(inf < j){
            quicksort(value, inf, j);
        }
        if(i<sup){
            quicksort(value, i, sup);
        }
    }
}
