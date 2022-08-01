package com.user.negocios;

import com.user.datos.*;
import com.user.domain.*;
import com.user.exceptions.AccesoDatosEx;
import com.user.negocios.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public void agregar(String nombreArchivo, Object object) {
        if (nombreArchivo.equalsIgnoreCase("Marcas.txt")) {
            Marca marca = (Marca) object;
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
        } else if (nombreArchivo.equalsIgnoreCase("Modelos.txt")) {
            Modelo modelo = (Modelo) object;
            modelo = new Modelo(modelo.getNombreMarca(), modelo.getTipoVehiculo(),
                    modelo.getDenominacion(),
                    modelo.getCantidad());
            boolean anexar = false;
            try {
                if (anexar = datos.existe(ARCHIVO_MODELOS)) {
                    this.datos.escribir(modelo, ARCHIVO_MODELOS);
                    System.out.println("Se agrego un modelo al archivo modelos!");
                } else {
                    System.out.println("El archivo modelos no existe!");
                }
            } catch (AccesoDatosEx ex) {
                System.out.println("Error al agregar modelo!");
                ex.printStackTrace(System.out);
            }
        } else if (nombreArchivo.equalsIgnoreCase("Caracteristicas Tecnicas.txt")) {
            CaracteristicasTec caracteristica = (CaracteristicasTec) object;
            caracteristica = new CaracteristicasTec(caracteristica.getModeloDenominacion(),
                    caracteristica.getTipoMotor(),
                    caracteristica.getCilindros(),
                    caracteristica.getCilindrada(),
                    caracteristica.getHP(),
                    caracteristica.getCaja(),
                    caracteristica.getEquipamiento(),
                    caracteristica.getCarroceria(),
                    caracteristica.getId());

            boolean anexar = false;
            try {
                if (anexar = datos.existe(ARCHIVO_CARACTERISTICAS_TEC)) {
                    this.datos.escribir(caracteristica, ARCHIVO_CARACTERISTICAS_TEC);
                    System.out.println("Se agrego una caracteristica al archivo caracteristicas tecnicas!");
                } else {
                    System.out.println("El archivo caracteristicas tecnicas no existe!");
                }
            } catch (AccesoDatosEx ex) {
                System.out.println("Error al agregar caracteristica tecnica!");
                ex.printStackTrace(System.out);
            }
        } else if (nombreArchivo.equalsIgnoreCase("Distribuidores.txt")) {
            Distribuidor distribuidor = (Distribuidor) object;
            distribuidor = new Distribuidor(distribuidor.getNombreDistribuidor(), distribuidor.getPais(), distribuidor.getMarcaDistribuida());
            boolean anexar = false;
            try {
                if (anexar = datos.existe(ARCHIVO_DISTRIBUIDORES)) {
                    this.datos.escribir(distribuidor, ARCHIVO_DISTRIBUIDORES);
                    System.out.println("Se agrego un distribuidor al archivo distribuidores!");
                } else {
                    System.out.println("El archivo distribuidores no existe!");
                }
            } catch (AccesoDatosEx ex) {
                System.out.println("Error al agregar distribuidor!");
                ex.printStackTrace(System.out);
            }
        } else if (nombreArchivo.equalsIgnoreCase("Agencias.txt")) {
            Agencia agencia = (Agencia) object;
            agencia = new Agencia(agencia.getNombreAgencia(),
                    agencia.getCiudad(),
                    agencia.getMarcaComercializada());
            boolean anexar = false;
            try {
                if (anexar = datos.existe(ARCHIVO_AGENCIAS)) {
                    this.datos.escribir(agencia, ARCHIVO_AGENCIAS);
                    System.out.println("Se agrego una agencia al archivo agencias!");
                } else {
                    System.out.println("El archivo agencia no existe!");
                }
            } catch (AccesoDatosEx ex) {
                System.out.println("Error al agregar agencia!");
                ex.printStackTrace(System.out);
            }
        }
    }

    @Override
    public void listarArchivo(String nombreArchivo, Object object) {
        switch (nombreArchivo) {
            case ARCHIVO_MARCAS -> {
                Marca marca = (Marca) object;
                try {
                    List<Marca> marcas = this.datos.listar(marca, ARCHIVO_MARCAS);
                    for (Marca detalle : marcas) {
                        System.out.println("Marca: " + detalle);
                    }
                } catch (AccesoDatosEx ex) {
                    System.out.println("Error al listar marcas!");
                    ex.printStackTrace(System.out);
                }
            }
            case ARCHIVO_MODELOS -> {
                Modelo modelo = (Modelo) object;
                try {
                    List<Modelo> modelos = this.datos.listar(modelo, ARCHIVO_MODELOS);
                    for (Modelo detalle : modelos) {
                        System.out.println("Modelo: " + detalle);
                    }
                } catch (AccesoDatosEx ex) {
                    System.out.println("Error al listar modelos!");
                    ex.printStackTrace(System.out);
                }
            }
            case ARCHIVO_CARACTERISTICAS_TEC -> {
                CaracteristicasTec caracteristica = (CaracteristicasTec) object;
                try {
                    List<CaracteristicasTec> caracteristicas = this.datos.listar(caracteristica, ARCHIVO_CARACTERISTICAS_TEC);
                    for (CaracteristicasTec detalle : caracteristicas) {
                        System.out.println("Caracteristica: " + detalle);
                    }
                } catch (AccesoDatosEx ex) {
                    System.out.println("Error al listar caracteristicas tecnicas!");
                    ex.printStackTrace(System.out);
                }
            }
            case ARCHIVO_DISTRIBUIDORES -> {
                Distribuidor distribuidor = (Distribuidor) object;
                try {
                    List<Distribuidor> distribuidores = this.datos.listar(distribuidor, ARCHIVO_DISTRIBUIDORES);
                    for (Distribuidor detalle : distribuidores) {
                        System.out.println("Distibuidor: " + detalle);
                    }
                } catch (AccesoDatosEx ex) {
                    System.out.println("Error al listar distribuidores!");
                    ex.printStackTrace(System.out);
                }
            }
            case ARCHIVO_AGENCIAS -> {
                Agencia agencia = (Agencia) object;
                try {
                    List<Agencia> agencias = this.datos.listar(agencia, ARCHIVO_AGENCIAS);
                    for (Agencia detalle : agencias) {
                        System.out.println("Agencia: " + detalle);
                    }
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
    public void venderVehiculo(String nombreArchivo, String denominacionModelo) {
        nombreArchivo = ARCHIVO_MODELOS;
        Modelo modelo = new Modelo();
        try {
            int existencia = datos.stockModelo(nombreArchivo, denominacionModelo);
            if (existencia >= 1) {
                int stock = existencia - 1;
                List<Modelo> modelos = datos.listar(modelo, ARCHIVO_MODELOS);
                for (int i = 0; i < modelos.size(); i++) {
                    if (modelos.get(i).getDenominacion().equalsIgnoreCase(denominacionModelo)) {
                        modelos.get(i).setCantidad(stock);
                        break;
                    }
                }
                datos.modificarDatoEnArchivo(ARCHIVO_MODELOS, modelos);
                System.out.println("Se ha venido un vehiculo " + denominacionModelo + " Quedan en stock " + stock + " unidades.");
            } else if(existencia == 1) {
                System.out.println("Se ha enviado pedido de reposicion de unidades a fabricante.");
            } else if (existencia == 0) {
                System.out.println("Momentaneamente no hay disponibilidad de este modelo.");
                System.out.println("Se le informara cuando haya unidades disponibles en stock.");
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al procesar venta!");
            ex.printStackTrace(System.out);
        }
    }
    
    @Override
    public void enviarRecibirPedidoDeFabricante(String nombreArchivo, Modelo modelo, String denominacionModelo, int unidadesRecibidas) {
        nombreArchivo = ARCHIVO_MODELOS;
        try {
            List<Modelo> modelos = datos.listar(modelo, ARCHIVO_MODELOS);
            var nuevoStock = unidadesRecibidas;
            for (int i = 0; i < modelos.size(); i++) {
                if (modelos.get(i).getDenominacion().equalsIgnoreCase(denominacionModelo)) {
                    if (modelos.get(i).getCantidad() > 0) {
                        modelos.get(i).setCantidad(modelos.get(i).getCantidad() + nuevoStock);
                        System.out.println("Se incorporaron al stock existente " + nuevoStock + " unidades del modelo " + modelos.get(i).getDenominacion());
                        break;
                    } else {
                        modelos.get(i).setCantidad(nuevoStock);
                        System.out.println("Se incorporaron " + nuevoStock + " unidades del modelo " + modelos.get(i).getDenominacion());
                        break;
                    }
                }
            }
            datos.modificarDatoEnArchivo(ARCHIVO_MODELOS, modelos);
            datos.stockModelo(ARCHIVO_MODELOS, denominacionModelo);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al solicitar reposicion!");
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
