package com.munte.disertatiebackend.classes.dtos;

public class TagsCounted {
    private String name;
    private long count = 0;

    public TagsCounted(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public void IncreaseCount() {
        this.count++;
    }
}
