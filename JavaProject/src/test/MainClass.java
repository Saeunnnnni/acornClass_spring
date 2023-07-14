package test;

public class MainClass {
	  
	public static void main(String[] args) {
		
		printNames();
		printNames("aaa");
		printNames("aaa","bbb");
		printNames("aaa","bbb","ccc");
	}
	public static void printNames(String... names) {
		for(String tmp:names) {
			System.out.println(tmp);
		}
		System.out.println(names.length+"개를 출력하엿습니다.");
	}
}
