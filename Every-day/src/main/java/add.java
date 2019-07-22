//import java.util.*;
//import java.util.*;
//
//public class Replacement {
//    public String replaceSpace(String iniString, int length) {
//        // write code here
//        if (iniString == null || iniString.length() == 0) {
//            return null;
//        }
//
//        char[] str = iniString.toCharArray();
//
//
//        int originalLength = 0;
//        int numberOfBlank = 0;
//
//        int i = 0;
//        while (str[i] != '\0') ;
//        {
//            ++originalLength;
//            if (str[i] == ' ') {
//                ++numberOfBlank;
//            }
//            ++i;
//        }
//
//
//        int newLength = originalLength + numberOfBlank * 2;
//
//        if (newLength > length) {
//            return null;
//        }
//
//        int indexOfOriginal = originalLength;
//        int indexOfNew = newLength;
//        while (indexOfOriginal >= 0 && indexOfNew > indexOfOriginal) {
//            if (str[indexOfOriginal] == ' ') {
//                str[indexOfNew--] = '0';
//                str[indexOfNew--] = '2';
//                str[indexOfNew--] = '%';
//            } else {
//                str[indexOfNew--] = str[indexOfOriginal];
//            }
//            --indexOfOriginal;
//
//
//        }
//    }
//}