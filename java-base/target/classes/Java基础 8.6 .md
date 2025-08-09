# Java的封装、继承、多态

## 一、封装

  封装就是把客观事物封装成抽象的类，并且类可以把自己的数据和方法只让可信的类或者对象操作，对不可信的进行信息隐藏。

### 1.1. 封装的规则

1. 将类的某些信息隐藏在类的内部，不允许外部程序直接访问；

2. 通过该提供的方法来实现对隐藏信息的操作和访问；

### 1.2. 封装的步骤

1. 修改属性为私有设为private；

2. 创建getter和setter方法，设为public用于属性的读写；

3. 在gettter和setter方法中加入属性控制语句，用于对属性的合法进行判断；

### 1.3. 封装的实现

1. **封装一个学生类**

```javascript
public class Student {
    private String name;
    private int age;
    // 获取学生姓名
    public String getName() {
        return name;
    }
    // 设置学生姓名
    public void setName(String name) {
        this.name = name;
    }
    // 获取学生年龄
    public int getAge() {
        return age;
    }

    // 设置学生年龄
    public void setAge(int age) {
        this.age = age;
    }
    // 无参构造函数
    public Student(){
    }
    // 有参构造函数
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

2. **调用学生类实例化对象**

```javascript
public class StudentTest {
    public static void main(String[] args){
        // 实例化一学生
        Student student = new Student();
        // 设置学生姓名
        student.setName("aiguangyuan");
        // 设置学生年龄
        student.setAge(30);
    }
}
```

## 二、继承

  使子类具有父类的属性和方法，还可以在子类中重新定义、追加属性和方法。

 **父类（基类）**：被继承的类，提供了通用的属性和方法。


 **子类（派生类）**：继承父类的类，可以扩展父类的功能，添加新的属性和方法，或者重写父类的方法。

**继承语法**

```java
class ParentClass {
    // 父类的属性和方法
}

class ChildClass extends ParentClass {
    // 子类的属性和方法
}
```

###  1.**父类成员的继承规则**

- **继承的成员**：子类继承父类的所有非私有成员（包括属性和方法）。如果父类的成员是私有的（`private`），子类无法直接访问，但可以通过父类的公共方法（如 getter 和 setter）间接访问。
- **构造方法**：子类不会继承父类的构造方法，但可以通过 `super()` 调用父类的构造方法来初始化父类部分。

### 2.方法的重写

  子类可以重写父类的方法，以提供特定的实现。重写的方法必须满足以下条件：

- 方法名、参数列表必须与父类被重写的方法完全相同。
- 返回类型必须与父类被重写的方法相同或兼容（协变返回类型）。
- 访问权限不能比父类被重写的方法更严格。

```java
class Parent {
    public void show() {
        System.out.println("父类的 show 方法");
    }
}

class Child extends Parent {
    @Override
    public void show() {
        System.out.println("子类重写的 show 方法");
    }
```

### 3.成员变量的隐藏

  如果子类定义了一个与父类同名的成员变量，那么子类的成员变量会隐藏父类的成员变量。访问时，需要通过 `super` 关键字来访问父类的成员变量。

```java
class Parent {
    int num = 10;
}

class Child extends Parent {
    int num = 20;

    public void print() {
        System.out.println(num);       // 输出子类的 num
        System.out.println(super.num); // 输出父类的 num
    }
}

```

### 4.构造方法的调用

- 子类的构造方法中默认会调用父类的无参构造方法（通过 `super()`）。

- 如果父类没有无参构造方法，子类必须显式调用父类的某个构造方法（通过 `super()`）。

  ```java
  class Parent {
      Parent(String name) {
          System.out.println("父类构造方法：" + name);
      }
  }
  
  class Child extends Parent {
      Child() {
          super("Hello"); // 显式调用父类的构造方法
          System.out.println("子类构造方法");
      }
  }
  ```

  

##  三、多态

  多态是指同一个接口或父类使用不同的底层实现对象，在运行时根据对象的实际类型调用对应的方法。多态分为两种：方法重载（编译时多态）和方法覆盖（运行时多态）。

**特点：**

- **提高代码的灵活性**：通过多态，可以使用父类类型的变量引用子类对象，调用方法时会根据实际对象的类型执行对应的方法。
- **增强可扩展性**：新增子类时，无需修改原有代码，只需保证子类继承父类并重写方法即可。

```
// 父类
class Animal {
    public void makeSound() {
        System.out.println("动物发出声音");
    }
}
 
// 子类1
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("狗叫：汪汪");
    }
}
 
// 子类2
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("猫叫：喵喵");
    }
}
 
public class TestPolymorphism {
    public static void main(String[] args) {
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();
 
        animal1.makeSound(); // 输出：狗叫：汪汪
        animal2.makeSound(); // 输出：猫叫：喵喵
    }
}
```

## 四、Java 多线程编程

  一条线程指的是进程中一个单一顺序的控制流，一个进程中可以并发多个线程，每条线程并行执行不同的任务。

### **一个线程的生命周期**

线程是一个动态执行的过程，它也有一个从产生到死亡的过程。

下图显示了一个线程完整的生命周期。

![img](https://www.runoob.com/wp-content/uploads/2014/01/java-thread.jpg)

- 新建状态:

  使用 **new** 关键字和 **Thread** 类或其子类建立一个线程对象后，该线程对象就处于新建状态。它保持这个状态直到程序 **start()** 这个线程。

- 就绪状态:

  当线程对象调用了start()方法之后，该线程就进入就绪状态。就绪状态的线程处于就绪队列中，要等待JVM里线程调度器的调度。

- 运行状态:

  如果就绪状态的线程获取 CPU 资源，就可以执行 **run()**，此时线程便处于运行状态。处于运行状态的线程最为复杂，它可以变为阻塞状态、就绪状态和死亡状态。

- 阻塞状态:

  如果一个线程执行了sleep（睡眠）、suspend（挂起）等方法，失去所占用资源之后，该线程就从运行状态进入阻塞状态。在睡眠时间已到或获得设备资源后可以重新进入就绪状态。可以分为三种：

  - 等待阻塞：运行状态中的线程执行 wait() 方法，使线程进入到等待阻塞状态。
  - 同步阻塞：线程在获取 synchronized 同步锁失败(因为同步锁被其他线程占用)。
  - 其他阻塞：通过调用线程的 sleep() 或 join() 发出了 I/O 请求时，线程就会进入到阻塞状态。当sleep() 状态超时，join() 等待线程终止或超时，或者 I/O 处理完毕，线程重新转入就绪状态。

- 死亡状态:

  一个运行状态的线程完成任务或者其他终止条件发生时，该线程就切换到终止状态。

------

## 创建一个线程

Java 提供了三种创建线程的方法：

- 通过实现 Runnable 接口；
- 通过继承 Thread 类本身；
- 通过 Callable 和 Future 创建线程。
