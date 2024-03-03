import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GenericsKbArrayApp2 extends JFrame implements ActionListener {

    private static KnowledgeBase[] genericsList;
    private static String fileName;

    public GenericsKbArrayApp2() {
        setSize(600, 400); // Changed size for better visibility
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GenericsKbArrayApp");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextField textBar = new JTextField("number of options", 10);
        textBar.setEditable(false);

        panel.add(textBar, BorderLayout.NORTH);

        JPanel label = new JPanel();
        label.setLayout(new FlowLayout(FlowLayout.CENTER));
        textBar.setPreferredSize(new Dimension(100, 100));
        JLabel choice = new JLabel("choose option:");
        JComboBox<Integer> optionBox = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        optionBox.addActionListener(this);
        label.add(choice);
        label.add(optionBox);
        panel.add(label, BorderLayout.CENTER);

        JTextArea editingBox = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(editingBox);
        panel.add(scrollPane, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    public void readInKnowledgeBase(String fileName) {
        try {
            int counter = 0;
            Scanner counterScanner = new Scanner(new File(fileName));
            while (counterScanner.hasNextLine()) {
                counterScanner.nextLine();
                counter++;
            }
            counterScanner.close();

            Scanner scanner = new Scanner(new File(fileName));
            genericsList = new KnowledgeBase[counter];
            int position = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\t");
                String term1 = parts[0];
                String statement1 = parts[1];
                double confidenceScore1 = Double.parseDouble(parts[2]);
                genericsList[position] = new KnowledgeBase(term1, statement1, confidenceScore1);
                position++;
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "File not found: " + ex.getMessage());
        }
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JComboBox) {
            JComboBox<?> jumboBox = (JComboBox<?>) source;
            Object item = jumboBox.getSelectedItem();
            if (item instanceof Integer) {
                int option = (Integer) item;
                if (option == 1) {
                    fileName = JOptionPane.showInputDialog("Enter the name of the file: ");
                    if (fileName != null && !fileName.isEmpty()) {
                        readInKnowledgeBase(fileName);
                        JOptionPane.showMessageDialog(this, "The knowledge base has been successfully loaded");
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid file name!");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GenericsKbArrayApp2();
            }
        });
    }
}
