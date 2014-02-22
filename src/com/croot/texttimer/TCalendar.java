package com.croot.texttimer;

import java.text.SimpleDateFormat;

public class TCalendar {
	private static SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMdd");
    private String dayInfo[][];
    private int dayCount;//间隔天数

    
    
    public  void initDayInfo(String start,String end)
    {
    	//初始化日期信息
    	java.util.Calendar cal1=java.util.Calendar.getInstance();
    	java.util.Calendar cal2=java.util.Calendar.getInstance();
    	java.util.Calendar cal3=java.util.Calendar.getInstance();
    	int year,month,day;
    	int i=0;
    	year=Integer.parseInt(start.substring(0,4));
    	month=Integer.parseInt(start.substring(4,6));
    	day=Integer.parseInt(start.substring(6,8));
    	cal1.set(year, month-1, day);
    	cal3.set(year, month-1, day);
    	year=Integer.parseInt(end.substring(0,4));
    	month=Integer.parseInt(end.substring(4,6));
    	day=Integer.parseInt(end.substring(6,8));
    	cal2.set(year, month-1, day);
    	while(!cal2.before(cal3))
    	{	
    		i++;
    		cal3.add(java.util.Calendar.DAY_OF_MONTH, 1);//日期时间+1
    	}
    	//每日数据列表
    	dayInfo=new String[i+1][3];
    	i=0;
    	while(!cal2.before(cal1))
    	{	
                System.out.println("==" + cal1.getTime());
    		dayInfo[i][0]=sDateFormat.format(cal1.getTime());
    		i++;
    		cal1.add(java.util.Calendar.DAY_OF_MONTH, 1);
    	}
    	
    	this.dayCount=i;
    	for (int j=0;j<i;j++)
    	{
    		this.dayInfo[j][1]="0";
    		this.dayInfo[j][2]="0";
    	}
    	
    }
    public int getDayCount() {
        return dayCount;
    }

    public void setDayCount(int dayCount) {
        this.dayCount = dayCount;
    }

    public String[][] getDayInfo() {
        return dayInfo;
    }

    public void setDayInfo(String[][] dayInfo) {
        this.dayInfo = dayInfo;
    }
}
