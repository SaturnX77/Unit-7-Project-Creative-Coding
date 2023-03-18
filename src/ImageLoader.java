import java.io.File;
import java.util.ArrayList;
import org.code.media.*;

public class ImageLoader {
    public static int counter = 0;
    public static boolean finishedLoading = false;
    static final int numberOfCars = 6;
    public static ArrayList<Image> getImages(String filename){
        ArrayList<Image> temp = new ArrayList<>();
        for(int i = 0; i < 240; i++){
            Image tempI = new Image("src" + File.separator + filename + File.separator + filename + (i+1) + ".png");
            temp.add(tempI);
        }
        counter ++;
        int percentage = (int)((double)counter/numberOfCars * 100);
        System.out.println("Loading Game Data..." + percentage + "%");
        if(percentage == 100){
            finishedLoading = true;
           // System.out.println("doneloading");
        }
        return temp;
    }
}
