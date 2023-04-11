package costamallas;

public class Tecnicos extends Empleado implements Instalaciones{

    public Tecnicos(String nom, int edad, double sue, int anio, int mes, int dia){

        super(nom, edad, sue, anio, mes, dia);
    }
    public String RealizarInstalaciones (String Instalacion){

        return "Los Tecnicos deben Realizar una" + Instalacion;
    }

}
