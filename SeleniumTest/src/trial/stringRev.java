package trial;

public class stringRev {
	
	public static void main(String[] args) {
		
		String arr = "Aditya is right"; // aytida si thgir
		
		String ar[] = arr.split(" ");
		System.out.println(ar);
		//char ch;
		for(int i =0; i >=ar.length-1;i-- ) {
			String temp = ar[i];
			char[] tmp = temp.toCharArray();
			for(int j=0;j<=temp.length();j++) {
				 //ch= tmp[i];
				
				System.out.print(tmp[tmp.length-1]);
				
				 //tmp[tmp.length-1]= ch; 
				 
			}
			System.out.print(" ");
			
		}
	}

}
