public class Student {
    private String firstName;
    private String lastName;
    private int group;
    private double averageMark;
    private int stipuxa;
    public Student(String firstName,
                   String lastName,
                   int group,
                   double averageMark){
        this.averageMark=averageMark;
        this.firstName=firstName;
        this.group=group;
        this.lastName=lastName;
    }
    public int getScholarship(){
        setStipuxa ((averageMark==5)? 2000 : 1900);
    return getStipuxa();
    }
    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }
    public String getFirstName(String firstName){
        return firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastNam(String lastName){
        return lastName;
    }
    public void setGroup(int group) {
        this.group = group;
    }
    public int getGroup(int group){
        return group;
    }
    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }
    public double getAverageMark(){
        return averageMark;
    }
    public int getStipuxa(){
        return stipuxa;
    }
    public void setStipuxa(int stipuxa){
        this.stipuxa = stipuxa;
    }
}

