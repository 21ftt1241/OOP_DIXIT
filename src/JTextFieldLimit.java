import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

// Create a class that extend a plain document to read text area object
public class JTextFieldLimit extends PlainDocument {
  // Instance variable for the text field limit
    private int limit;
    JTextFieldLimit(int limit) {
      super();
      this.limit = limit;
    }
    
    // Set the upper limit of the text field
    JTextFieldLimit(int limit, boolean upper) {
      super();
      this.limit = limit;
    }
    
    // method to prevent any new input inside the text area if character reach defined character limit
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
      if (str == null)
        return;
      
        // If the limit is reach, disable the input
      if ((getLength() + str.length()) <= limit) {
        super.insertString(offset, str, attr);
      }
    }
  }