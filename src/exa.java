public class exa {
    public static void main(String[] args) {
        double[]promedios={11.7,10,6.6,5,1.8,7,5,10,8,5.5};
        double[]nuevosValores=new double[10];
        for(int i=0;i<promedios.length;i++){
            nuevosValores[i]=promedios[i]*2;
            System.out.println(nuevosValores[i]);

        }
    }
}
