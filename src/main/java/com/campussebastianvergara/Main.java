package com.campussebastianvergara;

import java.util.Scanner;

import com.campussebastianvergara.models.Equipo;
import com.campussebastianvergara.models.Fecha;
import com.campussebastianvergara.models.Jugador;
import com.campussebastianvergara.models.PersonaMedica;
import com.campussebastianvergara.models.PersonaTecnica;
import com.campussebastianvergara.Servicios.EquipoServicio;
import com.campussebastianvergara.Servicios.Reportes;
import com.campussebastianvergara.Servicios.Tabla;
import com.campussebastianvergara.Servicios.JugadorServicio;
import com.campussebastianvergara.Servicios.LigaServicio;
import com.campussebastianvergara.Servicios.ReportesJugadores;
import com.campussebastianvergara.Servicios.PerMedServicio;
import com.campussebastianvergara.Servicios.PerTecServicio;
import com.campussebastianvergara.Servicios.FechaServicio;
import com.campussebastianvergara.Interfaces.IEquipoServicio;
import com.campussebastianvergara.Interfaces.IFechaServicio;
import com.campussebastianvergara.Interfaces.IJugadorServicio;
import com.campussebastianvergara.Interfaces.IPerMedServicio;
import com.campussebastianvergara.Interfaces.IPerTecServicio;
import com.campussebastianvergara.UI.Input;

public class Main {
    public static void main(String[] args) {
        String opcion = "";
        String opcIncorrecta = "Opción incorrecta. Ingrese un valor de los mostrados en el menú";
        Scanner sc = new Scanner(System.in);
        IJugadorServicio jugadorServicio = new JugadorServicio();
        IEquipoServicio equipoServicio = new EquipoServicio();
        IFechaServicio fechaServicio = new FechaServicio();
        IPerMedServicio perMedServicio = new PerMedServicio();
        IPerTecServicio perTecServicio = new PerTecServicio();
        // LigaServicio ligaServicio = new LigaServicio();
        // ligaServicio.registrar();
        // Menú
        do {
            System.out.println("***LigaBetplay***\n\nEscoja una opción");
            System.out.println(
                    "1.Registrar equipo\n2.Registrar fecha\n3.Reporte de equipos\n4.Registrar jugador\n5.Reporte jugadores \n6.Registrar Cuerpo técnico\n7.Listar cuerpo técnico \n8.Registrar cuerpo médico \n9.Salir");
            opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    Equipo equipo = new Equipo();
                    System.out.println("Ingrese el nombre del nuevo equipo");
                    equipo.setNombre(sc.nextLine());
                    equipoServicio.registrar(equipo);
                    break;
                case "2":
                    boolean registrarAmonestado = true;
                    Fecha fecha = new Fecha();
                    System.out.println("Ingrese el nombre del equipo local");
                    fecha.setEquipoLocal(sc.nextLine());
                    System.out.println("Cuántos goles hizo el equipo local");
                    fecha.setGolesLocal(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Ingrese el nombre del equipo visitante");
                    fecha.setEquipoVisitante(sc.nextLine());
                    System.out.println("Cuántos goles hizo el equipo visitante");
                    fecha.setGolesVisitante(sc.nextInt());

                    fechaServicio.registrar(fecha);
                    Equipo local = equipoServicio.buscarPorId(fecha.getEquipoLocal());
                    Equipo visitante = equipoServicio.buscarPorId(fecha.getEquipoVisitante());
                    System.out.println(local.getNombre());
                    System.out.println(visitante.getNombre());
                    String[] resultados = fechaServicio.determinarGanador(fecha);
                    equipoServicio.actualizarInfo(local, resultados[0], fecha.getGolesLocal(), fecha.getGolesVisitante());
                    equipoServicio.actualizarInfo(visitante, resultados[1], fecha.getGolesVisitante(), fecha.getGolesLocal());

                    if(fecha.getGolesLocal()> 0){
                        System.out.println("***Goles del local***");
                        Input.inputGoles(fecha.getGolesLocal());
                    }
                    if(fecha.getGolesVisitante()> 0){
                        System.out.println("***Goles del visitante***");
                        Input.inputGoles(fecha.getGolesVisitante());
                    }    

                    System.out.println("Hubo amonestados? Escriba si o no");
                    opcion = sc.nextLine();
                    if (opcion.equalsIgnoreCase("si")){
                        do {
                            Input.inputAmonestado();
                            System.out.println("Desea registrar otro jugador amonestado? 1.Si 2.No");
                            opcion = sc.nextLine();
                            if (opcion.equalsIgnoreCase("2")) {
                                registrarAmonestado = false;
                            }
                            
                        } while (registrarAmonestado);
                    }

                    Tabla.ordenamiento();
                    break;
                case "3":
                    // Menu de reportes
                    System.out.println("***Modulo de reportes*\n\nEscoja una opción");
                    System.out.println(
                            "1.Equipo con mas goles\n2.Equipo con mas puntos\n3.Equipo con mas partidos ganados\n4.Total de goles en la liga\n5.Promedio de goles en la liga \n6.Tabla de posiciones\n7.Salir");
                    opcion = sc.nextLine();
                    switch (opcion) {
                        case "1":
                            Reportes.masGoles();
                            break;
                        case "2":
                            Reportes.masPuntos();
                            break;
                        case "3":
                            Reportes.masVictorias();
                            break;
                        case "4":
                            Reportes.totalGoles();
                            break;
                        case "5":
                            Reportes.promedioGoles();
                            break;
                        case "6":
                            Tabla.imprimirTabla();
                            break;
                        default:
                            System.out.println(opcIncorrecta);
                            break;
                    }
                    break;
                case "4":
                    Jugador jugador = new Jugador();

                    System.out.println("Equipo");
                    jugador.setNombreEquipo(sc.nextLine());

                    System.out.println("Nombre jugador");
                    jugador.setNombre(sc.nextLine());

                    System.out.println("id");
                    jugador.setId(sc.nextLine());

                    System.out.println("nacionalidad");
                    jugador.setNacionalidad(sc.nextLine());

                    System.out.println("dorsal");
                    jugador.setDorsal(sc.nextLine());

                    System.out.println("fecha ingreso");
                    jugador.setFechaIngreso(sc.nextLine());

                    jugadorServicio.registrar(jugador);

                    break;
                case "5":
                    System.out.println("***Modulo de reportes de jugadores*\n\nEscoja una opción");
                    System.out.println("1.Goleador\n2.Jugador con más amarillas \n3.Jugador con más rojas");
                    opcion = sc.nextLine();
                    switch (opcion) {
                        case "1":
                            ReportesJugadores.jugadorConMasGoles();
                            break;
                        case "2":
                            ReportesJugadores.jugadorConMasAmarillas();
                            break;
                        case "3":
                            ReportesJugadores.jugadorConMasRojas();
                            break;
                        default:
                            System.out.println(opcIncorrecta);
                            break;
                    }
                    break;
                case "6":
                    PersonaTecnica personaTecnica = new PersonaTecnica();
                    System.out.println("Registro persona cuerpo técnico\n");
                    System.out.println("Equipo del que forma parte");
                    personaTecnica.setNombreEquipo(opcIncorrecta);
                    System.out.println("Ingrese el id");
                    personaTecnica.setId(sc.nextLine());
                    System.out.println("Ingrese el nombre");
                    personaTecnica.setNombre(sc.nextLine());
                    System.out.println("Rol que va a desempeñar");
                    personaTecnica.setRol(sc.nextLine());
                    perTecServicio.registrar(personaTecnica);
                    break;
                case "7":
                    System.out.println("Listado del cuerpo tecnico");

                    System.out.println("Ingrese el nombre del equipo");
                    Equipo equipoBuscado = equipoServicio.buscarPorId(sc.nextLine());
                    perTecServicio.listarCuerpoTecnico(equipoBuscado.getCuerpoTecnico());
                    break;
                case "8":
                    PersonaMedica personaMedica = new PersonaMedica();
                    System.out.println("Registro persona cuerpo médico\n");
                    System.out.println("Equipo del que forma parte");
                    personaMedica.setNombreEquipo(opcIncorrecta);
                    System.out.println("Ingrese el id");
                    personaMedica.setId(sc.nextLine());
                    System.out.println("Ingrese el nombre");
                    personaMedica.setNombre(sc.nextLine());
                    System.out.println("Rol que va a desempeñar");
                    personaMedica.setRol(sc.nextLine());
                    perMedServicio.registrar(personaMedica);
                    break;
                case "9":
                    break;
                default:
                    System.out.println(opcIncorrecta);
                    break;
            }
        } while (!opcion.equalsIgnoreCase("9"));
        System.out.println("Saliendo...");
    }
}
