/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.utility.myoccontainer.resolvestrategies;

import com.acidmanic.utility.myoccontainer.DependancyDictionary;
import com.acidmanic.utility.myoccontainer.Resolver;
import com.acidmanic.utility.myoccontainer.TaggedClass;
import com.acidmanic.utility.myoccontainer.resolvearguments.ResolveArguments;

/**
 *
 * @author diego
 */
public class DefaultOnlyResolveStrategy extends ResolveStrategyBase{

    public DefaultOnlyResolveStrategy(DependancyDictionary dependancyDictionary) {
        super(dependancyDictionary);
    }

    
    
    
    @Override
    public ResolveArguments search(Class resolving, String tagIfAny) {
        try {
            return dependancyDictionary.get(new TaggedClass(Resolver.DEFAULT_TAG,
                    resolving));
        } catch (Exception e) {
        }
        return null;
    }
    
}
