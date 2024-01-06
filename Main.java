package com.mycompany.subnet_rechner;

// @author Lorenz Schaller

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        
        System.out.println("drücken sie 1 für subnetzmaske | 2 für cidr nummer: ");
        int inputIfCidr = s1.nextInt();
        Subnetmask sm;
                
        if(inputIfCidr == 1){
            System.out.println("eingabe der subnetzmaske: ");
            String inputSN = s2.nextLine();
            sm = new Subnetmask(inputSN);
        }else{
            System.out.println("eingabe der cidr nummer: ");
            int inputCN = s1.nextInt();
            sm = new Subnetmask(inputCN);
        }
        
        System.out.println("ip adresse eingeben: ");
        String inputIP = s2.nextLine();
        
        IpAdresse ip = new IpAdresse(inputIP);
        
        ip.setIpAdressDecimal(inputIP);
        ip.toBinaryAdress();
        //System.out.println(ip);
        
        SubnetCalculator sc = new SubnetCalculator(sm, ip);
        
        System.out.println("net adress: " + sc.getNetAddress());
        System.out.println("broadcast adress: " + sc.getBroadcast());
        System.out.println("max hosts: " + sc.getMaxHosts());
    }
}