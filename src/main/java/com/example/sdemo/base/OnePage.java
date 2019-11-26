package com.example.sdemo.base;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class OnePage<T> {

    private boolean first;

    private boolean last;

    private int number;

    private int numberOfElements;

    private int size;

    private int totalElements;

    private int totalPages;

    private List<T> content = new ArrayList<>();

    public OnePage() {
        super();
    }

    public OnePage(int number, int size, int totalElements, List<T> content) {
        super();
        this.number = number + 1;
        this.size = size;
        this.totalElements = totalElements;
        this.content = content;
        this.totalPages = totalElements % size == 0 ? totalElements / size : totalElements / size + 1;
    }

    public OnePage(org.springframework.data.domain.Page<T> source) {
        BeanUtils.copyProperties(source, this);
    }

    public boolean isFirst() {
        return number == 1;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isLast() {
        return number == totalPages;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        //配合前端分页
        this.number = number + 1;
    }

    public int getNumberOfElements() {
        return content.size();
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalElements % size == 0 ? totalElements / size : totalElements / size + 1;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
        this.numberOfElements = this.content.size();
    }

    @Override
    public String toString() {
        return "OnePage [first=" + first + ", last=" + last + ", number=" + number + ", numberOfElements=" + numberOfElements + ", size=" + size
                + ", totalElements=" + totalElements + ", totalPages=" + totalPages + ", content=" + content + "]";
    }
}
