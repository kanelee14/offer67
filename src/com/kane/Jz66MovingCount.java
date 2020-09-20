package com.kane;

/**
 * @program: offer67
 * @description: 机器人的运动范围
 *
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * @author: Mr.kane
 * @creater: 2020-09-20 14:44
 **/

public class Jz66MovingCount {

    public int movingCount(int threshold, int rows, int cols){

        boolean[][] visited = new boolean[rows][cols];
        return countingSteps(threshold, rows, cols, 0, 0, visited);
    }

    public int countingSteps(int threshold, int rows, int cols, int r, int c, boolean[][] visited){
        if(r < 0 || c < 0 || r >= rows || c >= cols || visited[r][c]
                || bitSum(r) + bitSum(c) > threshold){
            return 0;
        }
        visited[r][c] = true;
        return countingSteps(threshold, rows, cols, r - 1, c, visited)
                + countingSteps(threshold, rows, cols, r + 1, c, visited)
                + countingSteps(threshold, rows, cols, r, c - 1, visited)
                + countingSteps(threshold, rows, cols, r, c + 1 , visited);
    }

    public int bitSum(int n){
        int count = 0;
        while (n != 0){
            count += n % 10;
            n /= 10;
        }
        return count;
    }
}
