package common.utils;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * @autor hecaigui
 * @date 2020-1-18
 * @description Robot常用工具类（外观模式）
 */
public class RobotCommonUtils {
    public  Robot rb ;
    public RobotCommonUtils(Robot rb ){
        this.rb = rb;
        //设置Robot产生一个动作后的默认休眠时间ms,否则执行过快可能会有异常
        this.rb.setAutoDelay(5);
    }
    /**
     * @description 判断是否开启大写键
     * @return  true 开启 false关闭
     */
    public static boolean isUpperLetter() {
        return Toolkit.getDefaultToolkit().getLockingKeyState(
                KeyEvent.VK_CAPS_LOCK);
    }
    /**
     * @description 鼠标左击
     */
    public  void mouseLeftClick(int delay){
        rb.mousePress(InputEvent.BUTTON1_MASK);
        rb.delay(10);
        rb.mouseRelease(InputEvent.BUTTON1_MASK);
    }
    /**
     * @description 鼠标右击
     */
    public  void mouseRightClick(int delay){
        rb.mousePress(InputEvent.BUTTON3_MASK);
        rb.delay(10);
        rb.mouseRelease(InputEvent.BUTTON3_MASK);
    }
    /**
     * @description alt+tab
     */
    public  void altTab() {
        //按下Alt+TAB键（切换桌面窗口）
        rb.keyPress(KeyEvent.VK_ALT);
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_ALT);
    }
    /**
     * @description 字符串转robot键盘事件 todo:确保键盘处于英文
     * @param s 数字，26字符 空格 . 等部分特殊字符
     */
    public  void stringTransferToRobotKeyEvent(String s) {
        //确保处于大写状态
        if (!RobotCommonUtils.isUpperLetter()){
            rb.keyPress(KeyEvent.VK_CAPS_LOCK);
            rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
        }
        char ss[] = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            switch (ss[i]){
                case 'a':
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    rb.keyPress(KeyEvent.VK_A);
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    break;
                case 'b':
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    rb.keyPress(KeyEvent.VK_B);
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    break;
                case 'c':
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    rb.keyPress(KeyEvent.VK_C);
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    break;
                case 'd':
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    rb.keyPress(KeyEvent.VK_D);
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    break;
                case 'e':
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    rb.keyPress(KeyEvent.VK_E);
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    break;
                case 'f':
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    rb.keyPress(KeyEvent.VK_F);
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    break;
                case 'g':
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    rb.keyPress(KeyEvent.VK_G);
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    break;
                case 'h':
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    rb.keyPress(KeyEvent.VK_H);
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    break;
                case 'i':
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    rb.keyPress(KeyEvent.VK_I);
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    break;
                case 'j':
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    rb.keyPress(KeyEvent.VK_J);
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    break;
                case 'k':
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    rb.keyPress(KeyEvent.VK_K);
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    break;
                case 'l':
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    rb.keyPress(KeyEvent.VK_L);
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    break;
                case 'm':
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    rb.keyPress(KeyEvent.VK_M);
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    break;
                case 'n':
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    rb.keyPress(KeyEvent.VK_N);
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    break;
                case 'o':
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    rb.keyPress(KeyEvent.VK_O);
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    break;
                case 'p':
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    rb.keyPress(KeyEvent.VK_P);
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    break;
                case 'q':
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    rb.keyPress(KeyEvent.VK_Q);
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    break;
                case 'r':
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    rb.keyPress(KeyEvent.VK_R);
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    break;
                case 's':
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    rb.keyPress(KeyEvent.VK_S);
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    break;
                case 't':
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    rb.keyPress(KeyEvent.VK_T);
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    break;
                case 'u':
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    rb.keyPress(KeyEvent.VK_U);
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    break;
                case 'v':
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    rb.keyPress(KeyEvent.VK_V);
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    break;
                case 'w':
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    rb.keyPress(KeyEvent.VK_W);
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    break;
                case 'x':
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    rb.keyPress(KeyEvent.VK_X);
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    break;
                case 'y':
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    rb.keyPress(KeyEvent.VK_Y);
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    break;
                case 'z':
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    rb.keyPress(KeyEvent.VK_Z);
                    rb.keyPress(KeyEvent.VK_CAPS_LOCK);
                    rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    break;
                case 'A':
                    rb.keyPress(KeyEvent.VK_A);
                    break;
                case 'B':
                    rb.keyPress(KeyEvent.VK_B);
                    break;
                case 'C':
                    rb.keyPress(KeyEvent.VK_C);
                    break;
                case 'D':
                    rb.keyPress(KeyEvent.VK_D);
                    break;
                case 'E':
                    rb.keyPress(KeyEvent.VK_E);
                    break;
                case 'F':
                    rb.keyPress(KeyEvent.VK_F);
                    break;
                case 'G':
                    rb.keyPress(KeyEvent.VK_G);
                    break;
                case 'H':
                    rb.keyPress(KeyEvent.VK_H);
                    break;
                case 'I':
                    rb.keyPress(KeyEvent.VK_I);
                    break;
                case 'J':
                    rb.keyPress(KeyEvent.VK_J);
                    break;
                case 'K':
                    rb.keyPress(KeyEvent.VK_K);
                    break;
                case 'L':
                    rb.keyPress(KeyEvent.VK_L);
                    break;
                case 'M':
                    rb.keyPress(KeyEvent.VK_M);
                    break;
                case 'N':
                    rb.keyPress(KeyEvent.VK_N);
                    break;
                case 'O':
                    rb.keyPress(KeyEvent.VK_O);
                    break;
                case 'P':
                    rb.keyPress(KeyEvent.VK_P);
                    break;
                case 'Q':
                    rb.keyPress(KeyEvent.VK_Q);
                    break;
                case 'R':
                    rb.keyPress(KeyEvent.VK_R);
                    break;
                case 'S':
                    rb.keyPress(KeyEvent.VK_S);
                    break;
                case 'T':
                    rb.keyPress(KeyEvent.VK_T);
                    break;
                case 'U':
                    rb.keyPress(KeyEvent.VK_U);
                    break;
                case 'V':
                    rb.keyPress(KeyEvent.VK_V);
                    break;
                case 'W':
                    rb.keyPress(KeyEvent.VK_W);
                    break;
                case 'X':
                    rb.keyPress(KeyEvent.VK_X);
                    break;
                case 'Y':
                    rb.keyPress(KeyEvent.VK_Y);
                    break;
                case 'Z':
                    rb.keyPress(KeyEvent.VK_Z);
                    break;
                case '0':
                    rb.keyPress(KeyEvent.VK_0);
                    break;
                case '1':
                    rb.keyPress(KeyEvent.VK_1);
                    break;
                case '2':
                    rb.keyPress(KeyEvent.VK_2);
                    break;
                case '3':
                    rb.keyPress(KeyEvent.VK_3);
                    break;
                case '4':
                    rb.keyPress(KeyEvent.VK_4);
                    break;
                case '5':
                    rb.keyPress(KeyEvent.VK_5);
                    break;
                case '6':
                    rb.keyPress(KeyEvent.VK_6);
                    break;
                case '7':
                    rb.keyPress(KeyEvent.VK_7);
                    break;
                case '8':
                    rb.keyPress(KeyEvent.VK_8);
                    break;
                case '9':
                    rb.keyPress(KeyEvent.VK_9);
                    break;
                case ',':
                    rb.keyPress(KeyEvent.VK_COMMA);
                    break;
                case '-':
                    rb.keyPress(KeyEvent.VK_MINUS);
                    break;
                case '.':
                    rb.keyPress(KeyEvent.VK_PERIOD);
                    break;
                case '/':
                    rb.keyPress(KeyEvent.VK_SLASH);
                    break;
                case ';':
                    rb.keyPress(KeyEvent.VK_SEMICOLON);
                    break;
                case '=':
                    rb.keyPress(KeyEvent.VK_EQUALS);
                    break;
                case '[':
                    rb.keyPress(KeyEvent.VK_OPEN_BRACKET);
                    break;
//                case '\':
//                    rb.keyPress(KeyEvent.VK_BACK_SLASH);
//                    break;
                case ']':
                    rb.keyPress(KeyEvent.VK_CLOSE_BRACKET);
                    break;
                case '@':
                    rb.keyPress(KeyEvent.VK_AT);
                    break;
                case ':':
                    rb.keyPress(KeyEvent.VK_COLON);
                    break;
                case '^':
                    rb.keyPress(KeyEvent.VK_CIRCUMFLEX);
                    break;
                case '$':
                    rb.keyPress(KeyEvent.VK_DOLLAR);
                    break;
                case '!':
                    rb.keyPress(KeyEvent.VK_EXCLAMATION_MARK);
                    break;
                case '(':
                    rb.keyPress(KeyEvent.VK_LEFT_PARENTHESIS);
                    break;
                case '#':
                    rb.keyPress(KeyEvent.VK_NUMBER_SIGN);
                    break;
                case '+':
                    rb.keyPress(KeyEvent.VK_PLUS);
                    break;
                case ')':
                    rb.keyPress(KeyEvent.VK_RIGHT_PARENTHESIS);
                    break;
                case '_':
                    rb.keyPress(KeyEvent.VK_UNDERSCORE);
                    break;
                //hcg空格
                case ' ':
                    rb.keyPress(KeyEvent.VK_SPACE);
                    break;
                default :
                    System.err.println("字符串转robot键盘事件,对于输入内容无法进行转换");
                    throw new RuntimeException("字符串转robot键盘事件,对于输入内容无法进行转换");
            }
        }
    }
    /**
     * @description 判断是当前输入法未英文还是中文状态 思路想办法通过robot？
     * @return english chinese
     */
}
