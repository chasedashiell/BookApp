public class MAIN {
    public static void main(String[] args) {
        BookCSVasList b1 = new BookCSVasList("C:\\Users\\230010154\\JAVA\\BookApp\\test.csv");
        b1.sortAndRemoveDuplicates(0);
        System.out.println(b1.getList());

    }
}
