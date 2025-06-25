package org.ediae.tfm.crmapi.constant;

public class GeneralConstant {

    private GeneralConstant() {
    }

    public static final String ERROR = "ERROR";
    public static final String FORBIDDEN = "FORBIDDEN";
    public static final String OK = "OK";
    public static final String EXCEPTION = "exception";
    public static final String TYPE = "type";
    public static final String DATA = "data";

    public static final int GENERAL_ERROR_CODE = 1;
    public static final int DB_ERROR_CODE = 2;

    public static final int NO_VALID_USER_ERROR_CODE = 3;

    public static final int USER_EXIST_ERROR_CODE = 5;

    public static final int NO_VALID_USER_ID_ERROR_CODE = 6;

    public static final int NO_FOUND_ERROR_CODE = 404;

    public static final String GENERAL_ERROR_MESSAGE = "Error inesperado en el servidor";

    public static final String BD_ERROR_MESSAGE = "Error de Conexion a base de datos";

    public static final String NO_VALID_USER_ERROR_MESSAGE = "El usuario y/o contraseña no son validos";

    public static final String NO_FOUND_ERROR_MESSAGE = "El usuario no ha sido encontrado";

    public static final String USER_EXIST_ERROR_MESSAGE = "Ya existe un usuario con ese nickname";

    public static final String NO_VALID_USER_ID_ERROR_MESSAGE = "La id del usuario no puede ser null";

}