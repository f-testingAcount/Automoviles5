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
                    System.out.println("Se ha modificado el archivo " + nombreArchivo + "!");
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

//    @Override
//    public void sobreEscribir(String nombreArchivo, Modelo modelo, String modeloDenominacion) throws AccesoDatosEx {
//        File archivo = new File(nombreArchivo);
//        try {
//            BufferedReader leer = new BufferedReader(new FileReader(archivo));
//            String linea = leer.readLine();
//            while (linea != null) {
//                linea = linea.substring(18);
//                String tipoVehiculo = linea.substring(0, linea.indexOf(" "));
//                String denominacion = linea.substring(linea.indexOf("Denominacion:") + 14, linea.indexOf(" | Cantidad:"));
//                String cantidad = linea.substring(linea.indexOf("Cantidad:") + 10, linea.indexOf(" -"));
//                Modelo datos = new Modelo(tipoVehiculo, denominacion, Integer.valueOf(cantidad) - 1);
//                if (modeloDenominacion.equals(datos.getDenominacion())) {
//                    PrintWriter write = new PrintWriter(new FileWriter(archivo, true));
//                    write.println(modelo.toString());
//                    write.close();
//                    break;
//                }
//                linea = leer.readLine();
//            }
//            leer.close();
//        } catch (FileNotFoundException ex) {
//            ex.printStackTrace(System.out);
//            throw new AccesoDatosEx("Error al sobre escribir en el archivo modelo!" + ex.getMessage());
//        } catch (IOException ex) {
//            ex.printStackTrace(System.out);
//            throw new AccesoDatosEx("Error al sobre escribir en el archivo modelo!" + ex.getMessage());
//        }
//    }
//    
    @Override
    public void modificarDatoEnArchivo(String nombreArchivo, List modelos) throws AccesoDatosEx {
        File archivo = new File(ARCHIVO_MODELOS);
        this.borrar(ARCHIVO_MODELOS);
        this.crear(ARCHIVO_MODELOS);
        for (int i = 0; i < modelos.size(); i++) {
            this.escribir(modelos.get(i), ARCHIVO_MODELOS);
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
                        linea = linea.substring(8);
                        String nombre = linea.substring(0, linea.indexOf(" | "));
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
                List<Modelo> modelos = new ArrayList<>();
                try {
                    BufferedReader leer = new BufferedReader(new FileReader(archivo));
                    String linea = leer.readLine();
                    while (linea != null) {
                        linea = linea.substring(7);
                        String nombreMarca = linea.substring(0, linea.indexOf(" | "));
                        String tipoVehiculo = linea.substring(linea.indexOf("Tipo de Vehiculo:") + 18, linea.indexOf(" | Denominacion"));
                        String denominacion = linea.substring(linea.indexOf("Denominacion:") + 14, linea.indexOf(" | Cantidad:"));
                        String cantidad = linea.substring(linea.indexOf("Cantidad:") + 10, linea.indexOf(" -"));
                        Modelo modelo = new Modelo(nombreMarca, tipoVehiculo, denominacion, Integer.valueOf(cantidad));
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
                        linea = linea.substring(8);
                        String modeloDenominacion = linea.substring(0, linea.indexOf(" | "));
                        String tipoMotor = linea.substring(linea.indexOf("TipoMotor:") + 11, linea.indexOf(" | Cilindros:"));
                        String cilindros = linea.substring(linea.indexOf("Cilindros:") + 11, linea.indexOf(" | Cilindrada"));
                        String cilindrada = linea.substring(linea.indexOf("Cilindrada:") + 12, linea.indexOf(" | HP"));
                        String hp = linea.substring(linea.indexOf("HP:") + 4, linea.indexOf(" | Caja"));
                        String caja = linea.substring(linea.indexOf("Caja:") + 6, linea.indexOf(" | Equipamiento:"));
                        String equipamiento = linea.substring(linea.indexOf("Equipamiento:") + 14, linea.indexOf(" | Carroceria"));
                        String carroceria = linea.substring(linea.indexOf("Carroceria:") + 12, linea.indexOf(" | id"));
                        String id = linea.substring(linea.indexOf("id:") + 4, linea.indexOf(" -"));
                        CaracteristicasTec caracteristica = new CaracteristicasTec(modeloDenominacion, tipoMotor, cilindros, Integer.valueOf(cilindrada),
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
                        linea = linea.substring(8);
                        String nombreDistribuidor = linea.substring(0, linea.indexOf(" | "));
                        String pais = linea.substring(linea.indexOf("Pais:") + 6, linea.indexOf(" | Marca Distribuida:"));
                        String marcaDistribuida = linea.substring(linea.indexOf("Marca Distribuida:") + 19, linea.indexOf(" -"));
                        Distribuidor distribuidor = new Distribuidor(nombreDistribuidor, pais, marcaDistribuida);
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
                try {
                    BufferedReader search = new BufferedReader(new FileReader(archivo));
                    var indice = 1;
                    String linea = search.readLine();
                    boolean encontrado = false;
                    while (linea != null) {
                        linea = linea.substring(8);
                        String nombre = linea.substring(0, linea.indexOf(" "));
                        String origen = linea.substring(linea.indexOf("Origen:") + 8, linea.indexOf(" | Logo"));
                        String logo = linea.substring(linea.indexOf("Logo:") + 6, linea.indexOf(" -"));
                        Marca datos = new Marca(nombre, origen, logo);
                        if (marca.getNombre() != null && marca.getNombre().equalsIgnoreCase(datos.getNombre())) {
                            object = "La marca " + marca.getNombre() + " se encuentra en el indice "
                                    + indice + " es de origen " + datos.getOrigen() + " y el logo es " + datos.getLogo();
                            encontrado = true;
                            break;
                        }
                        indice++;
                        linea = search.readLine();
                    }
                    if (marca.getNombre() == null || encontrado == false) {
                        System.out.println("La20"
                                + " marca indicada no esta registrada en este archivo o no existe!, Si desea buscar otra marca inicie nuevamente la busqueda");
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
                try {
                    BufferedReader search = new BufferedReader(new FileReader(archivo));
                    var indice = 1;
                    String linea = search.readLine();
                    boolean encontrado = false;
                    while (linea != null) {
                        linea = linea.substring(18);
                        String tipoVehiculo = linea.substring(0, linea.indexOf(" "));
                        String denominacion = linea.substring(linea.indexOf("Denominacion:") + 14, linea.indexOf(" | Cantidad:"));
                        String cantidad = linea.substring(linea.indexOf("Cantidad:") + 10, linea.indexOf(" -"));
                        Modelo datos = new Modelo(tipoVehiculo, denominacion, Integer.valueOf(cantidad));
                        if (modelo.getDenominacion() != null && modelo.getDenominacion().equalsIgnoreCase(datos.getDenominacion())) {
                            object = "Se ha localizado el modelo " + datos.getDenominacion() + " en el indice "
                                    + indice + " y hay en stock " + datos.getCantidad() + " unidades";
                            encontrado = true;
                            break;
                        }
                        indice++;
                        linea = search.readLine();
                    }
                    if (modelo.getDenominacion() == null || encontrado == false) {
                        System.out.println("El modelo indicado no esta registrada en este achivo o no existe!, Si desea buscar otro modelo inicie nuevamente la busqueda");
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
                try {
                    BufferedReader search = new BufferedReader(new FileReader(archivo));
                    var indice = 1;
                    String linea = search.readLine();
                    boolean encontrado = false;
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
                            encontrado = true;
                            break;
                        }
                        indice++;
                        linea = search.readLine();
                    }
                    if (caracteristica.getModeloDenominacion() == null || encontrado == false) {
                        System.out.println("El modelo indicado esta registrado en este archivo o no existe!, Si desea buscar otro modelo ingreselo nuevamente");
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
                try {
                    BufferedReader search = new BufferedReader(new FileReader(archivo));
                    var indice = 1;
                    String linea = search.readLine();
                    boolean encontrado = false;
                    while (linea != null) {
                        linea = linea.substring(8);
                        String nombreDistribuidor = linea.substring(0, linea.indexOf(" | "));
                        String pais = linea.substring(linea.indexOf("Pais:") + 6, linea.indexOf(" | Marca Distribuida:"));
                        String marcaDistribuida = linea.substring(linea.indexOf("Marca Distribuida:") + 19, linea.indexOf(" -"));
                        Distribuidor datos = new Distribuidor(nombreDistribuidor, pais, marcaDistribuida);
                        if (distribuidor.getNombreDistribuidor() != null && distribuidor.getNombreDistribuidor().equalsIgnoreCase(datos.getNombreDistribuidor())) {
                            object = "El distribuidor " + distribuidor.getNombreDistribuidor() + " se encuentra en el indice " + indice + " y se localiza en " + datos.getPais();
                            encontrado = true;
                            break;
                        }
                        indice++;
                        linea = search.readLine();
                    }
                    if (distribuidor.getNombreDistribuidor() == null || encontrado == false) {
                        System.out.println("El distribuidor indicado no esta registrado en este archivo o no existe!, Si desea buscar otro distribuidor inicie nuevamente la busqueda");
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
                try {
                    BufferedReader search = new BufferedReader(new FileReader(archivo));
                    var indice = 1;
                    String linea = search.readLine();
                    boolean encontrado = false;
                    while (linea != null) {
                        linea = linea.substring(8);
                        String nombreAgencia = linea.substring(0, linea.indexOf(" | "));
                        String ciudad = linea.substring(linea.indexOf("Ciudad:") + 8, linea.indexOf(" | Marca:"));
                        String marcaComercializada = linea.substring(linea.indexOf("Marca:") + 7, linea.indexOf(" -"));
                        Agencia datos = new Agencia(nombreAgencia, ciudad, marcaComercializada);
                        if (agencia.getNombreAgencia() != null && agencia.getNombreAgencia().equalsIgnoreCase(datos.getNombreAgencia())) {
                            object = "La agencia " + datos.getNombreAgencia() + " que se encuentra en el indice "
                                    + indice + ", se localiza en la ciudad de " + datos.getCiudad()
                                    + " y comercializa la marca " + datos.getMarcaComercializada();
                            encontrado = true;
                            break;
                        }
                        indice++;
                        linea = search.readLine();
                    }
                    if (agencia.getNombreAgencia() == null || encontrado == false) {
                        System.out.println("La agencia indicada no esta registrada en este archivo o no existe!, Si desea buscar otra agencia inicie nuevamente la busqueda");
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
    public int buscarIndice(String nombreArchivo, Object object, String modeloDenominacion) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        Modelo modelo = (Modelo) object;
        int indice = 0;
        boolean encontrado = false;
        try {
            BufferedReader leer = new BufferedReader(new FileReader(archivo));
            String linea = leer.readLine();
            indice = 1;
            while (linea != null) {
                linea = linea.substring(7);
                String nombreMarca = linea.substring(0, linea.indexOf(" | "));
                String tipoVehiculo = linea.substring(linea.indexOf("Tipo de Vehiculo:") + 18, linea.indexOf(" | Denominacion"));
                String denominacion = linea.substring(linea.indexOf("Denominacion:") + 14, linea.indexOf(" | Cantidad:"));
                String cantidad = linea.substring(linea.indexOf("Cantidad:") + 10, linea.indexOf(" -"));
                Modelo datos = new Modelo(denominacion);
                if (modelo.getDenominacion() != null && modelo.getDenominacion().equalsIgnoreCase(datos.getDenominacion())) {
                    encontrado = true;
                    break;
                }
                indice++;
                linea = leer.readLine();
            }
            leer.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al buscar indice en el archivo modelos!" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al buscar en el archivo modelos!" + ex.getMessage());
        }
        return indice;
    }

//    @Override
//    public boolean modeloExiste(String nombreArchivo, String nombreMarca, String denominacionModelo) throws AccesoDatosEx {
//        File archivo = new File(nombreArchivo);
//        boolean marcaNombre = false;
//        boolean modeloDenominacion = false;
//        boolean existe = false;
//        if (nombreArchivo.equalsIgnoreCase(ARCHIVO_MARCAS)) {
//            Marca marca = new Marca();
//            this.buscar(nombreArchivo, marca);
//            if (marca.getNombre().equalsIgnoreCase(nombreMarca)) {
//                marcaNombre = true;
//            }
//        }
//        if (nombreArchivo.equalsIgnoreCase(ARCHIVO_MODELOS)) {
//            Modelo modelo = new Modelo();
//            this.buscar(nombreArchivo, modelo);
//            if (modelo.getDenominacion().equalsIgnoreCase(denominacionModelo)) {
//                modeloDenominacion = true;
//            }
//        }
//        if (marcaNombre == true && modeloDenominacion == true) {
//            existe = true;
//        }
//        return existe;
//    }

    @Override
    public Integer stockModelo(String nombreArchivo, String denominacionModelo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        int stock = 0;
        boolean existencia = false;
        try {
            BufferedReader leer = new BufferedReader(new FileReader(archivo));
            String linea = leer.readLine();
            while (linea != null) {
                linea = linea.substring(7);
                        String nombreMarca = linea.substring(0, linea.indexOf(" | "));
                        String tipoVehiculo = linea.substring(linea.indexOf("Tipo de Vehiculo:") + 18, linea.indexOf(" | Denominacion"));
                        String denominacion = linea.substring(linea.indexOf("Denominacion:") + 14, linea.indexOf(" | Cantidad:"));
                        String cantidad = linea.substring(linea.indexOf("Cantidad:") + 10, linea.indexOf(" -"));
                        Modelo datos = new Modelo(nombreMarca, tipoVehiculo, denominacion, Integer.valueOf(cantidad));
                if (denominacionModelo != null && denominacionModelo.equalsIgnoreCase(datos.getDenominacion())
                        && datos.getCantidad() > 0) {
                    stock = datos.getCantidad();
                    existencia = true;
                    System.out.println("Del modelo " + denominacionModelo + " hay en existencia " + datos.getCantidad() + " unidades.");
                    break;
                } else if (denominacionModelo != null && denominacionModelo.equalsIgnoreCase(datos.getDenominacion())
                        && datos.getCantidad() == 0) {
                    existencia = true;
                    System.out.println("Del modelo " + denominacionModelo + " hay en existencia " + datos.getCantidad() + " unidades.");
                }
                linea = leer.readLine();
            }
            if (existencia == false) {
                System.out.println("El modelo no se encuentra en la lista!");
            }
            leer.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al buscar en el archivo modelos!" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al buscar en el archivo modelos!" + ex.getMessage());
        }
        return stock;
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            archivo.delete();
        }
    }
}
