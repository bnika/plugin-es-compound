package io.skerpa.plugin.compounds.plugin;


import  org.elasticsearch.index.analysis.AnalysisModule;
import  org.elasticsearch.plugins.AbstractPlugin;

import io.skerpa.plugin.compounds.analysis.ExhaustiveDictCompoundWordTokenFilter;
import io.skerpa.plugin.compounds.analysis.ExhaustiveDictCompoundWordTokenFilterFactory;

import  java.io.IOException;

public class ExhaustiveDictCompoundWordTokenFilterPlugin extends AbstractPlugin {
	

	@Override public String name() {
        return "exhaustive-decompound";
    }

    @Override public String description() {
        return "A dictionary compound token filter for german and other languages";
    }

    public void onModule(AnalysisModule module) {
        module.addTokenFilter("exhaustive-decompound", ExhaustiveDictCompoundWordTokenFilterFactory.class);
    }
	

}
