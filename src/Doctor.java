public class Doctor extends Person{
        private Integer medical_id;
        private String specialisation;

        public Doctor(String n, String sn, String dob, String mobno, Integer ID, String specialisation) {
            super(n, sn, dob, mobno);
            this.medical_id = ID;
            this.specialisation = specialisation;
        }

        public int getID() {
            return this.medical_id;
        }

        public String doctor_surname() {
            return super.getSurname();
        }

        public String doctor_details() {
            return (String.format(
                    "Name: %s %s\nContact no: %s\nDate of birth: %s\nMedical license no: %04d\nSpecialized field: %s\n",
                    super.getName(), super.getSurname(), super.getmob(),
                    super.getDob(), this.medical_id, this.specialisation));
        }

        public String save_details() {
            return (String.format("%s %s %s %s %04d %s", super.getName(), super.getSurname(),
                    super.getDob(), super.getmob(), this.medical_id, this.specialisation));
        }

        public void update_doctorID(Integer ID) {
            this.medical_id = ID;
        }

        public String update_doctorSpec() {
            return this.specialisation;
        }
    }
