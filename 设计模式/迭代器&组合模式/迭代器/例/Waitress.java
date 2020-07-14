import java.awt.*;

/**
 * @autor hecaigui
 * @date 2020-1-30
 * @description
 */
public class Waitress {

    //服务员使用迭代器接口来遍历数据
    static void  printMenu(DinnerMenu dinnerMenu){
        Iterator iterator = dinnerMenu.createIterator();
        while (iterator.hasNext()){
            //MenuItem menuItem = (MenuItem)iterator.next();
            String menuItem = (String)iterator.next();
            System.out.println(menuItem);
            //...
        }
    }

    public static void main(String[] args) {
        String[] menu = {"1","2菜单"};
        Waitress.printMenu(new DinnerMenu(menu));
    }
}
