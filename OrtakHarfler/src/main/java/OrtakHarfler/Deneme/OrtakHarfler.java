package OrtakHarfler.Deneme;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class OrtakHarfler extends JFrame {

	private JPanel contentPane;
	protected static OrtakHarfler frame;
	protected Robot robot;
	protected JLabel l1,l2,l3;
	protected JTextField t1,t2,t3;
	protected JButton b1;
	protected ArrayList<Character> ilkMetin= new ArrayList<Character>();
	protected ArrayList<Character> ikinciMetin= new ArrayList<Character>();
	protected ArrayList<Character> ortakMetin= new ArrayList<Character>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new OrtakHarfler();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OrtakHarfler() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		l1=new JLabel("İlk metni giriniz");
		l1.setSize(200,20);
		l1.setLocation(100,50);
		contentPane.add(l1);
		
		t1=new JTextField();
		t1.setSize(200,20);
		t1.setLocation(100,70);
		contentPane.add(t1);
		t1.getDocument().addDocumentListener(dl);
		
		l2=new JLabel("İkinci metni giriniz");
		l2.setSize(200,20);
		l2.setLocation(100,100);
		contentPane.add(l2);
		
		t2=new JTextField();
		t2.setSize(200,20);
		t2.setLocation(100,120);
		contentPane.add(t2);
		t2.getDocument().addDocumentListener(dl);
		
		l3=new JLabel("Girdiğiniz ortak karakterler");
		l3.setSize(200,20);
		l3.setLocation(100,150);
		contentPane.add(l3);
		
		t3=new JTextField();
		t3.setSize(200,20);
		t3.setLocation(100,170);
		t3.setFocusable(false);
		contentPane.add(t3);
		
//		b1=new JButton("Sonuç");
//		b1.setSize(75,25);
//		b1.setLocation(100,200);
//		contentPane.add(b1);
//		b1.addActionListener(al);
	}
	
	public void hesapla() 
	{
		if(t1.getText().length()==0 || t2.getText().length()==0) t3.setText("");
		if(t1.getText().length()>0 && t2.getText().length()>0)
		{
			for(int i=0;i<t1.getText().length();i++)
			{
				ilkMetin.add(t1.getText().charAt(i));
			}
			
			for(int i=0;i<t2.getText().length();i++)
			{
				ikinciMetin.add(t2.getText().charAt(i));
			}
			
			int i=0;
			int j=0;
			while(i<ilkMetin.size())
			{
				j=0;
				while(j<ikinciMetin.size())
				{

					if(String.valueOf(ilkMetin.get(i)).equals(String.valueOf(ikinciMetin.get(j))))
					{
						ortakMetin.add(ilkMetin.get(i));
						
						
						
					}
					j++;
					 
					
				}
				i++;
				
			}
			
			t3.setText("");
			Set<Character> set=new LinkedHashSet<Character>(ortakMetin);
			Iterator<Character> it=set.iterator();
			while(it.hasNext())
			{
				t3.setText(t3.getText()+it.next());
			}
			ilkMetin.clear();
			ikinciMetin.clear();
			ortakMetin.clear();
			set.clear();
	
		}
	}
	
	ActionListener al=new ActionListener() 
	{

		public void actionPerformed(ActionEvent e) 
		{
			hesapla();
			
		}
		
	};
	
	DocumentListener dl=new DocumentListener() 
	{

		public void insertUpdate(DocumentEvent e) 
		{
			hesapla();
		}

		public void removeUpdate(DocumentEvent e) 
		{
			hesapla();
		}

		public void changedUpdate(DocumentEvent e) 
		{
			hesapla();
		}
		
	};

}
