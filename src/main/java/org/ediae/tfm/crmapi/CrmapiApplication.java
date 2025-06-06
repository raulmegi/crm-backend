package org.ediae.tfm.crmapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "API de Gestion Comercial",
                version = "1.0",
                description = "Operaciones"
        )
)
@SpringBootApplication
public class CrmapiApplication {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}