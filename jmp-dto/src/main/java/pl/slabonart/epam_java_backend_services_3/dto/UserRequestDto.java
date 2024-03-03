package pl.slabonart.epam_java_backend_services_3.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "User request")
public class UserRequestDto {

    @ApiModelProperty(value = "User name", example = "Darth")
    private String name;

    @ApiModelProperty(value = "User surname", example = "Vader")
    private String surname;

    @ApiModelProperty(value = "User birthday", example = "2001-12-24")
    private LocalDate birthday;

}
