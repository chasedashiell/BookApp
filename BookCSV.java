import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

class BookCSV {
    ArrayList<Book> list = new ArrayList<>();

    public BookCSV(String path) {
        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            while ((line = reader.readLine()) != null) {
                String[] values = new String[3];
                values = line.split(",");
                Book book = new Book(values[0], values[1], values[2]);
                list.add(book);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        BookCSV b1 = new BookCSV("C:\\Users\\230010154\\Desktop\\java\\BookApp\\Copy of Reading List - Sheet1.csv");
        System.out.println(b1.list.get(12));
    }
}