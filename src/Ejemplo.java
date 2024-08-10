import java.util.HashMap;
import java.util.ArrayList;

public class Ejemplo {
    public static void main(String[] args) {
        //Crear el diccionario (MAP) y agregar elementos
        HashMap<Integer,ArrayList<String>> map = new HashMap<>();
        ArrayList<String> array1 = new ArrayList<>();
        ArrayList<String> array2 = new ArrayList<>();
        array1.add("Jesus");
        array1.add("Ivan");
        array2.add("Mally");
        array2.add("Samira");
        map.put(1, array1);
        map.put(2, array2);
        System.out.println(map);

        //Recorrer el diccionario y obtener las llaves y valores
        for(HashMap.Entry<Integer,ArrayList<String>> entry : map.entrySet()){
            Integer key = entry.getKey();
            ArrayList<String> value = entry.getValue();
            System.out.println("Llave: " + key);
            System.out.println("Valor: ");
            for(int i=0;i<value.size();i++){
                System.out.println(value.get(i));
            }
            System.out.println();
        }
    }
}
