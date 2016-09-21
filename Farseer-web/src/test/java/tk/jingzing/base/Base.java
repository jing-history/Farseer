package tk.jingzing.base;

import java.util.Objects;

/**
 * Java SE 7带来了Objects类和它的一些静态方法。Objects.toString的优点是它可以处理null值，
 * 甚至可以给null设置默认值。其性能与上一个相比略低
 * Created by wangyunjing on 16/9/21.
 */
public class Base {

    public static void main(String[] args) {
        int a = 1;
        String aa = null;
        String bb = "";
        Object cc = "aaa";

        System.out.println(Objects.toString(a));
        System.out.println(Objects.toString(aa));
        System.out.println(Objects.toString(bb));
        System.out.println(Objects.toString(cc));
        System.out.println("=====================");
        System.out.println(Objects.toString(a,""));
        System.out.println(Objects.toString(aa,""));
        System.out.println(Objects.toString(bb,""));
        System.out.println(Objects.toString(cc,""));
    }
}
