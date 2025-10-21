import java.util.Scanner;

abstract class Recipe {
    public final void makeBreakfast() { 
        greet();
        gatherIngredients();
        prepareFood();
        serve();
    }

    protected void greet() {
        System.out.println("Let's make your breakfast!");
    }

    //must be implemented in my sublasses

    protected abstract void gatherIngredients();
    protected abstract void prepareFood();

    protected void serve() {
        System.out.println("Serve on a plate and enjoy!\n");
    }
}

class EggRecipe extends Recipe {
    @Override
    protected void gatherIngredients() {
        System.out.println("Get 2 eggs, 1 tbsp butter, salt, and pepper.");
    }

    @Override
    protected void prepareFood() {
        System.out.println("Crack eggs, whisk, melt butter, cook eggs, and season.");
    }
}
class PancakeRecipe extends Recipe {
    @Override
    protected void gatherIngredients() {
        System.out.println("Get flour, baking powder, sugar, milk, butter, and egg.");
    }

    @Override
    protected void prepareFood() {
        System.out.println("Mix ingredients, pour batter on griddle, flip, and cook.");
    }
}

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

class TeaRecipe extends Recipe {
    @Override
    protected void gatherIngredients() {
        System.out.println("Get tea bag and water.");
    }

    @Override
    protected void prepareFood() {
        System.out.println("Boil water, steep tea bag, and pour into cup.");
    }
}

public class TemplateMethodRecipe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome! Choose your food: eggs or pancakes");
        String food = sc.nextLine().toLowerCase();

        System.out.println("Now choose your drink: coffee or tea");
        String drink = sc.nextLine().toLowerCase();

        Recipe foodRecipe = null;
        switch (food) {
            case "eggs":
                foodRecipe = new EggRecipe();
                break;
            case "pancakes":
                foodRecipe = new PancakeRecipe();
                break;
            default:
                System.out.println("Invalid food choice.");
        }

        Recipe drinkRecipe = null;
        switch (drink) {
            case "coffee":
                drinkRecipe = new CoffeeRecipe();
                break;
            case "tea":
                drinkRecipe = new TeaRecipe();
                break;
            default:
                System.out.println("Invalid drink choice.");
        }

        if (foodRecipe != null) foodRecipe.makeBreakfast();
        if (drinkRecipe != null) drinkRecipe.makeBreakfast();

        sc.close();
    }
}
