package assignments.iterator_pattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class BreakfastMenuIterator implements Iterator<MenuItem> {
    private ArrayList<MenuItem> items;
    private int position = 0;

    public BreakfastMenuIterator(ArrayList<MenuItem> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return items != null && position < items.size();
    }

    @Override
    public MenuItem next() {
        if (!hasNext()) throw new NoSuchElementException();
        return items.get(position++);
    }
}
