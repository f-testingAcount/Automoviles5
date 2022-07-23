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
                        modelo = new Modelo(tipoVehiculo, denominacion, modelo.getCantidad());
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
                        caracteristica =  new CaracteristicasTec(modeloDenominacion, tipoMotor, cilindros, caracteristica.getCilindrada(),
                                                                 caracteristica.getHP(), caja, equipamiento, carroceria, id);
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
                marca = new Marca();
                List<Marca> marcas = new ArrayList<>();
                try {
                    BufferedReader search = new BufferedReader(new FileReader(archivo));
                    var indice = 1;
                    String linea = search.readLine();
                    
                    while (linea != null) {
                        if ((marca.getNombre() != null && linea.contains(marca.getNombre()))
//                        || (marca.getOrigen() != null && linea.contains(marca.getOrigen()))
//                        || (marca.getLogo() != null && linea.contains(marca.getLogo()))
                                ) 
                                
                                {
                            //System.out.println("Se ha localizado la marca " + marca + " en el indice " + indice);
                            linea = linea.substring(8);
                            String nombre = linea.substring(0, linea.indexOf(" "));
                            String origen = linea.substring(linea.indexOf("Origen:") + 8, linea.indexOf(" | Logo"));
                            String logo = linea.substring(linea.indexOf("Logo:") + 6, linea.indexOf(" -"));
                            Marca marca1 = new Marca(nombre, origen, logo);
                            marcas.add(marca1);
                            break;
                        }
                        indice++;
                        linea = search.readLine();
                    }
                    search.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo marcas!" + ex.getMessage());
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al buscar en el archivo marcas!" + ex.getMessage());
                }
                return marcas;
            }
            case IAccionesComerciales.ARCHIVO_MODELOS -> {
                Modelo modelo = (Modelo) object;
                modelo = new Modelo();
                try {
                    BufferedReader search = new BufferedReader(new FileReader(archivo));
                    var indice = 1;
                    String linea = search.readLine();
                    while (linea != null) {
                        if (modelo.getDenominacion() != null && modelo.getDenominacion().equalsIgnoreCase(linea)) {
                            System.out.println("Se ha localizado el modelo " + modelo + " en la linea " + indice);
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
                return modelo.getDenominacion();
            }
            case IAccionesComerciales.ARCHIVO_CARACTERISTICAS_TEC -> {
                CaracteristicasTec caracteristica = (CaracteristicasTec) object;
                caracteristica = new CaracteristicasTec();
                Modelo modelo = new Modelo();
                String detalle = null;
                try {
                    BufferedReader search = new BufferedReader(new FileReader(archivo));
                    var indice = 1;
                    String linea = search.readLine();
                    while (linea != null) {
                        if (caracteristica.getModeloDenominacion() != null && caracteristica.getModeloDenominacion().equalsIgnoreCase(linea)) {
                            detalle = "Las caracteristicas del modelo " + modelo.getDenominacion() + " son: " + modelo.getCaracteristicas();
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
                return detalle;
            }
            case IAccionesComerciales.ARCHIVO_DISTRIBUIDORES -> {
                Distribuidor distribuidor = (Distribuidor) object;
                distribuidor = new Distribuidor();
                try {
                    BufferedReader search = new BufferedReader(new FileReader(archivo));
                    var indice = 1;
                    String linea = search.readLine();
                    while (linea != null) {
                        if (distribuidor.getNombreDistribuidor() != null && distribuidor.getNombreDistribuidor().equalsIgnoreCase(linea)) {
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
                return distribuidor.getNombreDistribuidor();
            }
            case IAccionesComerciales.ARCHIVO_AGENCIAS -> {
                Agencia agencia = (Agencia) object;
                agencia = new Agencia();
                try {
                    BufferedReader search = new BufferedReader(new FileReader(archivo));
                    var indice = 1;
                    String linea = search.readLine();
                    while (linea != null) {
                        if (agencia.getNombreAgencia() != null && agencia.getNombreAgencia().equalsIgnoreCase(linea)) {
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
                return agencia.getNombreAgencia();
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
