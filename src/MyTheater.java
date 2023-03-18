import org.code.theater.*;
import org.code.media.*;

import java.util.ArrayList;

public class MyTheater {
    public static ArrayList<Image> enzo;
    public static ArrayList<Image> gtr;
    public static ArrayList<Image> porsche;
    public static ArrayList<Image> skyline;
    public static ArrayList<Image> truck;
    public static ArrayList<Image> van;
    public static void main(String[] args) {
        //Scene scene = new Scene();
       // UserInteraction userInteraction = new UserInteraction();

       loadImages();
       System.out.println("Loading Game Data...0%");
       boolean loaded = false;
       while(!loaded){
            System.out.print("");
            if(ImageLoader.finishedLoading){
                UserInteraction userInteraction = new UserInteraction();
                userInteraction.welcome();
                loaded = true;
            }
       }
    }
    private static void loadImages(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                // code goes here.
                enzo = ImageLoader.getImages("enzo");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // code goes here.
                gtr = ImageLoader.getImages("gtr");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // code goes here.
                porsche = ImageLoader.getImages("porsche");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // code goes here.
                skyline = ImageLoader.getImages("skyline");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // code goes here.
                truck = ImageLoader.getImages("truck");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // code goes here.
                van = ImageLoader.getImages("van");
            }
        }).start();
    }
}
