package com.java.spring;

public class AopHelloImpl implements AopHello{
    public int add(int i, int j) {
        //System.out.println("The method add begins with["+ i +","+ j +"]");
        int result = i+j;
        //System.out.println("The method add ends with "+result);
        return result;
    }

    public int sub(int i, int j) {
        int result = i-j;
        return result;
    }

    public int mul(int i, int j) {
        int result = i*j;
        return result;
    }

    public int div(int i, int j) {
        int result = i/j;
        return result;
    }
}
