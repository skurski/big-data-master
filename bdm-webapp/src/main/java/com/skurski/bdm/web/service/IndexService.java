package com.skurski.bdm.web.service;


import com.skurski.bdm.domain.SearchForm;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.FacetParams;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Service for SOLR search engine.
 */
@Service
public class IndexService {

    private SolrClient solr = null;

    private QueryResponse queryResponse = null;

    private SolrDocumentList solrDocuments = null;

    private List<FacetField> facets = null;

    private final static String SOLR_URL = "http://localhost:8080/solr/core0";

    public IndexService() throws SolrServerException, InterruptedException, IOException {
        initSolr();
    }

    private void initSolr() throws IOException, SolrServerException,
            InterruptedException {

        solr = new HttpSolrClient.Builder(SOLR_URL).build();
    }

    public void importFullDb() throws IOException {
        ModifiableSolrParams params = new ModifiableSolrParams();

        params.set("qt", "/dataimport");
        params.set("command", "full-import");
        params.set("clean", "true");

        try {
            solr.query(params);
        } catch (SolrServerException sse) {
            sse.printStackTrace();
        }
    }

    public void querySolr(SearchForm searchForm) throws SolrServerException, IOException {
        SolrQuery query = new SolrQuery();
        if (searchForm.getKeywords().isEmpty()) {
            query.setQuery("*:*");
        } else {
            query.setQuery(searchForm.getKeywords());
        }
        query.setSort("id", SolrQuery.ORDER.asc);

        turnOnFacet(query);
        translateResponse(query);
    }

    private void turnOnFacet(SolrQuery query) {
        query.setParam(FacetParams.FACET, "on");
        query.setParam(FacetParams.FACET_FIELD, "supplier_name");
    }

    private void translateResponse(SolrQuery query) throws IOException, SolrServerException {
        queryResponse = solr.query(query);
        facets = queryResponse.getFacetFields();
        solrDocuments = queryResponse.getResults();
    }

    public SolrDocumentList getSolrDocuments() {
        return solrDocuments;
    }

    public List<FacetField.Count> getFacets() {
        return facets.get(0).getValues();
    }
}
