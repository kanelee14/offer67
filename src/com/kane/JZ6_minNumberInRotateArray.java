package com.kane;

/**
 * @program: offer67
 * @description: 旋转数组中的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @author: Mr.kane
 * @creater: 2020-07-29 17:07
 **/

public class JZ6_minNumberInRotateArray {
    /***
    * @Description:
    *     采用二分法解答这个问题，
     *     mid = low + (high - low)/2
     *     需要考虑三种情况：
     *     (1)array[mid] > array[high]:
     *     出现这种情况的array类似[3,4,5,6,0,1,2]，此时最小数字一定在mid的右边。
     *     low = mid + 1
     *     (2)array[mid] == array[high]:
     *     出现这种情况的array类似 [1,0,1,1,1] 或者[1,1,1,0,1]，此时最小数字不好判断在mid左边
     *     还是右边,这时只好一个一个试 ，
     *     high = high - 1
     *     (3)array[mid] < array[high]:
     *     出现这种情况的array类似[2,2,3,4,5,6,6],此时最小数字一定就是array[mid]或者在mid的左
     *     边。因为右边必然都是递增的。
     *     high = mid
     *     注意这里有个坑：如果待查询的范围最后只剩两个数，那么mid 一定会指向下标靠前的数字
     *     比如 array = [4,6]
     *     array[low] = 4 ;array[mid] = 4 ; array[high] = 6 ;
     *     如果high = mid - 1，就会产生错误， 因此high = mid
     *     但情形(1)中low = mid + 1就不会错误
    */
    public int minNumerInRotageArray(int[] array){

        if(array == null || array.length == 0){
            return 0;
        }
        int minNumber = 0;
        int first = 0;
        int end = array.length - 1;

        while (array[first] >= array[end]){

            if((end - first) == 1){
                minNumber = end;
                break;
            }

            minNumber = first + (end - first)/2;

            if(array[minNumber] > array[first]){
                first =  minNumber + 1;
            }
            if(array[minNumber] == array[end]){
                end = end - 1;
            } else if(array[minNumber] < array[end]){
                end = minNumber;
            }
        }
        System.out.println(array[minNumber]);
        return array[minNumber];

    }

    public static void main(String[] args) {
        JZ6_minNumberInRotateArray jz6_minNumberInRotateArray = new JZ6_minNumberInRotateArray();
        int[] array = {3,1,2};
        jz6_minNumberInRotateArray.minNumerInRotageArray(array);
    }
}
