package com.skurski.bdm.upload.service.process;

import com.skurski.bdm.upload.model.Report;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CsvProcessor implements ItemProcessor<Report, Report> {

    @Override
    public Report process(Report item) throws Exception {
        // simple hack :)
        item.setClicks("100");

        return item;
    }
}
