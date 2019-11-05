package mate.academy.boot.hellobootdemo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDto {
    @NotEmpty
    @NotNull
    private String title;
    @NotEmpty
    @NotNull
    private Double price;
    @NotEmpty
    @NotNull
    private Integer year;
}
