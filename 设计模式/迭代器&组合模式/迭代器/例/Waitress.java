import java.awt.*;

/**
 * @autor hecaigui
 * @date 2020-1-30
 * @description
 */
public class Waitress {
    DinnerMenu dinnerMenu;
    //服务员使用迭代器接口来遍历数据
    void  printMenu(){
        Iterator iterator = dinnerMenu.createIterator();
        while (iterator.hasNext()){
            MenuItem menuItem = (MenuItem)iterator.next();
            //...
        }
    }
}
