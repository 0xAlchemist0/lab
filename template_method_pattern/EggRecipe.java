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