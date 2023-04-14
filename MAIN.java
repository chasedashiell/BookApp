import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.*;

public class MAIN {
    public static void main(String[] args) {

        BookList b1 = new BookList("C:\\Users\\230010154\\Desktop\\java\\BookApp\\test.csv");
        b1.sortByLastName();
        b1.printCollection();
        b1.makeCsv("C:\\Users\\230010154\\Desktop\\java\\BookApp\\test.csv");
    }
}
