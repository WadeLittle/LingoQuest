package lingoQuest_package;

import java.util.ArrayList;

public class ItemShop {
    
    private ArrayList<Item> items;
    private static ItemShop itemShop;

    /**
     * @author Cade Stocker
     * private because ItemShop is a singleton
     * creates the arraylist of type item
     */
    private ItemShop() {
        items = new ArrayList<Item>();
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

    
    public boolean purchaseItem(User user, Item item) {
       if(user.ownsItem(item)) {
        return true;
       }
       else if(user)
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
