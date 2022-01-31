package com.example.java1il2022.week3.day10;


public class BuilderPattern {
    public static void main(String[] args) {
//        Day10Student stu = new Day10Student().setName("1").setAge("10");
        Day10Student stu = new Day10StudentBuilder().setAge("1").setName("2").build();
    }
}


class Day10Student {
    private String name;
    private String age;
    //10 fields

    public Day10Student(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Day10Student setName(String name) {
        this.name = name;
        return this;
    }

    public String getAge() {
        return age;
    }

    public Day10Student setAge(String age) {
        this.age = age;
        return this;
    }

}

class Day10StudentBuilder {

    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public Day10StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public String getAge() {
        return age;
    }

    public Day10StudentBuilder setAge(String age) {
        this.age = age;
        return this;
    }

    public Day10Student build() {
        return new Day10Student(name, age);
    }
}



