# Instructions

In this assignment you will utilize the base code located on github Template Method Pattern Assignment Base CodeLinks to an external site.. You will need to identify how to refactor the code in order to implement usage of the Template Method Pattern and execute said refactor.

1. Identify the issues with the code
   - Ensure you Identify **_all_** places in which the Template Method Pattern should be applied
   - It is advised to create a UML for this assignment, but it is not necessary
2. Refactor the code to utilize the Template Method Pattern
3. Ensure the code adheres to SOLID coding principles - Ensure your code adheres to all other standards as well
   You only need to refactor the code present.

An **algorithm** is just a **step-by-step process** or **set of instructions** for solving a problem or doing a task.

Think of it like a **recipe** in cooking — it tells you exactly what steps to follow and in what order to get the final dish.

In programming, algorithms are written as code — for example, an algorithm to make toast would be:

1. Get bread.
2. Put it in the toaster.
3. Wait until it pops.
4. Spread butter.
   Same idea — just logical steps the computer can follow to reach a result.

SOLID is a set of five principles that help you write clean, flexible, and maintainable object-oriented code. Here’s a simple breakdown:

S – Single Responsibility Principle (SRP)
Each class should do one thing and have one reason to change.
→ Example: Don’t mix “saving to a database” and “printing a report” in the same class.

O – Open/Closed Principle (OCP)
Code should be open for extension but closed for modification.
→ You should be able to add new features without changing existing code (e.g., using inheritance or interfaces).

L – Liskov Substitution Principle (LSP)
Subclasses should be usable wherever their parent class is used without breaking the program.
→ A child class must behave like its parent, not change expected behavior.

I – Interface Segregation Principle (ISP)
Don’t force a class to implement methods it doesn’t need.
→ Use smaller, more specific interfaces instead of one big one.

D – Dependency Inversion Principle (DIP)
Depend on abstractions, not concrete classes.
→ High-level modules shouldn’t depend directly on low-level modules — both should depend on interfaces.

In short: make code modular, extendable, and easy to change without breaking other parts.

templaye method ex:
public abstract class View {

    // This is our template method

    // It serves as the template for the algorithm in which we will be implementing

    // It is declared final to prevent subclasses from changing the sequence.

    public final void display(){

        setFocus();

        doDisplay();

        if(displayShouldReset()){

            resetDiplay();

        }

    }



    // The concrete methods can be declared as final if you do not want them to be overridden

    public final void setFocus(){

        System.out.println("View::setFocus called");

    }

    public abstract void doDisplay();



    public void resetDiplay(){

        System.out.println("View::resetDiplay called");

    }



    // This method is known as a hook.

    // A hook is a method that is (mostly) empty

    // it is used for optional functionality.

    // A subclass can override this, but should not need to in order to function

    public boolean displayShouldReset(){

        return true;

    }

}

import java.util.Scanner;

public class MyView extends View{

    public void doDisplay(){

        System.out.println("MyView::doDisplay called");

    }



    public boolean displayShouldReset(){

        String answer = "no";

        Scanner scnr = new Scanner(System.in);

        answer = scnr.nextLine();

        if(answer.equalsIgnoreCase("no")) {

            return false;

        }

        return true;

    }

}

public class ViewTester{

    public static void main(String[] args) {

        View myView = new MyView();

        myView.display();

    }

}
