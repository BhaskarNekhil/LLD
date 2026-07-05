class PDFDocument extends PrintableDocument {
    @Override
    public void open() {
        System.out.println("Opening the PDF Document");
    }
 
    @Override
    public void save() {
        System.out.println("Saving the PDF Document");
    }
 
    @Override
    public void print() {
        System.out.println("Printing the PDF Document");
    }
}