package proyectofinal;

public class PanelMostrar extends javax.swing.JFrame {

    public PanelMostrar() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextArea();

        setTitle("Ventana de muestra");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.white);
        setLocationByPlatform(true);
        setName("Ventana"); // NOI18N
        setResizable(false);

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        texto.setColumns(20);
        texto.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        texto.setRows(5);
        jScrollPane1.setViewportView(texto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea texto;
    // End of variables declaration//GEN-END:variables

    public void limpiarPanel(){
        texto.setText(null);
    }
    public void agregarTexto(String cadena){
        texto.append(cadena);
        texto.append(System.getProperty("line.separator"));
    }
    public void imprimirBuscar(Object dato, Sistema sistema){
        sistema.mostrarDato(dato,texto);
    }
    public void imprimirRecorrido(int seleccion , Sistema sistema){        
        sistema.mostrarArbol(seleccion, texto);
    }

}
