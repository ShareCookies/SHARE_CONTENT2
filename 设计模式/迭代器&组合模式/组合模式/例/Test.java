/**
 * @autor hecaigui
 * @date 2020-1-31
 * @description
 */
public class Test {
    public static void main(String args[]){
		//先创建顶层菜单
		MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU","Breakfast");
		MenuComponent allMenu = new Menu("PANCAKE HOUSE MENU","Breakfast");
        allMenus.add (pancakeHouseMenu);
        //为早午晚菜单添加菜单项
		pancakeHouseMenu.add (new MenuItem ("Apple Pie",  1.59));
		
		allMenu.print();
		
    }
}
