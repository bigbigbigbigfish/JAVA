package day7;

import java.util.Scanner;

public class Grade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row =scanner.nextInt();
        int sort = scanner.nextInt();
        String name[] = new String[row];
        int scores[] = new int[row];
        for (int i =0;i<row;i++) {
            name[i] = scanner.next();
            scores[i] = scanner.nextInt();
        }
        if(sort == 0) {
            for(int i =0; i<row;i++) {
                for(int j =0; j <row-i -1; j++) {
                    if(scores[j] < scores[j+1]) {
                        int temp =scores[j];
                        scores[j] =scores[j+1];
                        scores[j+1] = temp;
                        String str = "";
                        str = name[j];
                        name[j] = name[j+1];
                        name[j+1] = str;
                    }
                }
            }

        } else if(sort == 1) {
            //升序
            for(int i =0; i<row; i++) {
                for(int j =0;j <row-i-1 ;j++) {
                    if(scores[j]>scores[j+1]) {
                        int temp =scores[j];
                        scores[j] =scores[j+1];
                        scores[j+1] = temp;
                        String str = "";
                        str = name[j];
                        name[j] = name[j+1];
                        name[j+1] = str;
                    }
                }
            }
        }
        printSort(name,scores);

    }
    public static void printSort(String[] name,int[] scores) {
        for(int i=0;i<name.length;i++)  {
            if(i ==name.length -1){
                System.out.println(name[i] + " " +scores[i]);
                break;
            }
            System.out.println(name[i] + " "+scores[i]);
        }
    }
}
