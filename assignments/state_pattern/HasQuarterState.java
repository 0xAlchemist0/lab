package assignments.state_pattern;

public class HasQuarterState implements State {
    private GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter(){
        System.out.println("You can't insert another quarter");
    }

    @Override
    public void ejectQuarter(){
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank(){
        System.out.println("You turned...");
        if(gumballMachine.getCount() > 1 && Math.random() < 0.1){
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }

    @Override
    public void dispense(){
        System.out.println("No gumball dispensed");
    }
}
