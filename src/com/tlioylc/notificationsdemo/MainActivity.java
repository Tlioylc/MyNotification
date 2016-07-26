package com.tlioylc.notificationsdemo;




import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.Toast;
import android.widget.RemoteViews.RemoteView;


public class MainActivity extends Activity {
	private NotificationCompat.Builder mBuilder;
	private int notifyId = 100;
	private NotificationManager mNotificationManager ;
	public boolean isPlay = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void Notification(View v){
    	switch(v.getId()){
    	case R.id.show_notification:
    			show_notification();
    		break;
    	case R.id.show_notification_with_button:
    			show_notification_with_button();
    		break;
    	case R.id.show_notification_with_diy:
    			show_notification_with_diy();
    		break;
    	case R.id.show_notification_with_progress:
    			show_notification_with_progress();
    		break;
    	default:
    			Toast.makeText(getApplicationContext(), "what the hell！", Toast.LENGTH_SHORT).show();
    	}
    }
    
    public void show_notification(){
    	mBuilder =  new NotificationCompat.Builder(this);  
    	mBuilder.setContentTitle("hel")
    			.setContentIntent(PendingIntent.getActivity(this, 1, new Intent(), Notification.FLAG_AUTO_CANCEL))
    			.setWhen(System.currentTimeMillis())
    			.setPriority(Notification.PRIORITY_DEFAULT)
    			.setOngoing(false)
    			.setDefaults(Notification.DEFAULT_VIBRATE)
    			.setSmallIcon(R.drawable.ic_launcher)
    			.setContentText("balabalabala...")
    			.setTicker("gogogo");
    	mNotificationManager.notify(notifyId, mBuilder.build()); 
    }
    
    public void show_notification_with_button(){
    	mBuilder =  new NotificationCompat.Builder(this);
    	RemoteViews remoteView = new RemoteViews(getPackageName(), R.layout.view_custom_button);
    	remoteView.setImageViewResource(R.id.custom_song_icon,R.drawable.sing_icon);
    	
    	remoteView.setTextViewText(R.id.tv_custom_song_singer, "JAY");
    	remoteView.setTextViewText(R.id.tv_custom_song_name, "Self");
			remoteView.setViewVisibility(R.id.ll_custom_button, View.VISIBLE);
			//
			if(isPlay){
				remoteView.setImageViewResource(R.id.btn_custom_play, R.drawable.btn_pause);
			}else{
				remoteView.setImageViewResource(R.id.btn_custom_play, R.drawable.btn_play);
			}
			

			mBuilder.setContent(remoteView)
					.setContentIntent(PendingIntent.getActivity(this, 1, new Intent(), Notification.FLAG_AUTO_CANCEL))
					.setWhen(System.currentTimeMillis())
					.setTicker("listening")
					.setPriority(Notification.PRIORITY_DEFAULT)
					.setOngoing(true)
					.setSmallIcon(R.drawable.sing_icon);
			Notification notify = mBuilder.build();
			notify.flags = Notification.FLAG_ONGOING_EVENT;
			
			mNotificationManager.notify(200, notify);
    }
    
    public void show_notification_with_diy(){
    	 mBuilder = new NotificationCompat.Builder(this);
    	 RemoteViews remoteView = new RemoteViews(getPackageName(), R.layout.view_custom);
    	 remoteView.setImageViewResource(R.id.custom_icon, R.drawable.sing_icon);
    	 
    	 remoteView.setTextViewText(R.id.tv_custom_title, "yoyoyoyo");
    	 remoteView.setTextViewText(R.id.tv_custom_time, "yooooooooooooooooo~");
    	 remoteView.setTextViewText(R.id.tv_custom_content, "hahahhhah");
    	 
    	 mBuilder.setContent(remoteView)
    	 		 .setTicker("66666666")
    	 		 .setContentIntent(PendingIntent.getActivity(this, 1, new Intent(), Notification.FLAG_AUTO_CANCEL))
    	 		 .setWhen(System.currentTimeMillis())
    	 		.setPriority(Notification.PRIORITY_DEFAULT)
				.setOngoing(true)
				.setSmallIcon(R.drawable.sing_icon);
    	 Notification notify = mBuilder.build();
			notify.flags = Notification.FLAG_ONGOING_EVENT;
			
			mNotificationManager.notify(200, notify);
    }
    
    public void show_notification_with_progress(){
    	mBuilder = new NotificationCompat.Builder(this);
   	 RemoteViews remoteView = new RemoteViews(getPackageName(), R.layout.view_custom);
   	 remoteView.setImageViewResource(R.id.custom_icon, R.drawable.sing_icon);
   	 
   	 remoteView.setTextViewText(R.id.tv_custom_title, "yoyoyoyo");
   	 remoteView.setTextViewText(R.id.tv_custom_time, "yooooooooooooooooo~");
   	 remoteView.setTextViewText(R.id.tv_custom_content, "hahahhhah");
   	 
//   	 mBuilder.setContent(remoteView)
   	 mBuilder.setContentText("balabalabala...")
   	 		 .setContentTitle("hel")
   	 		 .setTicker("66666666")
   	 		 .setContentIntent(PendingIntent.getActivity(this, 1, new Intent(), Notification.FLAG_AUTO_CANCEL))
   	 		 .setWhen(System.currentTimeMillis())
   	 		 .setPriority(Notification.PRIORITY_DEFAULT)
   	 		 .setProgress(100, 60,false)
		     .setOngoing(true)
			 .setSmallIcon(R.drawable.sing_icon);
   	 Notification notify = mBuilder.build();
			notify.flags = Notification.FLAG_ONGOING_EVENT;
			
			mNotificationManager.notify(200, notify);
    	
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
