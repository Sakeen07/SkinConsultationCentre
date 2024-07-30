import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class User implements ActionListener {

    JFrame frame;
    JButton DoctorButton;
    JButton AddPatientButton;
    JButton AddConsultation;
    JPanel panel;
    Font myfont = new Font("Ink Free", Font.ITALIC, 25);

    User() {
        frame = new JFrame("Consultation Screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,550);
        frame.setLayout(null);

        DoctorButton = new JButton("Show Doctor List");
        AddPatientButton = new JButton("Add a Patient");
        AddConsultation = new JButton("Book a consultation");
        DoctorButton.setBounds(10,100,145,50);
        DoctorButton.addActionListener(this);
        DoctorButton.setFocusable(false);

        AddPatientButton.setBounds(210,100,145,50);
        AddPatientButton.setFocusable(false);
        AddPatientButton.addActionListener(this);

        AddConsultation.setBounds(410,100,145,50);
        AddConsultation.addActionListener(this);
        AddConsultation.setFocusable(false);

        panel = new JPanel();


        frame.add(DoctorButton);
        frame.add(AddPatientButton);
        frame.add(AddConsultation);
        frame.setVisible(true);

    }

    public static void main(String[]args) {
        User user = new User();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == DoctorButton) {
                DoctorTable doc = new DoctorTable();
        }
        if (e.getSource() == AddPatientButton) {
            AddPatient book = new AddPatient();
        }
        if (e.getSource() == AddConsultation) {
            Booking booking = new Booking();
        }
    }
}
