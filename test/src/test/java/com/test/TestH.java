package com.test;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TestH {

    @Test
    public void test1(){
        for (int i = 9; i >=1 ; i--) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(i+"*"+j+"="+(i*j)+" ");
            }
            System.out.println(" ");
        }
    }

    class C{
        C(){
            System.out.println("C");
        }
    }

    class A{
        C c=new C();

        A(){
            this("A");
            System.out.println("A");
        }

        A(String s){
            System.out.println(s);
        }
    }

    class B extends A{
        B(){
            super("A");
            System.out.println("B");
        }
    }

    @Test
    public  void test2(){
        new B();

    }


    public void test3(){
        short a=1;
//        a=a+1;

        a +=1;

        Integer f1=100,f2=100,f3=150,f4=150;
        System.out.println(f1==f2);
        System.out.println(f3==f4);

        ArrayList<Object> objects = new ArrayList<>();
        objects.size();
        objects.add("");
        objects.get(0);

        HashSet<Object> objects1 = new HashSet<>();
        objects1.size();
        objects1.add("");
        objects1.iterator();

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.get("");
        objectObjectHashMap.put("","");

        int[] i=new int[2];
        i[0]=1;


    }


    class MyObj{
         int b=99;
    }

    @Test
    public  void test4() {
        TestH t = new TestH();
        int a=99;
        int v=t.test1(a);//这里传递的参数a就是按值传递
        System.out.println("a:"+a);
        System.out.println("v:"+v);

        MyObj obj=new MyObj();
        t.test2(obj);//这里传递的参数obj就是引用传递
        System.out.println(obj.b);
    }

    public int test1(int a){
        a=++a;
        System.out.println(a);
        return a;
    }

    public void test2(MyObj obj){
        obj.b=100;
        System.out.println(obj.b);
    }

    public void test1(int a,String b){

    }
    public void test1(String b,int a){

    }

    Ttt t=new  Ttt(){

        @Override
        public String str() {
            return null;
        }
    };

    @Test
    public void test5(){
        String s=resStr("abcd");
        System.out.println(s);

        StringBuilder abcd = new StringBuilder("abcd");
        String s2 = abcd.reverse().toString();
        System.out.println("字符串翻转"+s2);
        String f = abcd.replace(0, 2, "fh").toString();
        System.out.println("字符串替换："+f);

        String s3 = s.replaceAll("a", "f");
        System.out.println("字符串替换："+s3);
    }

    String s1;
    public String resStr(String s){
        if(s==null||s.length()<=1){
          return s ;
        }
        System.out.println(s);
        s1=resStr(s.substring(1))+s.charAt(0);

//        resStr("bcd")+"a";    "dcb"+"a"
//        resStr("cd")+"b";     "dc"+"b"
//        resStr("d")+"c";      "d"+"c"
//        "d"                   "d"



        return s1;

    }


    @Test
    public void test6(){
      //获取年月日时分秒
//        获取当前时间
//        LocalDateTime now = LocalDateTime.now();
//        获取指定时间
        LocalDateTime now = LocalDateTime.of(2020, 4, 5, 20, 30, 30);

        System.out.println("年："+now.getYear());
        System.out.println("月："+now.getMonthValue());
        System.out.println("日："+now.getDayOfMonth());
        System.out.println("时："+now.getHour());
        System.out.println("分："+now.getMinute());
        System.out.println("秒："+now.getSecond());

        //获取从1970/01/01 00:00:00到现在的毫秒数
        Calendar.getInstance().getTimeInMillis();
        System.currentTimeMillis();

//        获取某月的最后一天
        Calendar instance = Calendar.getInstance();
        int actualMaximum = instance.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println("获取某月的最后一天："+actualMaximum);

        //格式化日期
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String format = now.format(dateTimeFormatter);
        System.out.println("格式化日期："+format);

        //获取昨天的当前时刻
        LocalDateTime now1 = LocalDateTime.now();

        LocalDateTime localDateTime = now1.minusDays(1);

        String format1 = localDateTime.format(dateTimeFormatter);
        System.out.println("昨天的当前时刻："+format1);
    }




    @Test
    public void test7(){
        try {
            throw new ExampleB("b");
//            throw new ExampleA();
        } catch(ExampleA e){
            System.out.println("ExampleA");
        } catch(Exception e){
            System.out.println("Exception");
        }

    }

    @Test
    public void test8(){
            try {
                try {
                    throw new Sneezes();
                }
                catch ( Annoyances a ) {
                    System.out.println("Caught Annoyance");
                    throw a;
                }
            }
            catch ( Sneezes s ) {
                System.out.println("Caught Sneeze");
                return ;
            }
            finally {
                System.out.println("Hello World!");
            }

    }
}
class ExampleA extends Exception{}
class ExampleB extends ExampleA{
        ExampleB(String s){
            System.out.println("s");
        }
}


class Annoyances extends Exception {}
class Sneezes extends Annoyances {}


