# Java基础常见面试题总结

​	

[TOC]

## 一、基本类型和包装类型的区别

- **用途**：除了定义一些常量和局部变量之外，我们在其他地方比如方法参数、对象属性中很少会使用基本类型来定义变量。并且，包装类型可用于泛型，而基本类型不可以。
- **存储方式**：基本数据类型的局部变量存放在 Java 虚拟机栈中的局部变量表中，基本数据类型的成员变量（未被 `static` 修饰 ）存放在 Java 虚拟机的堆中。包装类型属于对象类型，我们知道几乎所有对象实例都存在于堆中。
- **占用空间**：相比于包装类型（对象类型）， 基本数据类型占用的空间往往非常小。
- **默认值**：成员变量包装类型不赋值就是 `null` ，而基本类型有默认值且不是 `null`。
- **比较方式**：对于基本数据类型来说，`==` 比较的是值。对于包装数据类型来说，`==` 比较的是对象的内存地址。所有整型包装类对象之间值的比较，全部使用 `equals()` 方法。

## 二、包装类型的缓存机制

Java 基本数据类型的包装类型的大部分都用到了缓存机制来提升性能。

`Byte`,`Short`,`Integer`,`Long` 这 4 种包装类默认创建了数值 **[-128，127]** 的相应类型的缓存数据，`Character` 创建了数值在 **[0,127]** 范围的缓存数据，`Boolean` 直接返回 `TRUE` or `FALSE`。

## 三、成员变量与局部变量的区别

- **语法形式**：从语法形式上看，成员变量是属于类的，而局部变量是在代码块或方法中定义的变量或是方法的参数；成员变量可以被 `public`,`private`,`static` 等修饰符所修饰，而局部变量不能被访问控制修饰符及 `static` 所修饰；但是，成员变量和局部变量都能被 `final` 所修饰。
- **存储方式**：从变量在内存中的存储方式来看，如果成员变量是使用 `static` 修饰的，那么这个成员变量是属于类的，如果没有使用 `static` 修饰，这个成员变量是属于实例的。而对象存在于堆内存，局部变量则存在于栈内存。
- **生存时间**：从变量在内存中的生存时间上看，成员变量是对象的一部分，它随着对象的创建而存在，而局部变量随着方法的调用而自动生成，随着方法的调用结束而消亡。
- **默认值**：从变量是否有默认值来看，成员变量如果没有被赋初始值，则会自动以类型的默认值而赋值（一种情况例外:被 `final` 修饰的成员变量也必须显式地赋值），而局部变量则不会自动赋值。

## 四、静态变量的作用

静态变量也就是被 `static` 关键字修饰的变量。它可以被类的所有实例共享，无论一个类创建了多少个对象，它们都共享同一份静态变量。也就是说，静态变量只会被分配一次内存，即使创建多个对象，这样可以节省内存。

静态变量是通过类名来访问的，例如`StaticVariableExample.staticVar`（如果被 `private`关键字修饰就无法这样访问了）。

```
public class StaticVariableExample {
    // 静态变量
    public static int staticVar = 0;
}
```

通常情况下，静态变量会被 `final` 关键字修饰成为常量。

```
public class ConstantVariableExample {
    // 常量
    public static final int constantVar = 0;
}
```

------

## 五、静态方法为什么不能调用非静态成员

1. 静态方法是属于类的，在类加载的时候就会分配内存，可以通过类名直接访问。而非静态成员属于实例对象，只有在对象实例化之后才存在，需要通过类的实例对象去访问。
2. 在类的非静态成员不存在的时候静态方法就已经存在了，此时调用在内存中还不存在的非静态成员，属于非法操作。

## 六、静态方法和实例方法有何不同

**1、调用方式**

在外部调用静态方法时，可以使用 `类名.方法名` 的方式，也可以使用 `对象.方法名` 的方式，而实例方法只有后面这种方式。也就是说，**调用静态方法可以无需创建对象** 。

不过，需要注意的是一般不建议使用 `对象.方法名` 的方式来调用静态方法。这种方式非常容易造成混淆，静态方法不属于类的某个对象而是属于这个类。

因此，一般建议使用 `类名.方法名` 的方式来调用静态方法。

```java
public class Person {
    public void method() {
      //......
    }

    public static void staicMethod(){
      //......
    }
    public static void main(String[] args) {
        Person person = new Person();
        // 调用实例方法
        person.method();
        // 调用静态方法
        Person.staicMethod()
    }
}
```

**2、访问类成员是否存在限制**

静态方法在访问本类的成员时，只允许访问静态成员（即静态成员变量和静态方法），不允许访问实例成员（即实例成员变量和实例方法），而实例方法不存在这个限制

## 7、构造方法的特点 是否可被重写

构造方法具有以下特点：

- **名称与类名相同**：构造方法的名称必须与类名完全一致。
- **没有返回值**：构造方法没有返回类型，且不能使用 `void` 声明。
- **自动执行**：在生成类的对象时，构造方法会自动执行，无需显式调用。

构造方法**不能被重写（override）**，但**可以被重载（overload）**。因此，一个类中可以有多个构造方法，这些构造方法可以具有不同的参数列表，以提供不同的对象初始化方式。



## 8、接口和抽象类有什么共同点和区别

**接口和抽象类的共同点**

- **实例化**：接口和抽象类都不能直接实例化，只能被实现（接口）或继承（抽象类）后才能创建具体的对象。
- **抽象方法**：接口和抽象类都可以包含抽象方法。抽象方法没有方法体，必须在子类或实现类中实现。

**接口和抽象类的区别**

   **设计目的**：接口主要用于对类的行为进行约束，你实现了某个接口就具有了对应的行  为。抽象类主要用于代码复用，强调的是所属关系。

- **继承和实现**：一个类只能继承一个类（包括抽象类），因为 Java 不支持多继承。但一个类可以实现多个接口，一个接口也可以继承多个其他接口。

- **成员变量**：接口中的成员变量只能是 `public static final` 类型的，不能被修改且必须有初始值。抽象类的成员变量可以有任何修饰符（`private`, `protected`, `public`），可以在子类中被重新定义或赋值。

  

## 9、String、StringBuffer、StringBuilder 的区别

**可变性**

`String` 是不可变的

`StringBuilder` 与 `StringBuffer` 都继承自 `AbstractStringBuilder` 类，在 `AbstractStringBuilder` 中也是使用字符数组保存字符串，不过没有使用 `final` 和 `private` 关键字修饰，最关键的是这个 `AbstractStringBuilder` 类还提供了很多修改字符串的方法比如 `append` 方法。

**线程安全性**

`String` 中的对象是不可变的，也就可以理解为常量，线程安全。`AbstractStringBuilder` 是 `StringBuilder` 与 `StringBuffer` 的公共父类，定义了一些字符串的基本操作，如 `expandCapacity`、`append`、`insert`、`indexOf` 等公共方法。`StringBuffer` 对方法加了同步锁或者对调用的方法加了同步锁，所以是线程安全的。`StringBuilder` 并没有对方法进行加同步锁，所以是非线程安全的。

**性能**

每次对 `String` 类型进行改变的时候，都会生成一个新的 `String` 对象，然后将指针指向新的 `String` 对象。`StringBuffer` 每次都会对 `StringBuffer` 对象本身进行操作，而不是生成新的对象并改变对象引用。相同情况下使用 `StringBuilder` 相比使用 `StringBuffer` 仅能获得 10%~15% 左右的性能提升，但却要冒多线程不安全的风险。

**对于三者使用的总结：**

- 操作少量的数据: 适用 `String`
- 单线程操作字符串缓冲区下操作大量数据: 适用 `StringBuilder`
- 多线程操作字符串缓冲区下操作大量数据: 适用 `StringBuffer`



## 10、异常

![types-of-exceptions-in-java](C:\Users\55422\Downloads\types-of-exceptions-in-java.png)

在 Java 中，所有的异常都有一个共同的祖先 `java.lang` 包中的 `Throwable` 类。`Throwable` 类有两个重要的子类:

- **`Exception`** :程序本身可以处理的异常，可以通过 `catch` 来进行捕获。`Exception` 又可以分为 Checked Exception (受检查异常，必须处理) 和 Unchecked Exception (不受检查异常，可以不处理)。
- **`Error`**：`Error` 属于程序无法处理的错误 ，不建议通过`catch`捕获 。例如 Java 虚拟机运行错误（`Virtual MachineError`）、虚拟机内存不够错误(`OutOfMemoryError`)、类定义错误（`NoClassDefFoundError`）等 。这些异常发生时，Java 虚拟机（JVM）一般会选择线程终止。

**try-catch-finally 使用**

- `try`块：用于捕获异常。其后可接零个或多个 `catch` 块，如果没有 `catch` 块，则必须跟一个 `finally` 块。
- `catch`块：用于处理 try 捕获到的异常。
- `finally` 块：无论是否捕获或处理异常，`finally` 块里的语句都会被执行。当在 `try` 块或 `catch` 块中遇到 `return` 语句时，`finally` 语句块将在方法返回之前被执行。不要在 finally 语句块中使用 return。finally 中的代码不一定会执行，比如说 finally 之前虚拟机被终止运行的话，finally 中的代码就不会被执行。

## 11、泛型

**什么是泛型？有什么作用？**

使用泛型参数，可以增强代码的可读性以及稳定性。

编译器可以对泛型参数进行检测，并且通过泛型参数可以指定传入的对象类型。比如 `ArrayList<Person> persons = new ArrayList<Person>()` 这行代码就指明了该 `ArrayList` 对象只能传入 `Person` 对象，如果传入其他类型的对象就会报错。

并且，原生 `List` 返回类型是 `Object` ，需要手动转换类型才能使用，使用泛型后编译器自动转换。

```java
ArrayList<E> extends AbstractList<E>
    ArrayList<Person> persons = new ArrayList<Person>()
```

**泛型的使用方式有哪几种？**

泛型一般有三种使用方式:**泛型类**、**泛型接口**、**泛型方法**。

**1.泛型类**

```java
//在实例化泛型类时，必须指定T的具体类型
 /* E - Element (在集合中使用，因为集合中存放的是元素)
    * T - Type（Java 类）
    * K - Key（键）
    * V - Value（值）
    *  ？ - 表示不确定的 java 类型
   */
public class Generic<T>{

    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey(){
        return key;
    }
}

实例化泛型类：
   Generic<Integer> genericInteger = new Generic<Integer>(123456);
```

**2.泛型接口**：

```java
public interface Generator<T> {
    public T method();
}
实现泛型接口，不指定类型：
class GeneratorImpl<T> implements Generator<T>{
    @Override
    public T method() {
        return null;
    }
}
  实现泛型接口，指定类型：
class GeneratorImpl implements Generator<String> {
    @Override
    public String method() {
        return "hello";
    }
}
```

**3.泛型方法**：

```java
   public static < E > void printArray( E[] inputArray )
   {
         for ( E element : inputArray ){
            System.out.printf( "%s ", element );
         }
         System.out.println();
    }

使用：
    // 创建不同类型数组：Integer, Double 和 Character
Integer[] intArray = { 1, 2, 3 };
String[] stringArray = { "Hello", "World" };
printArray( intArray  );
printArray( stringArray  );
```



## 12、反射

**什么是反射**

  简单来说，Java 反射 (Reflection) 是一种**在程序运行时，动态地获取类的信息并操作类或对象（方法、属性）的能力**。

  通常情况下，我们写的代码在编译时类型就已经确定了，要调用哪个方法、访问哪个字段都是明确的。但反射允许我们在**运行时**才去探知一个类有哪些方法、哪些属性、它的构造函数是怎样的，甚至可以动态地创建对象、调用方法或修改属性，哪怕这些方法或属性是私有的。

  正是这种在运行时“反观自身”并进行操作的能力，使得反射成为许多**通用框架和库的基石**。它让代码更加灵活，能够处理在编译时未知的类型。

**优点：**

1. **灵活性和动态性**：反射允许程序在运行时动态地加载类、创建对象、调用方法和访问字段。这样可以根据实际需求（如配置文件、用户输入、注解等）动态地适应和扩展程序的行为，显著提高了系统的灵活性和适应性。
2. **框架开发的基础**：许多现代 Java 框架（如 Spring、Hibernate、MyBatis）都大量使用反射来实现依赖注入（DI）、面向切面编程（AOP）、对象关系映射（ORM）、注解处理等核心功能。反射是实现这些“魔法”功能不可或缺的基础工具。
3. **解耦合和通用性**：通过反射，可以编写更通用、可重用和高度解耦的代码，降低模块之间的依赖。例如，可以通过反射实现通用的对象拷贝、序列化、Bean 工具等。

**缺点：**

1. **性能开销**：反射操作通常比直接代码调用要慢。因为涉及到动态类型解析、方法查找以及 JIT 编译器的优化受限等因素。不过，对于大多数框架场景，这种性能损耗通常是可以接受的，或者框架本身会做一些缓存优化。
2. **安全性问题**：反射可以绕过 Java 语言的访问控制机制（如访问 `private` 字段和方法），破坏了封装性，可能导致数据泄露或程序被恶意篡改。此外，还可以绕过泛型检查，带来类型安全隐患。
3. **代码可读性和维护性**：过度使用反射会使代码变得复杂、难以理解和调试。错误通常在运行时才会暴露，不像编译期错误那样容易发现。

很多流行的框架，比如 Spring/Spring Boot、MyBatis 等，底层都大量运用了反射机制。

## 13、I/O

  数据输入到计算机内存的过程即输入，反之输出到外部存储（比如数据库，文件，远程主机）的过程即输出。数据传输过程类似于水流，因此称为 IO 流。IO 流在 Java 中分为输入流和输出流，而根据数据的处理方式又分为字节流和字符流。

- | **对比维度** | **字节流**                                | **字符流**                    |
  | ------------ | ----------------------------------------- | ----------------------------- |
  | 处理单位     | 字节（8 位）                              | 字符（16 位 Unicode）         |
  | 适用数据     | 所有类型（二进制 + 文本图片、音频、视频） | 仅文本数据                    |
  | 编码依赖     | 不涉及编码转换（直接操作字节）            | 依赖编码（自动转换字节↔字符） |
  | 基类         | `InputStream`/`OutputStream`              | `Reader`/`Writer`             |

**字节缓冲流**

  IO 操作是很消耗性能的，缓冲流将数据加载至缓冲区，一次性读取/写入多个字节，从而避免频繁的 IO 操作，提高流的传输效率。

  字节缓冲流这里采用了装饰器模式来增强 `InputStream` 和`OutputStream`子类对象的功能。

**四个缓冲流的对比表**

| **特性**     | `BufferedReader`              | `BufferedWriter`              | `BufferedInputStream`              | `BufferedOutputStream`              |
| ------------ | ----------------------------- | ----------------------------- | ---------------------------------- | ----------------------------------- |
| **处理单位** | 字符（Unicode）               | 字符（Unicode）               | 字节（8 位二进制）                 | 字节（8 位二进制）                  |
| **继承父类** | `Reader`                      | `Writer`                      | `InputStream`                      | `OutputStream`                      |
| **包装对象** | 字符输入流（如 `FileReader`） | 字符输出流（如 `FileWriter`） | 字节输入流（如 `FileInputStream`） | 字节输出流（如 `FileOutputStream`） |
| **核心优势** | 按行读取（`readLine()`）      | 跨平台换行（`newLine()`）     | 高效读取二进制数据                 | 高效写入二进制数据                  |
| **适用数据** | 文本数据（`.txt`、字符串等）  | 文本数据                      | 二进制数据（图片、视频等）         | 二进制数据                          |
| **典型方法** | `readLine()`                  | `newLine()`、`flush()`        | `read(byte[])`                     | `write(byte[])`、`flush()`          |
| **编码依赖** | 依赖（自动处理字符编码）      | 依赖（自动处理字符编码）      | 不依赖（直接操作字节）             | 不依赖（直接操作字节）              |

**关键总结**

- 所有缓冲流都**不能直接操作数据源**，必须包装一个对应的 “底层流”（如 `FileReader`、`FileInputStream` 等）。
- 缓冲流的核心价值是**提高效率**：通过缓冲区减少磁盘 I/O 次数（内存操作比磁盘操作快得多）。
- 选择原则：处理文本用 `BufferedReader`/`BufferedWriter`，处理二进制数据用 `BufferedInputStream`/`BufferedOutputStream`。
- 关闭缓冲流时，只需关闭缓冲流本身，底层流会被自动关闭。

**打印流**

  打印流是**输出流的一种扩展**，专为方便输出数据设计，提供了一系列重载的 `print()` 和 `println()` 方法，支持多种数据类型（如字符串、整数、对象等）的直接输出，无需手动转换格式。

适用场景

- 控制台输出（`System.out` 本质是 `PrintStream`）。

- 日志记录（方便输出各种类型的日志信息）。

- 格式化文本输出（如生成报告、配置文件等）。

  

**随机访问流**

随机访问流是一种**可以双向操作的流**，既可以读也可以写，并且支持**随机访问文件的任意位置**。

常用方法

- `seek(long pos)`：将文件指针定位到 `pos` 字节处（从文件开头计算）。
- `readXXX()`：读基本类型（如 `readInt()`、`readUTF()`）。
- `writeXXX()`：写基本类型（如 `writeInt()`、`writeUTF()`）。
- `getFilePointer()`：获取当前文件指针位置。
- `length()`：获取文件长度。

适用场景

- 大文件的分段读写（如断点续传）。
- 数据库文件、日志文件等需要随机修改的场景。
- 需要在文件中间插入或修改数据的场景（普通流只能覆盖或追加）。

| **特性**       | 打印流（PrintStream / PrintWriter）       | 随机访问流（RandomAccessFile）         |
| -------------- | ----------------------------------------- | -------------------------------------- |
| **主要功能**   | 便捷输出多种类型数据，简化输出操作        | 随机读写文件任意位置，支持双向操作     |
| **操作方向**   | 仅输出（写）                              | 既可以读也可以写                       |
| **定位能力**   | 只能顺序输出，无法定位                    | 通过 `seek()` 随机定位任意位置         |
| **处理的数据** | 文本数据为主（也可处理字节）              | 二进制或结构化数据（如固定格式的记录） |
| **典型应用**   | 控制台输出、日志记录、文本生成            | 断点续传、数据库文件、随机修改文件内容 |
| **依赖其他流** | 需要包装底层输出流（如 FileOutputStream） | 直接操作文件，不依赖其他流             |

## 14、语法糖

  指那些不影响语言功能、但能让代码更简洁、更易读、更符合人类思维习惯的语法特性。它们本质上是编译器提供的 “语法层面的包装”，最终会被编译（或解释）为语言的基础语法结构，不会引入新的功能，却能提升开发效率。

**Java 中的语法糖示例：**

1. **foreach 循环（增强 for 循环）**
   简化了对数组或集合的遍历，本质是编译器自动转换为迭代器（`Iterator`）或索引循环。

   ```java
   // 语法糖形式
   int[] arr = {1, 2, 3};
   for (int num : arr) {
       System.out.println(num);
   }
   
   // 解糖后（编译器转换的基础语法）
   int[] arr = {1, 2, 3};
   for (int i = 0; i < arr.length; i++) {
       int num = arr[i];
       System.out.println(num);
   }
   ```

2. **自动装箱 / 拆箱**
   简化了基本类型与包装类型的转换，本质是编译器自动插入 `valueOf()` 或 `xxxValue()` 方法调用。

   ```java
   // 语法糖形式
   Integer i = 10;  // 自动装箱（int → Integer）
   int j = i;       // 自动拆箱（Integer → int）
   
   // 解糖后
   Integer i = Integer.valueOf(10);
   int j = i.intValue();
   ```

3. **Lambda 表达式**
   简化了匿名内部类的写法，本质是编译器自动生成匿名类实现函数式接口。

   ```java
   // 语法糖形式
   Runnable r = () -> System.out.println("Hello");
   
   // 解糖后（类似匿名内部类）
   Runnable r = new Runnable() {
       @Override
       public void run() {
           System.out.println("Hello");
       }
   };
   ```

4. **字符串拼接（`+` 运算符）**
   简化了字符串拼接，本质是编译器自动转换为 `StringBuilder` 的 `append()` 方法。

   ```java
   // 语法糖形式
   String a = "Hello";
   String b = "World";
   String c = a + b;
   
   // 解糖后
   String a = "Hello";
   String b = "World";
   String c = new StringBuilder().append(a).append(b).toString();
   ```

5. **try-with-resources**
   简化了资源关闭代码，本质是编译器自动生成 `finally` 块来关闭资源。

   ```java
   // 语法糖形式
   try (FileReader fr = new FileReader("test.txt")) {
       // 操作文件
   } catch (IOException e) {
       e.printStackTrace();
   }
   
   // 解糖后（类似手动关闭资源）
   FileReader fr = new FileReader("test.txt");
   try {
       // 操作文件
   } catch (IOException e) {
       e.printStackTrace();
   } finally {
       if (fr != null) {
           try {
               fr.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
   }
   ```