import javax.validation.constraints.Min;

/**
 * @autor hecaigui
 * @date 2020-1-11
 * @description
 */
public class AdapterTest {
    public static void main(String[] args) {
        MiniDuck miniDuck = new MiniDuck();
        WildTurkey wildTurkey = new WildTurkey();

        Duck duckAdapter = new TurkeyAdapter(wildTurkey);
        duckAdapter.fly();
        duckAdapter.quack();
    }
}