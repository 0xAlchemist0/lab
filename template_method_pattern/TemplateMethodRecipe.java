import java.util.Scanner;




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
