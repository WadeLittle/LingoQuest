package code;
class Item {
    private String name;
    private String description;
    private int price;
    private boolean owned;

    // Constructor for Item class
    public Item(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.owned = false;
    }

    // Gets the name of the item
    public String getName() {
        return name;
    }

    // Gets the description of the item
    public String getDescription() {
        return description;
    }

    // Gets the price of the item
    public int getPrice() {
        return price;
    }

    // Returns if the item is owned
    public boolean getOwned() {
        return owned;
    }

    @Override
    public String toString() {
        return "Item{name='" + name + "', description='" + description + "', price=" + price + ", owned=" + owned + '}';
    }
}
