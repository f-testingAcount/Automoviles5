package com.user.negocios;

import com.user.datos.*;
import com.user.domain.*;
import com.user.exceptions.AccesoDatosEx;
import com.user.negocios.*;
import java.util.List;


public class AccionesComercialesImpl implements IAccionesComerciales {

    IAccesoDatos datos;

    public AccionesComercialesImpl() {
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void iniciarArchivo() {
        try {
            if (this.datos.existe(ARCHIVO_MARCAS)) {
                System.out.println("El archivo Marcas ya existe!");

            } else {
                this.datos.crear(ARCHIVO_MARCAS);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar archivo Marcas!");
            ex.printStackTrace(System.out);
        }
        try {
            if (this.datos.existe(ARCHIVO_MODELOS)) {
                System.out.println("El archivo Modelos ya existe!");

            } else {
                this.datos.crear(ARCHIVO_MODELOS);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar archivo Modelos!");
            ex.printStackTrace(System.out);
        }
        try {
            if (this.datos.existe(ARCHIVO_CARACTERISTICAS_TEC)) {
                System.out.println("El archivo Caracteristicas Tecnicas ya existe!");

            } else {
                this.datos.crear(ARCHIVO_CARACTERISTICAS_TEC);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar archivo Caracteristicas Tecnicas!");
            ex.printStackTrace(System.out);
        }
        try {
            if (this.datos.existe(ARCHIVO_DISTRIBUIDORES)) {
                System.out.println("El archivo Distribuidores ya existe!");

            } else {
                this.datos.crear(ARCHIVO_DISTRIBUIDORES);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar archivo Distribuidores!");
            ex.printStackTrace(System.out);
        }
        try {
            if (this.datos.existe(ARCHIVO_AGENCIAS)) {
                System.out.println("El archivo Agencias ya existe!");
            } else {
                this.datos.crear(ARCHIVO_AGENCIAS);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar archivo Agencias!");
            ex.printStackTrace(System.out);
        }
    }
    
    @Override
    public void agregar(String nombreArchivo, Object object){
        if (nombreArchivo.equalsIgnoreCase("Marcas.txt")) {
            Marca marca = null;
            marca = new Marca(marca.getNombre(), marca.getOrigen(), marca.getLogo());
            boolean anexar = false;
            try {
                if (anexar = datos.existe(ARCHIVO_MARCAS)) {
                    this.datos.escribir(marca, ARCHIVO_MARCAS);
                    System.out.println("Se agrego una marca al archivo marcas!");
                } else {
                    System.out.println("El archivo Marcas no existe!");
                }
            } catch (AccesoDatosEx ex) {
                System.out.println("Error al agregar marca!");
                ex.printStackTrace(System.out);
            }
        } else if (nombreArchivo.equals("Modelos.txt")) {
            Modelo modelo = null;
            modelo = new Modelo(modelo.getTipoVehiculo(),
                                modelo.getDenominacion(),
                                modelo.getCantidad());
            boolean anexar = false;
            try {
                if (anexar = datos.existe(ARCHIVO_MODELOS)) {
                    this.datos.escribir(modelo, ARCHIVO_MODELOS);
                } else {
                    System.out.println("El archivo modelos no existe!");
                }
            } catch (AccesoDatosEx ex) {
                System.out.println("Error al agregar modelo!");
                ex.printStackTrace(System.out);
            }
        } else if (nombreArchivo.equalsIgnoreCase("Caracteristicas Tecnicas.txt")) {
            CaracteristicasTec caracteristica = null;
            caracteristica = new CaracteristicasTec(caracteristica.getTipoMotor(),
                                                    caracteristica.getCilindros(),
                                                    caracteristica.getCilindrada(),
                                                    caracteristica.getHP(),
                                                    caracteristica.getCaja(),
                                                    caracteristica.getEquipamiento(),
                                                    caracteristica.getCarroceria(),
                                                    caracteristica.getId(),
                                                    caracteristica.getModeloDenominacion());
            boolean anexar = false;
            try {
                if (anexar = datos.existe(ARCHIVO_CARACTERISTICAS_TEC)) {
                    this.datos.escribir(caracteristica, ARCHIVO_CARACTERISTICAS_TEC);
                } else {
                    System.out.println("El archivo caracteristicas tecnicas no existe!");
                }
            } catch (AccesoDatosEx ex) {
                System.out.println("Error al agregar caracteristica tecnica!");
                ex.printStackTrace(System.out);
            }
        } else if (nombreArchivo.equalsIgnoreCase("Distribuidores.txt")) {
            Distribuidor distribuidor = null;
            distribuidor = new Distribuidor(distribuidor.getNombreDistribuidor(), ARCHIVO_DISTRIBUIDORES);
            boolean anexar = false;
            try {
                if (anexar = datos.existe(ARCHIVO_DISTRIBUIDORES)) {
                    this.datos.escribir(distribuidor, ARCHIVO_DISTRIBUIDORES);
                } else {
                    System.out.println("El archivo distribuidores no existe!");
                }
            } catch (AccesoDatosEx ex) {
                System.out.println("Error al agregar distribuidor!");
                ex.printStackTrace(System.out);
            }
        } else if (nombreArchivo.equalsIgnoreCase("Agencias.txt")) {
            Agencia agencia = null;
            agencia = new Agencia(agencia.getNombreAgencia(),
                                  agencia.getCiudad(),
                                  agencia.getMarcaComercializada());
            boolean anexar = false;
            try {
                if (anexar = datos.existe(ARCHIVO_AGENCIAS)) {
                    this.datos.escribir(agencia, ARCHIVO_AGENCIAS);
                } else {
                    System.out.println("El archivo agencia no existe!");
                }
            } catch (AccesoDatosEx ex) {
                System.out.println("Error al agregar agencia!");
                ex.printStackTrace(System.out);
            }            
        }
    }

//    @Override
//    public void agregarMarca(String nombreArchivo, String nombre, String origen, String logo) {
//        Marca marca = new Marca(nombre, origen, logo);
//        boolean anexar = false;
//        try {
//            if (anexar = datos.existe(ARCHIVO_MARCAS)) {
//                this.datos.escribir(marca, nombreArchivo);
//            } else {
//                System.out.println("El archivo Marcas no exixte!");
//            }
//        } catch (AccesoDatosEx ex) {
//            System.out.println("Error al agregar marca!");
//            ex.printStackTrace(System.out);
//        }
//    }
//    
//    

//    @Override
//    public void agregarModelos(String nombreArchivo, String tipoVehiculo, String denominacion, int cantidad) {
//        Modelo modelo = new Modelo(tipoVehiculo, denominacion, cantidad);
//        boolean anexar = false;
//        try {
//            if (anexar = this.datos.existe(ARCHIVO_MODELOS)) {
//                this.datos.escribir(modelo, nombreArchivo);
//            } else {
//                System.out.println("El archivo Modelos no existe!");
//            }
//        } catch (AccesoDatosEx ex) {
//            System.out.println("Error al agregar marca!");
//            ex.printStackTrace(System.out);
//        }
//
//    }
//
//    @Override
//    public void agregarCaracteristicasTecnicas(String nombreArchivo, String tipoMotor, String cilindros, 
//            int cilindrada, int HP, String caja, String equipamiento, String carroceria, 
//            String id, String modeloDenominacion) {
//        CaracteristicasTec caracteristica = new CaracteristicasTec(tipoMotor, cilindros, cilindrada, HP, 
//                caja, equipamiento, carroceria, id, modeloDenominacion);
//        try {
//            if (this.datos.existe(ARCHIVO_CARACTERISTICAS_TEC)) {
//                this.datos.escribir(caracteristica, nombreArchivo);
//            } else {
//                System.out.println("El archivo caracteristicas tecnicas no existe!");
//            }
//        } catch (AccesoDatosEx ex) {
//            System.out.println("Error al agregar caracteristicas tecnicas!");
//            ex.printStackTrace(System.out);
//        }
//    }
//
//    @Override
//    public void agregarDistribuidor(String nombreArchivo, String nombreDistribuidor, String pais) {
//        Distribuidor distribuidor = new Distribuidor(nombreDistribuidor, pais);
//        try {
//            if (this.datos.existe(ARCHIVO_DISTRIBUIDORES)) {
//                this.datos.escribir(distribuidor, nombreArchivo);
//            } else {
//                System.out.println("El archivo distribuidores no existe!");
//            }
//        } catch (AccesoDatosEx ex) {
//            System.out.println("Error al agregar distribuidor!");
//            ex.printStackTrace(System.out);
//        }
//    }
//
//    @Override
//    public void agregarAgencia(String nombreArchivo, String nombreAgencia, String ciudad, String marcaComercializada) {
//        Agencia agencia = new Agencia(nombreAgencia, ciudad, marcaComercializada);
//        try {
//            if (this.datos.existe(ARCHIVO_AGENCIAS)) {
//                this.datos.escribir(agencia, nombreArchivo);
//            } else {
//                System.out.println("El archivo agencias no existe!");
//            }
//        } catch (AccesoDatosEx ex) {
//            System.out.println("Error al agregar agencia!");
//            ex.printStackTrace(System.out);
//        }
//    }

    @Override
    public void listarArchivo(String nombreArchivo) {
        switch (nombreArchivo) {
            case ARCHIVO_MARCAS -> {
                try {
                    List<Marca> marcas = this.datos.listar(this, ARCHIVO_MARCAS);
                } catch (AccesoDatosEx ex) {
                    System.out.println("Error al listar marcas!");
                    ex.printStackTrace(System.out);
                }
            }              
            case ARCHIVO_MODELOS -> {
                try {
                    List<Modelo> modelos = this.datos.listar(this, ARCHIVO_MODELOS);
                    System.out.println(modelos);
                } catch (AccesoDatosEx ex) {
                    System.out.println("Error al listar modelos!");
                    ex.printStackTrace(System.out);
                }
            }
            case ARCHIVO_CARACTERISTICAS_TEC -> {
                try {
                    List<CaracteristicasTec> caracteristicas = this.datos.listar(this, ARCHIVO_CARACTERISTICAS_TEC);
                    System.out.println(caracteristicas);
                } catch (AccesoDatosEx ex) {
                    System.out.println("Error al listar caracteristicas tecnicas!");
                    ex.printStackTrace(System.out);
                }
            }
            case ARCHIVO_DISTRIBUIDORES -> {
                try {
                    List<Distribuidor> distribuidores = this.datos.listar(this, ARCHIVO_DISTRIBUIDORES);
                    System.out.println(distribuidores);
                } catch (AccesoDatosEx ex) {
                    System.out.println("Error al listar distribuidores!");
                    ex.printStackTrace(System.out);
                }
            }
            case ARCHIVO_AGENCIAS -> {
                try {
                    List<Agencia> agencias = this.datos.listar(this, ARCHIVO_AGENCIAS);
                    System.out.println(agencias);
                } catch (AccesoDatosEx ex) {
                    System.out.println("Error al listar agencias!");
                    ex.printStackTrace(System.out);
                }
            }
            default -> {
                System.out.println("El archivo no pertenece a esta lista!");
            }
        }
    }

    @Override
    public void enviarPedidoAFabricante(Marca marca, int unidades) {
        //En vase al stock con que cuenta el distribuidor solicitar mas unidades.
    }

    @Override
    public void venderVehiculo(Modelo modelo) {
        try {
            Modelo modeloEncontrado = (Modelo) datos.buscar(ARCHIVO_MODELOS, modelo.getDenominacion());
            if (modeloEncontrado != null) {
                modeloEncontrado.setCantidad(modeloEncontrado.getCantidad() - 1);
                System.out.println("Se ha vendido un vehiculo!");
                System.out.println("Quedan en stock del modelo " + modelo + " " + modelo.getCantidad());
            } else {
                //Pedir stock al fabricante
                System.out.println("No hay stock del modelo solicitado! Enviar pedido a distribuidor!");
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al vender vehiculo!");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void ingresarAlService(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void enviarUnidadesAAgencia(Marca marca, Modelo modelo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void borrarArchivo(String nombreArchivo) {
        try {
            if (this.datos.existe(nombreArchivo)) {
                this.datos.borrar(nombreArchivo);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al borrar el archivo");
            ex.printStackTrace(System.out);
        }
    }
}
