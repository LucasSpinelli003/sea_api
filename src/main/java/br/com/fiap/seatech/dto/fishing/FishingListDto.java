package br.com.fiap.seatech.dto.fishing;

import br.com.fiap.seatech.domain.Catch;
import br.com.fiap.seatech.domain.Fishing;
import br.com.fiap.seatech.dto.catchh.CatchDetailDto;

import java.time.LocalDate;
import java.util.List;

public record FishingListDto(Long id, LocalDate date, String localization, String climateConditions, String fishing, String fishingMethod, String details, List<CatchDetailDto> catchs) {

    public FishingListDto(Fishing fishing){
        this(fishing.getId(), fishing.getDate(), fishing.getLocalization(), fishing.getClimateConditions(), fishing.getFishing(), fishing.getFishingMethod(), fishing.getDetails(), fishing.getCatchs().stream().map(CatchDetailDto::new).toList());
    }
}
