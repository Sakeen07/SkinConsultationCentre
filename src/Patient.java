public class Patient extends Person {
    private Integer patient_id;

    public Patient(String n, String sn, String dob, String mobno, Integer ID) {
        super(n, sn, dob, mobno);
        this.patient_id = ID;
    }

    public Integer getPatient_id() {
        return patient_id;
    }


    public void patient_details() {

        System.out.println(this.patient_id);
    }

    public void setPatient_id(Integer ID) {

        this.patient_id = ID;
    }

    public String saveDetails () {
        return (String.format("%4d %s %s %s %s", this.patient_id, super.getName(), super.getSurname(),
                super.getDob(), super.getmob()));
    }
}
