package language;

public class StaticTest {
	static void m1() {
		System.out.println("static m1 function");
	}
	
	public static void main(String args[]) {
		m1();
		StaticClass.m2();
		StaticClass s = new StaticClass();
		s.m2();
		StaticClass s2 = new StaticClass();
		s2.m2();
	}
	
	static class StaticClass {
		StaticClass() {
			System.out.println("constructor of StaticClass function");
		}
		static void m2() {
			System.out.println("static m2 of StaticClass function");
		}
	}
}
