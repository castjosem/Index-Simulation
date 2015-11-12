package proyectofinal;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class PrincipalUI extends javax.swing.JFrame {
    private Sistema sistema;
    PanelMostrar panel;

    public PrincipalUI() {
        initComponents();
        sistema = new Sistema();
        panel = new PanelMostrar();
    }
    
    public Boolean validarArchivo(File f) {
        String extension = getExtension(f);

        if (extension != null) {
            if (extension.equals("txt"))
                    return true;
            else return false;
        }
        return false;
    }

    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelFondo = new javax.swing.JPanel();
        Panel_Mostrar = new javax.swing.JPanel();
        Menu_Mostrar = new javax.swing.JComboBox();
        Boton_Ok = new javax.swing.JButton();
        Boton_Archivo = new javax.swing.JButton();
        Boton_Salir = new javax.swing.JButton();
        Panel_Eliminar = new javax.swing.JPanel();
        Label_Eliminar = new javax.swing.JLabel();
        Cedula_Eliminar = new javax.swing.JTextField();
        Boton_Eliminar = new javax.swing.JButton();
        Panel_Buscar = new javax.swing.JPanel();
        Label_Buscar = new javax.swing.JLabel();
        Cedula_Buscar = new javax.swing.JTextField();
        Boton_Buscar = new javax.swing.JButton();
        Panel_Registro = new javax.swing.JPanel();
        Label_Nombre = new javax.swing.JLabel();
        Nombre = new javax.swing.JTextField();
        Label_Apellido = new javax.swing.JLabel();
        Apellido = new javax.swing.JTextField();
        Label_Cedula = new javax.swing.JLabel();
        Cedula = new javax.swing.JTextField();
        Label_Sector = new javax.swing.JLabel();
        Sector = new javax.swing.JTextField();
        Label_Telefono = new javax.swing.JLabel();
        Telefono = new javax.swing.JTextField();
        Label_Email = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        Boton_Añadir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Proyecto Final");
        setBackground(new java.awt.Color(255, 153, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        setResizable(false);

        PanelFondo.setBackground(new java.awt.Color(241, 159, 159));

        Panel_Mostrar.setBackground(new java.awt.Color(255, 204, 204));
        Panel_Mostrar.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Mostrar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 51, 51))); // NOI18N

        Menu_Mostrar.setFont(new java.awt.Font("Tahoma", 0, 12));
        Menu_Mostrar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pre-Orden", "In-Orden", "Post-Orden", "Por Indices" }));
        Menu_Mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_MostrarActionPerformed(evt);
            }
        });

        Boton_Ok.setFont(new java.awt.Font("Tahoma", 0, 12));
        Boton_Ok.setText("Ok");
        Boton_Ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_OkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_MostrarLayout = new javax.swing.GroupLayout(Panel_Mostrar);
        Panel_Mostrar.setLayout(Panel_MostrarLayout);
        Panel_MostrarLayout.setHorizontalGroup(
            Panel_MostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_MostrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Menu_Mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(Boton_Ok)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        Panel_MostrarLayout.setVerticalGroup(
            Panel_MostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_MostrarLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(Panel_MostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Boton_Ok)
                    .addComponent(Menu_Mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        Boton_Archivo.setFont(new java.awt.Font("Tahoma", 0, 12));
        Boton_Archivo.setText("Ingresar desde Archivo...");
        Boton_Archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_ArchivoActionPerformed(evt);
            }
        });

        Boton_Salir.setFont(new java.awt.Font("Tahoma", 0, 12));
        Boton_Salir.setText("Salir");
        Boton_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_SalirActionPerformed(evt);
            }
        });

        Panel_Eliminar.setBackground(new java.awt.Color(255, 204, 204));
        Panel_Eliminar.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Eliminar registro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 51, 51))); // NOI18N
        Panel_Eliminar.setForeground(new java.awt.Color(102, 102, 102));
        Panel_Eliminar.setPreferredSize(new java.awt.Dimension(310, 121));

        Label_Eliminar.setFont(new java.awt.Font("Tahoma", 0, 12));
        Label_Eliminar.setText("Cédula:");

        Cedula_Eliminar.setFont(new java.awt.Font("Lucida Console", 0, 12));
        Cedula_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cedula_EliminarActionPerformed(evt);
            }
        });

        Boton_Eliminar.setFont(new java.awt.Font("Tahoma", 0, 12));
        Boton_Eliminar.setText("Eliminar");
        Boton_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_EliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_EliminarLayout = new javax.swing.GroupLayout(Panel_Eliminar);
        Panel_Eliminar.setLayout(Panel_EliminarLayout);
        Panel_EliminarLayout.setHorizontalGroup(
            Panel_EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_EliminarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_EliminarLayout.createSequentialGroup()
                        .addComponent(Label_Eliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cedula_Eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                    .addComponent(Boton_Eliminar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        Panel_EliminarLayout.setVerticalGroup(
            Panel_EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_EliminarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_Eliminar)
                    .addComponent(Cedula_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Boton_Eliminar)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        Panel_Buscar.setBackground(new java.awt.Color(255, 204, 204));
        Panel_Buscar.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Buscar registro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 51, 51))); // NOI18N
        Panel_Buscar.setForeground(new java.awt.Color(102, 102, 102));

        Label_Buscar.setFont(new java.awt.Font("Tahoma", 0, 12));
        Label_Buscar.setText("Cédula:");

        Cedula_Buscar.setFont(new java.awt.Font("Lucida Console", 0, 12));
        Cedula_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cedula_BuscarActionPerformed(evt);
            }
        });

        Boton_Buscar.setFont(new java.awt.Font("Tahoma", 0, 12));
        Boton_Buscar.setText("Buscar");
        Boton_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_BuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_BuscarLayout = new javax.swing.GroupLayout(Panel_Buscar);
        Panel_Buscar.setLayout(Panel_BuscarLayout);
        Panel_BuscarLayout.setHorizontalGroup(
            Panel_BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_BuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_BuscarLayout.createSequentialGroup()
                        .addComponent(Label_Buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cedula_Buscar, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                    .addComponent(Boton_Buscar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        Panel_BuscarLayout.setVerticalGroup(
            Panel_BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_BuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_Buscar)
                    .addComponent(Cedula_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Boton_Buscar)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        Panel_Registro.setBackground(new java.awt.Color(255, 204, 204));
        Panel_Registro.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Ingresar nuevo registro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        Panel_Registro.setForeground(new java.awt.Color(102, 102, 102));
        Panel_Registro.setDoubleBuffered(false);

        Label_Nombre.setFont(new java.awt.Font("Tahoma", 0, 12));
        Label_Nombre.setText("Nombre:");

        Nombre.setFont(new java.awt.Font("Lucida Console", 0, 12));
        Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreActionPerformed(evt);
            }
        });

        Label_Apellido.setFont(new java.awt.Font("Tahoma", 0, 12));
        Label_Apellido.setText("Apellido: ");

        Apellido.setFont(new java.awt.Font("Lucida Console", 0, 12));
        Apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApellidoActionPerformed(evt);
            }
        });

        Label_Cedula.setFont(new java.awt.Font("Tahoma", 0, 12));
        Label_Cedula.setText("Cédula:");

        Cedula.setFont(new java.awt.Font("Lucida Console", 0, 12));
        Cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CedulaActionPerformed(evt);
            }
        });

        Label_Sector.setFont(new java.awt.Font("Tahoma", 0, 12));
        Label_Sector.setText("Sector: ");

        Sector.setFont(new java.awt.Font("Lucida Console", 0, 12));
        Sector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SectorActionPerformed(evt);
            }
        });

        Label_Telefono.setFont(new java.awt.Font("Tahoma", 0, 12));
        Label_Telefono.setText("Teléfono:");

        Telefono.setFont(new java.awt.Font("Lucida Console", 0, 12));

        Label_Email.setFont(new java.awt.Font("Tahoma", 0, 12));
        Label_Email.setText("Email: ");

        Email.setFont(new java.awt.Font("Lucida Console", 0, 12));

        Boton_Añadir.setFont(new java.awt.Font("Tahoma", 0, 12));
        Boton_Añadir.setText("Añadir");
        Boton_Añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_AñadirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_RegistroLayout = new javax.swing.GroupLayout(Panel_Registro);
        Panel_Registro.setLayout(Panel_RegistroLayout);
        Panel_RegistroLayout.setHorizontalGroup(
            Panel_RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_RegistroLayout.createSequentialGroup()
                .addGroup(Panel_RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Panel_RegistroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Boton_Añadir))
                    .addGroup(Panel_RegistroLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(Panel_RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Label_Telefono)
                            .addComponent(Label_Cedula)
                            .addComponent(Label_Nombre))
                        .addGap(4, 4, 4)
                        .addGroup(Panel_RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Telefono, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(Cedula)
                            .addComponent(Nombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addGroup(Panel_RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Label_Sector)
                            .addComponent(Label_Apellido)
                            .addComponent(Label_Email))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Panel_RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Sector)
                            .addComponent(Apellido, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        Panel_RegistroLayout.setVerticalGroup(
            Panel_RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_RegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_Nombre)
                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Apellido)
                    .addComponent(Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Panel_RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_Cedula)
                    .addComponent(Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Sector)
                    .addComponent(Sector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Panel_RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_Telefono)
                    .addComponent(Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Email)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(Boton_Añadir)
                .addContainerGap())
        );

        Apellido.getAccessibleContext().setAccessibleParent(Apellido);
        Cedula.getAccessibleContext().setAccessibleParent(Cedula);
        Sector.getAccessibleContext().setAccessibleParent(Sector);

        javax.swing.GroupLayout PanelFondoLayout = new javax.swing.GroupLayout(PanelFondo);
        PanelFondo.setLayout(PanelFondoLayout);
        PanelFondoLayout.setHorizontalGroup(
            PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFondoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFondoLayout.createSequentialGroup()
                        .addGroup(PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Panel_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Panel_Mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelFondoLayout.createSequentialGroup()
                                .addGroup(PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Boton_Archivo)
                                    .addComponent(Boton_Salir))
                                .addGap(15, 15, 15))
                            .addComponent(Panel_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Panel_Registro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        PanelFondoLayout.setVerticalGroup(
            PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel_Registro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Panel_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFondoLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(Boton_Archivo)
                        .addGap(18, 18, 18)
                        .addComponent(Boton_Salir))
                    .addGroup(PanelFondoLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(Panel_Mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreActionPerformed
        
}//GEN-LAST:event_NombreActionPerformed

    private void ApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApellidoActionPerformed
        
}//GEN-LAST:event_ApellidoActionPerformed

    private void CedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CedulaActionPerformed
        
}//GEN-LAST:event_CedulaActionPerformed

    private void SectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SectorActionPerformed
        
}//GEN-LAST:event_SectorActionPerformed

    private void Boton_AñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_AñadirActionPerformed

        String array[] = new String[6];

        String cedula = Cedula.getText();
        int num;
        if (cedula.isEmpty()){
            JOptionPane.showMessageDialog (null, "Error: Faltan campos por llenar");
            return;
        }
        else {
            try {
                num = Integer.parseInt(cedula);
            } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(null, "Cedula Invalida");
                Cedula.setText("");
                return;
            }
        }

        array[0] = Cedula.getText();
        array[1] = Nombre.getText();
        array[2] = Apellido.getText();
        array[3] = Sector.getText();
        array[4] = Telefono.getText();
        array[5] = Email.getText();

        Data datos = new Data(array);        

        Cedula.setText("");
        Nombre.setText("");
        Apellido.setText("");
        Sector.setText("");
        Telefono.setText("");
        Email.setText("");
        boolean ok = sistema.insertarSistema(datos);
        if ( ok )
            JOptionPane.showMessageDialog(null, "Registro ingresado exitosamente.");
        else
            JOptionPane.showMessageDialog(null, "Registro ya existente.");
}//GEN-LAST:event_Boton_AñadirActionPerformed

    private void Cedula_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cedula_BuscarActionPerformed
        
}//GEN-LAST:event_Cedula_BuscarActionPerformed

    private void Cedula_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cedula_EliminarActionPerformed
        
}//GEN-LAST:event_Cedula_EliminarActionPerformed

    private void Boton_OkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_OkActionPerformed
        int seleccion = Menu_Mostrar.getSelectedIndex();

        if(sistema.Vacia()){
            JOptionPane.showMessageDialog(null, "No hay registros");
        }
        else{
            panel.limpiarPanel();
            panel.imprimirRecorrido(seleccion,sistema);
            panel.setVisible(true);
        }
    }//GEN-LAST:event_Boton_OkActionPerformed

    private void Boton_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_Boton_SalirActionPerformed

    private void Boton_ArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_ArchivoActionPerformed
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(Boton_Añadir);
        String newline = null;

        if (returnVal == JFileChooser.APPROVE_OPTION){
            if (validarArchivo(fc.getSelectedFile())){
                try {
                    File file = fc.getSelectedFile();
                    if (file.canRead()){
                        sistema.leerArchivo(file);
                        JOptionPane.showMessageDialog(null, "Registros de " +fc.getName(file)+" ingresados exitosamente.");
                    } else JOptionPane.showMessageDialog(null, "Imposible leer del archivo " +fc.getName(file));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(PrincipalUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(PrincipalUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if ( !validarArchivo(fc.getSelectedFile()) )
                JOptionPane.showMessageDialog(null, "ERROR: Tipo de fichero no permitido");
        }
    }//GEN-LAST:event_Boton_ArchivoActionPerformed

    private void Boton_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_BuscarActionPerformed
        String cedula = Cedula_Buscar.getText();
        int num;
        if (cedula.isEmpty()) return;
        else {
            try {
                num = Integer.parseInt(cedula);
            } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(null, "Cédula Invalida");
                return;
            }
            Data aux = sistema.obtenerDato(sistema.buscar(cedula));
            if (aux != null){
                panel.limpiarPanel();
                panel.imprimirBuscar(aux,sistema);
                panel.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "Registro no encontrado o cédula invalida");
            }
        }
        Cedula_Buscar.setText("");
    }//GEN-LAST:event_Boton_BuscarActionPerformed
        
    private void Menu_MostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_MostrarActionPerformed
        
    }//GEN-LAST:event_Menu_MostrarActionPerformed

    private void Boton_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_EliminarActionPerformed
            String cedula = Cedula_Eliminar.getText();
        int num;
        if (cedula.isEmpty()) return;
        else {
            try {
                num = Integer.parseInt(cedula);
            }catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(null, "Cédula Invalida");
                return;
            }
            boolean ok = sistema.eliminarSistema(cedula);
            if( ok )
                JOptionPane.showMessageDialog(null, "Se elimino el registro con cédula :"+Cedula_Eliminar.getText());
            else{
                JOptionPane.showMessageDialog(null, "Registro no encontrado o cédula invalida");
            }
       }
       Cedula_Eliminar.setText("");    

    }//GEN-LAST:event_Boton_EliminarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Apellido;
    private javax.swing.JButton Boton_Archivo;
    private javax.swing.JButton Boton_Añadir;
    private javax.swing.JButton Boton_Buscar;
    private javax.swing.JButton Boton_Eliminar;
    private javax.swing.JButton Boton_Ok;
    private javax.swing.JButton Boton_Salir;
    private javax.swing.JTextField Cedula;
    private javax.swing.JTextField Cedula_Buscar;
    private javax.swing.JTextField Cedula_Eliminar;
    private javax.swing.JTextField Email;
    private javax.swing.JLabel Label_Apellido;
    private javax.swing.JLabel Label_Buscar;
    private javax.swing.JLabel Label_Cedula;
    private javax.swing.JLabel Label_Eliminar;
    private javax.swing.JLabel Label_Email;
    private javax.swing.JLabel Label_Nombre;
    private javax.swing.JLabel Label_Sector;
    private javax.swing.JLabel Label_Telefono;
    private javax.swing.JComboBox Menu_Mostrar;
    private javax.swing.JTextField Nombre;
    private javax.swing.JPanel PanelFondo;
    private javax.swing.JPanel Panel_Buscar;
    private javax.swing.JPanel Panel_Eliminar;
    private javax.swing.JPanel Panel_Mostrar;
    private javax.swing.JPanel Panel_Registro;
    private javax.swing.JTextField Sector;
    private javax.swing.JTextField Telefono;
    // End of variables declaration//GEN-END:variables

}
