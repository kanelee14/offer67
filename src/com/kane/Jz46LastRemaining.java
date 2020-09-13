package com.kane;

/**
 * @program: offer67
 * @description: 圆圈中最后剩下的数
 *
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:
 * 首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,
 * 并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....
 * 直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 *
 * @author: Mr.kane
 * @creater: 2020-09-09 14:16
 **/

public class Jz46LastRemaining {

    public int lastRemaining(int n, int m) {

        if(n < 1 || m < 1){
            return -1;
        }
//        int [] array = new int[n] ;
//        int i = -1, step = 0, count = n;
//        while(count > 0){
//            i++;
//            if(i >= n){
//                i = 0;
//            }
//            if(array[i] == -1){
//                continue;
//            }
//            step++;
//            if(step == m){
//                array[i] = -1;
//                step = 0;
//                count --;
//            }
//        }
//        return i;
//    }

//                找规律
//        使用动态规划。我们注意到，输入的序列在删除一个元素后，序列的长度会改变，如果索引
//        在被删除的元素位置开始计算，那么每删除一个元素，序列的长度减一而索引会完全改变。
//        如果能找到改变前的索引和新索引的对应关系，那么该问题就容易解决了。
//        我们定义一个函数f(n, m)，表示每次在n个数字0,1,2,3,…,n-1中每次删除第m个数字后剩下
//        的数字。那么第一个被删除的数字的索引是(m-1)%n。删除该索引元素后，剩下的n-1个数字
//        为0,1,2,…,k-1,k+1,…,n-1。下次删除数字是重k+1位置开始，于是可以把序列看
//        作k+1,..,n-1,0,1,…,k-1。该序列最后剩下的序列也是f的函数。但该函数和第一个函数
//        不同，存在映射关系，使用f'来表示，于是有：f(n, m)=f'(n-1, m)。接下来需要找到映射关系。
//        k+1 --> 0
//        k+2 --> 1
//                .
//     .
//     .
//        n-1 --> n-k-2
//        0   --> n-k-1
//                .
//     .
//     .
//        k-1 --> n-2
//        所以可以得到：right = left-k-1，则p(x) = (x-k-1)%n，而逆映射是p'(x) = (x+k+1)%n
//        即0~n-1序列中最后剩下的数字等于（0~n-2序列中最后剩下的数字+k）%n，很明显当n=1时，
//        只有一个数，那么剩下的数字就是0.问题转化为动态规划问题，关系表示为：
//
//        f(n)=(f(n-1)+m)%n； 当n=1,f(1)=0;


        int tmp = 0;
        for (int i = 2; i <= n; i++) {
            tmp = (tmp + m) % i;
        }
        return tmp;
    }
}