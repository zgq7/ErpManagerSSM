package com.erp;

public class test {
    public static void main(String[] args) {
        for (int i =  1 ; i< 94 ; i++) {
            int x = i % 3 ;
            if(x == 0){
                System.out.println(i*2 - 1);
            }
        }
    }
}
