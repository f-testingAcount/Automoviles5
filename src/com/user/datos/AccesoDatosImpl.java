package com.user.datos;

import com.user.domain.Agencia;
import com.user.domain.CaracteristicasTec;
import com.user.domain.Distribuidor;
import com.user.domain.Marca;
import com.user.domain.Modelo;
import com.user.exceptions.AccesoDatosEx;
import com.user.negocios.IAccionesComerciales;
import static com.user.negocios.IAccionesComerciales.ARCHIVO_MARCAS;
import static com.user.negocios.IAccionesComerciales.ARCHIVO_MODELOS;
import java.io.*;
import static java.nio.file.Files.lines;
import java.util.*;

public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        switch (nombreArchivo) {
            case ARCHIVO_MARCAS -> {
                try {
                    PrintWriter createFile = new PrintWriter(new FileWriter(archivo));
                    System.out.println("Se ha creado el archivo " + nombreArchivo + "!");
                    createFile.close();
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al crear el archivo marcas!" + ex.getMessage());
                }
            }
            case IAccionesComerciales.ARCHIVO_MODELOS -> {
                try {
                    PrintWriter createFile = new PrintWriter(new FileWriter(archivo));
                    System.out.println("Se ha creado el archivo " + nombreArchivo + "!");
                    createFile.close();
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al crear el archivo modelos!" + ex.getMessage());
                }
            }
            case IAccionesComerciales.ARCHIVO_CARACTERISTICAS_TEC -> {
                try {
                    PrintWriter createFile = new PrintWriter(new FileWriter(archivo));
                    System.out.println("Se ha creado el archivo " + nombreArchivo + "!");
                    createFile.close();
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al crear el archivo caracteristicas tecnicas!" + ex.getMessage());
                }
            }
            case IAccionesComerciales.ARCHIVO_DISTRIBUIDORES -> {
                try {
                    PrintWriter createFile = new PrintWriter(new FileWriter(archivo));
                    System.out.println("Se ha creado el archivo " + nombreArchivo + "!");
                    createFile.close();
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al crear el archivo distribuidores!" + ex.getMessage());
                }
            }
            case IAccionesComerciales.ARCHIVO_AGENCIAS -> {
                try {
                    PrintWriter createFile = new PrintWriter(new FileWriter(archivo));
                    System.out.println("Se ha creado el archivo " + nombreArchivo + "!");
                    createFile.close();
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al crear el archivo agencias!" + ex.getMessage());
                }
            }
            default -> {
            }
        }
    }

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public void escribir(Object object, String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        switch (nombreArchivo) {
            case ARCHIVO_MARCAS -> {
                Marca marca = (Marca) object;
                try {
                    PrintWriter write = new PrintWriter(new FileWriter(archivo, true));
                    write.println(marca.toString());
                    write.close();
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al escribir en el archivo marcas!" + ex.getMessage());
                }
            }
            case ARCHIVO_MODELOS -> {
                Modelo modelo = (Modelo) object;
                try {
                    PrintWriter write = new PrintWriter(new FileWriter(archivo, true));
                    write.println(modelo.toString());
                    write.close();
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al escribir en el archivo modelos!" + ex.getMessage());
                }
            }
            case IAccionesComerciales.ARCHIVO_CARACTERISTICAS_TEC -> {
                CaracteristicasTec caracteristica = (CaracteristicasTec) object;
                try {
                    PrintWriter write = new PrintWriter(new FileWriter(archivo, true));
                    write.println(caracteristica.toString());
                    write.close();
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al escribir en el archivo caracteristicas tecnicas!" + ex.getMessage());
                }
            }
            case IAccionesComerciales.ARCHIVO_DISTRIBUIDORES -> {
                Distribuidor distribuidor = (Distribuidor) object;
                try {
                    PrintWriter write = new PrintWriter(new FileWriter(archivo, true));
                    write.println(distribuidor.toString());
                    write.close();
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al escribir en el archivo distribuidor!" + ex.getMessage());
                }
            }
            case IAccionesComerciales.ARCHIVO_AGENCIAS -> {
                Agencia agencia = (Agencia) object;
                try {
                    PrintWriter write = new PrintWriter(new FileWriter(archivo, true));
                    write.println(agencia.toString());
                    write.close();
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al escribir en el archivo agencia!" + ex.getMessage());
                }
            }
            default -> {
                System.out.println("La opcion ingresada no exitste, ingrese una opcion valida!");
            }
        }
    }

    @Override
    public List listar(Object object, String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        switch (nombreArchivo) {
            case ARCHIVO_MARCAS -> {
                //Marca marca = (Marca) object;
                List<Marca> marcas = new ArrayList<>();
                try {
                    BufferedReader leer = new BufferedReader(new FileReader(archivo));
                    String linea = leer.readLine();
                    while (linea != null) {
                        //Marca marca = (Marca) object;
                        linea = linea.substring(8);
                        String nombre = linea.substring(0, linea.indexOf(" "));
                        String origen = linea.substring(linea.indexOf("Origen:") + 8, linea.indexOf(" | Logo:"));
                        String logo = linea.substring(linea.indexOf("Logo:") + 6, linea.indexOf(" -"));
                        Marca marca = new Marca(nombre, origen, logo);
                        marcas.add(marca);
                        linea = leer.readLine();
                    }
                    leer.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al listar el archivo marcas!" + ex.getMessage());
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al listar el archivo marcas!" + ex.getMessage());
                }
                return marcas;
            }
            case IAccionesComerciales.ARCHIVO_MODELOS -> {
                Modelo modelo = (Modelo) object;
                List<Modelo> modelos = new ArrayList<>();
                try {
                    BufferedReader leer = new BufferedReader(new FileReader(archivo));
                    String linea = leer.readLine();
                    while (linea != null) {
                        linea = linea.substring(18);
                        String tipoVehiculo = linea.substring(0, linea.indexOf(" "));
                        String denominacion = linea.substring(linea.indexOf("Denominacion:") + 14, linea.indexOf(" | Cantidad:"));
                        String cantidad = linea.substring(linea.indexOf("Cantidad:") + 10, linea.indexOf(" -"));                     
                        modelo = new Modelo(tipoVehiculo, denominacion, Integer.valueOf(cantidad));
                        modelos.add(modelo);
                        linea = leer.readLine();
                    }
                    leer.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al listar el archivo marcas!" + ex.getMessage());
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al listar el archivo marcas!" + ex.getMessage());
                }
                return modelos;
            }
            case IAccionesComerciales.ARCHIVO_CARACTERISTICAS_TEC -> {
                CaracteristicasTec caracteristica = (CaracteristicasTec) object;
                List<CaracteristicasTec> caracteristicas = new ArrayList<>();
                try {
                    BufferedReader leer = new BufferedReader(new FileReader(archivo));
                    String linea = leer.readLine();
                    while (linea != null) {
                        linea = linea.substring(8);
                        String modeloDenominacion = linea.substring(0, linea.indexOf(" "));
                        String tipoMotor = linea.substring(linea.indexOf("TipoMotor:") + 11, linea.indexOf(" | Cilindros:"));
                        String cilindros = linea.substring(linea.indexOf("Cilindros:") + 11, linea.indexOf(" | Cilindrada"));
                        String cilindrada = linea.substring(linea.indexOf("Cilindrada:") + 12, linea.indexOf(" | HP"));
                        String hp = linea.substring(linea.indexOf("HP:") + 4, linea.indexOf(" | Caja"));
                        String caja = linea.substring(linea.indexOf("Caja:") + 6, linea.indexOf(" | Equipamiento:"));
                        String equipamiento = linea.substring(linea.indexOf("Equipamiento:") + 14, linea.indexOf(" | Carroceria"));
                        String carroceria = linea.substring(linea.indexOf("Carroceria:") + 12, linea.indexOf(" | id"));
                        String id = linea.substring(linea.indexOf("id:") + 4, linea.indexOf(" -"));
                        caracteristica =  new CaracteristicasTec(modeloDenominacion, tipoMotor, cilindros, Integer.valueOf(cilindrada),
                                                                 Integer.valueOf(hp), caja, equipamiento, carroceria, id);
                        caracteristicas.add(caracteristica);
                        linea = leer.readLine();
                    }
                    leer.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al listar el archivo marcas!" + ex.getMessage());
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al listar el archivo marcas!" + ex.getMessage());
                }
                return caracteristicas;
            }
            case IAccionesComerciales.ARCHIVO_DISTRIBUIDORES -> {
                List<Distribuidor> distribuidores = new ArrayList<>();
                try {
                    BufferedReader leer = new BufferedReader(new FileReader(archivo));
                    String linea = leer.readLine();
                    while (linea != null) {
                        linea.substring(8);                        
                        String nombreDistribuidor = linea.substring(0, linea.indexOf(" | "));
                        String pais = linea.substring(linea.indexOf("Pais:") + 6, linea.indexOf(" -"));
                        Distribuidor distribuidor = new Distribuidor(nombreDistribuidor, pais);
                        distribuidores.add(distribuidor);
                        linea = leer.readLine();
                    }
                    leer.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al listar el archivo marcas!" + ex.getMessage());
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al listar el archivo marcas!" + ex.getMessage());
                }
                return distribuidores;
            }
            case IAccionesComerciales.ARCHIVO_AGENCIAS -> {
                List<Agencia> agencias = new ArrayList<>();
                try {
                    BufferedReader leer = new BufferedReader(new FileReader(archivo));
                    String linea = leer.readLine();
                    while (linea != null) {
                        linea = linea.substring(8);
                        String nombreAgencia = linea.substring(0, linea.indexOf(" | "));
                        String ciudad = linea.substring(linea.indexOf("Ciudad:") + 8, linea.indexOf("| Marca:"));
                        String marcaComerzializada = linea.substring(linea.indexOf("Marca:") + 7, linea.indexOf(" -"));
                        Agencia agencia = new Agencia(nombreAgencia, ciudad, marcaComerzializada);
                        agencias.add(agencia);
                        linea = leer.readLine();
                    }
                    leer.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al listar el archivo marcas!" + ex.getMessage());
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al listar el archivo marcas!" + ex.getMessage());
                }
                return agencias;
            }
            default -> {
            }
        }
        return (List) object;
    }

    @Override
    public Object buscar(String nombreArchivo, Object object) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        switch (nombreArchivo) {
            case ARCHIVO_MARCAS -> {
                Marca marca = (Marca) object;
                //marca = new Marca();
                List<Marca> marcas = new ArrayList<>();
                //busqueda = "";
                try {
                    BufferedReader search = new BufferedReader(new FileReader(archivo));
                    var indice = 1;
                    String linea = search.readLine();
                    while (linea != null) {
                        linea = linea.substring(8);
                        String nombre = linea.substring(0, linea.indexOf(" "));
                        String origen = linea.substring(linea.indexOf("Origen:") + 8, linea.indexOf(" | Logo"));
                        String logo = linea.substring(linea.indexOf("Logo:") + 6, linea.indexOf(" -"));
                        Marca datos = new Marca(nombre, origen, logo);
                        marcas.add(datos);
                        //for (int i = 0; i < marcas.size(); i++) {
//                            if (marca.getNombre() != null && linea.contains(marca.getNombre())) {
                            if (marca.getNombre() != null && marca.getNombre().equalsIgnoreCase(datos.getNombre())) {
                                object = "La marca " + marca.getNombre() + " se encuentra en el indice "
                                        + indice + " es de origen " + datos.getOrigen() + " y el logo es " + datos.getLogo();
                                break;
                            }    
                            //break;
//                        } else if(busqueda.equalsIgnoreCase(origen)){
//                            busqueda = "El origen de la marca " + nombre + " es: " + origen + " y se encuentra en el idice " + indice;
//                            break;
//                        } else if (busqueda.equalsIgnoreCase(logo)) {
//                            busqueda = "El logo de la marca " + nombre + " es: " + logo + " y se localiza en el indice " + indice;
//                            break;
                        
                        indice++;
                        linea = search.readLine();
                        
//                        Marca datos = new Marca(nombre, origen, logo);
//                        marcas.add(datos);                        
//                        if ((marca.getNombre() != null && linea.contains(marca.getNombre()))
////                        || (marca.getOrigen() != null && linea.contains(marca.getOrigen()))
////                        || (marca.getLogo() != null && linea.contains(marca.getLogo()))
//                                ){
//                            //System.out.println("Se ha localizado la marca " + marca + " en el indice " + indice);
//                            linea = linea.substring(8);
//                            String nombre = linea.substring(0, linea.indexOf(" "));
//                            String origen = linea.substring(linea.indexOf("Origen:") + 8, linea.indexOf(" | Logo"));
//                            String logo = linea.substring(linea.indexOf("Logo:") + 6, linea.indexOf(" -"));
//                            Marca datos = new Marca(nombre, origen, logo);
//                            marcas.add(datos);
//                            
//                            break;
//                        }
//                        indice++;
//                        linea = search.readLine();
                    }
                    search.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo marcas!" + ex.getMessage());
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo marcas!" + ex.getMessage());
                }
                return object;
            }
            case IAccionesComerciales.ARCHIVO_MODELOS -> {
                Modelo modelo = (Modelo) object;
                List<Modelo> modelos = new ArrayList<>();
                try {
                    BufferedReader search = new BufferedReader(new FileReader(archivo));
                    var indice = 1;
                    String linea = search.readLine();
                    while (linea != null) {
                        linea = linea.substring(18);
                        String tipoVehiculo = linea.substring(0, linea.indexOf(" "));
                        String denominacion = linea.substring(linea.indexOf("Denominacion:") + 14, linea.indexOf(" | Cantidad:"));
                        String cantidad = linea.substring(linea.indexOf("Cantidad:") + 10, linea.indexOf(" -"));
                        Modelo datos = new Modelo(tipoVehiculo, denominacion, Integer.valueOf(cantidad));
                        modelos.add(datos);
                        if (modelo.getDenominacion() != null && modelo.getDenominacion().equalsIgnoreCase(datos.getDenominacion())) {
                            object = "Se ha localizado el modelo " + datos.getDenominacion() + " en la linea " 
                                      + indice + " y hay en stock " + datos.getCantidad() + " unidades";
                            break;
                        }
                        indice++;
                        linea = search.readLine();
                    }
                    search.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo modelos!" + ex.getMessage());
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo modelos!" + ex.getMessage());
                }
                return object;
            }
            case IAccionesComerciales.ARCHIVO_CARACTERISTICAS_TEC -> {
                CaracteristicasTec caracteristica = (CaracteristicasTec) object;
                List<CaracteristicasTec> caracteristicas = new ArrayList<>();
                try {
                    BufferedReader search = new BufferedReader(new FileReader(archivo));
                    var indice = 1;
                    String linea = search.readLine();
                    while (linea != null) {
                        linea = linea.substring(8);
                        String modeloDenominacion = linea.substring(0, linea.indexOf(" "));
                        String tipoMotor = linea.substring(linea.indexOf("TipoMotor:") + 11, linea.indexOf(" | Cilindros:"));
                        String cilindros = linea.substring(linea.indexOf("Cilindros:") + 11, linea.indexOf(" | Cilindrada:"));
                        String cilindrada = linea.substring(linea.indexOf("Cilindrada:") + 12, linea.indexOf(" | HP:"));
                        String HP = linea.substring(linea.indexOf("HP:") + 4, linea.indexOf(" | Caja:"));
                        String caja = linea.substring(linea.indexOf("Caja:") + 6, linea.indexOf(" | Equipamiento:"));
                        String equipamiento = linea.substring(linea.indexOf("Equipamiento:") + 14, linea.indexOf(" | Carroceria:"));
                        String carroceria = linea.substring(linea.indexOf("Carroceria:") + 12, linea.indexOf(" | id:"));
                        String id = linea.substring(linea.indexOf("id:") + 4, linea.indexOf(" -"));
                        CaracteristicasTec detalle = new CaracteristicasTec(modeloDenominacion, tipoMotor, cilindros, Integer.valueOf(cilindrada), Integer.valueOf(HP), caja, equipamiento, carroceria, id);
                        caracteristicas.add(detalle);
                        if (caracteristica.getModeloDenominacion() != null && caracteristica.getModeloDenominacion().equalsIgnoreCase(detalle.getModeloDenominacion())) {
                            object = "El modelo " + caracteristica.getModeloDenominacion() + " que se encuentra en el indice " + indice + " tiene las siguientes caracteristicas: " 
                                    + detalle.getTipoMotor() + " | " 
                                    + detalle.getCilindros() + " | " 
                                    + detalle.getCilindrada() + " | " 
                                    + detalle.getHP() + " | " 
                                    + detalle.getCaja() + " | " 
                                    + detalle.getEquipamiento() + " | " 
                                    + detalle.getCarroceria() + " | " 
                                    + detalle.getId();
                            break;
                        }
                        indice++;
                        linea = search.readLine();
                    }
                    search.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo caracteristicas tecnicas!" + ex.getMessage());
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo caracteristicas tecnicas!" + ex.getMessage());
                }
                return object;
            }
            case IAccionesComerciales.ARCHIVO_DISTRIBUIDORES -> {
                Distribuidor distribuidor = (Distribuidor) object;
                List<Distribuidor> distribuidores = new ArrayList<>();
                try {
                    BufferedReader search = new BufferedReader(new FileReader(archivo));
                    var indice = 1;
                    String linea = search.readLine();
                    while (linea != null) {
                        linea = linea.substring(8);
                        String nombreDistribuidor = linea.substring(0, linea.indexOf(" | "));
                        String pais = linea.substring(linea.indexOf("Pais:") + 6, linea.indexOf(" -"));
                        Distribuidor datos = new Distribuidor(nombreDistribuidor, pais);
                        distribuidores.add(datos);
                        if (distribuidor.getNombreDistribuidor() != null && distribuidor.getNombreDistribuidor().equalsIgnoreCase(datos.getNombreDistribuidor())) {
                            object = "El distribuidor " + distribuidor.getNombreDistribuidor() + " se encuentra en el indice " + indice + " y se localiza en " + datos.getPais();
                            break;
                        }
                        indice++;
                        linea = search.readLine();
                    }
                    search.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo modelos!" + ex.getMessage());
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo modelos!" + ex.getMessage());
                }
                return object;
            }
            case IAccionesComerciales.ARCHIVO_AGENCIAS -> {
                Agencia agencia = (Agencia) object;
                List<Agencia> agencias = new ArrayList<>();
                try {
                    BufferedReader search = new BufferedReader(new FileReader(archivo));
                    var indice = 1;
                    String linea = search.readLine();
                    while (linea != null) {
                        linea = linea.substring(8);
                        String nombreAgencia = linea.substring(0, linea.indexOf(" | "));
                        String ciudad = linea.substring(linea.indexOf("Ciudad:") + 8, linea.indexOf(" | Marca:"));
                        String marcaComercializada = linea.substring(linea.indexOf("Marca:") + 7, linea.indexOf(" -"));
                        Agencia datos = new Agencia(nombreAgencia, ciudad, marcaComercializada);
                        agencias.add(datos);
                        if (agencia.getNombreAgencia() != null && agencia.getNombreAgencia().equalsIgnoreCase(datos.getNombreAgencia())) {
                            object = "La agencia " + datos.getNombreAgencia() + " que se encuentra en el indice " 
                                    + indice + ", se localiza en la ciudad de " + datos.getCiudad() 
                                    + " y comercializa la marca " + datos.getMarcaComercializada();
                            break;
                        }
                        indice++;
                        linea = search.readLine();
                    }
                    search.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo modelos!" + ex.getMessage());
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo modelos!" + ex.getMessage());
                }
                return object;
            }
            default -> {
                System.out.println("La opcion ingresada no exitste, ingrese una opcion valida!");
            }
        }
        return object;
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            archivo.delete();
        }
    }
}
