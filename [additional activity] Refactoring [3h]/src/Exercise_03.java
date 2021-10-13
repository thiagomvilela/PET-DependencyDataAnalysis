
public class Exercise_03 {
	void f() {
		int x = 10;
		method_g1(x); // to extract
		method_g2(x); // to extract
		int y = x+1;
	}

	private void method_g2(int x) {
		System.out.println(x);
	}

	private void method_g1(int x) {
		x++;
	}
}