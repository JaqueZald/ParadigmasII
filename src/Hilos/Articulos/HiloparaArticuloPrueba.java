package Hilos.Articulos;

public class HiloparaArticuloPrueba {
        public static void main(String[] args) {
            System.out.println("Lista de Articulos");
            Thread articulos=new Thread(new HiloparaArticulo());
            articulos.start();
        }
}
