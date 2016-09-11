package com.skurski.bdm.common;


/**
 * Links for web application.
 */
public interface BdmLinks {

    interface Rest {
        String ROOT = "/services/rest";
        String FULL_IMPORT = "/index/full";
    }

    interface Search {
        String ROOT = "/search";
        String RESULT = ROOT + "/result";
    }
}
