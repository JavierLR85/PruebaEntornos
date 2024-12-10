/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.educastur.javierlr.agenda2024;

/**
 *
 * @author alu14d
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner; 

public class LoredoRuizJavierAgenda{
   ArrayList<Contacto> contactos;
    
public LoredoRuizJavierAgenda(){
    contactos=new ArrayList();
    }
    
   
    public static void main(String[] args) {
        LoredoRuizJavierAgenda agenda=new LoredoRuizJavierAgenda();    
        agenda.cargaDatos();
        agenda.menu();

        
    }
    public void menu (){
         Scanner sc=new Scanner(System.in);
        int opcion=0;
        do{
            System.out.println("\n\n\n\n\n\t\t\t\tMENU DE OPCIONES\n");
            System.out.println("\t\t\t\t1 - NUEVO CONTACTO");
            System.out.println("\t\t\t\t2 - LISTA DE CONTACTOS");
            System.out.println("\t\t\t\t3 - MODIFICAR CONTACTO");
            System.out.println("\t\t\t\t4 - BORRAR CONTACTO");
            System.out.println("\t\t\t\t5 - Quien cumple años hoy?");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion=sc.nextInt();
            switch (opcion){
                case 1:{
                    nuevoContacto();
                    break;
                }    
                case 2:{
                    listaContactos();
                    break;
                } 
                case 3:{
                    modificarContacto();
                    break;
                } 
                case 4:{
                    borrarContacto();
                    break;
                }
                case 5:{
                    ListaCumpleaños();
                    break;
                }
                }
        }while (opcion != 9);
    }
       

    public void cargaDatos() {
        contactos.add(new Contacto("Ana","666654321","ana@hotmail.com",LocalDate.parse("2000-01-13")));
        contactos.add(new Contacto("Berto","669654321","Bertorebollada@hotmail.com",LocalDate.parse("2004-11-13")));    
        contactos.add(new Contacto("Eva","653343234"));
        contactos.add(new Contacto("ANA","666666666","anaberta@gmail.com",LocalDate.parse("2000-01-01")));
        contactos.add(new Contacto("LUIS","777777777","luis@gmail.com",LocalDate.parse("2006-12-12")));
        contactos.add(new Contacto("PEPE","666777777","pepe@gmail.com",LocalDate.parse("2002-11-11")));
        contactos.add(new Contacto("JULIA","666888888","julia@gmail.com",LocalDate.parse("2005-03-15")));
        contactos.add(new Contacto("ROSA","666999999","rosa@gmail.com",LocalDate.parse("2003-05-05")));
           } 
    public void nuevoContacto (){
        String nombre, telefono, email, fechaNac;
         Scanner sc= new Scanner (System.in); 
         System.out.println("Nuevo Contacto: ");
         System.out.println("Nombre: ");
         nombre=sc.nextLine();
         System.out.println("Telefono: ");
         telefono=sc.nextLine();
         System.out.println("Email: ");
         email=sc.nextLine();
         System.out.println("Fecha Nacimiento: ");
         fechaNac=sc.nextLine();
        contactos.add(new Contacto(nombre,telefono,email,LocalDate.parse(fechaNac)));
        System.out.println(new Contacto(nombre,telefono,email,LocalDate.parse(fechaNac)));
        Collections.sort(contactos);
    }
    public void listaContactos() {
        for (Contacto c : contactos) {
            System.out.println(c);
        }
    }
    public void modificarContacto () {     
       Scanner sc=new Scanner (System.in);
        System.out.println("Nombre del contacto a modificar: ");
        String nombre=sc.nextLine();
        int pos=buscaContacto(nombre);
        if(pos==-1){
            System.out.println("El nombre que buscas no esta en la agenda");
        }else{
            System.out.println("Teclea el numero de telefono:");
            contactos.get(pos).setTelefono(sc.nextLine());
        }
    }
    public void borrarContacto() {
    Scanner sc=new Scanner (System.in);
        System.out.println("Nombre del contacto a borrar: ");
        String nombre=sc.nextLine();
        int pos=buscaContacto(nombre);
        if(pos==-1){
            System.out.println("El nombre que buscas no esta en la agenda");
        }else{
            
            System.out.println("Se ha eliminado el contacto: "+nombre);
           }
}
      public void listacumpleaños(){
          
}
    public int buscaContacto (String nombre){
        int pos=-1;
        for (int i = 0; i <contactos.size(); i++) {
         if(contactos.get(i).getNombre().equalsIgnoreCase(nombre)){
             pos=i;
             break;
         }   
        }
         return pos;
        }
  public void ListaCumpleaños(){
  Scanner sc=new Scanner(System.in);
  int dias=0;
  LocalDate hoy=LocalDate.now();
      System.out.println("Cumpleaños en los proximos X dias: ");
      System.out.println("Valor de X?");
      dias=sc.nextInt();
      for (Contacto c : contactos){
          int dif=c.getFechaNac().getDayOfYear()-hoy.getDayOfYear();
          if (Math.abs(dif)<=dias){
              System.out.println(c);
          }
      }
  }
}

   