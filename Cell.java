public class Cell {
    private String val; // declaring a private variable "value" this will take input the values --> X,O
                        // or empty

    public Cell() {
        this.val = " "; // Constructor initializing Cell with a default value of an empty space
    }

    public String getVal() { // Other classes use the getValue to get the value stored in the cell
        return val;
    }

    public void setVal(String val) { // Here other classes set the value of the cell. values-->X,O, empty space
        this.val = val;
    }

    public boolean isEmpty() {
        return val == " ";
    }

    @Override
    public String toString() {
        return "| " + getVal() + " |";
    }

}

// So in the cell Class, we declare a String "Value" which means it can be
// String values input to the cell like X,O,empty space. Having defined the
// values, we now use two methods, getValue which is used by the other classes
// to use the value which is stored in the cell
// we also have the setter method which the other classes use to store a value
// in the cell