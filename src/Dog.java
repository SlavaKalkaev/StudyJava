public class Dog extends Animal{
    public Dog(String name, String poroda) {
        super(name, poroda);
    }

    @Override
    public void makeNoise() {
        System.out.println("woof");
    }

    @Override
    public void eat() {
        System.out.println("all");

    }

    @Override
    public String getDescription() {
        return name+poroda;
    }
}
