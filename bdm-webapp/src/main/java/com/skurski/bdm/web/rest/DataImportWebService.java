package com.skurski.bdm.web.rest;


import com.skurski.bdm.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping("/rest/services")
public class DataImportWebService {

    @Autowired
    private IndexService indexService;

    @RequestMapping("/index/full")
    public String doFullImport(Model model) {
        try {
            indexService.importFullDb();
        } catch (IOException e) {
//            log.trace("info...");
            e.printStackTrace();
        }

        return "Full index started...";
    }
}
