
package agenda;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.util.Timer;
import java.util.TimerTask;



/**
 *
 * @author sever
 */
public class MainForm2 extends javax.swing.JFrame {

    public static client_model model = new client_model();

    File f = null;
    FileInputStream fis = null;
    FileOutputStream  fos = null;
    ObjectInputStream ois = null;
    ObjectOutputStream oos = null;

    String[] images = {"image1.JPG","image2.JPG"};
    int imageindex = 0;

    String saveFileName = "";

    Timer timer_publicitate = new Timer();
    Timer timer_autosave = new Timer();

    public static boolean isDataModified = false;
    boolean Registered = false;
    boolean filterActive = false;

    
    public MainForm2() {

        initComponents();

        jTable1.setModel(model);
        regLabel.setCursor(new Cursor(12));
        txtFilter.selectAll();


        if (isRegistered() == 0)
            if (JOptionPane.showConfirmDialog(this, "Application not registered, run SHAREWARE mode ?", "Warning", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.CANCEL_OPTION)
               System.exit(0);
            else
            {
                this.setTitle("Client phonebook : SHAREWARE version");
                showPublicitate();
            }
                
        else{
           this.setTitle("Client Phonebook 2.0 - registered mode");
           regLabel.setText("Registered mode.");
           mnuRegister.setEnabled(false);
           mnuSave.setEnabled(true);
           mnuOpen.setEnabled(true);
           
        }

    }

     private void showPublicitate() {
        TimerTask tt = new TimerTask(){
         ImageIcon i = new ImageIcon();
            public void run() {

             if (Registered == true)
                     return;

             if (imageindex == 0)
                 imageindex = 1;
             else
                 imageindex = 0;
              i = new ImageIcon(".\\pub_images\\"+images[imageindex]);
              regLabel.setIcon(i);
            }
        };

        timer_publicitate.schedule(tt, 10, 1000);
    }


    private void startAutosave(){
        if (isDataModified == true) // se salveaza doar daca s-a modificat ceva
            return;
        if (saveFileName.isEmpty())
            return;

      TimerTask tt = new TimerTask(){
         ImageIcon i = new ImageIcon();
            public void run() {
              if (Registered == false)
                     return;
              SavePhonebook();
              isDataModified = false; // flag ca s-a salvat, nu se mai salveaza nimic pana la o noua modificare.
            }
        };

        timer_autosave.schedule(tt, 10, 50000); // autosalvare la fiecare 5 minute
   }



      @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JFO = new javax.swing.JFileChooser();
        JFS = new javax.swing.JFileChooser();
        jTableMenu = new javax.swing.JPopupMenu();
        mnuPopupDelete = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mnuPopup_Search = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblFilter = new javax.swing.JLabel();
        txtFilter = new javax.swing.JTextField();
        radioFilterNume = new javax.swing.JRadioButton();
        radioFilterPrenume = new javax.swing.JRadioButton();
        btnFilter = new javax.swing.JButton();
        btnClearFilter = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        radioNume = new javax.swing.JRadioButton();
        radioPrenume = new javax.swing.JRadioButton();
        radioCNP = new javax.swing.JRadioButton();
        radioNrtel = new javax.swing.JRadioButton();
        chkReverse = new javax.swing.JCheckBox();
        btnSort = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        regLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuOpen = new javax.swing.JMenuItem();
        mnuSave = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuAdd = new javax.swing.JMenuItem();
        mnuSearch = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuHelp = new javax.swing.JMenu();
        mnuRegister = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuAbout = new javax.swing.JMenuItem();

        JFO.setCurrentDirectory(new java.io.File("C:\\Program Files\\NetBeans 6.9.1"));
        JFO.setDialogTitle("Open database");

        JFS.setCurrentDirectory(new java.io.File("C:\\Program Files\\NetBeans 6.9.1"));

        mnuPopupDelete.setText("Delete");
        mnuPopupDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPopupDeleteActionPerformed(evt);
            }
        });
        jTableMenu.add(mnuPopupDelete);
        jTableMenu.add(jSeparator3);

        mnuPopup_Search.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        mnuPopup_Search.setText("Search...");
        mnuPopup_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPopup_SearchActionPerformed(evt);
            }
        });
        jTableMenu.add(mnuPopup_Search);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client phonebook 2.0 - SHAREWARE MODE");
        setBounds(new java.awt.Rectangle(350, 250, 0, 0));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblFilter.setText("Filter records by :");

        txtFilter.setText("enter filter data");

        buttonGroup2.add(radioFilterNume);
        radioFilterNume.setSelected(true);
        radioFilterNume.setText("Nume");

        buttonGroup2.add(radioFilterPrenume);
        radioFilterPrenume.setText("Prenume");

        btnFilter.setText("Apply filter");
        btnFilter.setToolTipText("Display a subset of records");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        btnClearFilter.setText("Clear filter");
        btnClearFilter.setToolTipText("Cancels active filter");
        btnClearFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFilterActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Sort by :");

        buttonGroup1.add(radioNume);
        radioNume.setText("Nume");

        buttonGroup1.add(radioPrenume);
        radioPrenume.setText("Prenume");

        buttonGroup1.add(radioCNP);
        radioCNP.setText("CNP");

        buttonGroup1.add(radioNrtel);
        radioNrtel.setText("Numar telefon");

        chkReverse.setText("Reverse order");
        chkReverse.setToolTipText("Arranges records in reverse order");

        btnSort.setText("Sort");
        btnSort.setToolTipText("Selects matching record ");
        btnSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortActionPerformed(evt);
            }
        });

        lblStatus.setForeground(java.awt.Color.gray);
        lblStatus.setText("Status : ");

        regLabel.setBackground(java.awt.Color.gray);
        regLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        regLabel.setForeground(java.awt.Color.gray);
        regLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        regLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regLabelMouseClicked(evt);
            }
        });

        jButton1.setText("Exit");
        jButton1.setToolTipText("Quit application");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblFilter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(radioFilterNume)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioFilterPrenume)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(btnFilter)
                        .addGap(18, 18, 18)
                        .addComponent(btnClearFilter))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioNume)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioPrenume)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioCNP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioNrtel))
                            .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(chkReverse)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSort, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(regLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFilter)
                    .addComponent(radioFilterNume)
                    .addComponent(radioFilterPrenume)
                    .addComponent(btnClearFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioNume)
                    .addComponent(radioPrenume)
                    .addComponent(radioCNP)
                    .addComponent(radioNrtel)
                    .addComponent(chkReverse)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSort, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(regLabel)))
        );

        jMenu1.setText("File");

        mnuOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        mnuOpen.setText("Open");
        mnuOpen.setEnabled(false);
        mnuOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuOpenActionPerformed(evt);
            }
        });
        jMenu1.add(mnuOpen);

        mnuSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        mnuSave.setText("Save");
        mnuSave.setEnabled(false);
        mnuSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSaveActionPerformed(evt);
            }
        });
        jMenu1.add(mnuSave);
        jMenu1.add(jSeparator1);

        mnuExit.setText("Exit");
        mnuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExitActionPerformed(evt);
            }
        });
        jMenu1.add(mnuExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Clients");

        mnuAdd.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_INSERT, 0));
        mnuAdd.setText("Add new record ");
        mnuAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAddActionPerformed(evt);
            }
        });
        jMenu2.add(mnuAdd);

        mnuSearch.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        mnuSearch.setText("Search");
        mnuSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSearchActionPerformed(evt);
            }
        });
        jMenu2.add(mnuSearch);

        jMenuItem1.setText("Delete selected record");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        mnuHelp.setText("Help");

        mnuRegister.setText("Register");
        mnuRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegisterActionPerformed(evt);
            }
        });
        mnuHelp.add(mnuRegister);
        mnuHelp.add(jSeparator2);

        mnuAbout.setText("About ...");
        mnuAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAboutActionPerformed(evt);
            }
        });
        mnuHelp.add(mnuAbout);

        jMenuBar1.add(mnuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Client phonebook 2.0 : SHAREWARE version");

        pack();
    }// </editor-fold>//GEN-END:initComponents



    private byte isRegistered(){
         String s = null;
         f = new File ("registered.key");
         if (f.exists() == false)
             return 0;
        
         try {
             fis = new FileInputStream(f);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainForm2.class.getName()).log(Level.SEVERE, "File \"registered.key\" not found !", ex);
            return 0;
        }


        try {
            ois = new ObjectInputStream(fis); // exceptie !
            
        } catch (IOException ex) {
            Logger.getLogger(MainForm2.class.getName()).log(Level.SEVERE, "Can't read \"registered.key\" ! ", ex);
            
        }
        try {
            s = (String) ois.readObject();
            if (s.contains("Registered"))
            {
                Registered = true;
                return 1;
            }
        } catch (IOException ex) {
            Logger.getLogger(MainForm2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainForm2.class.getName()).log(Level.SEVERE, null, ex);
        }


  return -2; // implicit nu se considera activat
  


 }

   public boolean verifyKey(String key){
        Registered = key.matches("[A-Z,a-z][0-9][A-Z,a-z][0-9]"); //A9x5 , a3Q6
        return Registered;
    }

  private void registerApp(){
      if (Registered)
        return;

      String s = JOptionPane.showInputDialog(this,"Enter registration code :", "" );
      if (s == null)
          return;

      if (verifyKey(s)){
          //salvare register-key in fisierul "registered.key"

        mnuSave.setEnabled(true); // activeaza meniurile pentru lucrul cu baza de date, chiar daca , probabil, salvarea cheii va esua, mai jos
        mnuOpen.setEnabled(true);
        mnuRegister.setEnabled(false);

        f = new File("registered.key");

            try {
                fos = new FileOutputStream(f);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainForm2.class.getName()).log(Level.SEVERE, "Can't create handle key file !", ex);
            }

            try {
                oos = new ObjectOutputStream(fos);
                oos.writeObject("Registered with key :"+s);
            } catch (IOException ex) {
                Logger.getLogger(MainForm2.class.getName()).log(Level.SEVERE, "Can't write to key file !", ex);
            }

            mnuOpen.setEnabled(true);
            mnuSave.setEnabled(true);
            regLabel.setIcon(null);
            regLabel.setText("Registered mode.");
            this.setTitle("Client phonebook 2.0 - registered version");
        } 
      else
         {
          JOptionPane.showMessageDialog(this, "Invalid key, continuing SHAREWARE mode.","Register",JOptionPane.OK_OPTION);
          }
    }


    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        

        int idx = jTable1.getSelectedRow();
        if ((idx <= -1) || jTable1.getSelectedRow() >  model.abonati.size())
            return;

        if (evt.getClickCount() == 2) // double-click ! Editare
        {

            if (filterActive){ // nu am implementat operatii cat este activ filtrul
                JOptionPane.showMessageDialog(this, "Can't modify during filter operation.\nClear filter.","Modify",JOptionPane.OK_OPTION);
                return;
            }





            abonat a = (abonat)model.abonati.get(idx);

            addModify frm = new addModify(this, true);
            frm.modifyAt(idx, a); // apeleaza un setter al clasei addModify

            frm.setLocationRelativeTo(this);
            frm.setValues(a);
            frm.setVisible(true);
            
            model.fireTableDataChanged();
            jTable1.setModel(model);
            isDataModified = true;
        }
    }//GEN-LAST:event_jTable1MouseClicked


      public  client_model getInstantModel(){ // sa stim exact ce model este afisat
        return (client_model)jTable1.getModel();
    }


    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        if (evt.isPopupTrigger())
            jTableMenu.show(evt.getComponent(),evt.getX(), evt.getY());
    }//GEN-LAST:event_jTable1MouseReleased

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {

            if (filterActive){ // nu am implementat operatii cat este activ filtrul
                JOptionPane.showMessageDialog(this, "Can't delete during filter operation.\nClear filter.","Delete record",JOptionPane.OK_OPTION);
                return;
             }

            int idx = jTable1.getSelectedRow();
            if (idx <= -1)
                return;
            String aNume, aPrenume;

            client_model m = (client_model)jTable1.getModel(); // pentru citirea modelului INSTANTANEU al tabelului (poate e pus filtru)
            abonat a = (abonat)m.abonati.get(idx);
            
            aNume = a.getNume();
            aPrenume = a.getPrenume();
            int i = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete \n"+aNume + " " + aPrenume+" ?", "Client detele", JOptionPane.OK_CANCEL_OPTION);
            if (i == JOptionPane.OK_OPTION){
                if (jTable1.getSelectedRow() < model.abonati.size()){
                    model.abonati.remove(a); // eliminarea abonatului din lista REALA, nu din cea afisata !!!
                    model.fireTableDataChanged();
                    lblStatus.setText("Success. Phonebook updated");
                    isDataModified = true;
                }
            }



        }
}//GEN-LAST:event_jTable1KeyPressed

    private void mnuOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuOpenActionPerformed
       
        if (JFO.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){

            f = JFO.getSelectedFile();
            try {
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                
                client_model c = (client_model)ois.readObject();
               
                jTable1.setModel(c);
                model = c;
                model.fireTableDataChanged();

               
                ois.close();
                fis.close();
                lblStatus.setText("Phonebook load complete.");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainForm2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MainForm2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}//GEN-LAST:event_mnuOpenActionPerformed


public void SavePhonebook(){
        if (saveFileName.isEmpty()){ // daca numele este gol, inseamna ca nu s-a mai salvat ...
           if (JFS.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
             f = JFS.getSelectedFile();
             saveFileName = f.getAbsolutePath();
            }
            else
                return;
     
        }
            try {
                fos = new FileOutputStream(saveFileName); // se considera ca s-a mai salvat anterior ...
                oos = new ObjectOutputStream(fos);
                oos.writeObject(jTable1.getModel());// java.io.NotSerializableException

                oos.close();
                lblStatus.setText("Phonebook save complete.");
                isDataModified = false;

             } catch (IOException ex) {
                Logger.getLogger(MainForm2.class.getName()).log(Level.SEVERE, "Eroare IO", ex);
               }

}

    private void mnuSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSaveActionPerformed

        SavePhonebook();
        startAutosave();
    
}//GEN-LAST:event_mnuSaveActionPerformed

    private void mnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExitActionPerformed
        int i;
        if (isDataModified){

            i = JOptionPane.showConfirmDialog(this, "Database not saved. \n Save it before closing ?", "Exit application", JOptionPane.YES_NO_CANCEL_OPTION);
            if (i == JOptionPane.CANCEL_OPTION)
                return;
            if (i == JOptionPane.YES_OPTION){
                SavePhonebook();
                System.exit(0);
            }
            if (i == JOptionPane.NO_OPTION)
                System.exit(0);

        }
        i = JOptionPane.showConfirmDialog(this, "Do you want to exit ?", "Exit application", JOptionPane.OK_CANCEL_OPTION);
        if (i == JOptionPane.OK_OPTION)
            System.exit(0);
}//GEN-LAST:event_mnuExitActionPerformed

    private void mnuAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAddActionPerformed

         if (filterActive){ // nu am implementat operatii cat este activ filtrul
                JOptionPane.showMessageDialog(this, "Can't add records during filter operation.\nClear filter.","Add record",JOptionPane.OK_OPTION);
                return;
             }


        addModify frm = new addModify(this, true);
        frm.addRecord(); // trimitere comanda de adaugare inregistrare catre dialog.
        frm.setLocationRelativeTo(this);
        frm.setVisible(true);
}//GEN-LAST:event_mnuAddActionPerformed

    private void mnuSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSearchActionPerformed
        String s = JOptionPane.showInputDialog(this, "Enter string","Search client",JOptionPane.QUESTION_MESSAGE);
        if (s != null){
            int i = 0;
            boolean found = false;
            abonat a = null;
            for (i = 0; i < model.abonati.size(); i++) {
                a = (abonat)model.abonati.get(i);
                if (a.getNume().contains(s)){
                    found = true;
                    break; // iesire din for;
                }
            }

            if (found == true)
                jTable1.setRowSelectionInterval(i, i); // selectare rand gasit;
            else
                JOptionPane.showMessageDialog(this, "Client \""+s+"\" not found.");

        }

    }//GEN-LAST:event_mnuSearchActionPerformed

    private void mnuRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegisterActionPerformed
       registerApp();
}//GEN-LAST:event_mnuRegisterActionPerformed

    private void mnuAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAboutActionPerformed
        JOptionPane.showMessageDialog(this,"Client Phonebook\nConstantin Sever for Infoacademy \nSeptember-October 2010");
}//GEN-LAST:event_mnuAboutActionPerformed

     private Comparator dupaNume = new Comparator() {

        public int compare(Object o1, Object o2) {
           abonat a1 = (abonat) o1;
           abonat a2 = (abonat) o2;
           return a1.getNume().compareToIgnoreCase(a2.getNume());
        }
    };


    private Comparator dupaPrenume = new Comparator() {

        public int compare(Object o1, Object o2) {

           abonat a1 = (abonat) o1;
           abonat a2 = (abonat) o2;
           return a1.getPrenume().compareToIgnoreCase(a2.getPrenume());

        }
    };

   private Comparator dupaCNP = new Comparator() {

        public int compare(Object o1, Object o2) {

           abonat a1 = (abonat) o1;
           abonat a2 = (abonat) o2;
           int retVal = 0;
           if (a1.getCNP() < a2.getCNP())
               retVal = -1;
           if (a1.getCNP() == a2.getCNP())
               retVal = 0;
           if (a1.getCNP() > a2.getCNP())
               retVal = 1;

           return retVal;
        }
    };


   private Comparator dupaNrtel = new Comparator() {

        public int compare(Object o1, Object o2) {

           abonat a1 = (abonat) o1;
           abonat a2 = (abonat) o2;
           int retVal = 0;
           if (a1.getNrtel() < a2.getNrtel())
               retVal = -1;
           if (a1.getNrtel() == a2.getNrtel())
               retVal = 0;
           if (a1.getNrtel() > a2.getNrtel())
               retVal = 1;

           return retVal;
        }
    };




    private void btnSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortActionPerformed
        if (radioNume.isSelected())
            Collections.sort(model.abonati,dupaNume);
        if (radioPrenume.isSelected())
            Collections.sort(model.abonati,dupaPrenume);
        if (radioCNP.isSelected())
            Collections.sort(model.abonati,dupaCNP);
        if (radioNrtel.isSelected())
            Collections.sort(model.abonati,dupaNrtel);

        if (chkReverse.isSelected())
            Collections.reverse(model.abonati);

        model.fireTableDataChanged();
        isDataModified = true;

    }//GEN-LAST:event_btnSortActionPerformed

    private void mnuPopupDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPopupDeleteActionPerformed

         if (filterActive){ // nu am implementat operatii cat este activ filtrul
                JOptionPane.showMessageDialog(this, "Can't delete during filter operation.\nClear filter.","Delete",JOptionPane.OK_OPTION);
                return;
         }




        int idx = jTable1.getSelectedRow();
        if (idx <= -1)
            return;
        String aNume, aPrenume;
        abonat a = (abonat)model.abonati.get(idx);
        aNume = a.getNume();
        aPrenume = a.getPrenume();
        int i = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete \n"+aNume + " " + aPrenume+" ?", "Client detele", JOptionPane.OK_CANCEL_OPTION);
        if (i == JOptionPane.OK_OPTION){
            if (jTable1.getSelectedRow() < model.abonati.size()){
                model.abonati.remove(a);
                model.fireTableDataChanged();
                isDataModified = true;
                lblStatus.setText("Success. Phonebook updated");
            }
        }
}//GEN-LAST:event_mnuPopupDeleteActionPerformed

    private void mnuPopup_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPopup_SearchActionPerformed
        mnuSearchActionPerformed(evt);
    }//GEN-LAST:event_mnuPopup_SearchActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        int i = 0;
        abonat source = null;
        abonat destination  = null;
        String s = txtFilter.getText();
        client_model c = new client_model();
         for (i = 0; i < model.abonati.size(); i++) {
                source = (abonat)model.abonati.get(i);
                if (radioFilterNume.isSelected())
                    if (source.getNume().contains(s))
                     c.abonati.add(source);
                    else; // de la if-ul imediat precedents
                else // se presupune ca este selectat Prenume
                     if (source.getPrenume().contains(s))
                       c.abonati.add(source);
         }
        jTable1.setModel(c); // schimbare PROVIZORIE a modelului afisat !!! modelul real este in variabila "model"
        lblStatus.setText("Filter active ! Clear filter for normal operation !");
        lblStatus.setForeground(Color.red);
        filterActive = true;

    }//GEN-LAST:event_btnFilterActionPerformed

    private void regLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regLabelMouseClicked
        if (Registered == true)
            return;
        registerApp();

    }//GEN-LAST:event_regLabelMouseClicked

    private void btnClearFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFilterActionPerformed
        jTable1.setModel(model);
        lblStatus.setText("Filter cleared.");
        lblStatus.setForeground(Color.gray);
        filterActive = false;
    }//GEN-LAST:event_btnClearFilterActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        mnuExitActionPerformed(evt);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        if (filterActive){ // nu am implementat operatii cat este activ filtrul
            JOptionPane.showMessageDialog(this, "Can't delete records during filter operation.\nClear filter.","Delete",JOptionPane.OK_OPTION);
            return;
        }

        int idx = jTable1.getSelectedRow();
        if (idx <= -1)
            return;
        String aNume, aPrenume;
        abonat a = (abonat)model.abonati.get(idx);
        aNume = a.getNume();
        aPrenume = a.getPrenume();
        int i = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete \n"+aNume + " " + aPrenume+" ?", "Client detele", JOptionPane.OK_CANCEL_OPTION);
        if (i == JOptionPane.OK_OPTION){
            if (jTable1.getSelectedRow() < model.abonati.size()){
                model.abonati.remove(a);
                model.fireTableDataChanged();
                isDataModified = true;
                lblStatus.setText("Success. Phonebook updated");
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm2().setVisible(true);
            }
        });
    }






   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser JFO;
    private javax.swing.JFileChooser JFS;
    private javax.swing.JButton btnClearFilter;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnSort;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox chkReverse;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JPopupMenu jTableMenu;
    private javax.swing.JLabel lblFilter;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JMenuItem mnuAbout;
    private javax.swing.JMenuItem mnuAdd;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JMenuItem mnuOpen;
    private javax.swing.JMenuItem mnuPopupDelete;
    private javax.swing.JMenuItem mnuPopup_Search;
    private javax.swing.JMenuItem mnuRegister;
    private javax.swing.JMenuItem mnuSave;
    private javax.swing.JMenuItem mnuSearch;
    private javax.swing.JRadioButton radioCNP;
    private javax.swing.JRadioButton radioFilterNume;
    private javax.swing.JRadioButton radioFilterPrenume;
    private javax.swing.JRadioButton radioNrtel;
    private javax.swing.JRadioButton radioNume;
    private javax.swing.JRadioButton radioPrenume;
    private javax.swing.JLabel regLabel;
    private javax.swing.JTextField txtFilter;
    // End of variables declaration//GEN-END:variables

}


