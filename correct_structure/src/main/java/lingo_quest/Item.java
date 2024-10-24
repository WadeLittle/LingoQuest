package lingo_quest;

import java.util.UUID;

public class Item {
  
    private String name;
    private String description;
    private int price;
    private UUID id;
    //private boolean owned;
    // REFER TO REMOVED getOwned() method below

    /**
     * @author Cade Stocker
     * default constructor doesn't need to do anything specific
     */
    public Item() {
        this.id = UUID.randomUUID();
    }

    /**
     * parameterized constructor
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

    /**
     * @author Cade Stocker
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @author Cade Stocker
     * @return the description of the item
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @author Cade Stocker
     * @return price of the item
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * @author cade
     * @param id
     */
    public void setID(UUID id) {
        this.id = id;
    }

    /**
     * @author cade
     * @return
     */
    public UUID getID() {
        return this.id;
    }


    //public boolean getOwned() {
    //    return this.owned;
    //}
    // CADE STOCKER got rid of this method after
    // adding User: ownsItem(Item):boolean
    // we should check to see if the user has the item
    // rather than seeing if the item is owned

    /**
     * @author Cade Stocker
     * @return a string containing the name, description, and price of the item
     */
    public String toString() {
        return "Name: " + name + " Description: " + description + " Price: " + price;
    }
}

