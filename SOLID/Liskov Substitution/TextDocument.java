public class TextDocument extends Document {
    @Override
    public void open() {
        System.out.println("Opening the Text Document");
    }
 
    @Override
    public void save() {
        System.out.println("Saving the Text Document");
    }
    
}
