package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

public class OdontologoDaoH2 implements iDao<Odontologo> {
    private Integer id;
    private Integer numeroMatricula;
    private String nombre;
    private String apellido;
    private static final Logger logger= Logger.getLogger(OdontologoDAOH2.class);
    private static final String SQL_INSERT="INSERT INTO ODONTOLOGO (NUMEROMATRICULA, NOMBRE, APELLIDO) VALUES(?,?,?)";

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("inicando la operacion de guardado");
        Connection connection=null;
        try{
            connection= BD.getConnection();
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setInt(1,odontologo.getNumeroMatricula());
            psInsert.setString(2, odontologo.getNombre());
            psInsert.setString(3, odontologo.getApellido());
            psInsert.execute(); //CUANDO SE EJECUTE SE VAN A GENERAR ID
            ResultSet rs= psInsert.getGeneratedKeys();
            while (rs.next()){
                odontologo.setId(rs.getInt(1));
            }


        }catch (Exception e){
            logger.warn(e.getMessage());
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        return List.of();
    }


}