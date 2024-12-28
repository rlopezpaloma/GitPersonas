package personas;
import java.util.regex.Pattern;

/**
 * Clase que almacena y maneja los atributos de las personas
 * @autor IES Virgen de la Paloma
 * @version 2
 */
public class Persona {

    private String dni;
    private String nombre;
    private String apellidos;
    private int edad;

    static final int MAYORIA_EDAD = 18;
    static final int JUBILACION_EDAD = 65;

    /**
     * Constructor
     * @param dni
     * @param nombre
     * @param apellidos
     * @param edad
     */
    public Persona(String dni, String nombre, String apellidos, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }
    
    /**
     * Constructor
     * @param nombre
     * @param apellidos
     * @param edad
     */
    Persona(String nombre, String apellidos, int edad){
        this("-", nombre, apellidos, edad);
    }
    
    /**
     * Constructor
     */
    public Persona() {
    	this("", "", "", 0);
    }

    /**
     * Devuelve el DNI
     * @return
     */
    public String getDni() {
        return dni;
    }

    /**
     * Guarda el DNI
     * @param dni
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Devuelve el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Guarda el nombre
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve los apellidos
     * @return
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Guarda los apellidos
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Devuelve la edad
     * @return
     */
    public int getEdad() {
        return this.edad; 
    }

    /**
     * Guarda la edad
     * @param edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Suma 1 año a la edad de la persona
     */
    public void updateEdad() {
        this.edad = this.edad + 1;
        
    }

    /**
     * Indica si la persona es menor de edad
     * @return
     */
    public boolean esMenor() {
        return this.edad < Persona.MAYORIA_EDAD;
    }
    
    
    /**
     * Indica si la persona está en edad de jubilación
     * @return
     */
    public boolean esJubilado() {
    	return this.edad >= JUBILACION_EDAD;
    }

    /**
     * Devuelve la diferencia de edad entre este objeto y el recibido
     * @param p
     * @return
     */
    public int diferenciaEdad(Persona p) {
        return this.edad - p.edad;
    }

    /**
     * Muestra por pantalla los datos de la persona
     */
    public void imprime() {
        System.out.println("DNI: " + this.dni);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Apellidos: " + this.apellidos);
        System.out.println("Edad: " + this.edad);
    }

    /**
     * Sobreescribe el metodo toString de la clase Object
     */
    @Override
    public String toString(){
    	return "Persona{" + "nombre=" + this.nombre + ", apellidos=" + this.apellidos + ", dni=" + this.dni + ", edad=" + this.edad + '}';
    }
    
    
    /**
     * Funcion que recibe un DNI y devuelve si es valido o no. OJO no comprueba que la letra sea correcta
     * @param valor
     * @return Devuelve true si se cumple la expresion regular
     */
    public static boolean validarDNI(String valor) {
        // Expresion regular que indica 8 digitos y al final alguna de las letras que se permiten
        // rangos A-H J-N P-T V-Z (recordad, algunas no se permiten)

        String dniRegexp = "\\d{8}[A-HJ-NP-TV-Z]";
        return Pattern.matches(dniRegexp, valor);
    }
    
}