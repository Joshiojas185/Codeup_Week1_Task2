/*
In this Program , we will Create methods to implement different operations on a String
The Methods include : Append, CountWords, Replace, isPalindrome, Splice, Split,
 MaxRepeatingCharacter, Sort, Shift, and Reverse.
 Program Owned by - Ojas Joshi
 Date -> 04/09/2024
 */
import java.util.Arrays;
import java.util.Scanner;
public class MyString {
    public static String currentString;
    public static void main(String[] args) {
        System.out.println(Constants.Welcome);
        Scanner scan = new Scanner(System.in);
        System.out.println(Constants.currentStringInput);
        currentString = scan.nextLine();
        System.out.println(Constants.OperationChoices);
        do {
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    System.out.println(Constants.appendOperation);
                    System.out.println(Constants.appendString);
                    String appendStr = scan.nextLine();
                    System.out.println(append(appendStr));
                    break;
                case 2:
                    System.out.println(Constants.NumberOfWords + countWords());
                    break;
                case 3:
                    System.out.println(Constants.replaceOperation);
                    System.out.println(Constants.firstCharacter);
                    char a = scan.next().charAt(0);
                    System.out.println(Constants.secondCharacter);
                    char b = scan.next().charAt(0);
                    System.out.println(replace(a, b));
                    break;
                case 4:
                    System.out.println(isPalindrome());
                    break;
                case 5:
                    System.out.println(Constants.spliceOperation);
                    System.out.println(Constants.startIndex);
                    int start = scan.nextInt();
                    System.out.println(Constants.spliceLength);
                    int length = scan.nextInt();
                    System.out.println(splice(start, length));
                    break;
                case 6:
                    String[] arrayOfString = split();
                    for (String s : arrayOfString) {
                        System.out.print(s + " ");
                    }
                    System.out.println();
                    break;
                case 7:
                    System.out.println(Constants.maximumRepeatingChar+ maxChar());
                    break;
                case 8:
                    System.out.println(Constants.sortedString + sort());
                    break;
                case 9:
                    System.out.println(Constants.shiftOperation);
                    System.out.println(Constants.shiftIndex);
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
                    System.out.println(Constants.InvalidInput);
                    break;
            }
            if (choice == 0) {
                break;
            }
        }
        while(true);

    }
    public static String append(String s){
        currentString = currentString + s;
        return currentString ;
    }
    public static boolean isPalindrome(){
        for(int i = 0,j=currentString.length()-1;i<currentString.length()/2;i++,j--){
            if(currentString.charAt(i) != currentString.charAt((j))){
                return false;
            }
        }
        return true;
    }
    public static String sort(){
        char[] arr = new char[currentString.length()];
        for(int i = 0;i<currentString.length();i++){
            arr[i] = currentString.charAt(i);
        }
        Arrays.sort(arr);
        return new String(arr) ;
    }
    public static String splice(int start , int length){
        if (start < 0 || start >= currentString.length() || start + length > currentString.length()) {
            return Constants.InvalidInput;
        }
        char[] arr = new char[currentString.length()- length];
        int index = 0;
        for (int i = 0; i < currentString.length(); i++) {
            if (i < start || i >= start + length) {
                arr[index++] = currentString.charAt(i);
            }
        }

        return new String(arr);
    }

    public static String maxChar(){
        char[] arrayOfCharacter = new char[currentString.length()];
        for(int i = 0;i<arrayOfCharacter.length;i++){
            arrayOfCharacter[i] = currentString.charAt(i);
        }
        Arrays.sort(arrayOfCharacter);
        char temp = ' ';
        int count = 1;
        int maxCount = 1;

        for (int i = 0; i < arrayOfCharacter.length - 1; i++) {
            if (arrayOfCharacter[i] == arrayOfCharacter[i+1] && arrayOfCharacter[i] != ' ') {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                    temp = arrayOfCharacter[i];
                }
                count = 1;
            }
        }
        if (count > maxCount) {
            maxCount = count;
            temp = arrayOfCharacter[arrayOfCharacter.length - 1];
        }

        return temp + " -> " + maxCount;
    }
    public static String reverse(){
        char[] arrayOfCharacter = new char[currentString.length()];
        for(int i = 0,j=currentString.length()-1;i<currentString.length();i++,j--){
            arrayOfCharacter[i] = currentString.charAt(j);
        }
        return new String(arrayOfCharacter);
    }
    public static String shift(int n){
        n= n % currentString.length();
        char[] arrayOfCharacter = new char[currentString.length()];
        int index = 0;
        for(int i =currentString.length() - n;i<currentString.length();i++ ){
            arrayOfCharacter[index++] = currentString.charAt(i);
        }
        for(int i = 0; i < currentString.length() - n ; i++){
            arrayOfCharacter[index++] = currentString.charAt(i);
        }
        return new String(arrayOfCharacter);
    }
    public static int countWords(){
        String temp = currentString;
        currentString = " " +currentString+" ";
        int count = 0;
        for(int i = 0; i <currentString.length()-1 ; i++){
            if(currentString.charAt(i)==' ' && currentString.charAt(i+1) != ' '){
                count++;
            }
        }
        currentString = temp;
        return count;
    }
    public static String replace(char a , char b){
        char[] arrayOfCharacter = new char[currentString.length()];
        for(int i = 0 ;i<arrayOfCharacter.length;i++){
            arrayOfCharacter[i] = currentString.charAt(i);
        }
        for(int i = 0;i<arrayOfCharacter.length;i++){
            if(arrayOfCharacter[i]==a){
                arrayOfCharacter[i] = b;
            }
        }
        return new String(arrayOfCharacter);
    }
    public static String[] split(){
        String temp = currentString;
        String[] words = new String[countWords()];
        temp = " "+temp+" ";
        int index = 0;
        for(int i = 0;i<temp.length()-1;i++){
            for(int j = i+1;j<temp.length();j++){
                if(temp.charAt(i)==' ' && temp.charAt(j)==' ' && temp.charAt(i+1) != ' '){
                    words[index++] = temp.substring(i,j);
                    i = j;
                }
            }
        }
        return words;
    }


}
