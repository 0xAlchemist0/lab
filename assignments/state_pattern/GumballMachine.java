package assignments.state_pattern;

import java.util.Random;

public class GumballMachine {
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;

    State state;
    int count = 0;
    Random randomWinner = new Random(System.currentTimeMillis());

    public GumballMachine(int numberGumballs){
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);

        this.count = numberGumballs;
        if(numberGumballs > 0){
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }

    public void insertQuarter(){ state.insertQuarter(); }
    public void ejectQuarter(){ state.ejectQuarter(); }
    public void turnCrank(){ 
        state.turnCrank();
        state.dispense();
    }

    void releaseBall(){
        System.out.println("A gumball comes rolling out the slot...");
        if(count > 0) count--;
    }

    public int getCount(){ return count; }

    public void refill(int count){
        this.count += count;
        System.out.println("Machine refilled. Count: " + this.count);
        if(state == soldOutState){
            state = noQuarterState;
        }
    }

    // State setters and getters
    public void setState(State state){ this.state = state; }
    public State getSoldOutState(){ return soldOutState; }
    public State getNoQuarterState(){ return noQuarterState; }
    public State getHasQuarterState(){ return hasQuarterState; }
    public State getSoldState(){ return soldState; }
    public State getWinnerState(){ return winnerState; }
}
