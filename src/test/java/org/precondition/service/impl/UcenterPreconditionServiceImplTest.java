package org.precondition.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.junit.Before;
import org.junit.Test;
import org.precondition.dao.UcenterRuleDao;
import org.precondition.limit.impl.CommonLimit;
import org.precondition.model.UcenterPreconditionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class UcenterPreconditionServiceImplTest {
    private UcenterPreconditionServiceImpl preconditionService;


    @Before
    private void init(){
        if(preconditionService==null){
            preconditionService = new UcenterPreconditionServiceImpl();
            preconditionService.setLimiter(new CommonLimit());
            preconditionService.setUcenterRuleDao(new UcenterRuleDao() {
                Logger logger = LoggerFactory.getLogger(this.getClass());
                @Override public KnowledgeBase getUcenterPreconditionRuleByType(UcenterPreconditionEvent type) {
                    return null;  //TODO
                }

                @Override public Map<UcenterPreconditionEvent, KnowledgeBase> getAllUcenterPreconditionRule() {
                    KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
                    List<String> allRules = Lists
                            .newArrayList("ucenter_same_ip_ten_minute.drl", "ucenter_same_ip_one_hour.drl",
                                    "ucenter_same_ip_twenty_four_hour.drl", "ucenter_c_ip_hour.drl",
                                    "ucenter_b_ip_hour.drl",
                                    "ucenter_all_ip_hour.drl");
                    for (String allRule : allRules) {
                        knowledgeBuilder.add(ResourceFactory.newClassPathResource(allRule), ResourceType.DRL);
                    }
                    if(knowledgeBuilder.hasErrors()){
                        KnowledgeBuilderErrors errors = knowledgeBuilder.getErrors();
                        logger.error("hasError {}",errors);
                        throw  new RuntimeException();
                    }
                    KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
                    knowledgeBase.addKnowledgePackages(knowledgeBuilder.getKnowledgePackages());
                    Map<UcenterPreconditionEvent, KnowledgeBase> rules = Maps.newConcurrentMap();
                    rules.put(UcenterPreconditionEvent.SHOW_CAPTCHA, knowledgeBase);
                    return rules;
                }
            });
        }

    }

    @Test
    public void testPreProcess() throws Exception {

    }

    @Test
    public void testPostProcess() throws Exception {

    }
}