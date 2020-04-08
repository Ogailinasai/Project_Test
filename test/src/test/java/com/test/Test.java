package com.test;

import com.sun.deploy.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.concurrent.locks.Lock;

public class Test {

    @org.junit.Test
    public void test1(){

        String s1 = new StringBuilder("go")
                .append("od").toString();

        System.out.println(s1.intern() == s1);

        String s2 = new StringBuilder("ja")
                .append("va").toString();
        System.out.println(s2.intern() == s2);
        System.out.println(s2.intern().getBytes());
        System.out.println(s2.getBytes());

    }

    @org.junit.Test
    public  void test2(){
        System.out.println(7<<3);

        int[] arr=new int[]{1,2};
        int length = arr.length;

    }


    @org.junit.Test
    public void test3(){
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
//        s6.intern()指向的是s1
        System.out.println(s1 == s6.intern());
//        s2.intern()指向的是s1
        System.out.println(s2 == s2.intern());


    }


//    public String test1(){
//        return null;
//    }


    //递归实现字符串翻转
    public static String reverse(String originStr) {
        if(originStr == null || originStr.length() <= 1)
            return originStr;
        System.out.println(originStr.substring(1));
        System.out.println(originStr.charAt(0));
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }

    @org.junit.Test
    public void test4(){
        String abc = reverse("abc");
        System.out.println(abc);

    }

    //打印昨天的当前时刻
    @org.junit.Test
    public void test5(){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE,-1);
        System.out.println("昨天的当前时刻："+instance.getTime());
    }


    public  void test6(){
        LinkedList<Object> objects = new LinkedList<>();
        objects.add("aa");
        objects.get(0);

        HashSet<Object> objects1 = new HashSet<>();

        Iterator<Object> iterator = objects1.iterator();

        while (iterator.hasNext()){
            Object next = iterator.next();

        }


    }

    //打印文件夹内的文件并打开下级文件夹
    @org.junit.Test
    public void test7(){
        showDirectory(new File("D:\\百度网盘"));

    }

    public static void showDirectory(File f) {
        _walkDirectory(f,0);
    }

    private static void _walkDirectory(File f,int level) {
        if(f.isDirectory()) {
            for(File temp : f.listFiles()) {
                _walkDirectory(temp, level + 1);
            }
        }else {
            for(int i = 0; i < level - 1; i++) {
                System.out.print("\t");
            }
            System.out.println(f.getName());
        }
    }


    @org.junit.Test
    public void test8() throws IOException {
        Path path = Paths.get("D:\\百度网盘");
        Files.walkFileTree(path,new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.getFileName().toString());
                return FileVisitResult.CONTINUE;
            }
        });
    }


    //排序
//    冒泡排序
    @org.junit.Test
    public void test9(){
        int[] arr=new int[]{1,5,2,4,9,3,7,8};

        int k=0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if(arr[j-1]<arr[j]){
                   k= arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=k;
                }
            }
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }

//    选择排序
    @org.junit.Test
    public void test10(){
        int[] arr=new int[]{1,5,2,4,9,3,7,8};

        int min=0;
        int index=0;

        for (int i = 0; i < arr.length; i++) {
            min=arr[i];
            index=i;
            for (int j =i+1; j < arr.length; j++) {
                if(min>arr[j]){
                    min=arr[j];
                    index=j;
                }
            }

            int ing=arr[i];
            arr[i]=min;
            arr[index]=ing;
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }




    /**
     * 二分查找
     * @param arr 要进行查找的数组，要求数组必须是有序的
     * @param findElem 要查找的元素
     * @return 返回要查找的元素在数组的索引位置， 返回-1表示没找到
     */
    public int binarySearch(int[] arr, int findElem) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            //如果要查找的元素findElem小于中间位置的元素mid，指向数组的较大端的high索引重新指向中间索引mid的左边（mid-1）
            if (findElem < arr[mid]) {
                high = mid - 1;
            }
            //如果要查找的元素findElem大于中间位置的元素mid，指向数组的较小端的low索引重新指向中间索引mid的右边（mid+1）
            if (findElem > arr[mid]) {
                low = mid + 1;
            }
            if (arr[mid] == findElem) {
                return mid;
            }
        }
        return -1;
    }


    public int find(int[] arr,int a){

        int low=0;
        int max=arr.length-1;
        System.out.println(max+" "+max/2);
        int mid;

        while (low<=max){
            mid=(low+max)/2;

            if(arr[mid]>a){
                max =mid - 1;
            }

            if(arr[mid]<a){
                low =mid + 1;
            }

            if(arr[mid]==a){
                return arr[mid];
            }
        }
        
        
        return -1;
    }

    @org.junit.Test
    public void test11(){

        int[] arr={1,2,4,5,55,66,77,88};

        int a=find(arr,55);
        System.out.println(a);


    }
}
