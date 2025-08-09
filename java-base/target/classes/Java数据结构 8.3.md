# Java 常用数据结构总结

## 1. 数组（Arrays）

- **定义**：一种可以存储固定大小的相同类型元素的线性数据结构。

- 特点

  - **优点**：随机访问元素效率高，通过索引可以直接定位到元素。
  - **缺点**：大小固定，一旦初始化后长度无法改变，因此插入和删除元素时需要移动大量元素，操作相对较慢。

- 示例代码

  ```java
  int[] arr = new int[5]; // 声明一个长度为5的int类型数组
  ```

- **适用场景**：适用于元素数量固定，且需要频繁进行随机访问的场景，如存储学生成绩、统计数据等。

## 2. 列表（Lists）

列表是一种动态的线性数据结构，主要有 ArrayList 和 LinkedList 两种常见实现。

### 2.1 ArrayList

- **底层数据结构**：基于动态数组实现，会根据元素数量自动扩容或缩容。

- 特点

  - **优点**：支持高效的随机访问（通过索引计算元素地址），且尾部插入和删除元素速度快。
  - **缺点**：在中间或头部进行插入和删除操作时，需要移动大量元素，效率相对较低。

- 示例代码

  ```java
  List<String> list = new ArrayList<>();
  list.add("apple"); // 添加元素
  String element = list.get(0); // 获取索引为0的元素
  ```

### 2.2 LinkedList

- **底层数据结构**：基于双向链表实现，元素之间通过指针（引用）相互连接。

- 特点

  - **优点**：在任意位置进行插入和删除元素时，只需修改指针指向，操作高效。
  - **缺点**：随机访问元素时需要从链表头或尾开始遍历，效率相对较慢。

- 示例代码

  ```java
  List<Integer> linkedList = new LinkedList<>();
  linkedList.add(10);
  linkedList.remove(0); // 删除索引为0的元素
  ```

## 3. 集合（Sets）

集合用于存储不重复的元素，主要有 HashSet 和 TreeSet 两种实现。

### 3.1 HashSet

- **底层实现**：基于哈希表（HashMap）实现。

- 特点

  - **优点**：查询、插入和删除元素的效率高，平均时间复杂度为 O (1)。
  - **缺点**：存储的元素是无序的，不保证元素的排列顺序。

- 示例代码

  ```java
  Set<String> hashSet = new HashSet<>();
  hashSet.add("banana");
  boolean contains = hashSet.contains("banana"); // 判断是否包含指定元素
  ```

### 3.2 TreeSet

- **底层实现**：基于红黑树（一种自平衡的二叉搜索树）实现，不允许存储重复元素。

- 特点

  - **优点**：会对存储的元素自动排序，适用于需要按顺序存储和访问元素的场景。
  - **缺点**：不允许插入 null 值，插入和删除元素的效率相对 HashSet 较低。

- 示例代码

  ```java
  Set<Integer> treeSet = new TreeSet<>();
  treeSet.add(3);
  treeSet.add(1);
  // 遍历集合时，元素会按升序排列：1, 3
  ```

## 4. 映射（Maps）

映射用于存储键值对（key-value）数据，每个键唯一，主要有 HashMap 和 TreeMap 两种实现。

### 4.1 HashMap

- **底层实现**：基于哈希表实现键值对的存储。

- 特点

  - **优点**：查询、插入和删除操作的效率高，平均时间复杂度为 O (1)。
  - **缺点**：存储的键值对是无序的，不保证遍历顺序。

- 示例代码

  ```java
  Map<String, Integer> hashMap = new HashMap<>();
  hashMap.put("score", 90); // 添加键值对
  int value = hashMap.get("score"); // 根据键获取值
  ```

### 4.2 TreeMap

- **底层实现**：基于红黑树实现，能够保证键值对的有序存储。

- 特点

  - **优点**：可以按照键的自然顺序或自定义顺序进行遍历。
  - **缺点**：插入和删除元素的效率相对 HashMap 较低，时间复杂度为 O (log n)。

- 示例代码

  ```java
  Map<String, String> treeMap = new TreeMap<>();
  treeMap.put("b", "ball");
  treeMap.put("a", "apple");
  // 遍历集合时，键会按升序排列：a=apple, b=ball
  ```

## 5. 栈（Stack）

- **定义**：一种特殊的线性数据结构，遵循 “后进先出”（LIFO，Last In First Out）的原则。

- 基本操作

  - 入栈（push）：将元素添加到栈顶。
  - 出栈（pop）：移除并返回栈顶元素。
  - 查看栈顶元素（peek）：返回栈顶元素但不移除。

- 示例代码

  ```java
  Stack<Integer> stack = new Stack<>();
  stack.push(5);
  stack.push(10);
  int top = stack.pop(); // 弹出栈顶元素10
  ```

- **适用场景**：表达式求值、括号匹配、函数调用栈等。

## 6. 队列（Queue）

- **定义**：一种线性数据结构，遵循 “先进先出”（FIFO，First In First Out）的原则。

- 基本操作

  - 入队（offer）：将元素添加到队列尾部。
  - 出队（poll）：移除并返回队列头部元素。
  - 查看队头元素（peek）：返回队列头部元素但不移除。

- **常见实现**：LinkedList（实现了 Queue 接口）、ArrayDeque 等。

- 示例代码

  ```java
  Queue<String> queue = new LinkedList<>();
  queue.offer("first");
  queue.offer("second");
  String head = queue.poll(); // 弹出队头元素"first"
  ```

- **适用场景**：消息队列、广度优先搜索（BFS）等。

## 7. 堆（Heap）

- 定义：一种基于完全二叉树的数据结构，通常分为最大堆和最小堆

  - 最大堆：每个父节点的值都大于或等于其左右子节点的值。
  - 最小堆：每个父节点的值都小于或等于其左右子节点的值。

- 基本操作

  - 插入元素：将元素添加到堆的末尾，然后进行上浮调整以维持堆的性质。
  - 删除堆顶元素：移除堆顶元素后，将堆尾元素移到堆顶，再进行下沉调整。

- 示例代码

  ```java
  // Java中通过PriorityQueue实现最小堆（默认）
  PriorityQueue<Integer> minHeap = new PriorityQueue<>();
  minHeap.add(3);
  minHeap.add(1);
  minHeap.add(2);
  int min = minHeap.poll(); // 弹出最小元素1
  
  // 实现最大堆
  PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
  ```

- **适用场景**：优先队列、堆排序、获取 Top K 元素等。