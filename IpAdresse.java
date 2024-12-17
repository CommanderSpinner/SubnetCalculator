package com.mycompany.subnet_rechner;

public class IpAdresse {

    private String[] ipAdressBinary;
    private String ipAdressDecimal;

    public void toBinaryAdress() {
        String[] ipAdressDecimalSplit = ipAdressDecimal.split("\\.");

        String[] ipAdressBinaryTemp = new String[ipAdressDecimalSplit.length];// temp weil ipAdressBinary hier null ist

        for (int i = 0; i < ipAdressDecimalSplit.length; i++) {
            //System.out.println("(Debug)ipAdressDecimalSplit: " + ipAdressDecimalSplit[i]); //debug
            ipAdressBinaryTemp[i] = NumberConverter.fromDecimalToBinary(Integer.parseInt(ipAdressDecimalSplit[i]));

            //System.out.println("(Debug)ipAdressBinary: " + ipAdressBinaryTemp[i]); // debug
            if (ipAdressBinaryTemp[i].length() < 8) {
                ipAdressBinaryTemp[i] = "0".repeat(8 - ipAdressBinaryTemp[i].length()) + ipAdressBinaryTemp[i];
            }
        }
        ipAdressBinary = ipAdressBinaryTemp;
    }

    public IpAdresse(String ipAdresse){
        ipAdressDecimal = ipAdresse;
    }
    
    public String getIpAdressDecimal() {
        return ipAdressDecimal;
    }

    public void setIpAdressDecimal(String ipAdressDecimal) {
        this.ipAdressDecimal = ipAdressDecimal;
    }

    public String[] getIpAdressBinary() {
        return ipAdressBinary;
    }

    public void setIpAdressBinary(String[] ipAdressBinary) {
        this.ipAdressBinary = ipAdressBinary;
    }

    @Override
    public String toString() {
        String output = "ipAdressBinary: ";

        for (int i = 0; i < ipAdressBinary.length; i++) {
            output += ipAdressBinary[i] + ".";
        }

        output += "\nipAdressDecimal: " + ipAdressDecimal;

        return output;
    }
}
