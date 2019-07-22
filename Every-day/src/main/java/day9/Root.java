//package day9;
//
///***
// * 有一棵无穷大的满二叉树，其结点按根结点一层一层地从左往右依次编号，根结点编号为1。现在有两个结点 a，b。
// * 请设计一个算法，求出a和b点的最近公共祖先的编号。 给定两个int a,b。为给定结点的编号。
// */
//public class Root {
//
//
//
//    public static void main(String[] args) {
//
//    }
//    public String replaceSpace(String iniString, int length) {
//        // write code here
//        if(iniString == null || iniString.length() ==0) {
//            return null;
//        }
//
//        char[] str = iniString.toCharArray();
//
//
//        int originalLength = 0;
//        int numberOfBlank = 0;
//
//        int i =0;
//        while (str[i] != '\0'); {
//            ++originalLength;
//            if(str[i] == ' ') {
//                ++numberOfBlank;
//            }
//            ++i;
//        }
//
//
//
//
//
//
//
//
//
//
//
//
//
//    }
//
//
//
//
//    private static int find(int left, int right) {
//        while (left != right) {
//            if(left > right) {
//                left = left / 2;
//            } else {
//                right = right / 2;
//            }
//        }
//        return left;
//    }
//}
