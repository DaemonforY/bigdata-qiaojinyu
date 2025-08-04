package com.example.day03;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// 定义地点类
class Location {
    private String name;

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

// 定义地点集合类
class LocationCollection implements Iterable<Location> {
    private List<Location> locations;

    public LocationCollection() {
        this.locations = new ArrayList<>();
    }

    public void addLocation(Location location) {
        locations.add(location);
    }

    @Override
    public Iterator<Location> iterator() {
        return locations.iterator();
    }
}

// 导航系统类使用迭代器遍历地点信息
public class NavigationSystem {
    public static void main(String[] args) {
        LocationCollection collection = new LocationCollection();
        collection.addLocation(new Location("博物馆"));
        collection.addLocation(new Location("公园"));
        collection.addLocation(new Location("剧院"));
        collection.addLocation(new Location("餐厅"));

        // 使用迭代器遍历地点
        Iterator<Location> iterator = collection.iterator();
        System.out.println("导航系统正在遍历地点信息:");
        while (iterator.hasNext()) {
            Location location = iterator.next();
            System.out.println("现在位置: " + location);
        }
    }
}