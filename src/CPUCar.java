public class CPUCar extends Car{
    public CPUCar(){
        super();
    }
    public void generateCar(){
        System.out.println("Generating computer car...");
        setCarName(generateRandomName());
        setGrip(0);
        setDownforce(0);
        setHorsepower(0);
        setWeight(0);
    }
    public int generateRandom(int minimum, int maximum){
        return (int)(Math.random() * (maximum - minimum)) + minimum;
    }
    @Override
    public void setGrip(int grip) {
        super.setGrip(generateRandom(1,10));
    }
    @Override
    public void setDownforce(int downforce) {
        super.setDownforce(generateRandom(1,10));
    }
    @Override
    public void setHorsepower(int horsepower) {
        super.setHorsepower(generateRandom(1,1500));
    }

    @Override
    public void setWeight(int weight) {
        super.setWeight(generateRandom(1,3000));
    }

    public String generateRandomName(){
        int index = generateRandom(1,6);
        if(index == 1){
            return "enzo";
        } else if (index == 2) {
            return "gtr";
        } else if (index == 3) {
            return "porsche";
        } else if (index == 4) {
            return "skyline";
        } else if (index == 5) {
            return "truck";
        } else if (index == 6) {
            return "van";
        }
        return "enzo";
    }

    public void printCPUCarStats(){
        System.out.println("CPU Car:");
        System.out.println(getCarName());
        System.out.println("Power: " + getHorsepower());
        System.out.println("Weight: " + getWeight());
        System.out.println("Grip: " + getGrip());
        System.out.println("Downforce: " + getDownforce());
    }
}
