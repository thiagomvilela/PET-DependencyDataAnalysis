
public class Exercise_01 {
	void f() {
		int x = 10;
		x++;
		method_g(x); // to extract
	}

	private void method_g(int x) {
		System.out.println(x);
	}
}
