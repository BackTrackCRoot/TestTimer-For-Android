package com.croot.texttimer;


import java.text.SimpleDateFormat;
import java.util.*;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

public class ExampleAppWidgetProvider extends AppWidgetProvider{
	 public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
	        final int N = appWidgetIds.length;
	 
	        // Perform this loop procedure for each App Widget that belongs to this provider
	        for (int i=0; i<N; i++) {
	            int appWidgetId = appWidgetIds[i];
	            
	            TCalendar tCalendar = new TCalendar();
	            SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd"); 
	            Date d=new Date();
	            tCalendar.initDayInfo(df.format(d),"20140606");
	            String TextTimer = "距离高考还有"+String.valueOf(tCalendar.getDayCount())+"天";
	            
	            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.example_appwidget);
	            views.setTextViewText(R.id.textView1, TextTimer);
	         // Tell the AppWidgetManager to perform an update on the current app widget
	            appWidgetManager.updateAppWidget(appWidgetId, views);
	        }
	 }
}
