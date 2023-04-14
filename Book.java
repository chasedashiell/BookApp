import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.ArrayBlockingQueue;

class Book implements Comparable<Book> {
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
        int lastCommaIndex = -1;

        ArrayList<String> tokens = new ArrayList<>();
        for (int curIndex = 0; curIndex < line.length(); curIndex++) {
            String curCharacter = line.substring(curIndex, curIndex + 1);
            if (quoteMode == true) {
                if (curCharacter.equals("\"")) { // closing quote
                    quoteMode = false;
                    tokens.add(line.substring(lastCommaIndex +1, curIndex));
                    // assume there's a comma afterwards
                    curIndex++;
                    lastCommaIndex = curIndex;
                }
            } else {
                if (curCharacter.equals("\"")) { // opening quote
                    quoteMode = true;
                    lastCommaIndex = curIndex;
                } else if (curCharacter.equals(",")) {
                    tokens.add(line.substring(lastCommaIndex+1, curIndex));
                    lastCommaIndex = curIndex;
                }
            }
        }
        return new Book(tokens.get(0), tokens.get(1), tokens.get(2));
    }

    // public int compareTo(Book other, int by) {
    //     if (by == 0) {
    //         return this.getLastName().compareTo(other.getLastName());
    //     } else if (by == 1) {
    //         return this.getFirstName().compareTo(other.getFirstName());
    //     } else if (by == 2) {
    //         return this.getTitle().compareTo(other.getTitle());
    //     }
    //     return 0;
    // }

    public int compareTo(Book other) {
        int compareResult = this.lastName.compareTo(other.lastName);
        if (compareResult == 0) {
            compareResult =  this.firstName.compareTo(other.firstName);
            if (compareResult == 0) {
                return this.title.compareTo(other.title);
            } else {
                return compareResult;
            }
        } else {
            return compareResult;
        }
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

class FirstNameComparator implements Comparator<Book> {
    public int compare(Book b1, Book b2)
    {
        return b1.getFirstName().compareTo(b2.getFirstName());
    }
}