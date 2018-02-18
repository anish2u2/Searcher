package org.searcher.filter;

import java.util.logging.Logger;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;

import org.apache.solr.core.SolrCore;
import org.apache.solr.servlet.SolrDispatchFilter;

public class SearcherRequestFilter extends SolrDispatchFilter {
	
	Logger logger = Logger.getLogger(SearcherRequestFilter.class.getName());

	@Override
	public void init(FilterConfig config) throws ServletException {
		logger.info("Initializing Solr Searcher.");
		System.setProperty("solr.solr.home", "/solr");
		System.setProperty("solr.log.dir", "/solr/log/");
		super.init(config);
		for (SolrCore core : super.getCores().getCores()) {
			logger.info("Solr core:" + core.getName());
		}
		logger.info("initialization done.");
	}	

}
