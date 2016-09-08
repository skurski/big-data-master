package com.skurski.bdm.web.controller;


import com.skurski.bdm.domain.SearchForm;
import com.skurski.bdm.web.service.IndexService;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.List;

/**
 * Solr index controller.
 *
 * Responsible for invoking data importing from database to Solr indexes
 * and for searching through service indexes to retrieve information.
 */
@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping("/import-db")
    public String importDb(Model model) {
        model.addAttribute("message", "Database imported to SOLR indexes.");
        model.addAttribute("searchForm", new SearchForm());

        try {
            indexService.importFullDb();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "search-form";
    }

    @RequestMapping(value="/search", method= RequestMethod.POST)
    public String search(@ModelAttribute SearchForm searchForm, Model model) {
        try {
            indexService.querySolr(searchForm);

            SolrDocumentList result = indexService.getSolrDocuments();
            model.addAttribute("result", result);

            List<FacetField.Count> facets = indexService.getFacets();
            model.addAttribute("facets", facets);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "result";
    }

}
