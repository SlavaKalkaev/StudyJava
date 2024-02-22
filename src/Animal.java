public abstract class Animal {
    protected String name;
    protected String poroda;
    public Animal(String name, String poroda){
        this.name = name;
        this.poroda = poroda;
    }

    public  void makeNoise(){
        System.out.println("sound");
    } ;
    public  void eat(){
        System.out.println("food");
    };

    public  String getDescription() {
        return "1";
    }
            ;


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
        for (Animal animal : animals){
            animal.makeNoise();
            animal.eat();
        }
    }

    }