package com.elias.usuarios_api.model;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Entidade de usuário do sistema")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do usuário", example = "1")
    private Long id;

    @Schema(description = "Nome do usuário", example = "Elias")
    private String nome;

    @Schema(description = "Email do usuário", example = "elias@email.com")
    private String email;
}
