package io.skerpa.plugin.compounds.analysis;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.compound.DictionaryCompoundWordTokenFilter;
import org.apache.lucene.analysis.util.CharArraySet;

public class ExhaustiveDictCompoundWordTokenFilter extends DictionaryCompoundWordTokenFilter {

	public ExhaustiveDictCompoundWordTokenFilter(TokenStream input,
			CharArraySet dictionary) {
		super(input, dictionary);
	}
	
	public ExhaustiveDictCompoundWordTokenFilter(TokenStream input, CharArraySet dictionary,
            int minWordSize, int minSubwordSize, int maxSubwordSize, boolean onlyLongestMatch) {
			super(input, dictionary, minWordSize, minSubwordSize, maxSubwordSize, onlyLongestMatch);

	}
	
	@Override
	  protected void decompose() {
	    final int len = termAtt.length();
	    for (int i=0;i<=len-this.minSubwordSize;++i) {
	        CompoundToken longestMatchToken=null;
	        for (int j=this.minSubwordSize;j<=this.maxSubwordSize;++j) {
	            if(i+j>len) {
	                break;
	            }
	            if(dictionary.contains(termAtt.buffer(), i, j)) {
	                if (this.onlyLongestMatch) {
	                   if (longestMatchToken!=null) {
	                     if (longestMatchToken.txt.length()<j) {
	                       longestMatchToken=new CompoundToken(i,j);
	                     }
	                   } else {
	                     longestMatchToken=new CompoundToken(i,j);
	                   }
	                } else {
	                   tokens.add(new CompoundToken(i,j));
	                }
	            } 
	        }
	        if (this.onlyLongestMatch && longestMatchToken!=null) {
	          tokens.add(longestMatchToken);
	        }
	    }
	  }

}
