package pl.slabonart.epam_java_backend_services_3.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@ApiModel(value = "User response")
public class UserResponseDto {

    @ApiModelProperty(notes = "User identifier", example = "1")
    private Long id;

    @ApiModelProperty(notes = "User name", example = "Anakin")
    private String name;

    @ApiModelProperty(notes = "User surname", example = "Skywalker")
    private String surname;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @ApiModelProperty(notes = "User birthday", example = "24-12-2001")
    private LocalDate birthday;

}
