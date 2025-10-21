package assignments.iterator_pattern;

import java.util.Iterator;

public interface Menu {
    void addItem(String name, String description, boolean vegetarian, double price);
    Iterator<MenuItem> createIterator(); // for Java iterator
    MyIterator<MenuItem> createMyIterator(); // for custom iterator
}
