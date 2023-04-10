package br.com.erudio.util;

public class NumberConverter {
    public static Double convertToDouble(String strNumber){
        //10,25 ||10.25
        String number=strNumber.replaceAll(",",".");
        if(strNumber==null){
            return 0D;
        }
        if(isNumeric(number)){
            return Double.parseDouble(number);
        }
        return 0D;
    }
    public static boolean isNumeric(String strNumber){
        String number=strNumber.replaceAll(",",".");

        if(strNumber==null){
            return false;
        }
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
