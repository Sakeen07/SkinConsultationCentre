import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// have to create button to show the details

public class AddPatient implements ActionListener {
    ArrayList<Patient> patients = new ArrayList<>();

    String numbers = "1,2,3,4,5,6,7,8,9,0";
    JFrame frame;

    JLabel name = new JLabel("Enter your name: ");
    JTextField nameField = new JTextField();

    JLabel surname = new JLabel("Enter your Surname: ");
    JTextField surnameField = new JTextField();

    JLabel dob = new JLabel("Enter your Date of Birth: ");
    JTextField dobField = new JTextField();

    JLabel mno = new JLabel("Enter your mobile number: ");
    JTextField mnoField = new JTextField();

    JLabel id = new JLabel("Patient ID: ");
    JTextField idField = new JTextField();

    JButton conform = new JButton("Conform");
    JButton view = new JButton("View");

    AddPatient() {
        id.setBounds(20,75,120,25);
        idField.setBounds(200,75,200,25);

        name.setBounds(20,100,120,25);
        nameField.setBounds(200,100,200,25);

        surname.setBounds(20,125,140,25);
        surnameField.setBounds(200,125,200,25);

        dob.setBounds(20,150,160,25);
        dobField.setBounds(200,150,200,25);

        mno.setBounds(20,175,180,25);
        mnoField.setBounds(200,175,200,25);

        conform.setBounds(300,250,100,25);
        conform.setFocusable(false);
        conform.addActionListener(this);

        view.setBounds(200,250,100,25);
        view.setFocusable(false);
        view.addActionListener(this);

        frame = new JFrame("Patient Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.add(id);
        frame.add(idField);
        frame.add(name);
        frame.add(nameField);
        frame.add(surname);
        frame.add(surnameField);
        frame.add(dob);
        frame.add(dobField);
        frame.add(mno);
        frame.add(mnoField);
        frame.add(conform);
        frame.add(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == conform) {
            Integer i = Integer.valueOf((idField.getText()));
            String n = nameField.getText();
            String sn = surnameField.getText();
            String date = dobField.getText();
            String mobile = String.valueOf(mnoField.getText());


            patients.add(new Patient(n,sn,date,mobile,i));

            try {
                File fileObj = new File("PatientInformation.txt");

                System.out.println("\nOverwriting\n");
                FileWriter save = new FileWriter(fileObj.getAbsolutePath());
                for (Patient patient: patients) {
                    save.write(patient.saveDetails() + "\n");
                }

                save.close();

            } catch (IOException a) {
                System.out.println(e);
                System.out.println("\nAn error has occurred.\n");
            }
        }else if (e.getSource() == view) {
            PatientTable patientTable = new PatientTable();
        }
    }
}
