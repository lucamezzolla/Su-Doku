package com.lucamezzolla.com.sudoku;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class SudokuFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public SudokuFrame(int[][] grid) {
		
		JPanel contentPane = new JPanel(new SpringLayout());
        
        int rows = 9;
        int cols = 9;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
	            JTextField textField = new JTextField(Integer.toString(grid[r][c]));
	            textField.setFont(new Font("Verdana", Font.BOLD, 14));
	            textField.setHorizontalAlignment(JTextField.CENTER);
	            textField.setPreferredSize(new Dimension(30, 30));
	            contentPane.add(textField);
            }
        }
 
        SpringUtilities.makeGrid(contentPane, rows, cols, 10, 10, 10, 10);
		setTitle("Su Doku");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(contentPane);
 
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        
	}
	
}