/*
In this Program , we will Create methods to implement different operations on a String
The Methods include : Append, CountWords, Replace, isPalindrome, Splice, Split,
 MaxRepeatingCharacter, Sort, Shift, and Reverse.
 Program Owned by - Ojas Joshi
 Date -> 04/09/2024
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringOperations {
    public static String currentStr;
    public static void main(String[] args) {
        System.out.println(Constants.Welcome);
        Scanner scan = new Scanner(System.in);
        System.out.println(Constants.currentString);
        currentStr = scan.nextLine();
        System.out.println(Constants.OperationChoices);
        while (true) {
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    System.out.println(Constants.appendOp);
                    System.out.println(Constants.appendedStr);
                    String appendStr = scan.nextLine();
                    System.out.println(append(appendStr));
                    break;
                case 2:
                    System.out.println(Constants.NoOfWords + countWords());
                    break;
                case 3:
                    System.out.println(Constants.replaceOp);
                    System.out.println(Constants.firstChar);
                    char a = scan.next().charAt(0);
                    System.out.println(Constants.secondChar);
                    char b = scan.next().charAt(0);
                    System.out.println(replace(a, b));
                    break;
                case 4:
                    System.out.println(isPalindrome());
                    break;
                case 5:
                    System.out.println(Constants.spliceOp);
                    System.out.println(Constants.startIndex);
                    int start = scan.nextInt();
                    System.out.println(Constants.spliceLength);
                    int length = scan.nextInt();
                    System.out.println(splice(start, length));
                    break;
                case 6:
                    String[] arr = split();
                    for (String s : arr) {
                        System.out.print(s + " ");
                    }
                    System.out.println();
                    break;
                case 7:
                    System.out.println(Constants.maxRepeatingChar+ maxChar());
                    break;
                case 8:
                    System.out.println(Constants.sortedString + sort());
                    break;
                case 9:
                    System.out.println(Constants.shiftOp);
                    System.out.println(Constants.shiftIdx);
                    int n = scan.nextInt();
                    System.out.println(shift(n));
                    break;
                case 10:
                    System.out.println(Constants.reversedString + reverse());
                    break;
                case 0:
                    System.out.println(Constants.exit);
                    break;
                default:
                    System.out.println(Constants.InvalidIp);
                    break;
            }
            if (choice == 0) {
                break;
            }
        }

    }
    public static String append(String s){
        currentStr = currentStr + s;
        return currentStr ;
    }
    public static boolean isPalindrome(){
        for(int i = 0,j=currentStr.length()-1;i<currentStr.length()/2;i++,j--){
            if(currentStr.charAt(i) != currentStr.charAt((j))){
                return false;
            }
        }
        return true;
    }
    public static String sort(){
        char[] arr = new char[currentStr.length()];
        for(int i = 0;i<currentStr.length();i++){
            arr[i] = currentStr.charAt(i);
        }
        Arrays.sort(arr);
        return new String(arr) ;
    }
    public static String splice(int start , int length){
        if (start < 0 || start >= currentStr.length() || start + length > currentStr.length()) {
            return Constants.InvalidIp;
        }
        char[] arr = new char[currentStr.length()- length];
        int index = 0;
        for (int i = 0; i < currentStr.length(); i++) {
            if (i < start || i >= start + length) {
                arr[index++] = currentStr.charAt(i);
            }
        }

        return new String(arr);
    }
    public static String maxChar(){
        char temp =' ';
        List<Character> list = new ArrayList<>();
        int maxCount = 0;
        for(int i = 0;i<currentStr.length();i++){

            for(int j = i;j<currentStr.length();j++){
                if(currentStr.charAt(i)==currentStr.charAt(j)){
                    list.add(currentStr.charAt(j));
                }
            }
            if(list.size()>=maxCount){
                maxCount = list.size();
                temp = list.get(0);
            }
            list.clear();
        }

        return temp+" -> "+maxCount;
    }
    public static String reverse(){
        char[] arr = new char[currentStr.length()];
        for(int i = 0,j=currentStr.length()-1;i<currentStr.length();i++,j--){
            arr[i] = currentStr.charAt(j);
        }
        return new String(arr);
    }
    public static String shift(int n){
        n= n % currentStr.length();
        char[] arr = new char[currentStr.length()];
        int index = 0;
        for(int i =currentStr.length() - n;i<currentStr.length();i++ ){
            arr[index++] = currentStr.charAt(i);
        }
        for(int i = 0; i < currentStr.length() - n ; i++){
            arr[index++] = currentStr.charAt(i);
        }
        return new String(arr);
    }
    public static int countWords(){
        String temp = currentStr;
        currentStr = " " +currentStr+" ";
        int count = 0;
        for(int i = 0; i <currentStr.length()-1 ; i++){
            if(currentStr.charAt(i)==' ' && currentStr.charAt(i+1) != ' '){
                count++;
            }
        }
        currentStr = temp;
        return count;
    }
    public static String replace(char a , char b){
        char[] arr = new char[currentStr.length()];
        for(int i = 0 ;i<arr.length;i++){
            arr[i] = currentStr.charAt(i);
        }
        for(int i = 0;i<arr.length;i++){
            if(arr[i]==a){
                arr[i] = b;
            }
        }
        return new String(arr);
    }
    public static String[] split(){
        List<String> list = new ArrayList<>();
        String temp = currentStr;
        temp = " "+temp+" ";
        for(int i = 0;i<temp.length();i++){
            for(int j = i+1;j<temp.length();j++){
                if(temp.charAt(i)==' ' && temp.charAt(j)==' '){
                    list.add(temp.substring(i,j));
                    i = j;
                }
            }
        }
        int index = 0;
        String[] words = new String[countWords()];
        for(int i = 0;i<list.size();i++){
            if(!list.get(i).isBlank()){
               words[index++] = list.get(i);
            }
        }
        return words;
    }
}
