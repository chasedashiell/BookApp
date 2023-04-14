import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

class BookCSVasList {
    private ArrayList<Book> list = new ArrayList<>();
    private Book header;

    public BookCSVasList(String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            ArrayList<Book> allBooks = new ArrayList<>();
            String line = reader.readLine();
            header = Book.parseFromCsvString(line);
            line = reader.readLine();
            while (line != null) {
                allBooks.add(Book.parseFromCsvString(line));
                line = reader.readLine();
            }
            this.list = allBooks;
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // public void sort(int by) {
    //     for (int i = 1; i < list.size(); i++){
    //         Book minValue = list.get(i);
    //         int minIndex = i;
    //         for (int j = i; j< list.size(); i++){
    //             if (minValue.compareTo(list.get(j), by) < 0){
    //                 minValue = list.get(j);
    //                 minIndex = j;
    //             }
    //         }
    //         Book tmp = list.get(i);
    //         list.set(i, list.get(minIndex));
    //         list.set(minIndex, tmp);
    //     }
    // }
    public void sort() {
        Collections.sort(list);
    }

    public void sortByFirstName() {
        Collections.sort(list, new FirstNameComparator());
    }

    public ArrayList<Book> getList() {
        return list;
    }

    public void printCollection() {
        System.out.println(header);
        for (Book b : list) {
            System.out.println(b);
        }
    }

}