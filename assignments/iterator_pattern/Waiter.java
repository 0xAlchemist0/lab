package assignments.iterator_pattern;

import java.util.Iterator;

public class Waiter {
    private Menu breakfastMenu;
    private Menu dinnerMenu;

    public Waiter() {
        breakfastMenu = new BreakfastMenu();
        dinnerMenu = new DinnerMenu();
    }

    public void printMenu() {
        System.out.println("------ Breakfast ------");
        printMenu(breakfastMenu.createIterator());

        System.out.println("------ Dinner ------");
        printMenu(dinnerMenu.createMyIterator());
    }

    private void printMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem item = iterator.next();
            System.out.printf("%s, %.2f -- %s%n", item.getName(), item.getPrice(), item.getDescription());
        }
    }

    private void printMenu(MyIterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem item = iterator.next();
            System.out.printf("%s, %.2f -- %s%n", item.getName(), item.getPrice(), item.getDescription());
        }
    }
}
