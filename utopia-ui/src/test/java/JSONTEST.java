import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class JSONTEST {

	public static void main(String[] args) throws Exception{
//		ObjectMapper mapper=new ObjectMapper();
//		T1 t=new T1();
//		T2 t2=new T2();
//		t2.setTest("mmm");
//		t.setT2(t2);
//		System.out.println(mapper.writeValueAsString(t));
		String input="User";
		String pattern="([A-Z][a-z])([A-Z][a-z])([A-Z][a-zA-Z]+)";
		System.out.println(input.matches(pattern));
		Pattern p=Pattern.compile(pattern);
		Matcher m= p.matcher(input);
		int index=0;
//		while(m.find(index)){
			m.find();
			m.group(1);
			System.out.println(m.group(index++));
//		}
	}

	static class T1{
		T2 t2;

		public T2 getT2() {
			return t2;
		}

		public void setT2(T2 t2) {
			this.t2 = t2;
		}
		
	}
	
	static class T2{
		String test="test";

		public String getTest() {
			return test;
		}

		public void setTest(String test) {
			this.test = test;
		}
		
	} 
}
