package com.excelsiorsoft;

import static org.junit.Assert.*;



import java.math.BigDecimal;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.junit.Test;



public class TransactionUtilTest {



@Test

public void testDoubleFormat() {
//https://stackoverflow.com/questions/8819842/best-way-to-format-a-double-value-to-2-decimal-places
double amount = 801.35;

System.out.println(new BigDecimal(amount).setScale(2, RoundingMode.CEILING).doubleValue());
DecimalFormat df = new DecimalFormat("#.00"); 
System.out.println(df.format(amount));

System.out.println(new BigDecimal(Double.toString(amount)).setScale(2));
System.out.println(new BigDecimal(Double.toString(amount)).setScale(2).doubleValue());
System.out.println(new BigDecimal(df.format(amount)).setScale(2));
System.out.println(Double.parseDouble(df.format(801.00)));
System.out.println(Double.valueOf(df.format(801.0)));
}



}