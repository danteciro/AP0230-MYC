/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao;

import gob.osinergmin.myc.domain.ui.PersonalFilter;
import gob.osinergmin.myc.service.exception.PersonalException;
import gob.osinergmin.myc.domain.dto.PersonalDTO;

import java.util.List;

/**
 *
 * @author jpiro
 */
public interface PersonalDAO {
    public List<PersonalDTO> find(PersonalFilter filtro) throws PersonalException;    
}
