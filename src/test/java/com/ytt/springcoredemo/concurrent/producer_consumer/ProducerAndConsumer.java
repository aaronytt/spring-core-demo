package com.ytt.springcoredemo.concurrent.producer_consumer;

import com.ytt.springcoredemo.model.Person;
import lombok.Builder;
import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 16:04 2019/8/16
 * @Modiflid By:
 */
public class ProducerAndConsumer {

    private final static Queue<Person> queue= new LinkedList<>();

    private synchronized static Queue<Person> getQueue(){
        return queue;
    }

    @Builder
    @Data
    public static class Producer {
        private String name;
        public void product(Person person){
            System.out.println(name + " 打探：name: "+ person.getName() + ",age: " + person.getAge());
            getQueue().add(person);
        }
    }

    @Builder
    @Data
    public static class Consumer {
        private String name;
        public void consume(){
            Person person = getQueue().poll();
            System.out.println(name + " 营救：name: "+ person.getName() + ",age: " + person.getAge());
        }
    }

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            int i = 0;
            while (true){
                i++;
                Producer.builder().name("x神探" + i).build().product(Person.builder().name("m人质" + i).age(i).build());
                try {
                    Thread.currentThread().sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread b = new Thread(() -> {
            int i = 0;
            while (i < 2){
                i++;
                Producer.builder().name("y神探" + i).build().product(Person.builder().name("n人质" + i).age(i).build());
                try {
                    Thread.currentThread().sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        a.start();
        b.start();

        new Thread(() -> {
            while (true){
                if(!queue.isEmpty()){
                    Consumer.builder().name("特战队").build().consume();
                }else {
                    try {
                        Thread.currentThread().sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

}
