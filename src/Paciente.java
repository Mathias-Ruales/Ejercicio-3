public class Paciente {
    public String nombre;
    public int prioridad;
    public Paciente siguiente;

    public Paciente(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.siguiente = null;
    }
}

