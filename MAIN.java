import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.*;   


public class MAIN {
    public static void main(String[] args) {
        
        BookCSVasList b1 = new BookCSVasList("C:\\Users\\230010154\\JAVA\\BookApp\\books.csv");
        b1.sortByFirstName();
        b1.printCollection();

       

    }
}
