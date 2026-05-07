package today;
import java.util.Scanner;
public class ETH1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("enter college name");
		String colname = s.nextLine();
		System.out.println("enter student name");
		String name = s.nextLine();
		System.out.println("enter rollno");
		int rollno = s.nextInt();
		System.out.println("enter student score");
		float score = s.nextFloat();
		System.out.println("enter student semester");
		byte sem= s.nextByte();
		System.out.println("enter gender");
		char gender = s.next().charAt(0);
		System.out.println("Rollno = "+rollno);
		System.out.println("semester = "+sem);
		System.out.println("college name = "+colname);
		System.out.println("student name = "+name);
		System.out.printf("Score =%f ",score);


		 

	}

}
