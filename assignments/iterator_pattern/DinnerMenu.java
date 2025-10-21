package assignments.iterator_pattern;

public class DinnerMenu implements Menu {
    private static final int MAX_ITEMS = 4;
    private MenuItem[] menuItems;
    private int numberOfItems = 0;

    public DinnerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("Vegetarian BLT", "Fake 'N bacon, lettuce, & tomato on wheat.", true, 2.99);
        addItem("BLT", "Bacon, lettuce, & tomato on wheat.", false, 2.99);
        addItem("Soup of the Day", "Usually chili.", true, 3.49);
        addItem("Hot Dog", "A hot dog on a bun.", false, 1.49);
    }

    @Override
    public void addItem(String name, String description, boolean vegetarian, double price) {
        if (numberOfItems >= MAX_ITEMS) return;
        menuItems[numberOfItems++] = new MenuItem(name, description, vegetarian, price);
    }

    @Override
    public java.util.Iterator<MenuItem> createIterator() {
        return null; // not needed for DinnerMenu
    }

 @Override
public MyIterator<MenuItem> createMyIterator() {
    return new DinnerMenuIterator(menuItems);
}

}
