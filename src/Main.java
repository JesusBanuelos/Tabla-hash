import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tabla tabla = new Tabla();
        Scanner scan = new Scanner(System.in);
        int opc=0;
        do{
            System.out.println("Menu principal");
            System.out.println("1. Ingresar usuarios");
            System.out.println("2. Mostrar Usarios");
            System.out.println("3. Buscar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Modificar usuario");
            System.out.println("6. Ordenar lista de usuarios");
            System.out.println("7. Salir.");
            System.out.print("Ingrese la opcion deseada: ");
            opc=scan.nextInt();
            scan.nextLine();
            switch (opc) {
                case 1:
                    ingresar(tabla);
                    break;
                case 2:
                    mostrar(tabla);
                    break;
                case 3:
                    buscar(tabla);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    ordenar(tabla);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        }while(opc!=7);        
    }
    public static void ingresar(Tabla tabla){
        Scanner scan = new Scanner(System.in);
        int num;
        String name;
        System.out.print("Cuantos usuarios deseas ingresar? ");
        num = scan.nextInt();
        scan.nextLine();
        for(int i=0;i<num;i++){
            System.out.print("Ingrese el nombre: ");
            name = scan.nextLine();
            tabla.ingresarMap(name);
        }
    }
    public static void mostrar(Tabla tabla){
        int opc=0;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("1. Mostrar toda la tabla");
            System.out.println("2. Mostrar por llave");
            System.out.println("3. Regresar al menu anterior");
            System.out.print("Ingrese la opcion deseada: ");
            opc=scan.nextInt();
            scan.nextLine();
            switch (opc) {
                case 1:
                    tabla.imprimirTodo();
                    break;
                case 2:
                    int num;
                    System.out.print("Ingrese la llave que desea mostrar: ");
                    num = scan.nextInt();
                    scan.nextLine();
                    tabla.imprimirPorLlave(num);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }while(opc!=3);
    }
    public static void buscar(Tabla tabla){
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese el usuario a buscar: ");
        String name = scan.nextLine();
        tabla.busqueda(name);
    }
    public static void ordenar(Tabla tabla){
        Scanner scan = new Scanner(System.in);
        int opc = 0;
        do{
            int llave = 0;
            System.out.println("1. Ordenar toda la tabla");
            System.out.println("2. Ordenar valores de una llave");
            System.out.println("3 Regresar al menu anterior");
            System.out.print("Ingrese la opcion deseada: ");
            opc = scan.nextInt();
            scan.nextLine();
            switch (opc) {
                case 1:
                    tabla.ordenar(llave);
                    break;
                case 2:
                    System.out.print("Ingrese la llave que desea ordenar: ");
                    llave = scan.nextInt();
                    scan.nextLine();
                    tabla.ordenar(llave);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }while(opc!=3);
    }
}
