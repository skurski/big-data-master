package com.skurski.bdm.web.rest;


import com.skurski.bdm.common.BdmLinks;
import com.skurski.bdm.service.DataIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping(BdmLinks.Rest.ROOT)
public class DataIndexWebService {

    @Autowired
    private DataIndexService dataIndexService;

    @RequestMapping(BdmLinks.Rest.FULL_IMPORT)
    public String doFullImport(Model model) {
        try {
            dataIndexService.importFullDb();
        } catch (IOException e) {
//            log.trace("info...");
            e.printStackTrace();
        }

        return "Full index started...";
    }
}
