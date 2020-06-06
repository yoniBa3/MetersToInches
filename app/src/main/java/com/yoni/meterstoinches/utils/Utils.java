package com.yoni.meterstoinches.utils;

public class Utils {

    public static boolean checkIfNumber(String number){

        char[] chars = number.toCharArray();
        int counter = 0;
        for(char ch:chars){
            if (ch > 47 && ch < 58 || ch == 46){
                if (ch == 46 ){
                    counter ++ ;
                }
                if (counter > 1){
                    return false;
                }
            }else {
                return false;
            }
        }


        return true;
    }
}
