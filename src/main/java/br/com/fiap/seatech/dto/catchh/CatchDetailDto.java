package br.com.fiap.seatech.dto.catchh;

import br.com.fiap.seatech.domain.Catch;

public record CatchDetailDto(Long id, Integer quantity, Double weight, String picture) {

    public CatchDetailDto(Catch catche){
        this(catche.getId(), catche.getQuantity(), catche.getWeight(), catche.getPicture());
    }

}
