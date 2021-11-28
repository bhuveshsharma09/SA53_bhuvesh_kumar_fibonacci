package com.example.service;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultService {

    // define the biggest possible datatype List
    public List<Long> fibonacciSequence = new ArrayList<>();
    public List<Long> sortedSequence = new ArrayList<>();

    // variable to hold element number
    public int elements;

    // constructor which takes elements number from Resource class
    public ResultService(int elements)
    {
        this.elements = elements;
    }

    // the method to process data and initialise the
    // result obj with appropriate values
    public Result getTheResult()
    {
        fibonacciCompute();
        //convertToString();
        Result result = new Result();

        this.sortedSequence = sortTheList();
        //printTheSeq(this.sortedSequence);
        System.out.println(Arrays.toString(this.sortedSequence.toArray()));

        // print for debug
        for(int i=0;i<this.sortedSequence.size();i++)
        {
            System.out.println(this.sortedSequence.get(i));
        }

        // set values in result object
        result.fibonacci=this.fibonacciSequence;
        result.sorted= this.sortedSequence;
        return result;
    }


    public void fibonacciCompute()
        {
            // the method to compute fibonacci sequence
            Long num1=0L,num2=1L,num3;
            int count=this.elements;
            //System.out.print(num1+" "+num2);
            this.fibonacciSequence.add(num1);
            this.fibonacciSequence.add(num2);

            for(int i=2; i<count; ++i)
            {//this.fibonacciSequence.add(num2);
                num3=num1+num2;
                //System.out.print(" "+num3);
                num1=num2;
                num2=num3;
                this.fibonacciSequence.add(num2);
            }
        }


        public List<Long> sortTheList()
        {
            // the method to sort the sequence values
            // as per recommendation in the test
             List<Long> evenList = new ArrayList<>();
             List<Long> oddList = new ArrayList<>();

            //System.out.println(Arrays.toString(this.fibonacciSequence.toArray()));

            for(int i=0;i<fibonacciSequence.size();i++)
            {
                if(this.fibonacciSequence.get(i) %2 ==0)
                {
                    evenList.add(this.fibonacciSequence.get(i));
                }
                else
                {
                    oddList.add(this.fibonacciSequence.get(i));
                }
            }
            // reverse the lists
            Collections.reverse(evenList);
            Collections.reverse(oddList);

            // join the lists
            List<Long> newList = new ArrayList<Long>(evenList);
            newList.addAll(oddList);
            // return new list
            return newList;
        }
}
