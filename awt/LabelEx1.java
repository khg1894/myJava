package awt;

import java.awt.Label;
import java.util.Iterator;


public class LabelEx1 extends MFrame {

	Label label[] = new Label[4];
	int pos[] = {Label.LEFT,Label.CENTER,Label.RIGHT,Label.LEFT};

	public LabelEx1() {
		super(200, 200);
		//setResizable(true);
		setTitle("Label Example");
		String str = "������ ��ſ� ������";
		for (int i = 0; i < label.length; i++) {
			label[i] = new Label(str, pos[i]);
			label[i].setBackground(MColor.rColor());
			add(label[i]);
		}
		validate();//���ΰ�ħ: for���� ���ư��� ������ ����� ��µǴ� ��� ���ΰ�ħ�� ���� ���� ������� ��µǵ����Ѵ�.
	}

	public static void main(String[] args) {
		new LabelEx1();
	}
}
