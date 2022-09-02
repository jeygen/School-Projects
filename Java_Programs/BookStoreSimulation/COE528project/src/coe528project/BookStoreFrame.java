/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BookStoreFrame extends JFrame {
    // Constants for screen size
    static final int WIDTH = 600;
    static final int HEIGHT = 550;

    static final Owner owner = new Owner("admin", "admin");

    private static final String BOOKS_FILE = "books.txt";
    private static final String CUSTOMER_FILE = "customers.txt";
    private static final String SEPARATOR = ";";
    private final ArrayList<Book> books;
    private final ArrayList<Customer> customers;

    private JTextField userName;
    private JTextField password;

    private JTextField bookName;
    private JTextField bookPrice;
    private DefaultTableModel model;
    private DefaultTableModel model1;
    private JTable j;
    private JTable j1;
    private JTable j2;
    private JTextField customerName;
    private JTextField customerPassword;
    private Customer theCustomer = null;
    double totalCost;
    JPanel p;

    public BookStoreFrame() throws HeadlessException {
        // Read data from files
        books = new ArrayList<>();
        customers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(BOOKS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(SEPARATOR);
                books.add(new Book(tokens[0], Double.parseDouble(tokens[1])));
            }
        } catch (IOException e) {

        }

        try (BufferedReader br = new BufferedReader(new FileReader(CUSTOMER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(SEPARATOR);
                customers.add(new Customer(tokens[0], tokens[1], Integer.parseInt(tokens[2])));
            }
        } catch (IOException e) {

        }

        p = new JPanel();
        p.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        p.setLayout(new BorderLayout());

        // Build UI
        buildLoginPage(p);
        add(p);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Save all data to files
                FileWriter writer;
                try {
                    // Write books to file
                    writer = new FileWriter(BOOKS_FILE);
                    for (Book book : books) {
                        writer.write(book.getName() + SEPARATOR + book.getPrice() + "\n");
                    }
                    writer.close();

                    // Write customer to file
                    writer = new FileWriter(CUSTOMER_FILE);
                    for (Customer customer : customers) {
                        writer.write(customer.getUserName() + SEPARATOR + customer.getPassword() + SEPARATOR +
                                customer.getPoints() + "\n");
                    }
                    writer.close();
                } catch (IOException ex) {
                }
            }
        });
    }

    /**
     * Build admin login page
     *
     * @param p Panel to add to
     */
    private void buildLoginPage(JPanel p) {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 2));
        JLabel lbl1 = new JLabel("Welcome to the BookStore App");
        p1.add(lbl1);
        JLabel lbl2 = new JLabel("");
        p1.add(lbl2);
        JLabel lbl3 = new JLabel("Username:");
        p1.add(lbl3);
        userName = new JTextField();
        p1.add(userName);
        JLabel lbl4 = new JLabel("Password:");
        p1.add(lbl4);
        password = new JTextField();
        p1.add(password);
        JLabel lbl5 = new JLabel("");
        p1.add(lbl5);
        JButton login = new JButton("Login");
        p1.add(login);
        login.addActionListener(new Login());

        p.add(p1, BorderLayout.NORTH);
    }

    /**
     * Build admin main page
     *
     * @param p Panel to add to
     */
    private void buildAdminMainPage(JPanel p) {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(3, 1));
        JButton books = new JButton("Books");
        p1.add(books);
        books.addActionListener(new Books());

        JButton customers = new JButton("Customers");
        p1.add(customers);
        customers.addActionListener(new Customers());

        JButton logout = new JButton("Logout");
        p1.add(logout);
        logout.addActionListener(new Logout());

        p.add(p1, BorderLayout.NORTH);
    }

    /**
     * Build books page
     *
     * @param p Panel to add to
     */
    private void buildBooksPage(JPanel p) {
        // Column Names
        String[] colHeadings = {"Book Name", "Book Price"};

        // Initializing the JTable
        int numRows = 0;
        model = new DefaultTableModel(numRows, colHeadings.length);
        model.setColumnIdentifiers(colHeadings);
        j = new JTable(model);
        j.setBounds(30, 40, 200, 100);

        for (Book book : books) {
            model.addRow(new Object[]{book.getName(), book.getPrice()});
        }

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        p.add(sp, BorderLayout.NORTH);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(3, 2));
        JLabel lbl1 = new JLabel("Book Name:");
        p2.add(lbl1);
        bookName = new JTextField();
        p2.add(bookName);
        JLabel lbl2 = new JLabel("Book Price:");
        p2.add(lbl2);
        bookPrice = new JTextField();
        p2.add(bookPrice);
        JLabel lbl3 = new JLabel("");
        p2.add(lbl3);
        JButton add = new JButton("Add");
        p2.add(add);
        add.addActionListener(new AddBook());
        p.add(p2, BorderLayout.CENTER);


        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 2));
        JButton delete = new JButton("Delete");
        p3.add(delete);
        delete.addActionListener(new DeleteBook());

        JButton back = new JButton("Back");
        p3.add(back);
        back.addActionListener(new Back());
        p.add(p3, BorderLayout.SOUTH);
    }

    /**
     * Build customers page
     *
     * @param p Panel to add to
     */
    private void buildCustomersPage(JPanel p) {
        // Column Names
        String[] colHeadings = {"User Name", "Password", "Points"};

        // Initializing the JTable
        int numRows = 0;
        model1 = new DefaultTableModel(numRows, colHeadings.length);
        model1.setColumnIdentifiers(colHeadings);
        j1 = new JTable(model1);
        j1.setBounds(30, 40, 200, 100);

        for (Customer customer : customers) {
            model1.addRow(new Object[]{customer.getUserName(), customer.getPassword(), customer.getPoints()});
        }

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j1);
        p.add(sp, BorderLayout.NORTH);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(3, 2));
        JLabel lbl1 = new JLabel("User Name:");
        p2.add(lbl1);
        customerName = new JTextField();
        p2.add(customerName);
        JLabel lbl2 = new JLabel("User Password:");
        p2.add(lbl2);
        customerPassword = new JTextField();
        p2.add(customerPassword);
        JLabel lbl3 = new JLabel("");
        p2.add(lbl3);
        JButton add = new JButton("Add");
        p2.add(add);
        add.addActionListener(new AddCustomer());
        p.add(p2, BorderLayout.CENTER);


        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 2));
        JButton delete = new JButton("Delete");
        p3.add(delete);
        delete.addActionListener(new DeleteCustomer());

        JButton back = new JButton("Back");
        p3.add(back);
        back.addActionListener(new Back());
        p.add(p3, BorderLayout.SOUTH);
    }


    /**
     * Build customer main page
     *
     * @param p Panel to add to
     */

    private void buildCustomerMainPage(JPanel p) {

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1));
        JLabel lbl1 = new JLabel("Welcome " + theCustomer.getUserName() + ". You have " + theCustomer.getPoints() +
                " points. Your status is " + theCustomer.getStatus());
        p1.add(lbl1);
        p.add(p1, BorderLayout.NORTH);

        // Column Names

        // Initializing the JTable
        DefaultTableModel model2 = new DefaultTableModel() {
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return Boolean.class;
                    default:
                        return String.class;
                }
            }
        };
        model2.addColumn("Book Name");
        model2.addColumn("Book Price");
        model2.addColumn("Selected");

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            model2.addRow(new Object[0]);
            model2.setValueAt(book.getName(), i, 0);
            model2.setValueAt(book.getPrice(), i, 1);
            model2.setValueAt(false, i, 2);
        }

        j2 = new JTable(model2);
        j2.setBounds(30, 40, 200, 100);
        JScrollPane sp = new JScrollPane(j2);

        p.add(sp, BorderLayout.CENTER);


        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 3));
        JButton buy = new JButton("Buy");
        p3.add(buy);
        buy.addActionListener(new Buy());

        JButton redeem = new JButton("Redeem points and Buy");
        p3.add(redeem);
        redeem.addActionListener(new RedeemBuy());

        JButton logout = new JButton("Logout");
        p3.add(logout);
        logout.addActionListener(new CustomerLogout());
        p.add(p3, BorderLayout.SOUTH);
    }

    /**
     * Build buy page
     *
     * @param p Panel to add to
     */
    private void buildBuyPage(JPanel p) {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1));
        JLabel lbl1 = new JLabel("Total Cost: " + totalCost);
        p1.add(lbl1);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 1));
        JLabel lbl2 = new JLabel("Points: " + theCustomer.getPoints() + ", Status: " + theCustomer.getStatus());
        p2.add(lbl2);

        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 1));
        JButton logout = new JButton("Logout");
        p3.add(logout);
        logout.addActionListener(new CustomerLogout());
        
        // Added this, test to see *************************************************** Come back to this
        /*
        JButton back = new JButton("Back");
        p3.add(back);
        back.addActionListener(new Buy());
        p.add(p3, BorderLayout.SOUTH);
        */
        //

        p.add(p1, BorderLayout.NORTH);
        p.add(p2, BorderLayout.CENTER);
        p.add(p3, BorderLayout.SOUTH);
    }

    private class Login implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userNameStr = userName.getText();
            String passwordStr = password.getText();

            if (userNameStr.equals(owner.getUserName()) && passwordStr.equals(owner.getPassword())) {
                // Admin logged in
                p.removeAll();
                buildAdminMainPage(p);
                revalidate();
                repaint();
            } else {
                // Check if customer logged
                boolean customerLoggedIn = false;
                for (Customer customer : customers) {
                    if (customer.getUserName().equals(userNameStr) && customer.getPassword().equals(passwordStr)) {
                        customerLoggedIn = true;
                        theCustomer = customer;
                        break;
                    }
                }

                if (customerLoggedIn) {
                    // Customer logged in
                    p.removeAll();
                    buildCustomerMainPage(p);
                    revalidate();
                    repaint();
                } else {
                    // Show error
                    JOptionPane.showMessageDialog(null, "Wrong admin ID/password", "Admin Login",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private class Books implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            p.removeAll();
            buildBooksPage(p);
            revalidate();
            repaint();
        }
    }

    private class Customers implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            p.removeAll();
            buildCustomersPage(p);
            revalidate();
            repaint();
        }
    }

    private class Logout implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            p.removeAll();
            buildLoginPage(p);
            revalidate();
            repaint();
        }
    }

    private class AddBook implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            books.add(new Book(bookName.getText(), Double.parseDouble(bookPrice.getText())));
            model.addRow(new Object[]{bookName.getText(), bookPrice.getText()});
            bookName.setText("");
            bookPrice.setText("");
        }
    }

    private class DeleteBook implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int[] selectedRows = j.getSelectedRows();
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                model.removeRow(selectedRows[i]);
                books.remove(selectedRows[i]);
            }
        }
    }

    private class Back implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            p.removeAll();
            buildAdminMainPage(p);
            revalidate();
            repaint();
        }
    }

    private class AddCustomer implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            customers.add(new Customer(customerName.getText(), customerPassword.getText(), 0));
            model1.addRow(new Object[]{customerName.getText(), customerPassword.getText(), 0});
            customerName.setText("");
            customerPassword.setText("");
        }
    }

    private class DeleteCustomer implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int[] selectedRows = j1.getSelectedRows();
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                model1.removeRow(selectedRows[i]);
                customers.remove(selectedRows[i]);
            }
        }
    }

    private class Buy implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Calculate total cost
            calculateCost();

            // Calculate points
            theCustomer.setPoints(theCustomer.getPoints() + ((int) totalCost) * 10);
            p.removeAll();
            buildBuyPage(p);
            revalidate();
            repaint();
        }

    }

    private void calculateCost() {
        totalCost = 0;
        for (int i = 0; i < j2.getRowCount(); i++) {
            boolean checked = Boolean.parseBoolean(j2.getValueAt(i, 2).toString());
            String price = j2.getValueAt(i, 1).toString();

            if (checked) {
                totalCost += Double.parseDouble(price);
            }
        }
    }

    private class CustomerLogout implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            p.removeAll();
            buildLoginPage(p);
            revalidate();
            repaint();
        }
    }

    private class RedeemBuy implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Calculate total cost
            calculateCost();

            // Check how many points to redeem
            int pointsInDollars = theCustomer.getPoints() / 100;
            if (totalCost <= pointsInDollars) {
                // Can cover all cost by points
                theCustomer.setPoints(theCustomer.getPoints() - ((int) totalCost) * 100);
                totalCost -= (int) totalCost;   // In case we have pennies
            } else {
                totalCost -= pointsInDollars;
                double temp = ((int)totalCost) * 10;
                theCustomer.setPoints((int) temp);   // All points used
            }
            p.removeAll();
            buildBuyPage(p);
            revalidate();
            repaint();
        }
    }
}
