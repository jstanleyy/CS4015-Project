package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

/**
 * @author jstanley
 *
 */
public class UI {

	private JFrame frmEditor;
	private SystemFacade system = new SystemFacade();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.frmEditor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEditor = new JFrame();
		frmEditor.setTitle("JStanley's Text Editor");
		frmEditor.setBounds(100, 100, 450, 300);
		frmEditor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEditor.getContentPane().setLayout(null);
		
		JLabel lblFileIO = new JLabel("File I/O");
		lblFileIO.setHorizontalAlignment(SwingConstants.CENTER);
		lblFileIO.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFileIO.setBounds(335, 140, 89, 14);
		frmEditor.getContentPane().add(lblFileIO);

		JTextArea txtrYouMustClick = new JTextArea();
		txtrYouMustClick.setText("You must click update to store the changes in the composite structure. Always update being saving!\r\n\r\nThis text can now be deleted.");
		txtrYouMustClick.setWrapStyleWord(true);
		txtrYouMustClick.setLineWrap(true);
		txtrYouMustClick.setBounds(0, 0, 320, 261);
		frmEditor.getContentPane().add(txtrYouMustClick);
		
		JLabel lblStatus = new JLabel("");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setBounds(335, 233, 89, 28);
		frmEditor.getContentPane().add(lblStatus);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(system.loadFile()) {
					txtrYouMustClick.setText(system.getText());
					lblStatus.setText("File loaded.");
				} else {
					lblStatus.setText("Error!");
				}
			}
		});
		btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnLoad.setBounds(335, 165, 89, 23);
		frmEditor.getContentPane().add(btnLoad);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(system.saveFile()) {
					lblStatus.setText("File saved.");
				} else {
					lblStatus.setText("Error!");
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSave.setBounds(335, 199, 89, 23);
		frmEditor.getContentPane().add(btnSave);
		
		JLabel lblActions = new JLabel("Actions");
		lblActions.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblActions.setHorizontalAlignment(SwingConstants.CENTER);
		lblActions.setBounds(335, 11, 89, 14);
		frmEditor.getContentPane().add(lblActions);
		
		JButton btnUndo = new JButton("Undo");
		btnUndo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(system.undo()) {
					txtrYouMustClick.setText(system.getText());
					lblStatus.setText("Undone");
				} else {
					lblStatus.setText("Can't undo");
				}
			}
		});
		btnUndo.setBounds(335, 70, 89, 23);
		frmEditor.getContentPane().add(btnUndo);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String updatedText = txtrYouMustClick.getText();
				if(system.update(updatedText)) {
					lblStatus.setText("Updated");		
				} else {
					lblStatus.setText("Error!");
				}
			}
		});
		btnUpdate.setBounds(335, 36, 89, 23);
		frmEditor.getContentPane().add(btnUpdate);
		
		JButton btnRedo = new JButton("Redo");
		btnRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(system.redo()) {
					txtrYouMustClick.setText(system.getText());
					lblStatus.setText("Redone");
				} else {
					lblStatus.setText("Can't redo");
				}
			}
		});
		btnRedo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRedo.setBounds(335, 104, 89, 23);
		frmEditor.getContentPane().add(btnRedo);
		
	}
}
