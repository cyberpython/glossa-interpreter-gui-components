/*
 *  Copyright 2010 Georgios Migdos <cyberpython@gmail.com>.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */

/*
 * JRuntimeArrayDialog.java
 *
 * Created on Nov 16, 2010, 6:38:00 PM
 */

package glossa.ui.gui.stackrenderer.components;

import glossa.interpreter.symboltable.symbols.RuntimeArray;
import glossa.interpreter.symboltable.symbols.RuntimeArrayListener;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;

/**
 *
 * @author Georgios Migdos <cyberpython@gmail.com>
 */
public class JRuntimeArrayDialog extends javax.swing.JDialog implements RuntimeArrayListener{

    private RuntimeArray arr;
    private DefaultListModel model;

    /** Creates new form JRuntimeArrayDialog */
    public JRuntimeArrayDialog(java.awt.Frame parent, boolean modal, RuntimeArray arr) {
        super(parent, modal);
        this.arr = null;
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        this.model = new DefaultListModel();
        jList1.setCellRenderer(new JRuntimeArrayRenderer());
        jList1.setModel(model);

        this.setRuntimeArray(arr);

    }

    public void arrayContentsChanged() {
        jList1.repaint();
    }



    private void setRuntimeArray(RuntimeArray arr) {
        this.model.clear();
        this.model.addElement(arr);
        arr.setListener(this);
        this.arr = arr;
        this.setTitle("Παρακολούθηση τιμών πίνακα: "+arr.getName());
        this.pack();
    }

    @Override
    public void dispose() {
        if(this.arr!=null){
            arr.removeListener();
        }
        super.dispose();
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JRuntimeArrayDialog dialog = new JRuntimeArrayDialog(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
