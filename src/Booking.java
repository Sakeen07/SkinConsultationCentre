import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// connect the patient id and doctor id

public class Booking implements ActionListener {
    ArrayList<Consultation> consultations = new ArrayList<>();
    JFrame frame;

    JLabel id = new JLabel("Add Patient ID: ");
    JTextField idField = new JTextField();

    JLabel doctorName = new JLabel("Enter Doctor first name: ");
    JTextField doctorNameField = new JTextField();

    JLabel date = new JLabel("Enter the Date: ");
    JTextField dateField = new JTextField();

    JLabel time = new JLabel("Enter the time: ");
    JTextField timeField = new JTextField();

    JLabel notes = new JLabel("Enter your Problem: ");
    JTextArea notesArea = new JTextArea();

    JLabel cost = new JLabel("Your cost is: ");
    JTextField costField = new JTextField();

    JButton conform = new JButton("Conform");
    JButton view = new JButton("View");

    Booking() {
        id.setBounds(20,75,120,25);
        idField.setBounds(200,75,200,25);

        doctorName.setBounds(20,100,170,25);
        doctorNameField.setBounds(200,100,200,25);

        date.setBounds(20,125,120,25);
        dateField.setBounds(200,125,200,25);

        time.setBounds(20,150,120,25);
        timeField.setBounds(200,150,200,25);

        notes.setBounds(20,200,170,25);
        notesArea.setBounds(200,180,200,125);

        cost.setBounds(20,310,120,25);
        costField.setBounds(200,310,200,25);

        conform.setBounds(300,350,140,25);
        conform.addActionListener(this);
        conform.setFocusable(false);

        view.setBounds(160,350,140,25);
        view.addActionListener(this);
        view.setFocusable(false);

        frame = new JFrame("Booking Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(440,420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(id);
        frame.add(idField);
        frame.add(doctorName);
        frame.add(doctorNameField);
        frame.add(date);
        frame.add(dateField);
        frame.add(time);
        frame.add(timeField);
        frame.add(notes);
        frame.add(notesArea);
        frame.add(cost);
        frame.add(costField);
        frame.add(conform);
        frame.add(view);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == conform) {
            String d = dateField.getText();
            String t = timeField.getText();
            int c = Integer.parseInt(costField.getText());
            String n = notesArea.getText();

            consultations.add(new Consultation(d,t,c,n));

            try {
                File fileObj = new File("ConsultationTime.txt");

                System.out.println("\nOverwriting\n");
                FileWriter save = new FileWriter(fileObj.getAbsolutePath());
                for (Consultation consultation: consultations) {
                    save.write(consultation.SavedDetails() + "\n");
                }

                save.close();

            } catch (IOException a) {
                System.out.println("\nAn error has occurred.\n");
            }

        } else if (e.getSource() == view) {
            ConsultationTable consultationTable = new ConsultationTable();
        }
    }
}
