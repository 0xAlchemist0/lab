package assignments.iterator_pattern;

import java.util.ArrayList;
import java.util.Iterator;

public class BreakfastMenu implements Menu {
    private ArrayList<MenuItem> menuItems;

    public BreakfastMenu() {
        menuItems = new ArrayList<>();
        addItem("Pancake Breakfast", "Pancakes, eggs, & toast", true, 2.99);
        addItem("Sausage and Pancakes", "Pancakes, eggs, and sausage", false, 2.99);
        addItem("Waffles", "Three waffles.", true, 2.99);
        addItem("Cereal", "Not frosted flakes...", true, 1.49);
    }

    @Override
    public void addItem(String name, String description, boolean vegetarian, double price) {
        menuItems.add(new MenuItem(name, description, vegetarian, price));
    }

    @Override
    public Iterator<MenuItem> createIterator() {
        return new BreakfastMenuIterator(menuItems);
    }

    @Override
    public MyIterator<MenuItem> createMyIterator() {
        return null; // not needed for BreakfastMenu
    }
}
