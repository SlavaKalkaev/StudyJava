public class Reader {
    private String name;
    private int ticketNumber;
    private String course;
    private double birth;
    private int phoneNumber;

    public Reader(int PhoneNumber,
                  int numberTicket,
                  int birth,
                  String name,
                  String course) {
        this.phoneNumber = PhoneNumber;
        this.ticketNumber = numberTicket;
        this.birth = birth;
        this.name = name;
        this.course = course;
    }

    public Reader() {
    }

    public void takeBook(int valueBook) {
        System.out.println(name + " take " + valueBook + " books");
    }

    public void takeBook(String  name,String message,String... nameBooks) {
        System.out.print(name+message  );
        for (int i = 0 ; i<nameBooks.length; i++) {
            System.out.println(nameBooks[i]);
        }
    }

    public void returnBook(int  valueBook) {
        System.out.println(name + " vernul " + valueBook + " books");
    }

    public void returnBook(String  name,String message,String... nameBooks) {
        System.out.print(name+message  );
            for (int i = 0 ; i<nameBooks.length; i++){
                System.out.print( nameBooks[i]+ ',');}
    }
    public void setNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getNumber(int phoneNumber) {
        return phoneNumber;
    }

    public void setNumberTicket(int numberTicket) {
        this.ticketNumber = numberTicket;
    }

    public int getNumberTicket() {
        return ticketNumber;
    }

    public void setBirth(double birth) {
        this.birth = birth;
    }

    public double getBirht() {
        return birth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }
}

class Lauch {
    public static void main(String[] args) {
        Reader Human = new Reader();
        Human.setBirth(20.11);
        Human.setCourse("itae");
        Human.setName("slava");
        Human.setNumber(898527652);
        Human.setNumberTicket(5);
        Human.takeBook(6);
        Human.takeBook("slava ", " взял ", " discovery, science, math ");
        Human.returnBook(7);
        Human.returnBook("slava ","вернул " ,"da", "net", "no");
    }
}

