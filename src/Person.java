public class Person {
    private String name;
    private String surname;
    private String date_of_birth;
    private String mob_no;

    public Person(String n, String sn, String dob, String mobno) {
        this.name = n;
        this.surname = sn;
        this.date_of_birth = dob;
        this.mob_no = mobno;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getDob() {
        return this.date_of_birth;
    }

    public String getmob() {
        return this.mob_no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setMob_no(String mob_no) {
        this.mob_no = mob_no;
    }
}
