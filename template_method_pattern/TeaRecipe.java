
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