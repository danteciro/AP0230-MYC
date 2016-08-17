/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.ui.PersonalFilter;
import gob.osinergmin.myc.domain.dto.PersonalDTO;

import java.util.List;

/**
 *
 * @author jpiro
 */
public interface PersonalServiceNeg {
    public List<PersonalDTO> findPersonal(PersonalFilter filtro);
}
