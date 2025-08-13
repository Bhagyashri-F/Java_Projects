import javax.swing.*;
import java.awt.event.*;
import MarvellousPackerUnpacker.MarvellousUnpackerExperiment;
// import java.awt.FlowLayout; //Incase FlowLayout used

class UnpackerGUIActionListenerUnpacking
{
    public static void main(String A[])
    {
        JFrame fobj = new JFrame("Packer");

        JLabel lobj1 = new JLabel("Name of Packed File");
        JTextField tobj1 = new JTextField();

        JButton bobj = new JButton("Unpack");

        fobj.add(lobj1);
        fobj.add(tobj1);
        fobj.add(bobj);

        fobj.setVisible(true);
        fobj.setSize(400,400);
        fobj.setLayout(null);

        lobj1.setBounds(15,20,120,20);
        tobj1.setBounds(150,20,120,20);

        bobj.setBounds(150,45,80,20);

        bobj.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent aobj)
            {
                String pack = null, dir = null;
                int Result = 0;

                pack = tobj1.getText();

                MarvellousUnpackerExperiment mobj = new MarvellousUnpackerExperiment(pack);
                Result = mobj.UnpackingActivity();

                if(Result == 1)
                {
                    JOptionPane.showMessageDialog(fobj, "Unpacking Activity Done...");
                }
                else
                {
                    JOptionPane.showMessageDialog(fobj, "Something is Wrong");
                }
            }
        }
        );


        fobj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}