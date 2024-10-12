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

    /**
     * @author Wade Little
     * Calls on the user.buyItem(Item item) method/
     * @param user The user that is attempting to buy the item
     * @param item The item the user wants to buy
     * @return True if the user successfully purchases the item. False if they already own it or don't have enough coins.
     */
    public boolean purchaseItem(User user, Item item) {
       return user.buyItem(item);
    }
    /**
     * @author Wade Little
     * Gets the selected items information in a String
     * @param item The item the user wants to view.
     * @return The items properties in a String
     */
    public String getItem(Item item) {
        return item.toString();
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
