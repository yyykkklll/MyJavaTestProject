package Swing_01;

public class Student {
    public String name;
    public boolean sex;
    public int age;
    public int id;

    public Student(String name,boolean sex,int age,int id) {
        this.name = name;
        this.sex =sex;
        this.age = age;
        this.id = id;
    }

    @Override
    public String toString() {
        String str = this.name;
        str += "（";
        if (this.sex)
            str += '男';
        else
            str += "女";
        str += ")";
        return str;
    }
}
