package com.learn.juc01;

/**
 *
 *
 * @author hutao
 * @date 2019-11-25 18:03
 */
public class LambdaExpressDemo02 {

    public static void main(String[] args) {
//        Foo foo = new Foo() {
//            @Override
//            public void sayHello() {
//                System.out.println("hello world....");
//            }
//        };
//        foo.sayHello();


//        Foo foo = () -> { System.out.println("hello world...."); };
//        foo.sayHello();

        Foo foo = (int x, int y) -> {
            System.out.println("come in add method");
            return x + y;
        };
        System.out.println(foo.add(3, 5));
        System.out.println(foo.mul(3, 5));
    }
}

/**
 * 1.拷贝小括号，写死右箭头，落地大括号
 * 2.@FunctionalInterface
 * 3.default方法
 * 4.static方法
 */
@FunctionalInterface
interface Foo{
    //void sayHello();
    int add(int x, int y);

    default int mul(int x, int y){
        return x * y;
    }

    static int div(int x, int y){
        return x/y;
    }
}