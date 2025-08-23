# Java8新特性

## Lambda表达式

使用 Lambda 表达式可以使代码变的更加简洁紧凑。

**1.`Runnable`接口**

```java
new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("The runable now is using!");
            }
}).start();
//用lambda
new Thread(() -> System.out.println("It's a lambda function!")).start();
```

**2.`Comparator` 接口**

```java
List<Integer> strings = Arrays.asList(1, 2, 3);

Collections.sort(strings, new Comparator<Integer>() {
@Override
public int compare(Integer o1, Integer o2) {
    return o1 - o2;}
});

//Lambda
Collections.sort(strings, (Integer o1, Integer o2) -> o1 - o2);
//分解开
Comparator<Integer> comparator = (Integer o1, Integer o2) -> o1 - o2;
Collections.sort(strings, comparator);
```

3. **自定义函数式接口**

```java
// 定义函数式接口
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

public class LambdaDemo {
    public static void main(String[] args) {
        // 使用 Lambda 实现接口
        Calculator add = (x, y) -> x + y;
        Calculator multiply = (x, y) -> x * y;

        System.out.println(add.calculate(2, 3)); // 输出 5
        System.out.println(multiply.calculate(2, 3)); // 输出 6
    }
}
```



## Stream

通过流把文件从一个地方输入到另一个地方，它只是内容搬运工，对文件内容不做任何增删改查。

`Stream`依然不存储数据，不同的是它可以检索(Retrieve)和逻辑处理集合数据、包括筛选、排序、统计、计数等。可以想象成是 Sql 语句。

它的源数据可以是 `Collection`、`Array` 等。由于它的方法参数都是函数式接口类型，所以一般和 Lambda 配合使用.

**流类型**

1. stream 串行流

2. parallelStream 并行流，可多线程执行。

   

### **1.创建流**

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        // 从集合创建
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> stream1 = list.stream(); // 顺序流
        Stream<String> stream2 = list.parallelStream(); // 并行流（多线程处理）

        // 从数组创建
        String[] arr = {"x", "y", "z"};
        Stream<String> stream3 = Arrays.stream(arr);

        // 直接生成
        Stream<Integer> stream4 = Stream.of(1, 2, 3, 4);
    }
}
```

### **2. 中间操作**

- `filter`：过滤元素
- `map`：元素转换
- `flatMap`：扁平化处理
- `sorted`：排序
- `distinct`：去重
- `peek`：对元素执行操作，但不改变流.`peek` 是专门为调试或临时观察流中元素设计的中间操作。不会改变流的元素，只能查看、打印、记录等。
- `limit`、`skip`：截断

```java
List<Integer> numbers = Arrays.asList(3, 1, 2, 2, 4, 5, 1);

// 过滤出偶数 → 去重 → 排序 → 限制前2个
Stream<Integer> processed = numbers.stream()
    .filter(n -> n % 2 == 0) // 保留偶数：2,2,4
    .distinct() // 去重：2,4
    .sorted() // 排序：2,4
    .limit(2); // 取前2个：2,4
```

### **3. 终端操作**

- **`collect(Collector)`**：将流转换为集合（如 `List`、`Set`、`Map`）。

- **`forEach(Consumer)`**：遍历元素并执行操作。

- **`count()`**：返回元素个数。

- **`findFirst()`**：返回第一个元素（`Optional` 类型）。

- **`reduce(BinaryOperator)`**：聚合元素（如求和、求积）。

  

```java
import java.util.List;
import java.util.stream.Collectors;

// 续上面的 processed 流
List<Integer> result = processed.collect(Collectors.toList()); // 转换为 List：[2,4]

// 遍历输出
numbers.stream().forEach(System.out::println); // 打印所有元素

// 求和
int sum = numbers.stream().reduce(0, Integer::sum); // 3+1+2+2+4+5+1=18

// 统计偶数个数
long evenCount = numbers.stream().filter(n -> n % 2 == 0).count(); // 3个（2,2,4）
```

**五、实际应用场景**

- 集合数据过滤与转换（如从用户列表中提取所有成年用户的姓名）。
- 数据聚合计算（如统计销售额总和、平均值）。
- 简化集合操作代码（替代传统的 for 循环 + 判断逻辑）。



例如，从用户列表中筛选出年龄大于 18 岁的用户名：

```java
class User {
    private String name;
    private int age;
    // 构造器、getter 略
}

List<User> users = Arrays.asList(
    new User("Alice", 20),
    new User("Bob", 17),
    new User("Charlie", 25)
);

// 提取成年用户的姓名
List<String> adultNames = users.stream()
    .filter(u -> u.getAge() > 18)
    .map(User::getName)
    .collect(Collectors.toList()); // 结果：[Alice, Charlie]
```

**延迟执行**

在执行返回 `Stream` 的方法时，并不立刻执行，而是等返回一个非 `Stream` 的方法后才执行。因为拿到 `Stream` 并不能直接用，而是需要处理成一个常规类型