public class Aspirant extends Student {
    String work;
    public Aspirant(String firstName,
                    String lastName,
                    int group,
                    double averageMark,
                    String work) {
        super(firstName, lastName, group, averageMark);
        this.work=work;
    }

    @Override
    public int  getScholarship(){
       setStipuxa((getAverageMark()==5) ? 2500: 2200);
    return getStipuxa();
    }
}
class Pupu{
    public static void main(String[] args) {
        Aspirant aspirant = new Aspirant("leha","pyatak",4,5,"work");
        Student vacek = new Student("vacek","lol",5,4.9);
        Student student = new Student("kost","bl4",5,5);
        Aspirant aspirant1 = new Aspirant("kolea","loh",8,3.2,"jopa");
        Student[] students = {aspirant,vacek,student,aspirant1};
        for (int i = 0; i<students.length;i++){
            System.out.println(students[i].getScholarship());
        }
    }
}
