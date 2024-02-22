public class Veterinar {
    private String name;
    private int workYear;
    public Veterinar(String name,int workYear){
        this.name = name;
        this.workYear = workYear;

    }

public void treetAnimal(Animal animal){
        System.out.println(animal.name+ "  " + animal.poroda + "  " +  animal.getDescription());
}
}
