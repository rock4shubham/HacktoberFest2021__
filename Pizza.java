package Java_programs;

// Decorator abstract class
public abstract class Pizza {
    // it is an abstract Decorator
    String name;
    String description;

    public Pizza(String n, String d) {
        this.name = n;
        this.description = d;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public abstract int getCost();

}

// The decorator class : It extends Pizza to be
// interchangable with it topings decorator can
// also be implemented as an interface
abstract class ToppingsDecorator extends Pizza {
    public ToppingsDecorator(String n, String d) {
        super(n, d);
    }

    public abstract String getDescription();
}

class Margherita extends Pizza {
    public Margherita() {
        super("Margherita Pizza", "Margherita");

    }

    public int getCost() {
        return 100;
    }
}

class Chicken extends Pizza {
    public Chicken() {
        super("Chicken Pizza", "Chicken");
    }

    public int getCost() {
        return 200;
    }
}

class Meat extends Pizza {
    public Meat() {
        super("Meat Pizza", "Meat");
    }

    public int getCost() {
        return 350;
    }
}

// Concrete toppings classes
class Tomato extends ToppingsDecorator {
    // we need a reference to obj we are decorating

    Pizza pizza;
    int unit;

    public Tomato(Pizza pizza, int unit) {
        super(pizza.name, pizza.description);
        this.pizza = pizza;
        this.unit = unit;

    }

    public String getDescription() {
        return pizza.getDescription() + " ," + unit + " Tomato";
    }

    public int getCost() {
        return unit * 40 + pizza.getCost();
    }
}

class Onion extends ToppingsDecorator {
    Pizza pizza;
    int unit;

    public Onion(Pizza pizza, int unit) {
        super(pizza.name, pizza.description);
        this.pizza = pizza;
        this.unit = unit;

    }

    public String getDescription() {
        return pizza.getDescription() + " ," + unit + " Onion";
    }

    public int getCost() {
        return unit * 40 + pizza.getCost();
    }
}

class Oliven extends ToppingsDecorator {
    Pizza pizza;
    int unit;

    public Oliven(Pizza pizza, int unit) {
        super(pizza.name, pizza.description);
        this.pizza = pizza;
        this.unit = unit;
    }

    public String getDescription() {
        return pizza.getDescription() + " ," + unit + " Oliven";
    }

    public int getCost() {
        return (unit) * 30 + pizza.getCost();
    }
}

// Driver class and method
class PizzaStore {
    public static void main(String args[]) {
        // create new margherita pizza
        Pizza pizza = new Meat();
        // decorate it with 1 tomato topping
        pizza = new Tomato(pizza, 1);

        // decorate it with 2 Onion topping
        pizza = new Onion(pizza, 2);

        // decorate it with 2 Oliven topping
        pizza = new Oliven(pizza, 2);

        System.out.println(pizza.getName() + "\n" + pizza.getDescription() + "\nCost :" + pizza.getCost());

    }
}
