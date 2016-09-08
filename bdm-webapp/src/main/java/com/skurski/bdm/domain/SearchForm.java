package com.skurski.bdm.domain;

/**
 * Data from search form.
 *
 * Used in Solr search engine.
 */
public class SearchForm {

    private String keywords;

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "SearchForm{" +
                "keywords='" + keywords + '\'' +
                '}';
    }
}
