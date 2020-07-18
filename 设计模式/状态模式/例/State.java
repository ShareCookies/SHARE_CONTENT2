/**
 * @autor hecaigui
 * @date 2020-1-31
 * @description
 */
public interface State {
    // 投入25美分
    void insertQuater();
    // 退还顾客25美分
    void ejectQuater();
    // 转动手柄
    void turnCrank();
    // 分发糖果
    void dispense();
}
