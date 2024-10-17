package com.zz.yang.test.rx;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class JavaTest {

    public static void main(String[] args) {
        System.out.println("main::START");
    }

    public JavaTest() {
        System.out.println("JavaTest::START");

        //문자열 섞기
        {
            solution("abc1abc1abc");
        }

        solution(new int[] {3, 4, 5, 2, 1});
    }

    public String solution(String code) {
        String answer = "";
        StringBuilder ret = new StringBuilder();
        char[] arr = code.toCharArray();
        int size = arr.length;
        int mode = 0;

        for (int idx = 0; idx<size; idx++) {
            if (arr[idx] == '1') {
                if (mode == 0) {
                    mode = 1;
                } else {
                    mode = 0;
                }
            } else {
                if (idx % 2 == mode) {
                    ret.append(arr[idx]);
                }
            }
        }

        answer = ret.toString();
        System.out.println(answer);
        if (answer.length() == 0) {
            answer = "EMPTY";
        }

        return answer;
    }

    public int solution(int[] num_list) {
        int answer = 0;
        int mult = Arrays.stream(num_list).reduce(1, (total, num) ->
                total * num);

        int plus = Arrays.stream(num_list).reduce(0, (total, num) ->
                total + num);
        plus = plus * plus;
        if (mult < plus) {
            answer = 1;
        }

        Arrays.stream(num_list).forEach(it -> {
            if (it % 2 == 0) {
                System.out.println(it + "짝수");
            } else {
                System.out.println(it + "홀수");
            }
        });

        return answer;
    }




}
