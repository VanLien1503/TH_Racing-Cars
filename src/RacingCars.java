import sun.tools.jar.Main;

import java.util.Random;

public class RacingCars implements Runnable {


    private String name;
    public RacingCars(String name){
        this.name=name;
    }
    public int DISTANCE = 100;
    public  int STEP = 2;

    @Override
    public void run() {
        // khởi tạo điểm start
        int runDistance = 0;
        // khởi tạo thời gian bắt đầu cuộc đua
        long starTime = System.currentTimeMillis();

        // ktra xem con xe chưa kết thúc
        while (runDistance<DISTANCE){
            try {
                int speed = (new Random()).nextInt(20);
                runDistance += speed;
                String log = "|";
                int percentTravel = (runDistance*100)/DISTANCE;
                for (int i=0;i<DISTANCE;i+=STEP){
                    if (percentTravel >= i + STEP) {
                        log+="=";
                    }else if (percentTravel>=i&&percentTravel<i+STEP){
                        log+="o";
                    }else {
                        log+="-";
                    }
                }
                log+="|";
                System.out.println("Car" + this.name + ": " + log + " " + Math.min(DISTANCE, runDistance) + "KM");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Car" + this.name + " broken...");
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Car" + this.name + " Finish in " + (endTime -starTime) / 1000 + "s");
    }
}
