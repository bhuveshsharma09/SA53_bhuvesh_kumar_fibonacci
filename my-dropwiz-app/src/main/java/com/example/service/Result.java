package com.example.service;
import java.util.*;
public class Result {

    public Result(){};
public Result(List<Long> fibonacci,List<Long> sorted)
{
    this.fibonacci = fibonacci;
    this.sorted =sorted;
}

    public List<Long> getFibonacciList() {
        return fibonacci;
    }

    public List<Long> getSortedList() {
        return sorted;
    }



    public List<Long> fibonacci;
    public List<Long> sorted;

}
