package com.example.demo.controller;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class TestController {

    public void test()
    {
        //基本数据类型 -> 包装类
        int a = 1;
        Integer b = Integer.valueOf(a); //手动装箱
        Integer c = a; //自动装箱

        //包装类 -> 基本数据类型
        int d = c.intValue(); //手动拆箱
        int e = c; //自动拆箱

        //字符串 -> 包装类
        String f = "100";
        Integer g = Integer.valueOf(f);
        //Long h = Long.valueOf(f);

        //字符串 -> 基本数据类型
        int i = Integer.parseInt(f);
        //long j = Long.parseLong(f);

        //包装类 -> 字符串
        String k = b.toString();

        //基本数据类型 -> 字符串
        String l = String.valueOf(a);




        //缓存机制（数值在 -128 ~ 127 区间的包装类会被缓存）
        int m = 100;
        Integer m1 = m;
        Integer m2 = m;
        System.out.println(m1 == m2); //true 比较的是包装类
        System.out.println(m1.equals(m2)); //true 比较的是包装类的值

        int n = 200;
        Integer n1 = n;
        Integer n2 = n;
        System.out.println(n1 == n2); //false 比较的是包装类
        System.out.println(n1.equals(n2)); //true 比较的是包装类的值



        int[] a1; //声明数组变量
        a1 = new int[10]; //创建数组
        a1[0] = 1; //赋值
        a1[1] = 2;

        int[] a2 = new int[10]; //声明数组变量并创建数组
        a2[0] = 10; //赋值
        a2[1] = 20;

        int[] a3 = {100, 200}; //创建数组并赋值

        int[][] a4 = new int[2][10]; //创建多维数组
        a4[0][0] = 1; //赋值
        a4[0][1] = 2;
        a4[1][0] = 3;

        //for循环
        for (int i1 = 0; i1 < a1.length; i1++) {
            System.out.println(a1[i1]);
        }

        //for-each循环
        for (int i2: a2) {
            System.out.println(i2);
        }



        ArrayList<Integer> list = new ArrayList<>(); //ArrayList集合
        list.add(1);
        list.add(2);
        list.add(3);
        list.set(1, 20); //修改索引位置上的值
        System.out.println(list);
        list.add(1, 200); //在索引位置上添加值，后面元素往后移动
        System.out.println(list);
        list.remove(Integer.valueOf(3)); //删除数组中值为3的元素（注意需要转成包装类）
        list.remove(0); //删除索引位置的元素

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(123);
        list.addAll(list2); //添加给定集合中的所有元素
        list.clear(); //删除集合中所有元素
        list.isEmpty();

        Iterator<Integer> iterator = list.iterator(); //iterator循环（集合）
        while (iterator.hasNext()) {
            //System.out.println(iterator.next());
            Integer val = iterator.next();
            if (val < 2) {
                iterator.remove();
            }
        }
        System.out.println(list);

        String[] s1 = new String[10];
        s1[0] = "1";
        String[] s2 = new String[10];
        s2[0] = "1";
        String[] s3 = s1;
        boolean b1 = Arrays.equals(s1, s2); //true 判断数组内容是否相等
        boolean b2 = s1 == s2; //false 判断是不是同一个数组对象



        LinkedList<String> linkedList = new LinkedList<>(); //LinkedList集合
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add(String.valueOf(100));
        System.out.println(linkedList);
        linkedList.clear();
        linkedList.isEmpty();
        linkedList.addFirst("f");
        linkedList.addLast("x");
        linkedList.offer("q");
        linkedList.offerFirst("s");
        linkedList.offerLast("u");
        String[] ss1 = linkedList.toArray(new String[0]);
        String[] ss2 = linkedList.toArray(new String[linkedList.size()]);



        String sa1 = "hello";
        String sa2 = "wold";
        //sa1.concat(sa2); //拼接字符串
        //sa1 + sa2; //拼接字符串
        System.out.println(sa1.hashCode());
        System.out.println(sa2.hashCode());

        String str1 = "hello world";
        String str2 = new String("hello world");
        String str3 = "hello world";
        String str4 = new String("hello world");
        System.out.println(str1==str2); //false
        System.out.println(str1==str3); //true
        System.out.println(str2==str4); //false

        /*String s1 = "ab";
        String s2 = "a" + "b";
        String s3 = new String("ab");
        final String s4 = "a";
        final String s5 = "b";
        String s6 = s4 + s5;
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s6);*/



        HashSet<String> hashSet = new HashSet<>(); //HashSet集合
        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("c");
        hashSet.add("c");
        System.out.println(hashSet);
        hashSet.remove("c");
        System.out.println(hashSet);
        System.out.println(hashSet.contains("c"));
        hashSet.isEmpty();
        hashSet.size();
        hashSet.clear();



        HashMap<Integer, String> hashMap = new HashMap<>(); //HashMap集合
        hashMap.put(1, "a"); //元素就是对象，一些常见的基本类型使用它的包装类。
        hashMap.put(2, "b");
        hashMap.put(3, "c");
        hashMap.get(2);
        hashMap.remove(3);
        hashMap.clear();
        hashMap.size();
        hashMap.isEmpty();
        hashMap.keySet(); //获取所有的键名
        hashMap.values(); //获取所有的键值
        System.out.println(hashMap);
        if (hashMap.containsKey(4)) { //检查 key 为 4 是否存在
            hashMap.put(4, "d");
        }



        //快速创建不可变集合（不支持添加、修改、删除）
        List<String> sc1 = List.of("a", "b", "c");
        Set<String> sc2 = Set.of("a", "b", "c");
        Map<Integer, String> sc3 = Map.of(1,"a",2, "b", 3, "c"); //Map.of最多支持10个元素
        Map<Integer, String> sc4 = Map.ofEntries(Map.entry(1, "a"), Map.entry(2, "b"), Map.entry(3, "c")); //Map.ofEntries不限制元素数量

        sc1.add("d"); //运行时会报错
        sc1.remove("a"); //运行时会报错
        sc1.clear(); //运行时会报错

        //把不可变集合转成可变集合
        List<String> scr1 = new ArrayList<>(sc1);
        Set<String> scr2 = new HashSet<>(sc2);
        Map<Integer, String> scr3 = new HashMap<>(sc3);

        scr1.add("d"); //运行时不会报错
        scr1.remove("a"); //运行时不会报错
        scr1.clear(); //运行时不会报错

        //List.of / Set.of / Map.of 创建的是不可变集合，
        //如果需要修改，必须通过 构造函数转成可变集合，
        //比如 new ArrayList<>(list)、new HashSet<>(set)、new HashMap<>(map)，
        //不能强转，也不能原地修改。

        /*if (scr1 instanceof ArrayList) {

        } else if (scr1 instanceof LinkedList) {

        } else {

        }*/















        return ;
    }

    //该方法接收一个数组参数再返回一个数组
    public static int[] reverse(int[] array) {
        int[] reslut = new int[array.length];
        for (int i = 0, j = reslut.length - 1; i < array.length; i++, j--) {
            reslut[j] = array[i];
        }
        return reslut;
    }

    /*
     * ...表示可变参数，本质就是数组
     * 下面的方法等价于 public void demo(int[] array)
     */
    public void demo(int... array) {
        if (array.length == 0) {
            System.out.println("没有参数");
            return;
        }
        
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /*
     * 服务端的Socket
     */
    public void socketServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(60000);
            serverSocket.setSoTimeout(10000);
            Socket server = serverSocket.accept();
            //读取数据
            DataInputStream in = new DataInputStream(server.getInputStream());
            System.out.println("客户端请求：" + in.readUTF());
            //写入数据
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            out.writeUTF("谢谢你连接我，再见！");
            //关闭连接
            server.close();
        } catch (Exception eee) {
            eee.getMessage();
            eee.printStackTrace();
        } finally {

        }
    }

    /*
     * 客户端的Socket
     */
    public void socketClient() {
        try {
            Socket client = new Socket("127.0.0.1", 60000);
            //读取数据
            DataInputStream in = new DataInputStream(client.getInputStream());
            System.out.println("服务端响应：" + in.readUTF());
            //写入数据
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            out.writeUTF("hello");
            //关闭连接
            client.close();
        } catch (Exception eee) {
            eee.getMessage();
            eee.printStackTrace();
        } finally {

        }
    }

}
