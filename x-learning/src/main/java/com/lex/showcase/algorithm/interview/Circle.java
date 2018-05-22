package com.lex.showcase.algorithm.interview;

import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;

/**
 * n个人围一圈报数，含有3的人退出最后剩下的人原来是几号
 */
public class Circle {

    public static void main(String[] args) {
        System.out.println("请输入围成圈的人数：");
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        List<Integer> group = new ArrayList<>();

        //1、给数组列表初始化数据
        for (int i = 1; i <= n; i++) {
            group.add(i);
        }

        //2、报数
        int number = 1;//第一个人报数为1

        //圈里的人循环报数
        for (int i = 0; i < n; i++) {
            if (number == 3) {//当圈里第i+1个人报道的数是3
                group.remove(i);//圈里第i+1个人退出圈子
                i--;//下一个报数的人在数组列表中的下标值
                n--;//圈子的总人数减少1
                number = 0;//通过number++，下一个人报的数是1
            }

            number++;  //报数时，每次加1
            if (i == n - 1) {//当所有的人报完一圈
                i = -1;//下一次从圈里的第一个人报，通过for循环的i++,对应数组列表下标值为0
            }

            if (n == 1) {//如果整个圈子最后只剩下一人
                break;
            }
        }

        System.out.println("最后留下的是原来" + group.get(0) + "号的那位。");
    }
}


