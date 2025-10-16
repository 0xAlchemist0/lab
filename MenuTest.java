import java.util.*;

// ================= MenuItem =================
class MenuItem {
    String name;
    String description;
    boolean vegetarian;
    double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public boolean isVegetarian() { return vegetarian; }
}

// ================= MyIterator (Custom) =================
interface MyIterator {
    boolean hasNext();
    Object next();
}

// ================= Menu Interface =================
interface Menu {
    void addItem(String name, String description, boolean vegetarian, double price);
    Object createIterator(); // Can return either MyIterator or Java Iterator
}

// ================= BreakfastMenu (ArrayList) =================
class BreakfastMenu implements Menu {
    List<MenuItem> menuItems;

    public BreakfastMenu() {
        menuItems = new ArrayList<>();
        addItem("Pancake Breakfast", "Pancakes, eggs, & toast", true, 2.99);
        addItem("Sausage and Pancakes", "Pancakes, eggs, and sausage", false, 2.99);
        addItem("Waffles", "Three waffles.", true, 2.99);
        addItem("Cereal", "Not frosted flakes...", true, 1.49);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        menuItems.add(new MenuItem(name, description, vegetarian, price));
    }

    public Iterator<MenuItem> createIterator() {
        return new BreakfastMenuIterator(menuItems);
    }
}

// ================= BreakfastMenuIterator (Java Iterator) =================
class BreakfastMenuIterator implements Iterator<MenuItem> {
    List<MenuItem> items;
    int position = 0;

    public BreakfastMenuIterator(List<MenuItem> items) {
        this.items = items;
    }

    public boolean hasNext() {
        return position < items.size();
    }

    public MenuItem next() {
        return items.get(position++);
    }
}

// ================= DinnerMenu (Array) =================
class DinnerMenu implements Menu {
    static final int MAX_ITEMS = 4;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinnerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("Vegetarian BLT", "Fake 'N bacon, lettuce, & tomato on whole wheat.", true, 2.99);
        addItem("BLT", "Bacon, lettuce, & tomato on whole wheat.", false, 2.99);
        addItem("Soup of the Day", "Our wonderful soup of the day, usually chili.", false, 3.49);
        addItem("Hot Dog", "A hot dog on a bun, not very interesting.", false, 1.49);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        if (numberOfItems >= MAX_ITEMS) {
            System.out.println("Menu is full! Can't add item.");
        } else {
            menuItems[numberOfItems++] = new MenuItem(name, description, vegetarian, price);
        }
    }

    public MyIterator createIterator() {
        return new DinnerMenuIterator(menuItems);
    }
}

// ================= DinnerMenuIterator (Custom Iterator) =================
class DinnerMenuIterator implements MyIterator {
    MenuItem[] items;
    int position = 0;

    public DinnerMenuIterator(MenuItem[] items) {
        this.items = items;
    }

    public boolean hasNext() {
        return position < items.length && items[position] != null;
    }

    public Object next() {
        return items[position++];
    }
}

// ================= Waiter (Client) =================
class Waiter {
    Menu breakfastMenu;
    Menu dinnerMenu;

    public Waiter() {
        breakfastMenu = new BreakfastMenu();
        dinnerMenu = new DinnerMenu();
    }

    public void printMenu() {
        System.out.println("------ Breakfast ------");
        printMenu((Iterator<MenuItem>) breakfastMenu.createIterator());
        System.out.println("------ Dinner ------");
        printMenu((MyIterator) dinnerMenu.createIterator());
    }

    private void printMenu(MyIterator myIterator) {
        while (myIterator.hasNext()) {
            MenuItem item = (MenuItem) myIterator.next();
            System.out.println(item.getName() + ", " + item.getPrice() + " -- " + item.getDescription());
        }
    }

    private void printMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem item = iterator.next();
            System.out.println(item.getName() + ", " + item.getPrice() + " -- " + item.getDescription());
        }
    }
}

// ================= MenuTest (Main) =================
public class MenuTest {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        waiter.printMenu();
    }
}
