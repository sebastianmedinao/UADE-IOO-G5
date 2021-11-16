package com.UADE.controller;

import com.UADE.dao.PracticaDAO;
import com.UADE.dao.ResultadoPracticaDAO;
import com.UADE.model.Practica;
import com.UADE.model.ResultadoPractica;

import java.util.List;

public class ResultadoPracticaController {
    private List<ResultadoPractica> resultadoPracticas;
    private final ResultadoPracticaDAO DAO;

    public ResultadoPracticaController() throws Exception {
        DAO = new ResultadoPracticaDAO(ResultadoPractica.class, "dao/ResultadoPractica.dao");
        resultadoPracticas = DAO.getAll();
    }


}