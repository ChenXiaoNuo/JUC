package com.learn.juc01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 题目：三个售票员卖出30张票
 * 笔记：如何编写企业级的多线程代码，固定的编程套路+模板是什么？
 *  1 在高内聚低耦合的前提下，线程操作资源类
 *      1.1 先创建一个资源类
 *      1.2
 *
 *
 * @author hutao
 * @date 2019-11-25 12:07
 */
public class SaleTIcketDemo01 {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();

        //线程状态：New、Runnable、Blocked、Waiting、Timed_Waiting、Terminated
        //匿名内部类
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i <= 40; i++) {
//                    ticket.sale();
//                }
//            }
//        }, "AAA").start();

        //Lamdba表达式写法
        new Thread(()->{ for (int i = 0; i < 40; i++) ticket.sale(); },"A").start();
        new Thread(()->{ for (int i = 0; i < 40; i++) ticket.sale(); },"B").start();
        new Thread(()->{ for (int i = 0; i < 40; i++) ticket.sale(); },"C").start();



    }


}
class Ticket{

    private int number = 30;

    Lock lock = new ReentrantLock();

    public void sale(){
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "\t卖出第：" + (number--) + "\t还剩下：" + number);
            }
        } finally {
            lock.unlock();
        }

    }

}