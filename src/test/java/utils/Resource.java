package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Resource {

    public static int cashbackAmountAbove100=129;
    public static int cashbackAmountBelow100=42;
    public static int nonCashbackAmount=50;

    public static String[] prepaidMsisdnHavingLoan={"01409900062","P9900062","PREPAID+LOAN_DUE"};
    public static String[] prepaidMsisdnHavingNoLoan={"01409900160","P9900160","PREPAID+NO+LOAN"};
    public static String[] prepaidMsisdnHavingLowBalance={"01409900110","P9900110","PREPAID_LOW_BALANCE"};//Balance Less than 10 TK
    public static String[] prepaidMsisdnHavingHighBalance={"01409900062","P9900062","PREPAID_HIGH_BALANCE"};
    public static String[] postpaidMsisdnHavingEnoughCreditLimit={"",""};


    public static String number110 = "01409900110";
    public static String password110 = "P9900110";
    public static String number290 = "01409900290";
    public static String pass290 = "P9900290";
    public static String number062 = "01409900062";
    public static String pass062 = "P9900062";
    public static String number371 = "01940162371";
    public static String number372 = "01913594372";
    public static String pass372 = "saif1234";
    public static String num346 = "01409900346";
    public static String pass346 = "P9900346";

    public static String allureReportDestination = System.getProperty("user.dir") + "/allure_report/";
    public static String resultFolderPath = System.getProperty("user.dir") + "/extent_report/";
    public static String autVersion = "Version_5_8_1";
    public static String allureReportSource = System.getProperty("user.dir") + "/allure-results/";

    static DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh-mm-ssaa");
    static Date date = new Date();
    public static String currentDateTime = dateFormat.format(date);
    static DateFormat dateFormatNew = new SimpleDateFormat("dd-MMM-yyyy");
    static Date dateNew = new Date();
    public static String currentDate = dateFormatNew.format(dateNew);
    public static String allureResultPathDes = Resource.allureReportDestination + currentDateTime;
}
