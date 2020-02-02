import java.awt.*;

/**
 * @autor hecaigui
 * @date 2020-1-30
 * @description
 */
//具体的子类实现迭代器接口
public class DinnerMenuIterator implements Iterator{
    MenuItem[] items;
    int position = 0;
    DinnerMenuIterator(MenuItem[] menuItems){
        this.items = menuItems;
    }
    @Override
    public Object next(){
        MenuItem menuItem = items[position];
        position = position + 1;
        return menuItem;
    }
    @Override
    public boolean hasNext(){
        if (position >= items.length || items[position] == null){
            return false;
        }else {
            return true;
        }
    }
}
