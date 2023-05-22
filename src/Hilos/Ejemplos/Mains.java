package Hilos.Ejemplos;

class Runner1e implements Runnable{
    @Override
    public void run(){
        for (int i=0; i< 1000; ++i)
            System.out.println("Runner1: "+ i);
    }
}
class Runner2e implements Runnable{
    @Override
    public void run(){
        for (int i=0; i< 1000; ++i)
            System.out.println("Runner2: "+ i);
    }
}

public class Mains {
    public static void main (String[] args){
        System.out.println("Jaqueline Zaldivar Miranda");
        Thread t1 = new Thread (new Runner1e());
        Thread t2 = new Thread (new Runner2e());

        t1.start();
        t2.start();
    }
}
