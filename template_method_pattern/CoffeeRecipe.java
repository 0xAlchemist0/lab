import java.util.Scanner;
class CoffeeRecipe extends Recipe {
    @Override
    protected void gatherIngredients() {
        System.out.println("Get ground coffee, water, milk, and sugar.");
    }

    @Override
    protected void prepareFood() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Boil water.");
        System.out.println("Drip hot water through filter and coffee into cup.");

        System.out.println("Would you like milk and sugar with your coffee? (y/n)");
        String answer = sc.nextLine().toLowerCase();

        if (answer.equals("y")) {
            System.out.println("Add milk and sugar.");
        } else {
            System.out.println("No milk or sugar added.");
        }
    }
}