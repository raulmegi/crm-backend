package org.ediae.tfm.crmapi.constant;

public class GeneralConstants {
    private GeneralConstants() {}

    // Tipos de respuesta
    public static final String OK = "OK";
    public static final String ERROR = "ERROR";
    public static final String FORBIDDEN = "FORBIDDEN";
    public static final String EXCEPTION = "exception";
    public static final String TYPE = "type";
    public static final String DATA = "data";

    // Códigos genéricos
    public static final int GENERAL_ERROR_CODE = 1;
    public static final int BD_ERROR_CODE = 2;

    // Códigos y mensajes específicos para tareas
    public static final int TASK_NOT_FOUND_CODE = 100;
    public static final int TASK_CREATION_ERROR_CODE = 101;
    public static final int TASK_UPDATE_ERROR_CODE = 102;
    public static final int TASK_DELETE_ERROR_CODE = 103;
    public static final int TASK_STATUS_INVALID_CODE = 104;

    public static final String TASK_NOT_FOUND_MESSAGE = "La tarea no ha sido encontrada";
    public static final String TASK_CREATION_ERROR_MESSAGE = "No se pudo crear la tarea";
    public static final String TASK_UPDATE_ERROR_MESSAGE = "No se pudo actualizar la tarea";
    public static final String TASK_DELETE_ERROR_MESSAGE = "No se pudo eliminar la tarea";
    public static final String TASK_STATUS_INVALID_MESSAGE = "El estado de la tarea no es válido";

    // Otros posibles
    public static final int USER_NOT_FOUND_CODE = 200;
    public static final String USER_NOT_FOUND_MESSAGE = "El usuario no ha sido encontrado";

    public static final int CUSTOMER_NOT_FOUND_CODE = 300;
    public static final String CUSTOMER_NOT_FOUND_MESSAGE = "El cliente no ha sido encontrado";

    public static final String GENERAL_ERROR_MESSAGE = "Error inesperado en el servidor";
    public static final String BD_ERROR_MESSAGE = "Error de conexión a base de datos";
}
