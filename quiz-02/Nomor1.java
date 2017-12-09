import java.util.*;

public class Nomor1 {
    public static void main(String[] args) {
        mainMethod();
    }

    public static List<String> hilangkanDuplikasi(List<String> param) {
        List<String> output = new ArrayList<String>();
        for (String str: param) {
            if (output.contains(str)){
                continue;
            }
            else {
                output.add(str);
            }
        }
        return output;
    }

    public static void print(String[] input) {
        List<String> list = Arrays.asList(input);
        System.out.println(list + " -> " + hilangkanDuplikasi(list));
    }

    public static void mainMethod() {
        String[] input1 = {"aa","aa","ab","ca","cab","e","e"};
        String[] input2 = {"a"};
        String[] input3 = {"hehe","hehe","hehe"};
        String[] input4 = {};
        print(input1);
        print(input2);
        print(input3);
        print(input4);
    }
}