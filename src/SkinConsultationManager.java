import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

interface SkinConsultationManager {
    ArrayList<Doctor> doc = new ArrayList<>(10);

    public static void addDoctor(Scanner sc) {
        System.out.println("\nPlease enter the details as per followed:\n");
        System.out.println("- First Name of Doctor:");
        String fn = sc.nextLine();

        System.out.println("\n- Enter Surname of Doctor:");
        String sn = sc.nextLine();

        System.out.println("\n- Enter date of birth (in the format dd-mm-yyyy):");
        SimpleDateFormat d = new SimpleDateFormat("dd-MM-yyyy");
        String date;

        while (true) {
            try {
                date = d.format(d.parse(sc.nextLine()));
                System.out.println(date);
                break;
            } catch (ParseException e1) {
                System.out.println("\nEnter the date in valid format:");
            }
        }

        System.out.println("\n- Enter mobile number:");
        String mb = sc.nextLine();

        System.out.println("\n- Enter Doctor ID:");
        Integer id = sc.nextInt();

        for (Doctor doctor : doc) {
            if (id == doctor.getID()) {
                while (true) {
                    System.out.println("\nID already exists, re-enter the license ID:");
                    id = sc.nextInt();
                    if (id != doctor.getID())
                        break;
                }
            }
        }

        System.out.println("\n- Enter the field of specialisation:");
        String specialisation = sc.next();

        doc.add(new Doctor(fn, sn, date, mb, id, specialisation));
        System.out.println("Success");
    }

    public static void deleteDoctor(Scanner sc) {
        if (!doc.isEmpty()) {

            System.out.println("\nPlease enter the medical license number:");
            int id = Integer.parseInt(sc.nextLine());

            for (Doctor doctor : doc) {
                if (doctor.getID() == id) {
                    doc.remove(doctor);
                    System.out.println("\nSuccessfully deleted\n");
                    return;
                }
            }
        } else {
            System.out.println("\nPlease appoint a doctor to the centre prior removing.\n");
            return;
        }
        System.out.println("\nLicense number doesn't exist in records\n");
    }

    public static void printDoctor() {
        System.out.println();
        if (!doc.isEmpty()) {
            ArrayList<String> surname = new ArrayList<>(10);
            for (Doctor doctor : doc) {
                surname.add(doctor.doctor_surname());
            }
            Collections.sort(surname);
            for (int i = 0; i < doc.size(); i++) {
                for (Doctor doctor : doc) {
                    if (Objects.equals(surname.get(i), doctor.doctor_surname()))
                        System.out.println(doctor.doctor_details());
                }
            }
            System.out.println();
        } else {
            System.out.println("\nPlease appoint a doctor to the centre prior display info\n");
        }
    }

    public static void saveInfo() {

        try {
            File fileObj = new File("Information.txt");

            System.out.println("\nOverwriting\n");
            FileWriter save = new FileWriter(fileObj.getAbsolutePath());
            for (Doctor doctor : doc) {
                save.write(doctor.save_details() + "\n");
            }
            save.close();

        } catch (IOException e) {
            System.out.println("\nAn error has occurred.\n");
        }
    }

    public static void loadInfo(Scanner sc) {
        String file = "Information.txt";
        File fileObj = new File(file);
        try {
            Scanner read = new Scanner(fileObj);
            try {

                while (read.hasNextLine()) {
                    doc.add(new Doctor(read.next(), read.next(), read.next(), read.next(),
                            Integer.parseInt(read.next()), read.next()));
                }
            } catch (NoSuchElementException e) {
                System.out.println(e);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }
}
