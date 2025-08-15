package com.example.day11;



import java.util.*;
        import java.util.concurrent.ConcurrentMap;
        import java.util.function.Supplier;
        import java.util.stream.*;

public class StreamPitfallsSolutions {

    public static void main(String[] args) {
        reuseStream();
        parallelSafeCollect();
        useCollectInsteadOfPeek();
        handleNulls();
        forceEvaluation();
        parallelForHeavyTasks();
        flatMapInsteadOfMap();
        collectToSet();
        concurrentGrouping();
        finiteInfiniteStream();
    }

    // 1. 流只能消费一次 → 使用 Supplier 或集合源
    static void reuseStream() {
        Supplier<Stream<String>> streamSupplier = () -> Stream.of("a", "b", "c");
        streamSupplier.get().forEach(System.out::println);
        long count = streamSupplier.get().filter("a"::equals).count();
        System.out.println("count of 'a': " + count);

        // 亦可：List<String> src = Arrays.asList("a","b","c"); src.stream()... 可多次创建新流
    }

    // 2. 并行流与共享可变状态 → 使用无副作用的收集
    static void parallelSafeCollect() {
        List<Integer> numbers = IntStream.range(0, 1000).boxed().toList();
        List<Integer> safeList = numbers.parallelStream().toList();
        System.out.println(safeList.size()); // 必为 1000
    }

    // 3. 正确收集数据 → 使用 collect，而非依赖 peek 副作用
    static void useCollectInsteadOfPeek() {
        List<String> list = Arrays.asList("a", "b", "c");
        List<String> result = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(result);
    }

    // 4. 安全处理 null 元素
    static void handleNulls() {
        List<String> list = Arrays.asList("a", null, "b");
        list.stream()
                .filter(Objects::nonNull)
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // 或保留位置并提供默认值
        List<String> withDefault = list.stream()
                .map(s -> Optional.ofNullable(s).map(String::toUpperCase).orElse("N/A"))
                .collect(Collectors.toList());
        System.out.println(withDefault);
    }

    // 5. 惰性求值 → 添加终止操作
    static void forceEvaluation() {
        List<String> list = Arrays.asList("a", "b", "c");
        list.stream()
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(x -> {}); // 终止操作（可换成 collect 或 forEach(System.out::println)
    }

    // 6. 小任务并行更慢 → 用更重任务展示优势
    static void parallelForHeavyTasks() {
        List<Integer> nums = IntStream.range(0, 100).boxed().collect(Collectors.toList());

        long t1 = System.currentTimeMillis();
        nums.stream().map(StreamPitfallsSolutions::heavyWork).forEach(i -> {});
        long t2 = System.currentTimeMillis();
        System.out.println("串行耗时：" + (t2 - t1) + "ms");

        long t3 = System.currentTimeMillis();
        nums.parallelStream().map(StreamPitfallsSolutions::heavyWork).forEach(i -> {});
        long t4 = System.currentTimeMillis();
        System.out.println("并行耗时：" + (t4 - t3) + "ms");
    }

    // 模拟较重 CPU 任务（避免 Thread.sleep 的调度干扰）
    static int heavyWork(int i) {
        long acc = 0;
        for (int k = 0; k < 100_000; k++) {
            acc += (k * 31L + i) ^ 0x9E3779B97F4A7C15L;
        }
        return (int)(acc & Integer.MAX_VALUE);
    }

    // 7. 使用 flatMap 展开嵌套流
    static void flatMapInsteadOfMap() {
        List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4));
        lists.stream().flatMap(List::stream).forEach(System.out::println); // 1,2,3,4
    }

    // 8. 正确收集为 Set
    static void collectToSet() {
        List<String> list = Arrays.asList("a", "b", "c");
        Set<String> set = list.stream().collect(Collectors.toSet());
        System.out.println(set);
        // 若需稳定迭代顺序：Collectors.toCollection(LinkedHashSet::new)
    }

    // 9. 并行流分组统计线程安全 → groupingByConcurrent
    static void concurrentGrouping() {
        List<String> list = Arrays.asList("a", "b", "a");
        ConcurrentMap<String, Long> map = list.parallelStream()
                .collect(Collectors.groupingByConcurrent(s -> s, Collectors.counting()));
        System.out.println(map);
    }

    // 10. 无限流 → 使用 limit 截断
    static void finiteInfiniteStream() {
        Stream.iterate(0, n -> n + 1).limit(10).forEach(System.out::println);
    }
}