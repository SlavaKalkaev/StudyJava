public class Bear extends Animal{
    public Bear(String name, String poroda) {
        super(name, poroda);
    }

    @Override
    public void makeNoise() {
        System.out.println("aaaa");
    }

    @Override
    public void eat() {
        System.out.println("all");

    }

    @Override
    public String getDescription() {
        return name;
    }
}