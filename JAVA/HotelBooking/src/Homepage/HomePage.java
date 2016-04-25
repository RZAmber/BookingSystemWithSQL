package Homepage;
import java.awt.*;
import javax.swing.*;

public class HomePage extends JFrame{
private String[] hotel_info= new String[]{"Contact information","Tel: (201)586-9124","Email: hello_world_hotle@gmail.com"};
private int mapX=250;
private int mapY=250;

public HomePage(){
	//Whole windows
	super("HOTEL BOOKING SYSTEM");
	Container c=getContentPane();
	c.setLayout(new BorderLayout());
	ImageIcon bg=new ImageIcon("building.jpg");
	JLabel l=new JLabel(bg);
	l.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
	getLayeredPane().add(l,new Integer(Integer.MIN_VALUE));
	((JPanel) c).setOpaque(false);
	
	
	//Title panel
	JPanel p1=new JPanel();
	p1.setOpaque(false);
	JLabel label1=new JLabel("WELCOME TO HELLO WORLD HOTEL !");
	label1.setForeground(Color.WHITE);
	label1.setFont(new Font("Zapfino", Font.BOLD,26));
	p1.add(label1);
	c.add(BorderLayout.NORTH,p1);
	
	
	
	//user Operation panel
	JPanel p2=new JPanel();
	p2.setOpaque(false);
	p2.setLayout(new FlowLayout(FlowLayout.CENTER,20,45));
	// after user setting the date the font color turn black
	JTextField f1=new JTextField("Please choose Location",15);
	f1.setForeground(Color.LIGHT_GRAY);
	JTextField f2=new JTextField("Check in date",15);
	f2.setForeground(Color.LIGHT_GRAY);
	JTextField f3=new JTextField("Check out date",15);
	f3.setForeground(Color.LIGHT_GRAY);
	JComboBox s1=new JComboBox();
	JComboBox s2=new JComboBox();
	JComboBox s3=new JComboBox();
	JButton b1=new JButton("OK");
	p2.add(f1);
	p2.add(s1);
	p2.add(f2);
	p2.add(s2);
	p2.add(f3);
	p2.add(s3);
	p2.add(b1);
	c.add(BorderLayout.CENTER,p2);
	
	//information panel
	JPanel p3=new JPanel();
	p3.setOpaque(false);
	p3.setLayout(new FlowLayout());
	
/*	map:
	JPanel subp1 = new JPanel(); 
	subp1.setOpaque(false);
	ImageIcon map =new ImageIcon("map.png");
	map.setImage(map.getImage().getScaledInstance(mapX,mapY,Image.SCALE_DEFAULT));
	JLabel mapl=new JLabel(map);
	JScrollPane maps=new JScrollPane(mapl);
	subp1.add(maps);
*/	
	
// hotel contact information panel
	JPanel subp2=new JPanel();
	subp2.setOpaque(false);
	subp2.setLayout(new GridLayout(3,1,20,10));
	for(int i=0; i<hotel_info.length;i++){
	JLabel l2=new JLabel(hotel_info[i]);
	l2.setForeground(Color.WHITE);
	l2.setFont(new Font("Noteworthy", Font.ITALIC,18));
	l2.setHorizontalAlignment(JLabel.CENTER);
	subp2.add(l2);
	}
	


	p3.add(subp2);
	c.add(BorderLayout.SOUTH,p3);
	setSize(1000,600);
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
}	
	

	public static void main(String[] args) {
		new HomePage();
		
	}

}
