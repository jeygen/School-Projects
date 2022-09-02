/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528project;

/**
 *
 * @author josh
 */
import javax.swing.*;

public class BookStoreViewer {
    public static void main(String[] args) {
        /* Create frame and set it properties*/
        BookStoreFrame frame = new BookStoreFrame();
        frame.setSize(BookStoreFrame.WIDTH, BookStoreFrame.HEIGHT);
        frame.setTitle("Bookstore App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Make frame visible to display drawing*/
        frame.setVisible(true);
    }
}
