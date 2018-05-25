package UserUi;

import java.util.Timer ;
import java.util.TimerTask ;



public class timeA {
	public static int count ;
	public void abc(){
		System.out.println("timeA1");
	}
	
timeA() {
		System.out.println("timeA");
		count = 0 ;
		final Timer m_timer = new Timer() ;
		TimerTask  m_task = new TimerTask(){
		
			public void run(){
				Manual_download md = new Manual_download();
				System.out.println("timeA에서 컨넥트 실행");
			}
		};
		m_timer.schedule(m_task,2000,2000) ;
		
	}
}