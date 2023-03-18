public class DragRace {
    Car userCar;
    CPUCar cpuCar;

    static int raceCounter = 0;
    public DragRace(Car userCar, CPUCar cpuCar){
        this.userCar = userCar;
        this.cpuCar = cpuCar;
    }
    public void simulateRun(int launch) {
        System.out.println("3");
        System.out.println("2");
        System.out.println("1");
        System.out.println("Go!");
        double userTime = calculateTime(userCar,launch);
        double cpuTime = calculateTime(cpuCar);
        System.out.println("Player time: " + userTime + "sec");
        System.out.println("Computer time: " + cpuTime + "sec");
        getWinner(userTime,cpuTime);
        UserInteraction.playRace(userCar,cpuCar,userTime,cpuTime);
        raceCounter++;
        FileReader.writeRaceTimes("Race: " + raceCounter + "\nPlayer time (seconds): " + userTime + "\nComputer time (seconds): " + cpuTime);
    }
    private double calculateTime(Car car, int launch){
        double weightLBs = car.getWeight() * 2.20462;
        //System.out.println("Weight lbs: " + weightLBs);
        double powerToWeight = (weightLBs/car.getHorsepower());
        //System.out.println("Power to weight: " + powerToWeight);
        //launch = getLaunch()
        double exponent = Math.pow(powerToWeight, (0.33333));
        double runTime = (7 * exponent);
        return runTime + (launch/400) - (car.getGrip()/5) + (car.getDownforce()/10);
    }
    private double calculateTime(Car car){
        double weightLBs = car.getWeight() * 2.20462;
        //System.out.println("Weight lbs: " + weightLBs);
        double powerToWeight = (weightLBs/car.getHorsepower());
        //System.out.println("Power to weight: " + powerToWeight);
        double exponent = Math.pow(powerToWeight, (0.33333));
        double runTime = (7 * exponent);
        return runTime - (car.getGrip()/5) + (car.getDownforce()/10);
    }
    private void getWinner(double userTime, double cpuTime){
        if(cpuTime > userTime){
            System.out.println("Player wins!");

        } else if(cpuTime < userTime){
            System.out.println("Computer wins!");
        } else {
            System.out.println("Its a tie!");
        }
        System.out.println("gap: " + Math.abs(userTime - cpuTime) + "sec");
    }
}
