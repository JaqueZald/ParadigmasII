import java.util.Scanner;

public class Tienda {
    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);

        int numeroProductos;
        double total=0;
        System.out.println("Tienda");
        System.out.println("Digita el numero de productos a pagar: ");
        numeroProductos=entrada.nextInt();
        int contador=1;
        while (contador<=numeroProductos){
            System.out.println("Digita el precio del producto"+contador+":");
            double precio=entrada.nextDouble();
            total=total+precio;
            contador++;
        }
        System.out.println("Total: $"+total);
    }
}
