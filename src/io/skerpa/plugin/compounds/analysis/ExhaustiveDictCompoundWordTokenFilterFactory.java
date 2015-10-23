package io.skerpa.plugin.compounds.analysis;

import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.assistedinject.Assisted;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.analysis.AnalysisSettingsRequired;
import org.elasticsearch.index.analysis.compound.AbstractCompoundWordTokenFilterFactory;
import org.elasticsearch.index.settings.IndexSettings;



	@AnalysisSettingsRequired
	public class ExhaustiveDictCompoundWordTokenFilterFactory extends AbstractCompoundWordTokenFilterFactory {

	    @Inject
	    public ExhaustiveDictCompoundWordTokenFilterFactory(Index index, @IndexSettings Settings indexSettings, Environment env, @Assisted String name, @Assisted Settings settings) {
	        super(index, indexSettings, env, name, settings);
	    }

	    @Override
	    public TokenStream create(TokenStream tokenStream) {
	        
	            return new ExhaustiveDictCompoundWordTokenFilter(tokenStream, wordList, minWordSize, 
	                                                         minSubwordSize, maxSubwordSize, onlyLongestMatch);
	    }

}
