package awt;

import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChoiceEx3 extends MFrame implements ItemListener {
	Choice name, star;
	String ms[] = { "�� ��", "�� ��", "�̹�ȣ", "�����", "����", "������" };
	String fs[] = { "��ƶ�", "�̿���", "���ϴ�", "��ä��", "�� ��", "�迬��" };

	public ChoiceEx3() {
		name = new Choice();
		name.add("���� ������");
		name.add("���� ������");
		star = new Choice();
		for (int i = 0; i < ms.length; i++) {
			star.add(ms[i]);
		}
		add(name);
		add(star);
		name.addItemListener(this);

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (name.getSelectedItem() == "���� ������") {
			inputItem(star, fs);
		} else if (name.getSelectedItem() == "���� ������"){
			inputItem(star, ms);
		}
	}

	public static void main(String[] args) {
		new ChoiceEx3();
	}

	public void inputItem(Choice c, String item[]) {
		c.removeAll();
		for (int i = 0; i < item.length; i++) {
			c.add(item[i]);

		}
	}

}
