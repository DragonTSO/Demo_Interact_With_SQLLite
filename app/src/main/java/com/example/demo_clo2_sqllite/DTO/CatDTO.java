package com.example.demo_clo2_sqllite.DTO;

public class CatDTO {
    int id;
    String name;
    public String toString (){
        return "ID Cat: " + id + "Name Cat: " + name;
    }
    // tạo các hàm getter và setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
