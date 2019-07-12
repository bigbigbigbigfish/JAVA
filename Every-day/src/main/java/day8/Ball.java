package day8;


import java.util.*;

import static java.lang.StrictMath.acos;

public class Ball {
    /***
     * 输入球的中心点和球上的某一点坐标,计算球的半径和体积
     *
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int x2 = in.nextInt();
        int x3 = in.nextInt();
        int y1 = in.nextInt();
        int y2 = in.nextInt();
        int y3 = in.nextInt();
        double pi = acos(-1);

        double radius = Math.sqrt((x1-y1)*(x1-y1) + (x2-y2)*(x2-y2) + (x3-y3)*(x3-y3));
        double volume = (4 * pi * radius *radius *radius) /3;
        System.out.println(String.format("%.3f",radius));
        System.out.println(String.format("%.3f",volume));
    }



}
