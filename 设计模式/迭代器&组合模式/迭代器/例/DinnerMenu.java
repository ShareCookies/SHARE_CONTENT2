/**
 * @autor hecaigui
 * @date 2020-1-30
 * @description
 */
public class DinnerMenu {
    //具体的子类返回其定义的迭代器接口实现
    public Iterator createIterator(){
        return new DinnerMenuIterator(menu);
    }
}
