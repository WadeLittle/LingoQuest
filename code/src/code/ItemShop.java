package code;

import java.util.ArrayList;

public class ItemShop {
    
    private ArrayList<Item> items;
    private static ItemShop itemShop;

    // Constructor
    private ItemShop() {
        items = new ArrayList<Item>;
    }

    /**
     * @author Cade Stocker
     * @return the instance of itemShop
     */
    public static ItemShop getInstance() {
        if(itemShop == null) {
            itemShop = new ItemShop();
        }
        return itemShop;
    }

    public boolean purchaseItem(Item item) {
        return false;
    }

    private void addItem(Item item) {
    }

    public Item getItem() {
        return null;
    }

    public ArrayList<Item> getItems() {
        return null;
    }

    private void removeItem(Item item) {
    }

    public void displayItemShop() {
    }

    public void loadItems() {
    }

    public void saveItems() {
    }
}
