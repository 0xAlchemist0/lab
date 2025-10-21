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