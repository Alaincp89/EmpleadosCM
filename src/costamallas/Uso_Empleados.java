package costamallas;

import java.util.*;

public class Uso_Empleados {
    public static void main(String[] args) {
        // TODO Auto-generated method stub



        Jefe IngSistemas = new Jefe("Ruben Gonzalez", 40,2000000,2018,05,10);
        IngSistemas.setIncentivo(200000);



        /*

        EmpleadosCM[0] = Gerente;
        EmpleadosCM[1] = Coordinador; // Polimorfismo
        EmpleadosCM[2] = IngSistemas; */

        ArrayList<Empleado> EmpleadosCM=new ArrayList<>();

        EmpleadosCM.add(new Jefe("Skarlyn Cervantes", 40,3500000, 2013, 01, 01) );
        EmpleadosCM.add(new Jefe("Alain Cervantes", 33,2500000, 2013, 10, 03) );
        EmpleadosCM.add(new Jefe("Ruben Gonzalez", 40,2000000,2018,05,10));
        EmpleadosCM.add(new Tecnicos("Anderson Espinoza", 24,1300000, 2019, 07, 01) );
        EmpleadosCM.add(new Tecnicos("Luis Mejia",30,1300000,2019,05,05) );
        EmpleadosCM.add(new Empleado("Yuraima Hernandez", 42,1300000, 2022, 11, 03));
        EmpleadosCM.add(new Empleado("Moises Meriño", 30,1300000, 2022, 11, 01));


        for (Empleado e : EmpleadosCM) { // Se le Aumenta a todos los trabajadores un 10 %
            e.setSubirSueldo(10);
        }


        for (Empleado e : EmpleadosCM){
            System.out.println(e.getDatos());
        }
    }

}
class Empleado implements Instalaciones, Recargo {


    public Empleado(String nom, int edad, double sue, int anio, int mes, int dia) {

        nombre = nom;

        this.edad = edad;

        sueldo = sue;

        GregorianCalendar calendario = new GregorianCalendar(anio, mes-1, dia);

        fechaIngreso = calendario.getTime();
        ++IdSiguiente;
        setId(IdSiguiente);
    }
    public String RealizarInstalaciones (String Instalacion){
        return "Los Tecnicos deben realizar una instalacion" + Instalacion;
    }

    public double HorasExtras (double Extras){
        return Recargo.valorExtra*Extras;
    }
    public Empleado(String nom) {

        this(nom, 33,1150000, 2022,04,01);
    }
    public String getDatos() { // Getter

        return "\nNombre del Empleado: " + nombre + " \nEdad: " + edad + "\nId: " + Id + "\nFecha de Ingreso: " + fechaIngreso + "\nSueldo: $" + sueldo;
    }

    public void setSubirSueldo(double porcentaje) { // setter
        double aumento=sueldo*porcentaje/100;
        sueldo+=aumento;

    }
    public double getSueldo(){
        return sueldo;
    }
    public void setId(int id) {
        Id = id;
    }


    private String nombre;
    private int edad;
    private double sueldo;
    private Date fechaIngreso;
    private static int IdSiguiente;
    private int Id;
}

class  Jefe extends Empleado {


    public Jefe(String nom, int edad, double sue, int anio, int mes, int dia) {

        super(nom, edad, sue, anio, mes, dia);
        incentivo = 0;
    }

    public void setIncentivo(double b) {

        incentivo = b;
    }

    public double getSueldo() {

        double sueldoBase=super.getSueldo();

        return sueldoBase + incentivo;
    }

    private double incentivo;
}
