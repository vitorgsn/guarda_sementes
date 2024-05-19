package br.com.ifs.edu.guarda_sementes.dtos.guardian;

import br.com.ifs.edu.guarda_sementes.dtos.user.ResponseUserDTO;
import br.com.ifs.edu.guarda_sementes.models.GuardianModel;
import lombok.Data;

@Data
public class ResponseGuardianDTO {

    private int id;
    private ResponseUserDTO user;

    public ResponseGuardianDTO(GuardianModel guardianModel) {
        this.id = guardianModel.getId();
        this.user = new ResponseUserDTO(guardianModel.getUser());
    }

}
