
public class A {

	public static void main(String[] args) {

		int a[]= {20,30,10,20};
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i]>a[j]) {
				    System.out.println(a[j]);
				    
				}
			}
			
		}
		
//		for (Integer integer : s) {
//			System.out.println(integer);
//		}

	}

}
