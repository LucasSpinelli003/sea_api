package br.com.fiap.seatech.dto.fishing;

import br.com.fiap.seatech.domain.Fishing;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Clob;
import java.time.LocalDate;

public record FishingDetailDto(Long id, LocalDate date, String climateConditions, String localization, String fishing, String fishingMethod, String details) {

    public FishingDetailDto(Fishing fishing){
        this(fishing.getId(), fishing.getDate(),fishing.getClimateConditions(), fishing.getLocalization(),  fishing.getFishing(),  fishing.getFishingMethod(), fishing.getDetails());
    }
}
