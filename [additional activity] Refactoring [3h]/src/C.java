
public class C {
	
	int fieldX;
	
	public void m( ) {
		int x2 = 10;
		this.fieldX = 10;
		System.out.print("A");
		HelperB2();
		System.out.print("C");
		System.out.print(x2);
		}

	public void m2( ) {
		HelperB2();
		System.out.print("D");
		}

	public void m3( ) {
		HelperB2();
		System.out.print("E");
		HelperB2();
		}
	
	public void HelperB2() {
		System.out.print("B2");
	}
}

