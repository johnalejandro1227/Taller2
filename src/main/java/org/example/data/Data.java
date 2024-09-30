package org.example.data;

import org.example.entities.Libro;
import org.example.entities.Persona;
import org.example.entities.Prestamo;
import org.example.entities.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import java.text.ParseException;
import java.util.Date;

public class Data {
    private SessionFactory sessionFactory;
    private boolean dataInit;

    public Data() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void enterData() throws ParseException {
        if (dataInit) {
            System.out.println("los datos ya han sido creados ");
            return;
        }

Session session = sessionFactory.openSession();
        try {
            long countPersonas = (long) session.createQuery("SELECT COUNT (p.id) FROM Persona p ").uniqueResult();
            if (countPersonas>0){
                System.out.println("los datos ya existen en la base de datos");
                dataInit = true;
                session.close();
                return;
            }



            session.beginTransaction();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");

            //persona
            Persona persona1 = new Persona();
            persona1.setNombre("luis");
            persona1.setApellido("alvarez");
            persona1.setSexo("masculino");

            Persona persona2 = new Persona();
            persona2.setNombre("carlos");
            persona2.setApellido("diaz");
            persona2.setSexo("masculino");

            Persona persona3 = new Persona();
            persona3.setNombre("sergio");
            persona3.setApellido("hernandez");
            persona3.setSexo("masculino");

            Persona persona4 = new Persona();
            persona4.setNombre("camilo");
            persona4.setApellido("torres");
            persona4.setSexo("masculino");

            Persona persona5 = new Persona();
            persona5.setNombre("cesar");
            persona5.setApellido("correa");
            persona5.setSexo("masculino");


            //usuario
            Usuario usuario1 = new Usuario();
            usuario1.setIdPersona(persona1);
            usuario1.setRol("bibliotecario");

            Usuario usuario2 = new Usuario();
            usuario2.setIdPersona(persona2);
            usuario2.setRol("cliente");

            Usuario usuario3 = new Usuario();
            usuario3.setIdPersona(persona3);
            usuario3.setRol("cliente");

            Usuario usuario4 = new Usuario();
            usuario4.setIdPersona(persona4);
            usuario4.setRol("bibliotecario");

            Usuario usuario5 = new Usuario();
            usuario5.setIdPersona(persona5);
            usuario5.setRol("bibliotecario");


            //libro
            Libro libro1 = new Libro();
            libro1.setAutor("gabriel garcia marquez");
            libro1.setTitulo("cien años de soledad");
            libro1.setIsbn("23");

            Libro libro2 = new Libro();
            libro2.setAutor("mariam rojas");
            libro2.setTitulo("persona vitamina");
            libro2.setIsbn("12");

            Libro libro3 = new Libro();
            libro3.setAutor("joseph murphi");
            libro3.setTitulo("el poder de la mente");
            libro3.setIsbn("10");

            Libro libro4 = new Libro();
            libro4.setAutor("mariam rojas");
            libro4.setTitulo("como hacer que te pasen cosas buenas");
            libro4.setIsbn("15");

            Libro libro5 = new Libro();
            libro5.setAutor("gabriel gracia");
            libro5.setTitulo("el coronel no tiene");
            libro5.setIsbn("20");


            //prestamo
            Prestamo prestamo1 = new Prestamo();
            prestamo1.setIdUsuario(usuario1);
            prestamo1.setIdLibro(libro1);
            prestamo1.setFechaPrestamo(formato.parse("2024-01-01"));
            prestamo1.setFechaDevolucion(formato.parse("0000-00-00"));
            prestamo1.setActivo(true);

            Prestamo prestamo2 = new Prestamo();
            prestamo2.setIdUsuario(usuario1);
            prestamo2.setIdLibro(libro1);
            prestamo2.setFechaPrestamo(formato.parse("2024-02-01"));
            prestamo2.setFechaDevolucion(formato.parse("0000-00-00"));
            prestamo2.setActivo(true);

            Prestamo prestamo3 = new Prestamo();
            prestamo3.setIdUsuario(usuario1);
            prestamo3.setIdLibro(libro1);
            prestamo3.setFechaPrestamo(formato.parse("2024-03-01"));
            prestamo3.setFechaDevolucion(formato.parse("0000-00-00"));
            prestamo3.setActivo(true);

            Prestamo prestamo4 = new Prestamo();
            prestamo4.setIdUsuario(usuario1);
            prestamo4.setIdLibro(libro1);
            prestamo4.setFechaPrestamo(formato.parse("2024-04-01"));
            prestamo4.setFechaDevolucion(formato.parse("0000-00-00"));
            prestamo4.setActivo(true);

            Prestamo prestamo5 = new Prestamo();
            prestamo5.setIdUsuario(usuario1);
            prestamo5.setIdLibro(libro1);
            prestamo5.setFechaPrestamo(formato.parse("2024-05-01"));
            prestamo5.setFechaDevolucion(formato.parse("0000-00-00"));
            prestamo5.setActivo(true);


            List<Object> entities = Arrays.asList(persona1, persona2, persona3, persona4, persona5, usuario1, usuario2, usuario3, usuario4, usuario5, libro1, libro2, libro3, libro4, libro5, prestamo1, prestamo2, prestamo3, prestamo4, prestamo5);

            for (Object entity : entities) {

                session.persist(entity);
            }

            session.getTransaction().commit();
            dataInit = true;
            System.out.println("los datos han sido creados correctamente");

        } catch (HibernateException error) {
            System.out.println("el error es " + error.getMessage());
        } finally{
            session.close();
        }

    }

}





