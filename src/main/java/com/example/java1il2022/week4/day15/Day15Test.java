package com.example.java1il2022.week4.day15;

import com.example.java1il2022.week3.day14.demo3.Student;

import java.util.TreeSet;

public class Day15Test {
    public static void main(String[] args) {
        TreeSet<Day15Student> set = new TreeSet<>();
        set.add(new Day15Student());
    }
}


class Day15Student implements Comparable{
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
