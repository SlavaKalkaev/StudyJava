public abstract class Animal {
    protected String name;
    protected String poroda;
    public Animal(String name, String poroda){
        this.name = name;
        this.poroda = poroda;
    }

    public abstract void makeNoise() ;
    public abstract void eat();
    public abstract String getDescription();


}
class Pi{
    public static void main(String[] args) {
        Veterinar veterinar = new Veterinar("vitya",15);
        Animal[] animals = new Animal[2];
        animals[0]= new Dog("bibi","dalamat");
        animals[1] = new Bear("aa","buriy");
        for (Animal animal : animals){
            veterinar.treetAnimal(animal);
        }
        animals[0].eat();
        animals[0].makeNoise();
        animals[1].getDescription();
    }

    }