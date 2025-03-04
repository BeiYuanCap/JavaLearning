package ProgrammerCarl.D_String;

/*        右旋字符串

字符串的右旋转操作是把字符串尾部的若干个字符转移到字符串的前面。给定一个字符串 s 和一个正整数 k，请编写一个函数，将字符串中的后面 k 个字符移到字符串的前面，实现字符串的右旋转操作。

例如，对于输入字符串 "abcdefg" 和整数 2，函数应该将其转换为 "fgabcde"。

输入：输入共包含两行，第一行为一个正整数 k，代表右旋转的位数。第二行为字符串 s，代表需要旋转的字符串。

输出：输出共一行，为进行了右旋转操作后的字符串。

样例输入：

2
abcdefg 
样例输出：

fgabcde
数据范围：1 <= k < 10000, 1 <= s.length < 10000;

 */

 import java.util.Scanner;

/*
 * 使用整体反转+局部反转就可以实现反转单词顺序的目的。
 * 
 */
 

public class RightReverseString {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();

        int len = s.length();
        char[] chars = s.toCharArray();
        reverseString(chars, 0, len-1);
        reverseString(chars, 0, n-1);
        reverseString(chars, n, len-1);

        System.out.println(chars);
        sc.close();
    }

    public static void reverseString(char[] chars, int left, int right) {  
        while(left<right){
            chars[left] ^= chars[right];
            chars[right] ^= chars[left];
            chars[left] ^= chars[right];
            left++;
            right--;
        }

    }

}
