package com.user.datos;

import com.user.domain.Agencia;
import com.user.domain.CaracteristicasTec;
import com.user.domain.Distribuidor;
import com.user.domain.Marca;
import com.user.domain.Modelo;
import com.user.exceptions.AccesoDatosEx;
import com.user.negocios.IAccionesComerciales;
import static com.user.negocios.IAccionesComerciales.ARCHIVO_MARCAS;
import java.io.*;
import java.util.*;


public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        switch (nombreArchivo) {
            case ARCHIVO_MARCAS:
                try {
                PrintWriter createFile = new PrintWriter(new FileWriter(archivo));
                System.out.println("Se ha creado el archivo " + nombreArchivo + "!");
                createFile.close();
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
                throw new AccesoDatosEx("Error al crear el archivo marcas!" + ex.getMessage());
            }
            break;
            case IAccionesComerciales.ARCHIVO_MODELOS:
                try {
                PrintWriter createFile = new PrintWriter(new FileWriter(archivo));
                System.out.println("Se ha creado el archivo " + nombreArchivo + "!");
                createFile.close();
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
                throw new AccesoDatosEx("Error al crear el archivo modelos!" + ex.getMessage());
            }
            break;
            case IAccionesComerciales.ARCHIVO_CARACTERISTICAS_TEC:
                try {
                PrintWriter createFile = new PrintWriter(new FileWriter(archivo));
                System.out.println("Se ha creado el archivo " + nombreArchivo + "!");
                createFile.close();
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
                throw new AccesoDatosEx("Error al crear el archivo caracteristicas tecnicas!" + ex.getMessage());
            }
            break;
            case IAccionesComerciales.ARCHIVO_DISTRIBUIDORES:
                try {
                PrintWriter createFile = new PrintWriter(new FileWriter(archivo));
                System.out.println("Se ha creado el archivo " + nombreArchivo + "!");
                createFile.close();
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
                throw new AccesoDatosEx("Error al crear el archivo distribuidores!" + ex.getMessage());
            }
            break;
            case IAccionesComerciales.ARCHIVO_AGENCIAS:
                try {
                PrintWriter createFile = new PrintWriter(new FileWriter(archivo));
                System.out.println("Se ha creado el archivo " + nombreArchivo + "!");
                createFile.close();
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
                throw new AccesoDatosEx("Error al crear el archivo agencias!" + ex.getMessage());
            }
            break;
            default:
                break;
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
                Marca marca = new Marca();
                try {
                    PrintWriter write = new PrintWriter(new FileWriter(archivo, true));
                    write.println(marca.toString());
                    write.close();
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                    throw new AccesoDatosEx("Error al escribir en el archivo marcas!" + ex.getMessage());
                }
            }
            case IAccionesComerciales.ARCHIVO_MODELOS -> {
                Modelo modelo = new Modelo();
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
                CaracteristicasTec caracteristica = new CaracteristicasTec();
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
                Distribuidor distribuidor = new Distribuidor();
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
                Agencia agencia = new Agencia();
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
            }
        }
    }

    @Override
    public List listar(Object object, String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        switch (nombreArchivo) {
            case ARCHIVO_MARCAS -> {
                List<Marca> marcas = new ArrayList<>();
                try {
                    BufferedReader leer = new BufferedReader(new FileReader(archivo));
                    String linea = leer.readLine();
                    while (linea != null) {
                        Marca marca = new Marca();
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
                List<Modelo> modelos = new ArrayList<>();
                try {
                    BufferedReader leer = new BufferedReader(new FileReader(archivo));
                    String linea = leer.readLine();
                    while (linea != null) {
                        Modelo modelo = new Modelo();
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
                List<CaracteristicasTec> caracteristicas = new ArrayList<>();
                try {
                    BufferedReader leer = new BufferedReader(new FileReader(archivo));
                    String linea = leer.readLine();
                    while (linea != null) {
                        CaracteristicasTec caracteristica = new CaracteristicasTec();
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
                        Distribuidor distribuidor = new Distribuidor();
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
                        Agencia agencia = new Agencia();
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
                Marca marca = new Marca();
                try {
                    BufferedReader search = new BufferedReader(new FileReader(archivo));
                    var indice = 1;
                    String linea = search.readLine();
                    while (linea != null) {
                        if (marca.getNombre() != null && marca.getNombre().equalsIgnoreCase(linea)) {
                            System.out.println("Se ha localizado la marca " + marca + " en el indice " + indice);
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
                return marca.getNombre();
            }
            case IAccionesComerciales.ARCHIVO_MODELOS -> {
                Modelo modelo = new Modelo();
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
                CaracteristicasTec caracteristica = new CaracteristicasTec();
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
                Distribuidor distribuidor = new Distribuidor();
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
                Agencia agencia = new Agencia();
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
            }
        }
        return object;
    }

    @Override
    public int buscarIndice(String nombreArchivo, Object object) throws AccesoDatosEx {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            archivo.delete();
        }
    }

}
