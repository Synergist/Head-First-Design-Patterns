package headfirst.designpatterns.observer.swing;

import java.awt.*;
import javax.swing.*;

public class SwingObserverExample {
	JFrame frame;
	boolean shouldDiscourage = false;

	public static void main(String[] args) {
		SwingObserverExample example = new SwingObserverExample();
		example.go();
	}

	public void go() {
		frame = new JFrame();
		JButton button = new JButton("Should I do it?");
		JCheckBox checkbox = new JCheckBox("Discourage");
		// Without lambdas
		//button.addActionListener(new AngelListener());
		//button.addActionListener(new DevilListener());

		// With lambdas
		button.addActionListener(event -> {
			String s = shouldDiscourage ? "Don't do it, you might regret it!" : "Come on, do it!";
			System.out.println(s);
		}
		);
		checkbox.addActionListener(e ->  toggleDiscourage() );

		// Set frame properties
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(BorderLayout.CENTER, button);
		frame.getContentPane().add(BorderLayout.EAST, checkbox);
		frame.setSize(300,300);
		frame.setVisible(true);
	}

	public void toggleDiscourage() {
		shouldDiscourage = !shouldDiscourage;
	}

	/*
	 * Remove these two inner classes to use lambda expressions instead.
	 *
	class AngelListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("Don't do it, you might regret it!");
		}
	}

	class DevilListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("Come on, do it!");
		}
	}
	*/

}
