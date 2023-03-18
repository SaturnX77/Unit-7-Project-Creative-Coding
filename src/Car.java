public class Car {

    private String carName;
    private int horsepower;
    private int grip;
    private int weight;
    private int downforce;

    public Car(){

    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public void setGrip(int grip) {
        if(grip > 10){
            grip = 10;
        } else if (grip < 1) {
            grip = 1;
        }
        this.grip = grip;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setDownforce(int downforce) {
        if(downforce > 10){
            downforce = 10;
        } else if (downforce < 1) {
            downforce = 1;
        }
        this.downforce = downforce;
    }
    public String getCarName() {
        return carName;
    }
    public int getHorsepower() {
        return horsepower;
    }
    public int getGrip() {
        return grip;
    }

    public int getDownforce() {
        return downforce;
    }

    public int getWeight() {
        return weight;
    }
}
