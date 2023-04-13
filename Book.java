import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

class Book {
    private String lastName;
    private String firstName;
    private String title;
    private boolean read = true;
    static int bookCount = 0;

    public Book(String lastName, String firstName, String title) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.title = title;
        bookCount += 1;
    }

    public static Book parseFromCsvString(String line) {
        line += ",";
        // assume last, first, title

        boolean quoteMode = false;
        int lastCommaIndex = 0;

        ArrayList<String> tokens = new ArrayList<>();
        for (int curIndex = 0; curIndex < line.length(); curIndex++) {
            String curCharacter = line.substring(curIndex, curIndex + 1);
            if (quoteMode == true) {
                if (curCharacter.equals("\"")) { // closing quote
                    quoteMode = false;
                    tokens.add(line.substring(lastCommaIndex + 1, curIndex));
                    // assume there's a comma afterwards
                    curIndex++;
                    lastCommaIndex = curIndex;
                }
            } else {
                if (curCharacter.equals("\"")) { // opening quote
                    quoteMode = true;
                    lastCommaIndex = curIndex;
                } else if (curCharacter.equals(",")) {
                    tokens.add(line.substring(lastCommaIndex + 1, curIndex));
                    lastCommaIndex = curIndex;
                }
            }
        }
        return new Book(tokens.get(0), tokens.get(1), tokens.get(2));
    }

    public int compareTo(Book other, int by) {
        if (by == 0) {
            String lastName1 = this.getLastName();
            String lastName2 = other.getLastName();
            return lastName1.compareTo(lastName2);
        } else if (by == 1) {
            String fistName1 = this.getFirstName();
            String firstName2 = other.getFirstName();
            return fistName1.compareTo(firstName2);
        } else if (by == 2) {
            String title1 = this.getTitle();
            String title2 = other.getTitle();
            return title1.compareTo(title2);
        }
        return 0;
    }

    public String toString() {
        return "\"" + title + "\"" + " by " + firstName + " " + lastName;
    }

    public static int getBookCount() {
        return bookCount;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}