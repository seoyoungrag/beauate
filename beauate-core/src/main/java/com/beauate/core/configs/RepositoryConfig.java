package com.beauate.core.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.beauate.core.entity.Atchfl;
import com.beauate.core.entity.AtchflDtl;
import com.beauate.core.entity.AthrMng;
import com.beauate.core.entity.BeutyUser;
import com.beauate.core.entity.CnntLog;
import com.beauate.core.entity.MenuMng;
import com.beauate.core.entity.MenuStat;
import com.beauate.core.entity.PrgrMng;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    	config.exposeIdsFor(Atchfl.class);
    	config.exposeIdsFor(AtchflDtl.class);
    	config.exposeIdsFor(AthrMng.class);
    	config.exposeIdsFor(BeutyUser.class);
    	config.exposeIdsFor(CnntLog.class);
    	config.exposeIdsFor(MenuMng.class);
    	config.exposeIdsFor(MenuStat.class);
    	config.exposeIdsFor(PrgrMng.class);
    }
    
}
