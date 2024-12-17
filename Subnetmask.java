package com.mycompany.subnet_rechner;

public class Subnetmask {

    private int cidr;
    private String mask = "";

    public String getMask() {
        return mask;
    }

    public Subnetmask(int cidr) {
        this.cidr = cidr;
        //Berechne mask
        int zerosToAdd = cidr;
        for (int i = 0; i < cidr; i++) {
            mask += "1";
            zerosToAdd--;
        }
        for (int i = 0; i < zerosToAdd; i++) {
            mask += "0";
        }
    }

    public Subnetmask(String mask) {
        this.mask = mask;
        //berechne CIDR
        String maskBin = getBinaryMask();
        
        char[] maskChar = maskBin.toCharArray();
        
        for (int i = 0; i < maskChar.length; i++) {
            if(maskChar[i] == '1'){
                cidr++;
            }
        }
        System.out.println("cidr: " + cidr); // debug
    }

    public String getBinaryMask() {
        String maskBin = "";
        String[] maskTemp = this.mask.split("\\.");
        for (int i = 0; i < maskTemp.length; i++) {
            maskBin += NumberConverter.fromDecimalToBinary(Integer.parseInt(maskTemp[i]));
        }
        return maskBin;
    }

    @Override
    public String toString() {
        return "cidr:" + cidr + "\nmask:" + mask;
    }
}
