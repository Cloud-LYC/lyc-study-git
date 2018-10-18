package com.lyc.study.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyuanchi on 2017/12/7
 */
public class ArrayList_LYC {

    /**
     * 1、概述
     *
     * public class ArrayList<E> extends AbstractList<E>
     *     implements List<E>, RandomAccess, Cloneable, java.io.Serializable

     * ArrayList是基于数组实现的，是一个动态数组，其容量能自动增长，类似于C语言中的动态申请内存，动态增长内存。
     * ArrayList不是线程安全的，只能用在单线程环境下，多线程环境下可以考虑用Collections.synchronizedList(List l)
     * 函数返回一个线程安全的ArrayList类，也可以使用concurrent并发包下的CopyOnWriteArrayList类。
     * ArrayList实现了Serializable接口，因此它支持序列化，能够通过序列化传输，实现了RandomAccess接口，支持快速随机访问，
     * 实际上就是通过下标序号进行快速访问，实现了Cloneable接口，能被克隆。
     * 每个ArrayList实例都有一个容量，该容量是指用来存储列表元素的数组的大小。它总是至少等于列表的大小。随着向ArrayList中
     * 不断添加元素，其容量也自动增长。自动增长会带来数据向新数组的重新拷贝，因此，如果可预知数据量的多少，可在构造ArrayList
     * 时指定其容量。在添加大量元素前，应用程序也可以使用ensureCapacity操作来增加ArrayList实例的容量，这可以减少递增式再分配的数量。
     *
     * 注意，此实现不是同步的。如果多个线程同时访问一个ArrayList实例，而其中至少一个线程从结构上修改了列表，那么它必须保持外部同步
     */
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            nums.add(i);

        }

        System.out.println(nums);



  int i = 8;

        System.out.println(i << 1);
    }

}


/**
 * 序列化与反序列化
 *
 * 序列化与反序列化

 以下是我从网上找到的关于，什么是序列化，为什么要序列化解释的比较好的一篇博文。
 ======================================================================分割线
 简单来说序列化就是一种用来处理对象流的机制。所谓对象流也就是将对象的
 内容进行流化，流的概念这里不用多说(就是I/O)。我们可以对流化后的对象进行读写
 操作，也可将流化后的对象传输于网络之间(注：要想将对象传输于网络必须进行流化)！
 在对对象流进行读写操作时会引发一些问题，而序列化机制正是用来解决这些问题的！
 -----------------------------------------------------------------------------------------小分割线
 问题的引出：
 如上所述，读写对象会有什么问题呢？比如：我要将对象写入一个磁盘文件而后再将
 其读出来会有什么问题吗？别急，其中一个最大的问题就是对象引用！
 举个例子来说：假如我有两个类，分别是A和B，B类中含有一个指向A类对象的引用，--->
 现在我们对两个类进行实例化{ A a = new A(); B b = new B(); }。这时在内存中实际上分配
 了两个空间，一个存储对象a，一个存储对象b。接下来我们想将它们写入到磁盘的一个文件
 中去，就在写入文件时出现了问题！因为对象b包含对对象a的引用，所以系统会自动的将a
 的数据复制一份到b中，这样的话当我们从文件中恢复对象时(也就是重新加载到内存中)时，
 内存分配了三个空间，而对象a同时在内存中存在两份，想一想后果吧，如果我想修改对象a
 的数据的话，那不是还要搜索它的每一份拷贝来达到对象数据的一致性，这不是我们所希望的！
 -----------------------------------------------------------------------------------------小分割线
 以下序列化机制的解决方案：
 1.保存到磁盘的所有对象都获得一个序列号(1, 2, 3等等)
 2.当要保存一个对象时，先检查该对象是否被保存了
 3.如果以前保存过，只需写入"与已经保存的具有序列号x的对象相同"的标记，否则，保存该对象
 通过以上的步骤序列化机制解决了对象引用的问题！
 -----------------------------------------------------------------------------------------小分割线
 序列化的实现
 将需要被序列化的类实现Serializable接口，该接口没有需要实现的方法，implements Serializable
 只是为了标注该对象是可被序列化的。然后使用一个输出流(如：FileOutputStream)来构造一个
 ObjectOutputStream(对象流)对象。接着，使用ObjectOutputStream对象的writeObject(Object obj)方法
 就可以将参数为obj的对象写出(即保存其状态)，要恢复的话则用输入流。
 在序列化的过程中，有些数据字段我们不想将其序列化，对于此类字段我们只需要在定义
 时给它加上transient关键字即可，对于transient字段序列化机制会跳过不会将其写入文件，当然
 也不可被恢复。但有时我们想将某一字段序列化，但它在SDK中的定义却是不可序列化的类型，
 这样的话我们也必须把他标注为transient，可是不能写入又怎么恢复呢？好在序列化机制为包含
 这种特殊问题的类提供了如下的方法定义：
 private void readObject(ObjectInputStream in) throws
 IOException, ClassNotFoundException;
 private void writeObject(ObjectOutputStream out) throws
 IOException;
 (注：这些方法定义时必须是私有的，因为不需要你显示调用，序列化机制会自动调用的)
 使用以上方法我们可以手动对那些你又想序列化又不可以被序列化的数据字段进行写出和读入操作。
 ======================================================================分割线
 下面是一个典型的例子，java.awt.geom包中的Point2D.Double类就是不可序列化的，因为该类
 没有实现Serializable接口，在我的例子中将把它当作LabeledPoint类中的一个数据字段，并演示
 如何将其序列化！
 [java] view plain copy
 import java.io.*;
 import java.awt.geom.*;

 public class TransientTest
 {
 public static void main(String[] args)
 {

 LabeledPoint label = new LabeledPoint("Book", 5.00, 5.00);

 try
 {
 System.out.println(label); // 写入前
 ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Label.txt"));
 out.writeObject(label);    //通过对象输出流，将label写入流中
 out.close();
 System.out.println(label);// 写入后
 ObjectInputStream in = new ObjectInputStream(new FileInputStream("Label.txt"));
 LabeledPoint label1 = (LabeledPoint) in.readObject();
 in.close();
 System.out.println(label1);// 读出并加1.0后
 }
 catch (Exception e)
 {
 e.printStackTrace();
 }
 }
 }

 class LabeledPoint implements Serializable
 {
 private String label;
 transient private Point2D.Double point;    //因为不可被序列化，所以需要加transient关键字

 public LabeledPoint(String str, double x, double y)//构造方法
 {
 label = str;
 point = new Point2D.Double(x, y);  //此类Point2D.Double不可被序列化
 }

 //因为Point2D.Double不可被序列化，所以需要实现下面两个方法
 private void writeObject(ObjectOutputStream out) throws IOException
 {

 out.defaultWriteObject();
 out.writeDouble(point.getX());
 out.writeDouble(point.getY());
 }
 private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
 {

 in.defaultReadObject();
 double x = in.readDouble() + 1.0;
 double y = in.readDouble() + 1.0;
 point = new Point2D.Double(x, y);
 }

 //重写toString方法
 public String toString()
 {
 return getClass().getName()+ "[label = " + label+ ", point.getX() = " + point.getX()+ ", point.getY() = " +

 point.getY()+ "]";
 }

 }

 ======================================================================分割线
 *
 */


/**
 * JAVA中的引用与对象详解
 *Thinking in Java 一书中提到，引用和对象就像瑶控器和电视机。用瑶控器（引用）来操作电视机（对象），想换频道什么的直接操作瑶控器就可以了，
 * 瑶控器再来调控电视机。如果你在房间里面走动，同时还想操作电视换频道，你只需要携带瑶控器就可以了。我觉得这个比较非常好，引用是用来操作对象的，
 * 对象是由你来创建的。通常用new关键字来创建一个对象。那么这些对象是怎样存储的，内存又是怎样分配的呢？
 存储在什么地方？
 1.寄存器（register）：由于寄存器是在CPU内部的，所以它的速度最快，但是数量有限，所以由编译器根据需求进行分配。
 2.栈（stack）：位于通用RAM中，通过栈指针的移动来分配和释放内存，指针向下移动分配新的内存；指针向上移动则释放内存。速度仅次于寄存器。创建程序时，
 Java编译器必须知道存储在栈内所有数据的确切大小和生命周期，因为它必须生成相应的代码，以便上下移动栈指针，这就限制了程序的灵活性。所以java中的对象
 并不存放在栈当中，但对象的引用存放在栈中。
 3.堆（heap）：也是位于RAM中的内存池，用于存放所有的JAVA对象。编译器不需要知道要从堆里分配多少存储区域，也不需要知道存储的数据在堆里面存活多长时间，
 因此堆要比栈灵活很多。当你new创建一个对象时，编译器会自动在堆里进行存储分配。当然，为这种灵活性必须要付出相应的代码。用堆进行存储分配比用栈进行存储
 存储需要更多的时间。
 4.静态存储（static storage）：这里的“静态”是指“在固定的位置”（也在RAM里）。静态存储里存放程序运行时一直存在的数据。你可用关键字static来标识一个
 对象的特定元素是静态的，即存放类中的静态成员，但JAVA对象本身从来不会存放在静态存储空间里。
 5. 常量存储（constant storage）：存放字符串常量和基本类型常量（public static final）。常量值通常直接存放在程序代码内部，它们永远不会被改变。有
 时，在嵌入式系统中，常量本身会和其他部分分割离开，所以在这种情况下，可以选择将其放在ROM中。
 简单描述下垃圾回收机制
 垃圾回收回收的是无任何引用的对象占据的内存空间（堆）而不是对象本身，要注意以下3点：
 1）对象可能不会被回收，即垃圾回收不一定会执行；
 2）垃圾回收并不等于析构；
 3）垃圾回收只与内存有关。
 引用计数器：一种简单但是速度很慢的垃圾回收策略。即每个对象都有一个引用计数器，当有引用连接至对象时计数器加1；当引用离开时计数器减1。垃圾回收器会在含有
 全部对象的列表中遍历，发现某个对象的引用计数器为0时，就释放其占用的内存。
 优点：引用计数收集器可以很快的执行，交织在程序运行中。对程序不被长时间打断的实时环境比较有利。
 缺点：无法检测出循环引用。如父对象有一个对子对象的引用，子对象反过来引用父对象。这样，他们的引用计数永远不可能为0。
 自适应、分代的、停止——复制、标记——清扫 垃圾回收方法：
 停止——复制：先暂停程序的运行，然后将所有活的对象从当前堆复制到另一个堆，没有被复制的都是垃圾。当对象从一个堆复制到另一个堆，它们的排列是一个挨着一个的，
 所以新堆保持紧凑排列。
 标记——清扫：遍历所有的引用，找出所有活的对象，然后对它们进行标记，这个过程不会回收任何对象，只有全部标记工作完成时才开始清除工作。没有被标记的对象将会被
 释放，不发生任何复制动作，所以剩下的堆空间不是连续的。
 创建了几个对象？
 String s="abc"; 创建了几个对象？
 毫无疑问，这里面只创建了一个对象——“abc"；
 String s1="abc"; String s2=s1;创建了几个对象？
 仍然只有一个对象——“abc"；
 String s1="abc"; String s2=”abc";创建了几个对象？
 这里仍然只有一个对象——“abc"；
 String s="abc"+"def";创建了几个对象？
 注意，这里创建了三个对象：“abc"、”def"、“abcdef"；
 String s=new String("abc");创建了几个对象？
 大家也都知道是两个对象。实际上是"abc"本身就是文字池中的一个对象，在运行new String()时，把文字池即pool中的字符串"abc"复制到堆中，并把这个对象的应用交给s，所以创建了两个String对象，一个在pool中，一个在堆中。
 String s1=new String("abc");String s2=new String("abc");创建了几个对象？
 三个对象。"abc"是文字池中的一个对象，然后又在堆中用new String()创建了两个对象。
 *
 */
