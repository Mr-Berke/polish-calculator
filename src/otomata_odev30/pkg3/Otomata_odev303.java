package otomata_odev30.pkg3;

import java.util.Stack;
public class Otomata_odev303 {
    public static void main(String[] args) {
        String ifade = "* + * + 1 2 + 3 4 5 6";
        int sonuc2 = hesaplayici(ifade);
        System.out.println(sonuc2);    
    }
     private static int hesaplayici(String metin) {
        Stack<Integer> stack = new Stack<>();
        String[] ifadeler = metin.split("\\s+");

        for (int i= ifadeler.length - 1; i>=0; i--) {
            String ifade =ifadeler[i];
            if (numara_mi(ifade)) {
                stack.push(Integer.parseInt(ifade));
            } else {

                int sayi1 = stack.pop();
                int sayi2 = stack.pop();
                int  sonuc = 0;

                switch (ifade) {
                    case "+":
                        sonuc = sayi1 + sayi2;
                        break;

                    case "-":
                        sonuc = sayi1 - sayi2;
                        break;

                    case "*":
                        sonuc = sayi1 * sayi2;
                        break;

                    case "/":
                        sonuc = sayi2 / sayi1;
                        break;
                }
                stack.push(sonuc);
            }
        }
        return stack.pop();
    }
    private static boolean numara_mi(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
    

