/*
 * @author Forrest Miller and Zachary Owen
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

/*
 * The PaintFrame class extends JFrame and is our main file. It creates the UI
 * and handles the events.
 */
public class Paint extends javax.swing.JFrame
{
    public Paint()
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents()
    {
        //Create components
        ShapeButtonGroup = new javax.swing.ButtonGroup();
        FColorButtonGroup = new javax.swing.ButtonGroup();
        BColorButtonGroup = new javax.swing.ButtonGroup();
        final DrawPanel DrawingPanel = new DrawPanel();
        MenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        DeleteMenuItem = new javax.swing.JMenuItem();
        ClearMenuItem = new javax.swing.JMenuItem();
        ExitMenuItem = new javax.swing.JMenuItem();
        ShapeMenu = new javax.swing.JMenu();
        LineMenuItem = new javax.swing.JRadioButtonMenuItem();
        RectangleMenuItem = new javax.swing.JRadioButtonMenuItem();
        FRectangleMenuItem = new javax.swing.JRadioButtonMenuItem();
        EllipseMenuItem = new javax.swing.JRadioButtonMenuItem();
        FEllipseMenuItem = new javax.swing.JRadioButtonMenuItem();
        FColorMenu = new javax.swing.JMenu();
        FRedMenuItem = new javax.swing.JRadioButtonMenuItem();
        FOrangeMenuItem = new javax.swing.JRadioButtonMenuItem();
        FYellowMenuItem = new javax.swing.JRadioButtonMenuItem();
        FGreenMenuItem = new javax.swing.JRadioButtonMenuItem();
        FBlueMenuItem = new javax.swing.JRadioButtonMenuItem();
        FPurpleMenuItem = new javax.swing.JRadioButtonMenuItem();
        FBlackMenuItem = new javax.swing.JRadioButtonMenuItem();
        FBrownMenuItem = new javax.swing.JRadioButtonMenuItem();
        BColorMenu = new javax.swing.JMenu();
        BRedMenuItem = new javax.swing.JRadioButtonMenuItem();
        BOrangeMenuItem = new javax.swing.JRadioButtonMenuItem();
        BYellowMenuItem = new javax.swing.JRadioButtonMenuItem();
        BGreenMenuItem = new javax.swing.JRadioButtonMenuItem();
        BBlueMenuItem = new javax.swing.JRadioButtonMenuItem();
        BPurpleMenuItem = new javax.swing.JRadioButtonMenuItem();
        BBlackMenuItem = new javax.swing.JRadioButtonMenuItem();
        BBrownMenuItem = new javax.swing.JRadioButtonMenuItem();
        HelpMenu = new javax.swing.JMenu();
        HelpMenuItem = new javax.swing.JMenuItem();
        AboutMenuItem = new javax.swing.JMenuItem();

        //set the default close op and add key listener
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter()
	    {
		    public void keyPressed(java.awt.event.KeyEvent evt)
		    {
		        formKeyPressed(evt);
		    }
	    });

        //create group layouts
        javax.swing.GroupLayout DrawingPanelLayout = new javax.swing.GroupLayout(DrawingPanel);
        DrawingPanel.setLayout(DrawingPanelLayout);
        DrawingPanelLayout.setHorizontalGroup(
					      DrawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					      .addGap(0, 400, Short.MAX_VALUE)
					      );
        DrawingPanelLayout.setVerticalGroup(
					    DrawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					    .addGap(0, 279, Short.MAX_VALUE)
					    );

        FileMenu.setText("File"); //File menu header

        DeleteMenuItem.setText("Delete Topmost Shape");
	    DeleteMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
		    public void actionPerformed(java.awt.event.ActionEvent evt)
            {
		        DeleteMenuItemActionPerformed(evt);
		    }
	    });
        FileMenu.add(DeleteMenuItem); //Created and added Delete to File menu

        ClearMenuItem.setText("Clear Screen");
        ClearMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
    		public void actionPerformed(java.awt.event.ActionEvent evt)
            {
    		    ClearMenuItemActionPerformed(evt);
    		}
	    });
        FileMenu.add(ClearMenuItem); //Created and added Clear to File menu

        ExitMenuItem.setText("Exit Paint");
        ExitMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
		    public void actionPerformed(java.awt.event.ActionEvent evt)
            {
		        ExitMenuItemActionPerformed(evt);
		    }
	    });
        FileMenu.add(ExitMenuItem); //Created and added Exit to File menu

        MenuBar.add(FileMenu); //Added File menu to main menu bar

        ShapeMenu.setText("Shape"); //Shape menu header

        ShapeButtonGroup.add(LineMenuItem);
        LineMenuItem.setSelected(true);
        LineMenuItem.setText("Line");
        LineMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
    		public void actionPerformed(java.awt.event.ActionEvent evt)
            {
    		    LineMenuItemActionPerformed(evt);
    		}
	    });
        ShapeMenu.add(LineMenuItem); //Created and added Line to Shape menu

        ShapeButtonGroup.add(RectangleMenuItem);
        RectangleMenuItem.setText("Rectangle");
        RectangleMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
    		public void actionPerformed(java.awt.event.ActionEvent evt)
            {
    		    RectangleMenuItemActionPerformed(evt);
    		}
	    });
        ShapeMenu.add(RectangleMenuItem); //Created and added Rectangle to Shape menu

        ShapeButtonGroup.add(FRectangleMenuItem);
        FRectangleMenuItem.setText("Filled Rectangle");
        FRectangleMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
		    public void actionPerformed(java.awt.event.ActionEvent evt)
            {
		        FRectangleMenuItemActionPerformed(evt);
		    }
	    });
        ShapeMenu.add(FRectangleMenuItem); //Created and added Filled Rectangle to Shape menu

        ShapeButtonGroup.add(EllipseMenuItem);
        EllipseMenuItem.setText("Ellipse");
        EllipseMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
		    public void actionPerformed(java.awt.event.ActionEvent evt)
            {
		        EllipseMenuItemActionPerformed(evt);
		    }
	    });
        ShapeMenu.add(EllipseMenuItem); //Created and added Ellipse to Shape menu

        ShapeButtonGroup.add(FEllipseMenuItem);
        FEllipseMenuItem.setText("Filled Ellipse");
        FEllipseMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
     		public void actionPerformed(java.awt.event.ActionEvent evt)
            {
	    	    FEllipseMenuItemActionPerformed(evt);
    		}
	    });
        ShapeMenu.add(FEllipseMenuItem); //Created and added Filled Ellipse to Shape menu

        MenuBar.add(ShapeMenu); //Added Shape menu to main menu bar

        FColorMenu.setText("Foreground Color"); //Foreground Color menu header

        FColorButtonGroup.add(FRedMenuItem);
        FRedMenuItem.setSelected(true);
        FRedMenuItem.setText("Red");
        FRedMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
    		public void actionPerformed(java.awt.event.ActionEvent evt)
            {
    		    FRedMenuItemActionPerformed(evt);
    		}
	    });
        FColorMenu.add(FRedMenuItem); //Created and added Red to Foreground menu

        FColorButtonGroup.add(FOrangeMenuItem);
        FOrangeMenuItem.setText("Orange");
        FOrangeMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
    		public void actionPerformed(java.awt.event.ActionEvent evt)
            {
    		    FOrangeMenuItemActionPerformed(evt);
    		}
	    });
        FColorMenu.add(FOrangeMenuItem); //Created and added Orange to Foreground menu

        FColorButtonGroup.add(FYellowMenuItem);
        FYellowMenuItem.setText("Yellow");
        FYellowMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
    		public void actionPerformed(java.awt.event.ActionEvent evt)
            {
    		    FYellowMenuItemActionPerformed(evt);
    		}
	    });
        FColorMenu.add(FYellowMenuItem); //Created and added Yellow to Foreground menu

        FColorButtonGroup.add(FGreenMenuItem);
        FGreenMenuItem.setText("Green");
        FGreenMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
    		public void actionPerformed(java.awt.event.ActionEvent evt)
            {
    		    FGreenMenuItemActionPerformed(evt);
    		}
	    });
        FColorMenu.add(FGreenMenuItem); //Created and added Green to Foreground menu

        FColorButtonGroup.add(FBlueMenuItem);
        FBlueMenuItem.setText("Blue");
        FBlueMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
    		public void actionPerformed(java.awt.event.ActionEvent evt)
            {
    		    FBlueMenuItemActionPerformed(evt);
    		}
	    });
        FColorMenu.add(FBlueMenuItem); //Created and added Blue to Foreground menu

        FColorButtonGroup.add(FPurpleMenuItem);
        FPurpleMenuItem.setText("Purple");
        FPurpleMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
    		public void actionPerformed(java.awt.event.ActionEvent evt)
            {
    		    FPurpleMenuItemActionPerformed(evt);
    		}
	    });
        FColorMenu.add(FPurpleMenuItem); //Created and added Purple to Foreground menu

        FColorButtonGroup.add(FBlackMenuItem);
        FBlackMenuItem.setText("Black");
        FBlackMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
    		public void actionPerformed(java.awt.event.ActionEvent evt)
            {
    		    FBlackMenuItemActionPerformed(evt);
    		}
	    });
        FColorMenu.add(FBlackMenuItem); //Created and added Black to Foreground menu

        FColorButtonGroup.add(FBrownMenuItem);
        FBrownMenuItem.setText("Brown");
        FBrownMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
    		public void actionPerformed(java.awt.event.ActionEvent evt)
            {
    		    FBrownMenuItemActionPerformed(evt);
    		}
	    });
        FColorMenu.add(FBrownMenuItem); //Created and added Brown to Foreground menu

        MenuBar.add(FColorMenu); //Added Foreground Color menu to main menu bar

        BColorMenu.setText("Background Color"); //Background Color menu header

        BColorButtonGroup.add(BRedMenuItem);
        BRedMenuItem.setSelected(true);
        BRedMenuItem.setText("Red");
        BRedMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
    		public void actionPerformed(java.awt.event.ActionEvent evt)
            {
    		    BRedMenuItemActionPerformed(evt);
    		}
	    });
        BColorMenu.add(BRedMenuItem); //Created and added Red to Background menu

        BColorButtonGroup.add(BOrangeMenuItem);
        BOrangeMenuItem.setText("Orange");
        BOrangeMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
    		public void actionPerformed(java.awt.event.ActionEvent evt)
            {
    		    BOrangeMenuItemActionPerformed(evt);
    		}
	    });
        BColorMenu.add(BOrangeMenuItem); //Created and added Orange to Background menu

        BColorButtonGroup.add(BYellowMenuItem);
        BYellowMenuItem.setText("Yellow");
        BYellowMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
    		public void actionPerformed(java.awt.event.ActionEvent evt)
            {
    		    BYellowMenuItemActionPerformed(evt);
    		}
	    });
        BColorMenu.add(BYellowMenuItem); //Created and added Yellow to Background menu

        BColorButtonGroup.add(BGreenMenuItem);
        BGreenMenuItem.setText("Green");
        BGreenMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
    		public void actionPerformed(java.awt.event.ActionEvent evt)
            {
    		    BGreenMenuItemActionPerformed(evt);
    		}
	    });
        BColorMenu.add(BGreenMenuItem); //Created and added Green to Background menu

        BColorButtonGroup.add(BBlueMenuItem);
        BBlueMenuItem.setText("Blue");
        BBlueMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
    		public void actionPerformed(java.awt.event.ActionEvent evt)
            {
    		    BBlueMenuItemActionPerformed(evt);
    		}
	    });
        BColorMenu.add(BBlueMenuItem); //Created and added Blue to Background menu

        BColorButtonGroup.add(BPurpleMenuItem);
        BPurpleMenuItem.setText("Purple");
        BPurpleMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
    		public void actionPerformed(java.awt.event.ActionEvent evt)
            {
    		    BPurpleMenuItemActionPerformed(evt);
    		}
	    });
        BColorMenu.add(BPurpleMenuItem); //Created and added Purple to Background menu

        BColorButtonGroup.add(BBlackMenuItem);
        BBlackMenuItem.setText("Black");
        BBlackMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
    		public void actionPerformed(java.awt.event.ActionEvent evt)
            {
    		    BBlackMenuItemActionPerformed(evt);
    		}
	    });
        BColorMenu.add(BBlackMenuItem); //Created and added Black to Background menu

        BColorButtonGroup.add(BBrownMenuItem);
        BBrownMenuItem.setText("Brown");
        BBrownMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
    		public void actionPerformed(java.awt.event.ActionEvent evt)
            {
    		    BBrownMenuItemActionPerformed(evt);   
    		}
	    });
        BColorMenu.add(BBrownMenuItem); //Created and added Brown to Background menu

        MenuBar.add(BColorMenu); //Added Background Color menu to main menu bar

        HelpMenu.setText("Help"); //Help menu header

        HelpMenuItem.setText("Help");
        HelpMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
    		public void actionPerformed(java.awt.event.ActionEvent evt)
            {
    		    HelpMenuItemActionPerformed(evt);
    		}
	    });
        HelpMenu.add(HelpMenuItem); //Created and added Help to Help menu

        AboutMenuItem.setText("About");
        AboutMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
		    public void actionPerformed(java.awt.event.ActionEvent evt)
            {
		        AboutMenuItemActionPerformed(evt);
		    }
	    });
        HelpMenu.add(AboutMenuItem); //Created and added About to Help menu

        MenuBar.add(HelpMenu); //Added Help menu to main menu bar

        setJMenuBar(MenuBar); //set the menu bar

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
				  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				  .addComponent(DrawingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				  );
        layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(DrawingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);

        pack(); //package the view
    }

    /*
    * Below are the action events for all the menu items.
    */
    private void DeleteMenuItemActionPerformed( java.awt.event.ActionEvent evt)
    {
	    DrawPanel.ExterminateTop(); //Delete topmost shape
	    repaint();
    }

    private void ClearMenuItemActionPerformed(java.awt.event.ActionEvent evt)
    {
	    DrawPanel.ClearShapes(); //Clear all shapes
	    repaint();
    }

    private void ExitMenuItemActionPerformed(java.awt.event.ActionEvent evt)
    {
        System.exit(0); //Exit program
    }

    private void LineMenuItemActionPerformed(java.awt.event.ActionEvent evt)
    {
    	char set = 'l';
    	DrawPanel.setShape( set ); //Set the shape char to 'l'
    }

    private void RectangleMenuItemActionPerformed(java.awt.event.ActionEvent evt)
    {
    	char set = 'r';
        DrawPanel.setShape( set ); //Set the shape char to 'r'
    }

    private void FRectangleMenuItemActionPerformed(java.awt.event.ActionEvent evt)
    {
    	char set = 'R';
        DrawPanel.setShape( set ); //Set the shape char to 'R'
    }

    private void EllipseMenuItemActionPerformed(java.awt.event.ActionEvent evt)
    {
    	char set = 'e';
    	DrawPanel.setShape( set); //Set the shape char to 'e'
    }

    private void FEllipseMenuItemActionPerformed(java.awt.event.ActionEvent evt)
    {
    	char set = 'E';
    	DrawPanel.setShape( set ); //Set the shape char to 'E'
    }

    private void FRedMenuItemActionPerformed(java.awt.event.ActionEvent evt)
    {
    	DrawPanel.setFColor( Color.RED ); //Set the foreground color to red
    }

    private void FOrangeMenuItemActionPerformed(java.awt.event.ActionEvent evt)
    {
    	DrawPanel.setFColor( Color.ORANGE ); //Set the foreground color to orange
    }

    private void FYellowMenuItemActionPerformed(java.awt.event.ActionEvent evt)
    {
    	DrawPanel.setFColor( Color.YELLOW ); //Set the foreground color to yellow
    }

    private void FGreenMenuItemActionPerformed(java.awt.event.ActionEvent evt)
    {
    	DrawPanel.setFColor( Color.GREEN ); //Set the foreground color to green
    }

    private void FBlueMenuItemActionPerformed(java.awt.event.ActionEvent evt)
    {
    	DrawPanel.setFColor( Color.BLUE ); //Set the foreground color to blue
    }

    private void FPurpleMenuItemActionPerformed(java.awt.event.ActionEvent evt)
    {
    	Color PURPLE = new Color( 102, 0, 204 );
    	DrawPanel.setFColor( PURPLE ); //Set the foreground color to purple
    }

    private void FBlackMenuItemActionPerformed(java.awt.event.ActionEvent evt)
    {
    	DrawPanel.setFColor( Color.black ); //Set the foreground color to black
    }

    private void FBrownMenuItemActionPerformed(java.awt.event.ActionEvent evt)
    {
    	Color BROWN = new Color( 153, 102, 51 );
    	DrawPanel.setFColor( BROWN ); //Set the foreground color to brown
    }

    private void BRedMenuItemActionPerformed(java.awt.event.ActionEvent evt)
    {
    	DrawPanel.setBColor( Color.RED ); //Set the background color to red
    }

    private void BOrangeMenuItemActionPerformed(java.awt.event.ActionEvent evt)
    {
    	DrawPanel.setBColor( Color.ORANGE ); //Set the background color to orange
    }

    private void BYellowMenuItemActionPerformed(java.awt.event.ActionEvent evt)
    {
    	DrawPanel.setBColor( Color.YELLOW ); //Set the background color to yellow
    }

    private void BGreenMenuItemActionPerformed(java.awt.event.ActionEvent evt)
    {
    	DrawPanel.setBColor( Color.GREEN ); //Set the background color to green
    }

    private void BBlueMenuItemActionPerformed(java.awt.event.ActionEvent evt)
    {
    	DrawPanel.setBColor( Color.BLUE ); //Set the background color to blue
    }

    private void BPurpleMenuItemActionPerformed(java.awt.event.ActionEvent evt)
    {
    	Color PURPLE = new Color(102, 0 , 204);
	    DrawPanel.setBColor( PURPLE ); //Set the background color to purple
    }

    private void BBlackMenuItemActionPerformed(java.awt.event.ActionEvent evt)
    {
    	DrawPanel.setBColor( Color.black ); //Set the background color to black
    }

    private void BBrownMenuItemActionPerformed(java.awt.event.ActionEvent evt)
    {
    	Color BROWN = new Color( 153, 102, 51 );
    	DrawPanel.setBColor( BROWN ); //Set the background color to brown
    }

    private void HelpMenuItemActionPerformed(java.awt.event.ActionEvent evt)
    {
        //Display dialog with help message
        JOptionPane.showMessageDialog(null, "To draw a shape left-click and drag on the"
				                      +" screen.\nTo move a shape right-click near the"
				                      +" center of the shape and drag\non the screen. "
				                      +"Use the drop-downs to select shapes,"
				                      +"\nforeground and background colors,"
				                      +" and other commands.", "Help",
                                      JOptionPane.INFORMATION_MESSAGE);
    }

    private void AboutMenuItemActionPerformed(java.awt.event.ActionEvent evt)
    {
        //Display dialog with about message
        JOptionPane.showMessageDialog(null, "About Java Paint:\nAuthors:Forrest Miller and "
                                      +"Zachary Owen\nVersion 2.0 Release 1\nThis "
                                      +"program was created using Java. Version 1.0"
                                      +" started with NetBeans but was quickly\n"
                                      +"scrapped. Forrest wrote the shape classes and"
                                      +" created the GUI. Zach did most of the event\n"
                                      +"handling. Both worked on the move and keyboard"
                                      +" shortcuts.", "About Java Paint",
                                      JOptionPane.INFORMATION_MESSAGE);
    }

    private void formKeyPressed(java.awt.event.KeyEvent evt)
    {
        if(evt.getKeyCode() == 27)
	    {
		    System.exit(0); //Exit program
	    }
        char key = evt.getKeyChar();
        if(key == 'd')
	    {
		    DrawPanel.ExterminateTop(); //Delete top shape
		    repaint();
	    }
        else if(key == 'c')
	    {
		    DrawPanel.ClearShapes(); //Clear all shapes
		    repaint();
	    }
        else if(key == 'q')
	    {
		    System.exit(0); //Exit program
	    }
    }

    public static void main(String args[])
    {
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
    		public void run()
            {
    		    new Paint().setVisible(true);
    		}
	    });
    }

    //Components
    private javax.swing.JMenuItem AboutMenuItem;
    private javax.swing.JRadioButtonMenuItem BBlackMenuItem;
    private javax.swing.JRadioButtonMenuItem BBlueMenuItem;
    private javax.swing.JRadioButtonMenuItem BBrownMenuItem;
    private javax.swing.ButtonGroup BColorButtonGroup;
    private javax.swing.JMenu BColorMenu;
    private javax.swing.JRadioButtonMenuItem BGreenMenuItem;
    private javax.swing.JRadioButtonMenuItem BOrangeMenuItem;
    private javax.swing.JRadioButtonMenuItem BPurpleMenuItem;
    private javax.swing.JRadioButtonMenuItem BRedMenuItem;
    private javax.swing.JRadioButtonMenuItem BYellowMenuItem;
    private javax.swing.JMenuItem ClearMenuItem;
    private javax.swing.JMenuItem DeleteMenuItem;
    private javax.swing.JPanel DrawingPanel;
    private javax.swing.JRadioButtonMenuItem EllipseMenuItem;
    private javax.swing.JMenuItem ExitMenuItem;
    private javax.swing.JRadioButtonMenuItem FBlackMenuItem;
    private javax.swing.JRadioButtonMenuItem FBlueMenuItem;
    private javax.swing.JRadioButtonMenuItem FBrownMenuItem;
    private javax.swing.ButtonGroup FColorButtonGroup;
    private javax.swing.JMenu FColorMenu;
    private javax.swing.JRadioButtonMenuItem FEllipseMenuItem;
    private javax.swing.JRadioButtonMenuItem FGreenMenuItem;
    private javax.swing.JRadioButtonMenuItem FOrangeMenuItem;
    private javax.swing.JRadioButtonMenuItem FPurpleMenuItem;
    private javax.swing.JRadioButtonMenuItem FRectangleMenuItem;
    private javax.swing.JRadioButtonMenuItem FRedMenuItem;
    private javax.swing.JRadioButtonMenuItem FYellowMenuItem;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenu HelpMenu;
    private javax.swing.JMenuItem HelpMenuItem;
    private javax.swing.JRadioButtonMenuItem LineMenuItem;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JRadioButtonMenuItem RectangleMenuItem;
    private javax.swing.ButtonGroup ShapeButtonGroup;
    private javax.swing.JMenu ShapeMenu;
}

/*
* The DrawPanel class extends JPanel and implements MouseListener. This is a
* custom panel class that is where the drawing will happen.
*/
class DrawPanel extends JPanel implements MouseListener
{
    //int variables for the start and end points of shapes
    private int x1 = 0, x2=0, y1=0, y2=0;
    private boolean rightdown, leftdown; //bool for which mouse button is pressed
    private int MoveShape; //an int to hold the index of the shape to be moved

    private static char selectedShape = 'l'; //char for shape the default is line
    public static Color foreground = Color.RED; //foreground color default is red
    public static Color background = Color.RED; //background color default is red
    //array of Shape to hold the shapes drawn
    public static ArrayList<Shape> myShapes = new ArrayList<Shape>();

    // constructor: set up window
    public DrawPanel()
    {
        // detect mouse click events
        addMouseListener( this );
    }
    
    public static void setShape( char mytype )
    {
    	selectedShape = mytype;
    }

    private Shape ShapeChoose()
    {
    	Shape Chosen;
        //switch decides which shape to create
    	switch(selectedShape)
        {
        	case 'l':
        	    Chosen = new Line(x1,y1,x2,y2,foreground);
        	    break;			      
    	    case 'r':
    	        Chosen = new Rectangle(x1,y1,x2,y2,foreground);
    	        break;
        	case 'R':
	            Chosen = new FilledRectangle(x1,y1,x2,y2,foreground,background);
        	    break;
        	case 'e':
	            Chosen = new Ellipse(x1,y1,x2,y2,foreground);
        	    break;
        	case 'E':
	            Chosen = new FilledEllipse(x1,y1,x2,y2,foreground,background);
      	        break;
	        default:
	            Chosen = new Line(x1,y1,x2,y2,foreground); //defaults to line
    	}
    	return Chosen;
    }

    public static void ExterminateTop()
    {
    	if(myShapes.size() > 0)
	    {
	    	myShapes.remove( myShapes.size()-1 ); //delete topmost shape
	    }
    }

    public static void ClearShapes()
    {
    	myShapes.clear(); //clear all shapes
    }
    public static void setFColor( Color Mycolor )
    {
	    foreground = Mycolor; //set foreground color
    }
    public static void setBColor( Color Mycolor )
    {
	    background = Mycolor; //set background color
    }

    private double distance(int x1, int y1, int x2, int y2)
    {
        //calculate distance between two points
    	return Math.sqrt( Math.pow(x2-x1,2) + Math.pow(y2-y1,2) );
    }

    // must override the following MouseListener methods
    public void mouseClicked( MouseEvent event ) { }
    public void mouseEntered( MouseEvent event ) { }
    public void mouseExited( MouseEvent event ) { }

    // mouse button press events (start drawing)
    public void mousePressed( MouseEvent evt )
    {
        // check for left mouse button press
	    if(SwingUtilities.isLeftMouseButton(evt) ) 
	    {
	    	x1 = evt.getX();
		    y1 = evt.getY();
		    leftdown = true;
	    }
        else if ( SwingUtilities.isRightMouseButton(evt))
	    {
            //right mouse button press
	    	rightdown = true;
		    x1 = evt.getX();
		    y1 = evt.getY();

		    if( !myShapes.isEmpty() )
		    {
		    	int index = 0;
		    	double min,temp;
		    	min = distance( x1, y1, myShapes.get(0).Get_Centroidx(), myShapes.get(0).Get_Centroidy() );

			    for(int i = 1; i < myShapes.size(); i++)
			    {
			    	temp = distance( x1, y1, myShapes.get(i).Get_Centroidx(), myShapes.get(i).Get_Centroidy() );
				    if ( temp < min )
				    {
					    min = temp;
					    index = i;
				    }
			    }

	    		if( Math.abs(min) > 100 )
			    {			       
		    		rightdown = false;
		    		return;
			    }
		    	else
			    {
		    		MoveShape = index;
			    }	
		    }
	    }
    }

    // mouse button release events (finish drawing)
    public void mouseReleased( MouseEvent evt )
    {
        if(leftdown ) 
	    {
	    	x2 = evt.getX();
		    y2 = evt.getY();
		
		    Shape newShape = ShapeChoose();
		
		    myShapes.add(newShape);
	    	leftdown = false; //left mouse button released
	    }
        else if ( rightdown )
	    {
		    Shape temp;
		    x2 = evt.getX();
		    y2 = evt.getY();
		    temp = myShapes.get(MoveShape);

		    temp.Move( (x1-x2)*-1, (y1 -y2)*-1 );

		    myShapes.remove(MoveShape);
		    myShapes.add(temp);
		    MoveShape = -1;
		    rightdown = false; //right mouse button released
	    }
        repaint();
    }

    // paintComponent() is the display callback function
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g ); //call superclass's paint method
        for(Shape shape : myShapes)
	    {
	    	shape.Draw(g); //call seperate classes Draw method
	    }
    }
}
