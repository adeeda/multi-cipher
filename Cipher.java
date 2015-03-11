package cipher;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 * Encrypts and Decrypts text using various cipher algorithms.
 * @author Andrew Elliott
 */
public class Cipher extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField shiftFactor;
	private JTextArea inputTA;
	private JTextArea outputTA;
	private Caesar caesar;
	private Morse morse;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Cipher().setVisible(true);
	}

	public Cipher(){
		caesar = new Caesar();
		morse = new Morse();
		
		setTitle("Multi Cipher");
		setVisible(true);
		setDefaultCloseOperation(3);

		Container content = getContentPane();
		GridLayout layout = new GridLayout(3, 0, 0, 10);
		content.setLayout(layout);

		inputTA = new JTextArea("Insert the text to be encrypted/decrypted here, then press the appropriate button.", 12, 40);
		inputTA.setLineWrap(true);
		inputTA.setWrapStyleWord(true);
		inputTA.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		JScrollPane scroller = new JScrollPane(inputTA);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		content.add(scroller);

		outputTA = new JTextArea("Output text.",12, 40);
		outputTA.setLineWrap(true);
		outputTA.setWrapStyleWord(true);
		outputTA.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		JScrollPane scroller2 = new JScrollPane(outputTA);
		scroller2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		content.add(scroller2);

		JPanel box1 = new JPanel();
		box1.setLayout(new FlowLayout());
		JButton decryptButton = new JButton("Decrypt");
		JButton encryptButton = new JButton("Encrypt");
		JButton rot13Button = new JButton("ROT13");
		JButton morseButton = new JButton("Morsify");
		JButton deMorseButton = new JButton("De-Morsify");
		JButton plus = new JButton("+");
		JButton minus = new JButton("-");
		decryptButton.addActionListener(this);
		encryptButton.addActionListener(this);
		rot13Button.addActionListener(this);
		morseButton.addActionListener(this);
		deMorseButton.addActionListener(this);
		plus.addActionListener(this);
		minus.addActionListener(this);
		box1.add(decryptButton);
		box1.add(encryptButton);
		box1.add(rot13Button);
		box1.add(morseButton);
		box1.add(deMorseButton);
		box1.add(minus);
		box1.add(plus);
		box1.add(new JLabel("Shift Factor"));
		box1.add(this.shiftFactor = new JTextField(20));
		content.add(box1);

		pack();
		
		this.shiftFactor.setText("0");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Encrypt")){
			//Get the text from the app and store it in a String variable.
			String textNum = this.shiftFactor.getText();
			//Check to see if a "Shift Factor" value was entered.
			//If there wasn't, set shift to zero,
			//Otherwise parse the input value to an integer so we can use it.
			int shift = 0;
			if(!textNum.equals("")){
				shift = Integer.parseInt(textNum)%26;
			}
			String inputText = inputTA.getText();
			outputTA.setText(caesar.encrypt(inputText,shift));
		}
		if (e.getActionCommand().equals("Decrypt")) {
			//Get the text from the app and store it in a String variable.
			String textNum = this.shiftFactor.getText();
			//Check to see if a "Shift Factor" value was entered.
			//If there wasn't, set shift to zero,
			//Otherwise parse the input value to an integer so we can use it.
			int shift = 0;
			if(!textNum.equals("")){
				shift = Integer.parseInt(textNum)%26;
			}
			String inputText = inputTA.getText();
			outputTA.setText(caesar.decrypt(inputText,shift));
		}
		if (e.getActionCommand().equals("ROT13")) {
			String inputText = inputTA.getText();
			outputTA.setText(caesar.encrypt(inputText, 13));
		}
		if (e.getActionCommand().equals("Morsify")) {
			String inputText = inputTA.getText();
			outputTA.setText(morse.encrypt(inputText));
		}
		if (e.getActionCommand().equals("De-Morsify")) {
			String inputText = inputTA.getText();
			outputTA.setText(morse.decrypt(inputText));
		}
		if (e.getActionCommand().equals("+")) {
			int number = (Integer.parseInt(this.shiftFactor.getText())+1)%26;
			String inputText = inputTA.getText();
			outputTA.setText(caesar.encrypt(inputText, number));
			this.shiftFactor.setText(Integer.toString(number));
		}
		if (e.getActionCommand().equals("-")) {
			int number = Integer.parseInt(this.shiftFactor.getText())%26;
			if (number <= 0) {
				number = 25;
			} else {
				number--;
			}
			String inputText = inputTA.getText();
			outputTA.setText(caesar.encrypt(inputText, number));
			this.shiftFactor.setText(Integer.toString(number));
		}
	}
}