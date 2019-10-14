package eg.edu.alexu.csd.oop.calculator.cs67;


import java.io.*;
import java.util.Scanner;

public class CalculatorImplementation implements Calculator {

    private int end=0,current=-1,steps=0;
    private String [] Result=new String[5];
    private double[] first=new double[5];
    private double[] second=new double[5];
    private int[] operator=new int[5];

    @Override
    public void input(String s) {
        steps=0;
        int Start=0;
        if(s.charAt(0)=='-'||s.charAt(0)=='+')
            Start++;
        for(;Start<s.length();Start++)
        {
            if(!(s.charAt(Start)<='9'&&s.charAt(Start)>='0'||s.charAt(Start)=='.'))
                break;
        }
        try
        {
            first[end%5]=Double.parseDouble(s.substring(0,Start));
        }catch (Exception e)
        {
            throw new RuntimeException("Make sure you entered a valid form of the first number");
        }
        try
        {
            second[end%5]=Double.parseDouble(s.substring(Start+1));
        }catch (Exception e)
        {
            throw new RuntimeException("Make sure you entered a valid form of the first number");
        }
        if(s.charAt(Start)=='+')
            operator[end%5]=1;
        else if(s.charAt(Start)=='-')
            operator[end%5]=2;
        else if(s.charAt(Start)=='*')
            operator[end%5]=3;
        else if(s.charAt(Start)=='/')
            operator[end%5]=4;
        Result[end%5]=s;
        current=end;
        end++;
    }

    @Override
    public String getResult() {
        if(operator[current%5]==4&&second[current%5]==0)
            throw new RuntimeException("Cannot divide by zero!");
        String ans="";
        if(operator[current%5]==1)
            ans=Double.toString(first[current%5]+second[current%5]);
        else if(operator[current%5]==2)
            ans=Double.toString(first[current%5]-second[current%5]);
        else if (operator[current%5]==3)
            ans=Double.toString(first[current%5]*second[current%5]);
        else if (operator[current%5]==4)
            ans=Double.toString(first[current%5]/second[current%5]);
        if(operator[current%5]>0&&operator[current%5]<5)
            return ans;
        else
            throw new RuntimeException("You didn't enter an operator!");
    }

    @Override
    public String current() {
        if(current!=-1)
        {
            String answer=Result[current%5];
            //end--;
            return answer;
        }
        return null;
        //throw new RuntimeException("No current operation found!");
    }

    @Override
    public String prev() {
        if(steps!=4&&current!=-1&&steps<end-1)
        {
            steps++;
            String answer=Result[(current-1)%5];
            current=(current-1)%5;
            return answer;
        }
        return null;
    }

    @Override
    public String next() {
        if (steps!=0&&current!=-1)
        {
            steps--;
            String answer=Result[(current+1)%5];
            current=(current+1)%5;
            return answer;
        }
        return null;
    }

    @Override
    public void save()  {
        try
        {
            PrintWriter pr = new PrintWriter("History.txt");
            for (int i=0; i<Result.length ; i++)
                pr.println(Result[i]);
            pr.println(steps);
            pr.println(end);
            pr.println(current);
            pr.close();
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException("No such file exists.");
        }
    }

    @Override
    public void load() {
        Scanner readCodes;
        try {
            readCodes = new Scanner(new File("History.txt"));
        } catch (Exception e) {
            throw new RuntimeException("No previous saved file exists!");
        }
        for(int i=0;i<5;i++)
            Result[i] = readCodes.nextLine();
        steps=Integer.parseInt(readCodes.nextLine());
        end=Integer.parseInt(readCodes.nextLine());
        current=Integer.parseInt(readCodes.nextLine());

    }
}
