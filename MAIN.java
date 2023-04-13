import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class MAIN {
    public static void main(String[] args) {
        // BookCSV b1 = new BookCSV("C:\\Users\\230010154\\JAVA\\BookApp\\test.csv");
        // System.out.println(b1.list);
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\230010154\\JAVA\\BookApp\\test.csv"));
            ArrayList<Book> allBooks = new ArrayList<>();
            String line = reader.readLine();
            while (line != null) {
                allBooks.add(Book.parseFromCsvString(line));
                line = reader.readLine();
            }
            System.out.println(allBooks);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
