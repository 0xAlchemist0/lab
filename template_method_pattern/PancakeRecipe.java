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