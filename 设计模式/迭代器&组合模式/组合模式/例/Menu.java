import java.util.ArrayList;

/**
 * @autor hecaigui
 * @date 2020-1-31
 * @description
 */
public class Menu extends MenuComponent {
    ArrayList menuComponents = new ArrayList();
    String name;
    String description;

    public Menu(String name , String description){
        this.name = name;
        this.description = description;
    }
    @Override
    public void add(MenuComponent menuComponent){
        menuComponents.add(menuComponent);
    }
    @Override
    public void remove(MenuComponent menuComponent){
        menuComponents.remove(menuComponent);
    }
    @Override
    public MenuComponent getChild(int i){
        return (MenuComponent)menuComponents.get(i);
    }
    @Override
    public String getName(){

    }
    @Override
    public  String getDescription(){

    }
    @Override
    public  void  print(){
        //
    }

}
