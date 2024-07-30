import java.util.Scanner;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {
    public static void main(String[] args) {
            int option;
            Scanner sc = new Scanner(System.in);
            SkinConsultationManager.loadInfo(sc);

            do {

                System.out.println("""
                1. Add new Doctor
                2. Delete a Doctor
                3. Show the List of the Doctors
                4. Save the File
                5. Exit the System
                Enter The Number of your work that you want to do:\s""");

                option = Integer.parseInt(sc.nextLine());

                switch (option) {
                    case 1 -> {
                        if (doc.size() != 10) {
                            SkinConsultationManager.addDoctor(sc);
                            sc.nextLine();
                        } else {
                            System.out.println("\nUnable to allocate more doctors to the centre.\n");
                        }
                    }
                    case 2 -> SkinConsultationManager.deleteDoctor(sc);
                    case 3 -> SkinConsultationManager.printDoctor();
                    case 4 -> SkinConsultationManager.saveInfo();
                }

            } while (option != 5);
        }
    }