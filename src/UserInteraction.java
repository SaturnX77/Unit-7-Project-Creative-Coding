import org.code.media.Image;
import org.code.theater.Theater;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInteraction {
    private ArrayList<String> carNames = new ArrayList<>();
    public UserInteraction(){
        carNames.add("enzo");
        carNames.add("gtr");
        carNames.add("porsche");
        carNames.add("skyline");
        carNames.add("truck");
        carNames.add("van");
    }
    public void welcome(){
        System.out.println("Welcome to the Theater's premier drag racing experience!");
        System.out.print("Which car body would you like to select?");
        System.out.println(" Options: " + carNames);
        String userInput = getUserInput();
        boolean loaded = false;
        playPreview(userInput);
        setStats(userInput);
    }
    public void setStats(String carName){
        Car userCar = new Car();
        userCar.setCarName(carName);
        System.out.println("\nHow much horsepower should your car have?");
        userCar.setHorsepower(getUserInput(true));
        System.out.println("How much grip should your car have [1-10]");
        userCar.setGrip(getUserInput(true));
        System.out.println("How much should your car weigh (kg)?");
        userCar.setWeight(getUserInput(true));
        System.out.println("How much downforce should your car have? [1-10]");
        userCar.setDownforce(getUserInput(true));
        CPUCar cpuCar = new CPUCar();
        cpuCar.generateCar();
        cpuCar.printCPUCarStats();
        playPreview(cpuCar.getCarName());
        playTransition(userCar,cpuCar);
        runDragRace(userCar,cpuCar);
    }

    private void runDragRace(Car car, CPUCar cpuCar){
        if(CarScenes.transitionFinished) {
            DragRace dragRace = new DragRace(car,cpuCar);
            dragRace.simulateRun(getLaunch());
        }

    }
    private int getLaunch(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number 1 to 100 [getting closer to the computer's random number gives you a better launch]");
        int userInput = scanner.nextInt();
        if(userInput > 100){
            userInput = 100;
        } else if(userInput < 1){
            userInput = 1;
        }
        int computerNumber = (int)(Math.random() * (1 - 101)) + 1;
        return Math.abs(userInput-computerNumber);
    }

    private String getUserInput(){
        Scanner scanner = new Scanner(System.in);
        String temp = scanner.next();
        //scanner.close();
        return temp;
    }
    private int getUserInput(boolean integer){
        Scanner scanner = new Scanner(System.in);
        int temp = scanner.nextInt();
        //scanner.close();
        return temp;
    }
    private void playPreview(String carName){
        CarScenes carScenes = new CarScenes(getCarArrayList(carName));
        Theater.playScenes(carScenes);
    }
    private void playTransition(Car car, CPUCar cpuCar){
        CarScenes transitionScene = new CarScenes(car,cpuCar);
        Theater.playScenes(transitionScene);
    }
    public static void playRace(Car userCar, CPUCar cpuCar, double userTime, double cpuTime){
        CarScenes raceScene = new CarScenes(userCar,cpuCar,userTime,cpuTime);
        Theater.playScenes(raceScene);
    }

    public static ArrayList<Image> getCarArrayList(String carName){
        if(carName.equalsIgnoreCase("enzo")){
            return MyTheater.enzo;
        } else if (carName.equalsIgnoreCase("gtr")) {
            return MyTheater.gtr;
        } else if (carName.equalsIgnoreCase("porsche")){
            return MyTheater.porsche;
        } else if (carName.equalsIgnoreCase("skyline")) {
            return MyTheater.skyline;
        } else if (carName.equalsIgnoreCase("truck")) {
            return MyTheater.truck;
        } else if (carName.equalsIgnoreCase("van")) {
            return MyTheater.van;
        }
        return null;
    }
}
