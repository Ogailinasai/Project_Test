package com.test;

import org.junit.Test;

import java.io.*;

public class TestInputOut {


//    复制文件
    @Test
    public void test1() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("E:\\bb\\宝宝.zip");
        BufferedInputStream bis = new BufferedInputStream(fileInputStream);

        FileOutputStream fileOutputStream = new FileOutputStream("E:\\宝宝.zip");
        BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);

        byte[] by=new byte[2014];
        int index;


        while((index=bis.read(by))!=-1){
                bos.write(by,0,index);
        }

        bos.close();
        fileOutputStream.close();
        bis.close();
        fileInputStream.close();
    }

//    统计一个字符在文件中出现的次数
    @Test
    public void test2() throws IOException {

        String ss="b";
        int num=0;

        FileReader fileReader = new FileReader("E:\\bbb.txt");

        BufferedReader br = new BufferedReader(fileReader);
        String str=null;
        while((str=br.readLine())!=null){
//            System.out.println(str);
            int in=-1;
            while(ss.length()<=str.length()&&(in=str.indexOf(ss))>=0){
                    num++;
                    str=str.substring(in+ss.length());
            }
         }

        System.out.println(num);
    }

//    列出一个目录下的所有文件
    @Test
    public void test3(){
//        File file = new File("E:\\脚本");
//        String[] list = file.list();
//        for (String s : list) {
//            System.out.println(s);
//        }
        File file = new File("E:\\脚本");
        fileD(file,1);

    }

    public void fileD(File file,int in){

        if(file.isDirectory()) {

            for (int i = 0; i < in; i++) {
                System.out.print("  ");
            }

            System.out.println(file.getName());

            for (File f : file.listFiles()) {
                fileD(f,in+1);
            }
        }else{
            for (int i = 0; i < in; i++) {
                System.out.print("  ");
            }
            System.out.println(file.getName());
        }
    }

    @Test
    public void test4(){
        String s="a b c d e f g";
        boolean bl = s.matches("正则表达式");
        System.out.println(bl);

        String[] split = s.split(" ");
        System.out.println(split[0]);
    }

    @Test
    public void test5(){

        int[] arr1=new int[]{1,6,3,8,4,9,7,5,2};
//        int[] ints = mpPX(arr1);
        int[] ints = xZPX(arr1);

        for (int anInt : ints) {
            System.out.print(anInt);
        }

    }

//    冒泡排序
    public int[] mpPX(int... arr){

        int in;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]>arr[j]){
                    in=arr[i];
                    arr[i]=arr[j];
                    arr[j]=in;
                }
            }
        }
        return arr;
    }

//    选择排序
    public int[] xZPX(int... arr){

        int max;
        int index;

        for (int i = 0; i < arr.length; i++) {
                max=arr[i];
                index=i;

            for (int j = i+1; j < arr.length; j++) {
                if(max>arr[j]){
                    max=arr[j];
                    index=j;
                }
            }
            arr[index]=arr[i];
            arr[i]=max;

        }
        return arr;
    }

//    折半查找
    @Test
    public void test6(){
        int[] arr=new int[]{1,2,3,6,7,9,11,15,16};
        int i = eFCZ(arr, 14);
        System.out.println(i);
    }


    public int eFCZ(int[] arr,int t){
        int min=0;
        int high=arr.length-1;
        int in;

        while(min<=high){
            in=(min+high)/2;

            if(arr[in]>t){
                high=in-1;
            }
            if(arr[in]<t){
                min=in+1;
            }
            if(arr[in]==t){
               return arr[in];
            }
        }
        return -1;
    }
}
