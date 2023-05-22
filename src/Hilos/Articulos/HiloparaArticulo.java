package Hilos.Articulos;

public class HiloparaArticulo implements Runnable{
    @Override
    public void run(){
        ArticuloMinorista articulo1=new ArticuloMinorista("Chaqueta", 12,59.95);
        ArticuloMinorista articulo2=new ArticuloMinorista("Jeans de diseñador", 40,34.95);
        ArticuloMinorista articulo3=new ArticuloMinorista("Camisa", 20,24.95);
        System.out.println(articulo1.toString());
        System.out.println(articulo2.toString());
        System.out.println(articulo3.toString());

    }
}
