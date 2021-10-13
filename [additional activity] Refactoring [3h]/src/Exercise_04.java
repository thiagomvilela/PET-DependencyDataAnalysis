
public class Exercise_04 {
	void f() {
		int x = 10;
		int y;
		method_g1(); // to extract
		y = method_g2(); // to extract
		method_g3(y); // to extract
		int z = y+1;
		}

	private void method_g3(int y) {
		System.out.println(y);
	}

	private int method_g2() {
		int y;
		y = h()*2;
		return y;
	}

	private void method_g1() {
		int y;
	}
}