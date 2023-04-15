import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

class BookList {
    private ArrayList<Book> list = new ArrayList<>();
    private Book header;

    public BookList(String path) {
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

    public void makeCsv(String path) {
        try {
            FileWriter writer = new FileWriter(path);
            writer.write("\"" + header.getLastName() + "\"" + "," + "\"" + header.getFirstName() + "\"" + "," + "\""
                    + header.getTitle() + "\"");
            writer.write(System.lineSeparator());
            for (int i = 0; i < list.size(); i++) {
                String currValue = "\"" + list.get(i).getLastName() + "\"" + "," + "\"" + list.get(i).getFirstName()
                        + "\"" + "," + "\"" + list.get(i).getTitle() + "\"";
                writer.write(currValue);
                writer.write(System.lineSeparator());
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void removeDuplicates(){
        for (int i = 0; i < list.size()-1; i++){
            for (int j = i +1; j < list.size(); j++){
                if (list.get(i).compareTo(list.get(j)) == 0){
                System.out.println(list.get(i));
                System.out.println(list.get(j));
                list.remove(i);
            }
            }
            
        }
    }

    public void sort() {
        Collections.sort(list);
    }

    public void sortByFirstName() {
        Collections.sort(list, new ComparatorFirstName());
    }

    public void sortByLastName() {
        Collections.sort(list, new ComparatorLastName());
    }

    public void sortByTitle() {
        Collections.sort(list, new ComparatorTitle());
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