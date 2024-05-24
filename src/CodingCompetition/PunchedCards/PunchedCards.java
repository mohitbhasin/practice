import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PunchedCards {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int numTest = scanner.nextInt();
        List<int[]> input = new ArrayList<>();
        for(int i=0; i<numTest; i++) {
            int[] tempInput = new int[2];
            tempInput[0] = scanner.nextInt();
            tempInput[1] = scanner.nextInt();
            input.add(tempInput);
        }
        int count = 1;
        for(int[] val: input) {
            System.out.println("Case #"+count++ +":");
            printCard(val[0]*2+1,val[1]*2+1);
        }
    }

    public static void printCard(int R, int C) {

        System.out.print("..");
        for(int i=0; i<C-2; i++) {
            if(i%2==0) {
                System.out.print('+');
            } else {
                System.out.print('-');
            }
        }
        System.out.println();

        System.out.print("..");
        for(int i=0; i<C-2; i++) {
            if(i%2==0) {
                System.out.print('|');
            } else {
                System.out.print('.');
            }
        }
        System.out.println();
        for(int r=2; r<R; r++) {
            for(int c=0; c<C; c++) {
                //for boundary
                if(r%2==0) {
                    if(c%2==0) {
                        System.out.print('+');
                    } else {
                        System.out.print('-');
                    }
                }
                // for punches
                else {
                    if(c%2==0) {
                        System.out.print('|');
                    } else {
                        System.out.print('.');
                    }
                }
            }
            System.out.println();
        }
    }
}
