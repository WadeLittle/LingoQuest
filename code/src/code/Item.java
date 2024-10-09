package code;
public class Item {
  
    private String name;
    private String description;
    private int price;
    private boolean owned;

    /**
     * @author Cade Stocker
     * default constructor doesn't need to do anything specific
     */
    public Item() {

    }

    /**
     * @author Cade Stocker
     * @param name of the item
     * @param description of the item
     * @param price of the item
     */
    public Item(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
