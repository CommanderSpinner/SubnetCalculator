package com.mycompany.subnet_rechner;

public class NumberConverter {

    public static String fromDecimalToBinary(int number) {
        String res = "";
        if (number > 0) {
            int divisionres = number;
            int rest = 0;
            while (divisionres > 0) {
                rest = divisionres % 2;
                divisionres = divisionres / 2;
                res = rest + res;
            }
            if ("".equals(res)) {
                res = "0";
            }
            return res;
        } else {
            return "0";
        }
    }

    public static int fromBinaryToDecimal(String number) {
        int mult = 1;
        int res = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            Integer s = Integer.parseInt(Character.toString(number.charAt(i)));
            res += s * mult;
            mult *= 2;
        }
        return res;
    }

    public static String fromBinaryToDecimalIP(String binIp) {
        return "";
    }

    public static String fromDecimalToBinaryIP(String decIp) {
        return "";
    }
}
