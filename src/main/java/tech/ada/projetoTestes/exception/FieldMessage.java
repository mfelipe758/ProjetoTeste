package tech.ada.projetoTestes.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldMessage {

    private String name;
    private String message;
}
