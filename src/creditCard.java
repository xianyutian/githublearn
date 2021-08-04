
import java.util.Scanner;
public class creditCard {
    public static void main(String []args)
    {   Scanner input=new Scanner(System.in);
        System.out.print("请输入卡号:");//合法：52713524856122，不合法：4388576018402626
        long n=input.nextLong();//
        if(isValid(n))
        {
            System.out.println("卡号合法！");
        }
        else System.out.println("卡号不合法！");
    }
    /*Return true if the card number is valid*/
    public static boolean isValid(long number)
    {
        if(prefixMatched(number,4)||prefixMatched(number,5)||prefixMatched(number,6)||prefixMatched(number,37))
        {
            if(getSize(number)>=13&&getSize(number)<=16)
            {
                if((sumOfDoubleEvenPlace(number)+sumOfOddPlace(number))%10==0)
                    return true;
            }
        }
        return false;
    }

    /*Get the result from step 2*/
    public static int sumOfDoubleEvenPlace(long number)
    {
        int k=0;
        number/=10;
        while(number>0)
        {
            k+=getDigit(2*(int)(number%10));
            number/=100;
        }
        return k;
    }
    /*Return this number if it is a single digit, otherwise return the sum of the two digits*/
    public static int getDigit(int number)
    {
        if(number<10)
            return number;
        else
            return number%10+1;
    }

    /*Return sum of odd place digits in number*/
    public static int sumOfOddPlace(long number)
    {
        int k=0;
        while(number>0)
        {
            k+=number%10;
            number/=100;
        }
        return k;
    }

    /*Return true if the digit d is a prefix for number*/
    public static boolean prefixMatched(long number, int d)
    {
        if(getPrefix(number,1)==d||getPrefix(number,2)==d)
            return true;
        else return false;
    }

    /*Return the number of digits in d*/
    public static int getSize(long d)
    {
        int count=0;
        while(d!=0)
        {
            d=d/10;
            count++;
        }
        return count;
    }


    /*Return the first k number of digits from number. If the number of digits in number is less than k, return number*/
    public static long getPrefix(long number, int k)
    {
        int length=getSize(number)-k;
        for(int i=0;i<length;i++)
            number/=10;
        return number;
    }

}

