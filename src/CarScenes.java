import org.code.theater.Scene;
import org.code.media.*;
import java.util.ArrayList;

public class CarScenes extends Scene {
    public static boolean transitionFinished = false;
    public CarScenes(ArrayList<Image> car){
        loadCarPreview(car);
    }
    public CarScenes(Car car, CPUCar cpuCar){
        transitionScene(car, cpuCar);

    }
    public CarScenes(Car car, CPUCar cpuCar, double userTime, double cpuTime){
        raceScene(car,cpuCar,userTime,cpuTime);
    }
    private void loadCarPreview(ArrayList<Image> car){
        //car = ImageLoader.getImages(car);
        for(int i = 0; i < car.size(); i ++){
            clear("black");
            drawImage(car.get(i),0,0,400);
            pause(0.1);
            if(i % 60 == 0){
                System.out.println("Loading car preview..." + ((double)i/car.size() * 100) + "%");
            }
        }
        System.out.println("Loading car preview...100.0%");
    }

//    private void loadCarPreview(ArrayList<Image> car, int frames){
//        for(int i = 0; i < frames; i ++){
//            drawImage(car.get(i),0,0,400);
//            pause(0.1);
//            if(i % 60 == 0){
//                System.out.println("Loading car preview..." + ((double)i/frames * 100) + "%");
//            }
//        }
//        System.out.println("Loading car preview...100.0%");
//    }

    private void transitionScene(Car car, CPUCar cpuCar){
//        fadeTransition();
//        loadCarPreview(UserInteraction.getCarArrayList(cpuCar.getCarName()),80);
        fadeTransition();
        clear("silver");
        drawImage(UserInteraction.getCarArrayList(car.getCarName()).get(214),-200,0,400);
        drawImage(UserInteraction.getCarArrayList(cpuCar.getCarName()).get(86),200,0,400);
        drawImage("src/computerImage.png",200,350,200);
        drawImage("src/playerImage.png", 20,350,150);
        drawImage("src/vsImage.png", 100,0,200);
        System.out.println("Get ready to race...");
        transitionFinished = true;
    }
    private void fadeTransition(){
        clear("black");
        pause(0.5);
        clear("gray");
        pause(0.5);
        clear("silver");
        pause(0.5);
        clear("gray");
        pause(0.5);
        clear("black");
    }
    private void raceScene(Car car,CPUCar cpuCar,double userTime, double cpuTime){
        fadeTransition();
        clear("green");
        drawImage("src/road-pixelized.png",0,0,400);
        drawImage("src/minis/" + car.getCarName() + "-mini.png",0,10,50);
        drawImage("src/minis/" + cpuCar.getCarName() + "-mini.png",0,55,50);
        double loopLength;
        boolean playerWins = false;
        if(userTime > cpuTime){
            loopLength = userTime;
        } else {
            loopLength = cpuTime;
            playerWins = true;
        }
        double time = 0;
        for(double i = 0.0; i < loopLength*10; i++){
            clear("green");
            drawImage("src/road-pixelized.png",0,0,400);
            drawImage("src/minis/" + car.getCarName() + "-mini.png",(int)(i * 380/(userTime/0.1)),10,50);
            drawImage("src/minis/" + cpuCar.getCarName() + "-mini.png",(int)(i * 380/(cpuTime/0.1)),55,50);
            drawText("Time: " + time + " sec",80,300);
            time += 0.1;
            pause(0.1);
        }
        if(playerWins){
            drawText("PLAYER WINS!", 130,250);
        } else {
            drawText("COMPUTER WINS!", 80, 250);
        }
        drawText("Gap: " + (Math.abs(userTime - cpuTime) + " sec"), 80,350);

    }
}
