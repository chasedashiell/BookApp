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

    public String toString() {
        return lastName + "," + firstName + "," + title;
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