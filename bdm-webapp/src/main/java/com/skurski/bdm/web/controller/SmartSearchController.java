package com.skurski.bdm.web.controller;


import com.skurski.bdm.common.BdmLinks;
import com.skurski.bdm.domain.SearchForm;
import com.skurski.bdm.service.DataIndexService;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.common.SolrDocumentList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class SmartSearchController {

    private static final Logger LOG = LoggerFactory.getLogger(SmartSearchController.class);

    @Autowired
    private DataIndexService dataIndexService;

    @RequestMapping(BdmLinks.Search.ROOT)
    public String searchEngine(Model model) {
        model.addAttribute("message", "Database imported to SOLR indexes.");
        model.addAttribute("searchForm", new SearchForm());

        LOG.debug("search engine method executed.");

        return "search-form";
    }

    @RequestMapping(value=BdmLinks.Search.RESULT, method= RequestMethod.POST)
    public String search(@ModelAttribute SearchForm searchForm, Model model) {
        try {
            dataIndexService.querySolr(searchForm);

            SolrDocumentList result = dataIndexService.getSolrDocuments();
            model.addAttribute("result", result);

            List<FacetField.Count> facets = dataIndexService.getFacets();
            model.addAttribute("facets", facets);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "result";
    }

}
