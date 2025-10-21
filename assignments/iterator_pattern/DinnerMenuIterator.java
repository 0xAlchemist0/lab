// DinnerMenuIterator.java
package assignments.iterator_pattern;

public class DinnerMenuIterator implements MyIterator<MenuItem> {
    private MenuItem[] items;
    private int position = 0;

    public DinnerMenuIterator(MenuItem[] items) { this.items = items; }

    @Override
    public boolean hasNext() {
        return position < items.length && items[position] != null;
    }

    @Override
    public MenuItem next() {
        return items[position++];
    }
}
