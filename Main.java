package ByteJump;

import java.util.Scanner;

/**
 * 判断给定的字符串是否由字符数组中的元素组成
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {//注意while处理多个case

            String str = in.nextLine();
            String[] strArray = str.split(" ");
            strArray[0] = strArray[0].substring(1);

            strArray[strArray.length - 2] = strArray[strArray.length - 2].
                    substring(0, strArray[strArray.length - 2].length() - 1);

            for (int jj = 0; jj < strArray.length - 1; jj++) {
                for (int kk = jj + 1; kk < strArray.length - 1; kk++) {
                    if (strArray[jj].length() < strArray[kk].length()) {
                        String temp = strArray[kk];
                        strArray[kk] = strArray[jj];
                        strArray[jj] = temp;
                    }
                }
            }

            String targetStr = strArray[strArray.length - 1];
            while (targetStr.length() != 0) {
                Boolean match = false;
                for (int ii = 0; ii < strArray.length - 1; ii++) {
                    if (strArray[ii].length() != 0 && targetStr.startsWith(strArray[ii])) {
                        targetStr = targetStr.substring(strArray[ii].length(), targetStr.length());
                        match = true;
                    }
                }
                if (!match) {
                    break;
                }
            }
            Boolean result = targetStr.length() == 0;
            System.out.println(result);
        }

    }
}