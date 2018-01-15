package problem2;

/**
 * 问题：设计一个类，我们只能生成该类的一个实例。
 * Created by fengyuwusong on 2018/1/15 15:04.
 */

/**
 * 懒汉式加载
 * 只适合单线程环境（不好）
 * 注解:Singleton的静态属性instance中，只有instance为null的时候才创建一个实例，构造函数私有，确保每次都只创建一个，避免重复创建。
 * 缺点：只在单线程的情况下正常运行，在多线程的情况下，就会出问题。例如：当两个线程同时运行到判断instance是否为空的if语句，
 * 并且instance确实没有创建好时，那么两个线程都会创建一个实例。
 */
class Singleton1 {
    private Singleton1() {
    }

    private static Singleton1 instance = null;

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}

/**
 * 改进懒汉式，多线程情况下可用（效率不好）
 * 注解：在解法一的基础上加上了同步锁，使得在多线程的情况下可以用。例如：当两个线程同时想创建实例，由于在一个时刻只有一个线程能得到同步锁，
 * 当第一个线程加上锁以后，第二个线程只能等待。第一个线程发现实例没有创建，创建之。第一个线程释放同步锁，第二个线程才可以加上同步锁，执行下面的代码。
 * 由于第一个线程已经创建了实例，所以第二个线程不需要创建实例。保证在多线程的环境下也只有一个实例。
 * 缺点：每次通过getInstance方法得到singleton实例的时候都有一个试图去获取同步锁的过程。而众所周知，加锁是很耗时的。能避免则避免。
 */

class Singleton2 {
    private Singleton2() {
    }

    private static Singleton2 instance = null;

    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}

/**
 * 加同步锁时，前后两次判断实例是否存在（可行）
 * 注解：只有当instance为null时，需要获取同步锁，创建一次实例。当实例被创建，则无需试图加锁。
 * 缺点：用双重if判断，复杂，容易出错。
 */
class Singleton3 {
    private Singleton3() {
    }

    private volatile static Singleton3 instance = null;

    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}

/**
 * 饿汉式
 * 注解：初试化静态的instance创建一次。如果我们在Singleton类里面写一个静态的方法不需要创建实例，它仍然会早早的创建一次实例。而降低内存的使用率。
 * 缺点：没有lazy loading的效果，从而降低内存的使用率。
 */
class Singleton4 {
    private Singleton4() {
    }

    public static Singleton4 instance = new Singleton4();

    public static Singleton4 getInstance() {
        return instance;
    }
}

/**
 * 静态内部
 * 注解：定义一个私有的内部类，在第一次用这个嵌套类时，会创建一个实例。而类型为SingletonHolder的类，只有在Singleton.getInstance()中调用，
 * 由于私有的属性，他人无法使用SingleHolder，不调用Singleton.getInstance()就不会创建实例。
 * 优点：达到了lazy loading的效果，即按需创建实例。
 */
class Singleton5 {
    private Singleton5() {
    }

    private static class SingletonHolder {
        private final static Singleton5 instance = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return SingletonHolder.instance;
    }
}

/**
 * effect java中推荐写法
 * 优点
 * (1)自由序列化。
 * (2)保证只有一个实例。
 * (3)线程安全。
 */
enum Singleton6 {
    INSTANCE;

    public void otherMethods() {
        System.out.println("单例里面的方法~");
    }
}