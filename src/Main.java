public class Main {
    public static int DISTANCE = 100;
    public static int STEP = 2;

    public static void main(String[] args) {
        RacingCars carA=new RacingCars("A");
        RacingCars carB=new RacingCars("B");
        RacingCars carC=new RacingCars("C");

        Thread thread1=new Thread(carA);
        Thread thread2=new Thread(carB);
        Thread thread3=new Thread(carC);

        thread1.start();
        thread2.start();
        thread3.start();


    }
}
