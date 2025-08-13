import javax.swing.*;
import java.awt.event.*;
import MarvellousPackerUnpacker.MarvellousPackerExperiment;
// import java.awt.FlowLayout; //Incase FlowLayout used

class PackerGUIActionListenerPacking
{
    public static void main(String A[])
    {
        JFrame fobj = new JFrame("Packer");

        JLabel lobj1 = new JLabel("Name of Directory");
        JTextField tobj1 = new JTextField();

        JLabel lobj2 = new JLabel("Name of Packed File");
        JTextField tobj2 = new JTextField();

        JButton bobj = new JButton("Pack");

        fobj.add(lobj1);
        fobj.add(lobj2);
        fobj.add(tobj1);
        fobj.add(tobj2);
        fobj.add(bobj);

        fobj.setVisible(true);
        fobj.setSize(400,400);
        fobj.setLayout(null);

        lobj1.setBounds(15,20,120,20);
        tobj1.setBounds(150,20,120,20);

        lobj2.setBounds(15,45,120,20);
        tobj2.setBounds(150,45,120,20);

        bobj.setBounds(150,80,80,20);

        bobj.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent aobj)
            {
                String pack = null, dir = null;
                int Result = 0;

                pack = tobj2.getText();
                dir = tobj1.getText();

                MarvellousPackerExperiment mobj = new MarvellousPackerExperiment(pack, dir);
                Result = mobj.PackingActivity();

                if(Result == 1)
                {
                    JOptionPane.showMessageDialog(fobj, "Packing Activity Done...");
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