package awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.border.Border;

public class DesignEx2 extends MFrame {

	TextField tf;
	TextArea ta;
	Button btn1, btn2;
	Panel p1, p2;

	public DesignEx2() {
		super(500, 400);
		setTitle("������ ����2");
		setLayout(new BorderLayout());
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		p1.add(tf = new TextField("ȫ�浿", 20), "North");
		add(p1,BorderLayout.NORTH);
		add(ta = new TextArea(), "Center");
		p2.add(btn1 = new Button("���콺�׽�Ʈ"));
		p2.add(btn2 = new Button("end"));
		add(p2,BorderLayout.SOUTH);

		
		validate();

	}

	public static void main(String[] args) {
		new DesignEx2();
	}
}
