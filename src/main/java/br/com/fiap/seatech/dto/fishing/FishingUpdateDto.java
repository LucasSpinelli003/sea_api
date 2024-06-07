package br.com.fiap.seatech.dto.fishing;

import br.com.fiap.seatech.dto.catchh.CatchDetailDto;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

public record FishingUpdateDto(
        LocalDate date,
        @Size(max = 300, min = 5, message = "max size 300 is and min 5")
        String localization,
        String climateConditions,
        @Size(max = 50, min = 5, message = "max size is 50 and min 5")
        String fishing,
        @Size(max = 100, min = 3, message = "max size 100 is and min 5")
        String fishingMethod,
        String details
) {
}
