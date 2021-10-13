
public class Exercise_02 {
	void f() {
		int x = 10;
		x = method_g1(x); // to extract
		method_g2(x); // to extract
	}

	private void method_g2(int x) {
		System.out.println(x);
	}

	private int method_g1(int x) {
		x++;
		return x;
	}
}

