package com.kane;

/**
 * @program: offer67
 * @description: 数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 * @author: Mr.kane
 * @creater: 2020-07-30 15:29
 **/

public class JZ12_power {

    public double power(double base, int exponent){

        double result = 0.0;
        if(exponent == 0){
            return  1.0;
        }else{
            if(exponent > 0){
                result = powerExponent(base,exponent);
            }else {
                result = 1.0/powerExponent(base,-exponent);
            }
            return result;
        }
    }

    public double powerExponent(double base, int exponent){

        double result = 1.0;
        for(int i = 0; i < exponent; i++){
            result = result * base;
            if(result > Double.MAX_VALUE){
                throw new RuntimeException("已经超出double类型的取值范围。");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        JZ12_power jz12_power = new JZ12_power();
        double base = 2.03;
        int exponent = -2;
        System.out.println(jz12_power.power(base,exponent));
    }
}
