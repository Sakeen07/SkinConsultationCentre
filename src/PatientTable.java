import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class PatientTable implements ActionListener {

    JFrame frame;
    JButton button;
    final String col[] ={"Name", "Surname", "BirthDate", "MobileNo", "ID"};
    final DefaultTableModel tableModel = new DefaultTableModel (col,10);
    final JTable table = new JTable(tableModel);

    PatientTable() {
        button = new JButton("Import from File");
        button.setBounds(10,100,145,50);
        button.addActionListener(this);

        table.setBounds(10,150,100000,300);


        frame = new JFrame("Patient List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,550);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(button);
        frame.add(table);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            String line = null;
            try {
                File file = new File("PatientInformation.txt");
                FileReader fr = new FileReader(file.getAbsoluteFile());
                BufferedReader br = new BufferedReader (fr);

                StringBuilder builder = new StringBuilder();
                while (( line= br.readLine()) != null) {
                    builder.append(line);
                }
                String[] lineArray= builder.toString().split(";");
                table.setModel(new DefaultTableModel(col,10));
                for(String currentLine: lineArray){
                    String[] dataArray = currentLine.split(";");
                    ((DefaultTableModel)table.getModel()).addRow(dataArray);
                }
                br.close();

            } catch (Exception ae) {
                JOptionPane.showMessageDialog(null, ae+"");
            }
        }
    }
}
