package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

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
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(0, 0, 320, 261);
		frmEditor.getContentPane().add(textPane);
		
		JLabel lblStatus = new JLabel("");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setBounds(335, 233, 89, 28);
		frmEditor.getContentPane().add(lblStatus);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(system.loadFile()) {
					textPane.setText(system.getText());
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
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				system.undo();
				textPane.setText(system.getText());
			}
		});
		btnUndo.setBounds(335, 36, 89, 23);
		frmEditor.getContentPane().add(btnUndo);
		
		textPane.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				String updatedText = textPane.getText();
				if(system.update(updatedText)) {
					lblStatus.setText("Updated");		
				} else {
					lblStatus.setText("Error!");
				}
			}
		});
	}
}
