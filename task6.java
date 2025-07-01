import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class task6 {
    private JFrame frame;
    private JTextField taskInput;
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;

    public task6() {
      
        frame = new JFrame("To-Do List");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        
        taskInput = new JTextField();
        taskInput.setBounds(20, 20, 250, 30);
        frame.add(taskInput);

       
        JButton addButton = new JButton("Add Task");
        addButton.setBounds(280, 20, 90, 30);
        frame.add(addButton);

        
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setBounds(20, 70, 350, 200);
        frame.add(scrollPane);

       
        JButton deleteButton = new JButton("Delete Selected");
        deleteButton.setBounds(120, 290, 150, 30);
        frame.add(deleteButton);

       
        addButton.addActionListener(e -> {
            String task = taskInput.getText().trim();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskInput.setText("");
            }
        });

        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(task6::new);
    }
}
