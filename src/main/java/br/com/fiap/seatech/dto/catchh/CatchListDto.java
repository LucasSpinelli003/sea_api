package br.com.fiap.seatech.dto.catchh;

import br.com.fiap.seatech.domain.Catch;

public record CatchListDto(Long id, Integer quantity, Double weight, String picture) {

    public CatchListDto(Catch catchh){
        this(catchh.getId(), catchh.getQuantity(), catchh.getWeight(), catchh.getPicture());
    }

}
