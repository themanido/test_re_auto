package UserUi;


import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel ;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AwtButtonControl {
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;
	
	public AwtButtonControl(){
		prepareGUI();
	}
	
	public static void main(String[] args){
		AwtButtonControl awtControlDemo = new AwtButtonControl();
		awtControlDemo.showButton();
	}
	
	private void prepareGUI(){
		// Frame에 대한 셋팅
		
		int x = 500 ;
		int y = 300 ;
		
		mainFrame = new Frame("Java AWT");
		mainFrame.setSize(x, y);
		mainFrame.setLayout(new GridLayout(3, 1));
		
		mainFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}
		});
		
		// 상단 라벨
		headerLabel = new Label();
		headerLabel.setAlignment(Label.CENTER);
        headerLabel.setText("Control Test : Button");
 
        // 하단 상태값 라벨
        statusLabel = new Label();
        statusLabel.setText("Status Lable");
        statusLabel.setAlignment(Label.CENTER);
        statusLabel.setSize(350, 100);
 
        controlPanel = new Panel();
        controlPanel.setLayout(new FlowLayout());
 
        mainFrame.add(headerLabel);
        mainFrame.add(statusLabel);
        mainFrame.add(controlPanel);
        
        //중앙정렬
        Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		
		System.out.println(screenSize) ;
		mainFrame.setLocation(((screenSize.width/2)-(x/2)), (screenSize.height/2)-(y/2));
		
        mainFrame.setVisible(true);
    }
 
    private void showButton() {
 
        Button btnManual = new Button("수동 수신");
        Button btnAuto = new Button("자동 수신");
        //Button btnCancel = new Button("닫기");
 
        btnManual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("수동 수신중");
                
                //DBConnection conn = new DBConnection() ;
                Manual_download md = new Manual_download();
                System.out.println("수동수신 완료") ;
            }
        });
 
        btnAuto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                statusLabel.setText("자동 수신중");
                timeA ta = new timeA();
        
           	}  
        });
            
		
 
       /* 
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("닫기");
            }
        });
       */

        controlPanel.add(btnManual);
        controlPanel.add(btnAuto);
       // controlPanel.add(btnCancel);
 
        mainFrame.setVisible(true);
 
	}
    
    
}
