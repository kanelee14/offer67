package com.kane;

import java.util.ArrayList;

/**
 * @program: offer67
 * @description: 和为S的连续正数序列
 *
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,
 * 他马上就写出了正确答案是100。但是他并不满足于此,
 * 他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，
 * 序列间按照开始数字从小到大的顺序
 *
 * @author: Mr.kane
 * @creater: 2020-09-03 18:16
 **/

public class Jz41FindContinuousSequence {

    /**
     * @desc TODO
     * @author lynn
     * @date 2020/9/4 09:23
     * @return int
     */

    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum){

        ArrayList<ArrayList<Integer>>  arrayLists = new ArrayList<>();
        int low = 1, high = 2;
        while(high > low){
            int cur = (high + low) * (high - low + 1) / 2;
            if(cur == sum){
                ArrayList<Integer> arrayList = new ArrayList<>();
                for(int i = low; i <= high; i++){
                    arrayList.add(i);
                }
                arrayLists.add(arrayList);
                low++;
            }else if(cur < sum){
                high++;
            }else{
                low++;
            }
        }
        return arrayLists;
    }
}
