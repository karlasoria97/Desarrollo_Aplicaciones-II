/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.dao;

import java.util.List;
import practica.model.Excursion;

/**
 *
 * @author Karla
 */
public interface ExcursionDAO {
    void agregarExcursion(Excursion excursion);
    void borrarExcursion(int idExcursion);
    void cambiarExcursion(Excursion excursion);
    List<Excursion> desplegarExcursion();
    Excursion elegirExcursion(int idExcursion);
    
    
}