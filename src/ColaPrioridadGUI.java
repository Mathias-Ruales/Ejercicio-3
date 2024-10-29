import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColaPrioridadGUI {
    private JTextField txtElemento;
    private JTextField txtPrioridad;
    private JTextArea txtResultado;
    private JButton encolarButton;
    private JButton desencolarButton;
    private JPanel pGeneral;
    public ColaPrioridad cp = new ColaPrioridad();
    public int pacienteContador=0;
    public static  int pacienteIngresado;
    public ColaPrioridadGUI() {

        desencolarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cp.estaVacia()){
                    JOptionPane.showMessageDialog(null, "La cola esta vacia");
                }
                while (!cp.estaVacia()){
                    JOptionPane.showMessageDialog(null, cp.desencolar(txtResultado) +   " ha sido atendido/a");
                }
                int respuesta =JOptionPane.showConfirmDialog(null,
                        "Todos los pacientes han sido atendidos. Desea ingresar mas?",
                        " ",
                        JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION){
                    pacienteContador=0;
                    pacienteIngresado = Integer.parseInt(JOptionPane.showInputDialog("Cuantos pacientes desea ingreaar?"));
                }
            }
        });

        encolarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = txtElemento.getText();
                String prio = txtPrioridad.getText();
                try{
                    int prioridad = Integer.parseInt(prio);
                    cp.encolar(input, prioridad, txtResultado);
                    txtElemento.setText("");
                    txtPrioridad.setText("");
                    pacienteContador++;

                    if (pacienteIngresado == pacienteContador) {
                        pacienteContador=0;
                        int respuesta = JOptionPane.showConfirmDialog(null,
                                "Se ha ingresado el número de pacientes deseados. ¿Desea ingresar más?",
                                "",
                                JOptionPane.YES_NO_OPTION);
                        if (respuesta == JOptionPane.YES_OPTION) {
                            pacienteIngresado = Integer.parseInt(JOptionPane.showInputDialog("Cuantos pacientes desea ingreaar?"));
                        } else {
                            JOptionPane.showMessageDialog(null, "Gracias por usar el programa.");
                            System.exit(0);
                        }

                    }
                }catch (Exception ex){
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ColaPrioridadGUI");
        frame.setContentPane(new ColaPrioridadGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        pacienteIngresado = Integer.parseInt(JOptionPane.showInputDialog("Cuantos pacientes desea ingreaar?"));

    }
}
