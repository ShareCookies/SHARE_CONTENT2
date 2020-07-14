/**
 * @autor hecaigui
 * @date 2020-1-30
 * @description
 */
public class DinnerMenu {
    String[] menuItems;
    DinnerMenu(String[] menuItems){
        this.menuItems = menuItems;
    }
    //具体的子类返回其定义的迭代器接口实现
    public Iterator createIterator(){
        return new DinnerMenuIterator(menuItems);
    }
}
