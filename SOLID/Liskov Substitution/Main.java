public class Main {
    public static void main(String[] args) {
        Document doc = new PDFDocument();
        doc.open();
        doc.save();
        ((Printable) doc).print();
        // doc.print(); // This will cause a compile-time error since Document does not have a print() method
    }
}
