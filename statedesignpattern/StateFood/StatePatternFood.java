interface State {
    public void doAction(Food Food);
}

class OrderState implements State {
    public void doAction(Food Food) {
        System.out.println("Food is ordered");
        Food.setState(this);
    }

    public String toString() {
        return "State: Ordered\n";
    }
}

class PreparingState implements State {
    public void doAction(Food Food) {
        System.out.println("Preparing Food");
        Food.setState(this);
    }

    public String toString() {
        return "State: Preparing\n";
    }
}

class ServedState implements State {
    public void doAction(Food Food) {
        System.out.println("Food is served");
        Food.setState(this);
    }

    public String toString() {
        return "State: Served\n";
    }
}

class Food {
    private State state;

    public Food() {
        state = null;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}

public class StatePatternFood {
    public static void main(String[] args) {
        Food Food = new Food();

        OrderState orderstate = new OrderState();
        orderstate.doAction(Food);
        System.out.println(Food.getState().toString());

        PreparingState preparingstate = new PreparingState();
        preparingstate.doAction(Food);
        System.out.println(Food.getState().toString());

        ServedState servedState = new ServedState();
        servedState.doAction(Food);
        System.out.println(Food.getState().toString());
    }
}