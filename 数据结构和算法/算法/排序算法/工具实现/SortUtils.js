/* eslint-disable */
const ArraySortUtils = {
    /**
     * 数组内对象的升序插入排序
     * <p> sortNo 确保排序号都有值 </p>
     * @param array（[{sortNo:666},{sortNo:6}] ） objCompareField（字符串'sortNo'）
     * @returns {Array|*}
     */
    ascSortByInsertForObj: function (array,objCompareField) {
        //debugger;
        if (!(array instanceof Array) || !(typeof objCompareField === 'string')){
            return;
        }
        // sortNo 确保排序号都有值，无值可以考虑默认全部赋值为99999
        for (let i=0;i<array.length;i++){
            array[i][objCompareField] = parseInt(array[i][objCompareField]);
            if (!(typeof array[i][objCompareField] === 'number') || isNaN(parseInt(array[i][objCompareField]))){
                array[i][objCompareField] = 99999999;
            }
        }
        let temp;
        for (let i=1;i<array.length;i++){
            if (array[i][objCompareField]<array[i-1][objCompareField]){//如果待排序元素小于已排序元素，则开始准备移动该待排元素，否则该待排元素则进入已排序元素。
                temp = array[i];//记录待排元素(因为这样可以直接用这个临时元素移动而不用管这个元素是否丢失，只要确保旧元素不会丢失就好)
                for (let j=i;j>=0;j--){
                    if (j>0 && array[j-1][objCompareField]>temp[objCompareField]) {// 排序元素与已排序元素比较，并交换位置
                        array[j]=array[j-1];
                    } else {
                        array[j]=temp;
                        break;
                    }
                }
            }
        }
        console.log(array);
        //debugger;
        return array;
    }
};
export { ArraySortUtils };

// 应用：//import { ArraySortUtils } from '@test/test-comon/src/utils/SortUtils.js';