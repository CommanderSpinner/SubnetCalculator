package com.mycompany.subnet_rechner;

public class SubnetCalculator {

    Subnetmask sn;
    IpAdresse ip;

    public SubnetCalculator(Subnetmask sn, IpAdresse ip) {
        this.sn = sn;
        this.ip = ip;
    }

    public String getNetAddress() {
        String netAddress = "";

        char[] binMask = sn.getBinaryMask().toCharArray();

        for (int i = 0; i < ip.getIpAdressBinary().length; i++) {
            netAddress += ip.getIpAdressBinary()[i];
        }

        char[] netAdressChar = netAddress.toCharArray();

        for (int i = 0; i < binMask.length && i < netAdressChar.length; i++) {
            if (binMask[i] == '0') {
                netAdressChar[i] = '0';
            }
        }

        netAddress = new String();

        for (int i = 0; i < netAdressChar.length; i++) {
            if (i % 8 == 0) {
                if (i == 0) {
                    continue;
                }
                netAddress += ".";
            }
            netAddress += netAdressChar[i];
        }

        String[] netAdressArray = netAddress.split("\\.");

        String output = "";

        for (int i = 0; i < netAdressArray.length; i++) {
            output += NumberConverter.fromBinaryToDecimal(netAdressArray[i]) + ".";
        }

        return output;
    }

    public String getBroadcast() {
        String broadcast = "";

        char[] binMask = sn.getBinaryMask().toCharArray();

        for (int i = 0; i < ip.getIpAdressBinary().length; i++) {
            broadcast += ip.getIpAdressBinary()[i];
        }

        char[] BroadcastChar = broadcast.toCharArray();

        for (int i = 0; i < binMask.length && i < BroadcastChar.length; i++) {
            if (binMask[i] == '0') {
                BroadcastChar[i] = '1';
            }
        }

        broadcast = new String();

        for (int i = 0; i < BroadcastChar.length; i++) {
            if (i % 8 == 0) {
                if (i == 0) {
                    continue;
                }
                broadcast += ".";
            }
            broadcast += BroadcastChar[i];
        }

        String[] BroadcastArray = broadcast.split("\\.");

        String output = "";

        for (int i = 0; i < BroadcastArray.length; i++) {
            output += NumberConverter.fromBinaryToDecimal(BroadcastArray[i]) + ".";
        }

        return output;
    }

    public int getMaxHosts() {

        char[] mask = sn.getBinaryMask().toCharArray();
        int cidr = 0;
        
        for (int i = 0; i < mask.length; i++) {
            if(mask[i] == '1'){
                cidr++;
            }
        }
        
        int hosts = (int)Math.pow(2, 32 - cidr);
        
        hosts -= 2;
        
        return hosts;
    }

    public Subnetmask getSn() {
        return sn;
    }

    public void setSn(Subnetmask sn) {
        this.sn = sn;
    }

    public IpAdresse getIp() {
        return ip;
    }

    public void setIp(IpAdresse ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        String output = "";
        output += ip.toString();
        output += sn.toString();
        return output;
    }
}
