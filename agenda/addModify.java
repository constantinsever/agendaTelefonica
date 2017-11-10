
package agenda;

import javax.swing.JOptionPane;

/**
 *
 * @author sever
 */
public class addModify extends javax.swing.JDialog {

    private final byte ADD_RECORD = 1;
    private final byte INSERT_RECORD = 2;
    private final byte MODIFY_RECORD = 3;

    //1 = adauga inregistrare
    //2 = insereaza inregistrare
    //3 = modificare inregistrare selectata

    private byte desired_action = 0;
    private int record_index = 0;
    private client_model model = null;

    private abonat theValues = new abonat("","",0,0);

    public addModify(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getRootPane().setDefaultButton(btnOK);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNume = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();
        txtPrenume = new javax.swing.JTextField();
        txtCNP = new javax.swing.JTextField();
        txtNrtel = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add / Modify client");
        setResizable(false);

        jLabel1.setText("Nume :");

        txtNume.setText("Popescu");

        jLabel2.setText("Prenume :");

        jLabel3.setText("CNP :");

        jLabel4.setText("Numar de telefon :");

        btnOK.setText("OK");
        btnOK.setSelected(true);
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        txtPrenume.setText("Ionel");

        txtCNP.setText("1234567894567");

        txtNrtel.setText("123456");

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNrtel)
                    .addComponent(txtPrenume)
                    .addComponent(txtCNP)
                    .addComponent(txtNume, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnOK))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrenume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNrtel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        String error ="";
        if (txtNume.getText().isEmpty() || txtPrenume.getText().isEmpty() || txtCNP.getText().isEmpty() || txtNrtel.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "No field can be empty !", "Empty fields detected", JOptionPane.OK_OPTION + JOptionPane.ERROR_MESSAGE);
            return;
        }

        if ( txtNrtel.getText().matches("[0-9]{6}") == false){  // se accepta doar 6 cifre.
            JOptionPane.showMessageDialog(this, "Bad number, use 6 digit numbers only !", "Bad data entered", JOptionPane.OK_OPTION + JOptionPane.ERROR_MESSAGE);
            return;
        }

        if ( txtCNP.getText().matches("[0-9]{13}") == false){  // se accepta doar 13 cifre pt CNP
            JOptionPane.showMessageDialog(this, "Bad CNP, use 13 digit numbers only !", "Bad data entered", JOptionPane.OK_OPTION + JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        
        switch (desired_action){
          case ADD_RECORD :
               theValues = getValues();
               MainForm2.model.abonati.add(theValues);
            case MODIFY_RECORD:
                theValues = getValues();
                MainForm2.model.abonati.set(record_index, theValues);
           
          default: break;
      }

    
        this.dispose(); 
        MainForm2.model.fireTableDataChanged();
        MainForm2.isDataModified = true;
    }//GEN-LAST:event_btnOKActionPerformed


    public void setValues(abonat o){
        txtNume.setText(o.getNume());
        txtPrenume.setText(o.getPrenume());
        txtCNP.setText(String.valueOf(o.getCNP()));
        txtNrtel.setText(String.valueOf(o.getNrtel()));
    }

    public abonat getValues(){
        abonat a = new abonat("","",0,0);
         a.setNume(txtNume.getText());
         a.setPrenume(txtPrenume.getText());
         a.setCNP(Long.parseLong(txtCNP.getText()));
         a.setNrtel(Long.parseLong(txtNrtel.getText()));
        return a;
    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    public void addRecord(){
      desired_action = ADD_RECORD;
    }

  
    public void modifyAt(int idx, abonat a){
        desired_action = MODIFY_RECORD;
        record_index = idx;
    }


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                addModify dialog = new addModify(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtCNP;
    private javax.swing.JTextField txtNrtel;
    private javax.swing.JTextField txtNume;
    private javax.swing.JTextField txtPrenume;
    // End of variables declaration//GEN-END:variables

}
