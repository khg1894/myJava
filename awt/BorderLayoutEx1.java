package awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.util.Random;

public class BorderLayoutEx1 extends MFrame{
	
	String str[] = {"첫번째","두번째","세번째","네번째","다섯번째"};
	Button btn[] = new Button[5];
	
	
	public BorderLayoutEx1() {
		setLayout(new BorderLayout());//배치 관리자
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new Button(str[i]);
			Color c[] = MColor.rColor2();
			btn[i].setBackground(c[0]);
			btn[i].setForeground(c[1]);
		}
		add(btn[0], "North");//위치 타이핑을 통해 지정하는건 권장 안함 아래의 방식 사용
		add(btn[1], BorderLayout.EAST);
		add(BorderLayout.SOUTH,btn[2]);
		add(BorderLayout.WEST,btn[3]);
		add(btn[4], BorderLayout.CENTER);//지정안하면 센터로
	}
	

	public static void main(String[] args) {
		Random r = new Random();
		for (int i = 0; i < 1000; i++) {
			BorderLayoutEx1 bl =
					new BorderLayoutEx1();
			int x = r.nextInt(2000);
			int y = r.nextInt(1000);
			bl.setBounds(x,y,200,200);
		}
		new BorderLayoutEx1();
	}

}
