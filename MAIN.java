import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.*;

public class MAIN {
    public static void main(String[] args) {

        BookList b1 = new BookList("C:\\Users\\dashc\\java coding stuff\\BookApp\\books.csv");
        b1.sortByLastName();
        b1.removeDuplicates();
        b1.makeCsv("C:\\Users\\dashc\\java coding stuff\\BookApp\\test.csv");
    }
}
