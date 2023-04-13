import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

class BookCSVasList {
    private static ArrayList<Book> list = new ArrayList<>();

    public BookCSVasList(String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            ArrayList<Book> allBooks = new ArrayList<>();
            String line = reader.readLine();
            while (line != null) {
                allBooks.add(Book.parseFromCsvString(line));
                line = reader.readLine();
            }
            list = allBooks;
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void sortAndRemoveDuplicates(int by) {
        for (int i = 1; i < list.size() - 1; i++) {
            Book minValue = list.get(i);
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j), by) > 1) {
                    minValue = list.get(j);
                    minIndex = j;
                }
            }
            Book tmp = list.get(i);
            list.set(i, minValue);
            list.set(minIndex, tmp);
        }
    }

    public ArrayList<Book> getList() {
        return list;
    }

}