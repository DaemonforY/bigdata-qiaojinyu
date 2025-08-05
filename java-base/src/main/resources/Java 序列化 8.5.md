# Java 知识

## 一、序列化

### 📌 什么是序列化？

**序列化（Serialization）** 是指将 Java 对象转换为字节流的过程，以便于保存到磁盘或通过网络传输。

**反序列化（Deserialization）** 则是将字节流转换为 Java 对象的过程。

------

### 🧩 使用场景

- 将对象存储到文件、数据库中。
- 通过网络传输对象（如 RMI、Socket 通信）。
- 深拷贝对象（通过序列化+反序列化实现）。

------

### 🛠️ 实现方式

**1. 实现 `java.io.Serializable` 接口**

```
public class Person implements Serializable {
    private String name;
    private int age;
}
```

`Serializable` 是一个标记接口，没有任何方法。

------

**2. 使用 `ObjectOutputStream` 和 `ObjectInputStream`**

```
// 序列化
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"));
oos.writeObject(person);
oos.close();

// 反序列化
ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"));
Person person = (Person) ois.readObject();
ois.close();
```

# 

### 🔍 什么是 `static`？

`static` 是 Java 中的一个 **修饰符**，可以用来修饰：

- **变量**
- **方法**
- **代码块**
- **内部类**

它表示 **“属于类而不属于对象”**，即可以通过类名直接访问，而不需要创建对象。

------

### 🧩 static 修饰变量（静态变量）

```
java复制编辑public class Counter {
    static int count = 0;

    public Counter() {
        count++;
    }
}
```

- 所有对象共享同一个 `static` 变量。
- 一旦类被加载，静态变量就会被初始化。
- 常用于记录全局状态（例如：计数器、缓存等）。

```
Counter c1 = new Counter();
Counter c2 = new Counter();
System.out.println(Counter.count); // 输出 2
```

------

### ⚙️ static 修饰方法（静态方法）

```
public class MathUtil {
    public static int add(int a, int b) {
        return a + b;
    }
}
```

- 静态方法可以通过 **类名调用**，不需要实例化对象。
- **不能访问非静态成员**（因为它不依赖对象）。

```
int result = MathUtil.add(3, 5);
```

> 注意：`main` 方法本身就是一个静态方法。

```
public static void main(String[] args) {
    // 程序入口
}
```

------

### 🧱 static 代码块（静态代码块）

```
public class Test {
    static {
        System.out.println("类加载时执行");
    }
}
```

- 在类被加载时自动执行一次。
- 常用于静态变量的初始化。

------

### 🧩 static 修饰内部类（静态内部类）

```
public class Outer {
    static class Inner {
        void show() {
            System.out.println("静态内部类方法");
        }
    }
}
```

- 不依赖外部类实例。
- 可以直接使用：`Outer.Inner inner = new Outer.Inner();`

------

### 🚫 static 的限制

- 静态方法不能访问非静态变量或调用非静态方法。
- 不能使用 `this` 和 `super`。
- 不能被重写（override），但可以被隐藏（隐藏与继承不同）。

------

### 🧠总结

| 用法            | 说明             | 是否依赖对象 |
| --------------- | ---------------- | ------------ |
| `static` 变量   | 所有实例共享     | 否           |
| `static` 方法   | 可用类名调用     | 否           |
| `static` 代码块 | 类加载时执行一次 | 否           |
| `static` 内部类 | 不依赖外部类对象 | 否           |

## 二、数组

### 🔍 什么是数组？

**数组（Array）** 是 Java 中的一种 **容器**，用来存储 **固定大小的同一类型元素** 的集合。

> 在内存中，数组是**一块连续的内存空间**。

------

### 🧱 数组的分类

| 数组类型 | 示例                                 | 描述                 |
| -------- | ------------------------------------ | -------------------- |
| 一维数组 | `int[] nums = new int[5];`           | 常用，基本或引用类型 |
| 二维数组 | `int[][] matrix = new int[3][3];`    | 表格、矩阵类数据     |
| 多维数组 | `int[][][] cube = new int[2][2][2];` | 不常见，但支持       |



------

### 🛠️ 数组的声明和创建

**一维数组**

```
// 声明数组（不分配内存）
int[] nums;
String names[]; // 旧风格，也可以用

//（分配内存）
nums = new int[5]; // 默认值为 0
```

**声明 + 创建 + 初始化**

```
int[] scores = new int[]{90, 85, 100};
int[] ages = {18, 22, 30}; // 简写方式
```

**二维数组**

```
int[][] grid = new int[3][2]; // 3 行 2 列
int[][] matrix = {
    {1, 2},
    {3, 4},
    {5, 6}
};
```



------

### 🔁 数组的遍历

**使用 `for` 循环**

```
for (int i = 0; i < scores.length; i++) {
    System.out.println(scores[i]);
}
```

**使用增强型 `for-each` 循环**

```
for (int score : scores) {
    System.out.println(score);
}
```

------

### 🧩 数组的长度

```
int len = scores.length;
```

> `length` 是一个 **属性**，不是方法，不能写成 `length()`。

------

### 🔄 数组常见操作

| 操作     | 示例                               | 说明         |
| -------- | ---------------------------------- | ------------ |
| 获取长度 | `arr.length`                       | 获取数组长度 |
| 排序     | `Arrays.sort(arr);`                | 升序排序     |
| 拷贝     | `Arrays.copyOf(arr, newLength);`   | 拷贝数组     |
| 查找     | `Arrays.binarySearch(arr, value);` | 查找值       |
| 填充     | `Arrays.fill(arr, value);`         | 全部赋值     |
| 转字符串 | `Arrays.toString(arr);`            | 输出数组内容 |

> 需要导入 `java.util.Arrays`

------

### ⚠️ 注意事项

- 数组长度一旦定义就**不可更改**（固定长度）。
- 访问越界会抛出 `ArrayIndexOutOfBoundsException`。
- Java 中数组是对象，存放的是引用。
- 多维数组本质上是数组的数组。

------

### 🧠 总结

| 特性         | 说明                         |
| ------------ | ---------------------------- |
| 静态数据结构 | 大小固定，不能动态扩容       |
| 类型安全     | 同一数组中只能存储同一类型   |
| 效率高       | 访问元素时间复杂度为 O(1)    |
| 易越界       | 注意合法范围 `[0, length-1]` |



## 三、构造方法

### 📌 什么是构造方法？

构造方法是类的一种特殊方法，用于创建对象并初始化其状态。每当使用 `new` 关键字创建对象时，都会调用构造方法。

------

### 🧱 构造方法的特点

- 方法名必须与类名相同
- 没有返回类型（连 `void` 也没有）
- 可以有参数或没有参数
- 可以被重载（Overload）

------

### 📝 构造方法的类型

**1. 无参构造方法（默认构造器）**

```
public class Person {
    public Person() {
        System.out.println("调用无参构造方法");
    }
}
```

> 如果没有显式定义构造方法，Java 会自动提供一个无参构造方法（默认构造器）。

------

**2. 有参构造方法**

```
public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

------

**3. 构造方法重载**

构造方法可以根据参数的类型和个数进行重载：

```
public class Person {
    String name;
    int age;

    public Person() {
        this("未知", 0); // 调用另一个构造方法
    }

    public Person(String name) {
        this(name, 0);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

------

**🔁 使用 `this()` 调用构造方法**

- `this()` 用于调用当前类中的其他构造方法
- 必须是构造方法的第一行

```
public class Person {
    String name;
    int age;

    public Person() {
        this("默认名", 18); // 调用有参构造
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

------

### ⚠️ 注意事项

- 构造方法不能被继承，但可以通过 `super()` 调用父类构造方法
- 构造方法不能是 `static`、`final` 或 `abstract`
- 如果你定义了任何构造方法，Java 就不会自动生成默认构造器

------

### 🧬 使用 `super()` 调用父类构造方法

```
public class Animal {
    public Animal(String name) {
        System.out.println("动物名字: " + name);
    }
}

public class Dog extends Animal {
    public Dog() {
        super("狗"); // 调用父类构造方法
    }
}
```

------

## ✅ 总结

| 特性                        | 是否适用 |
| --------------------------- | -------- |
| 方法名与类名相同            | ✅        |
| 无返回类型                  | ✅        |
| 可重载                      | ✅        |
| 可用 `this()` 调用自身构造  | ✅        |
| 可用 `super()` 调用父类构造 | ✅        |
| 可继承                      | ❌        |