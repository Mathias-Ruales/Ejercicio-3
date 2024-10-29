import javax.swing.*;

public class ColaPrioridad {
    public Paciente frente;

    public ColaPrioridad() {
        frente = null;
    }

    public boolean estaVacia(){
        return frente == null;
    }
    public void mostrarCola(JTextArea textArea){
        if(estaVacia()){
            textArea.setText("Cola Vacia");
        }else{
            StringBuilder colaStr = new StringBuilder();
            Paciente actual = frente;

            while(actual != null){
                colaStr.append(" Nombre: ").append(actual.nombre)
                        .append(", prioridad ").append(actual.prioridad)
                        .append("\n");
                actual = actual.siguiente;
            }
            textArea.setText(colaStr.toString());
        }
    }

    public void actualizarCola(JTextArea textArea){
        mostrarCola(textArea);
    }
    public void encolar(String nombre, int prioridad, JTextArea textArea){
        Paciente nuevoPaciente = new Paciente(nombre, prioridad);

        if(estaVacia() || prioridad < frente.prioridad){
            nuevoPaciente.siguiente = frente;
            frente = nuevoPaciente;
        }else{
            Paciente actual = frente;
            while(actual.siguiente != null && actual.siguiente.prioridad <= prioridad){
                actual = actual.siguiente;
            }
            nuevoPaciente.siguiente = actual.siguiente;
            actual.siguiente = nuevoPaciente;
        }
        actualizarCola(textArea);
    }

    public String desencolar(JTextArea textArea){
        if(estaVacia()){
            return "La cola esta vacia";
        }
        String nombre = frente.nombre;
        frente = frente.siguiente;
        actualizarCola(textArea);
        return nombre;
    }
}
