import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int stu_arr[] = new int[1000]; 
        int studentNum = 0;                 //학생 수
    	Scanner sc = new Scanner(System.in);  
        int num = sc.nextInt();            //테스트 케이스
        
        for(int i = 0; i < num ; i++) { 
        	double avg = 0.0;
            int total = 0;                //점수 합산
            int upStudent = 0;            //평균 넘는 학생 수 
            studentNum = sc.nextInt();
            
        	for(int j = 0; j < studentNum ; j++) {
        		stu_arr[j] = sc.nextInt();
        		total = total + stu_arr[j]; 
        	}
        	
        	avg = (double)(total / studentNum);  

            for(int j = 0; j < studentNum ; j++) {
        		if(avg < stu_arr[j]) {
        			upStudent++;
        		}
        	}
        	
            System.out.printf("%.3f", (100.0 * upStudent) / studentNum); 
            System.out.println('%');        
        }
        sc.close();
	}
}
