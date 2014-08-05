package org.precondition.service.impl;

import com.google.common.collect.Maps;
import org.precondition.dao.UcenterRuleDao;
import org.precondition.model.UcenterPreconditionType;
import org.drools.KnowledgeBase;
import org.drools.runtime.StatelessKnowledgeSession;

import java.util.Map;

/**
 * .
 * User: jiawei.gao
 * Date: 14-8-5
 * qunar.com
 */
public abstract class UcenterAbstractDroolsImpl {
    private Map<UcenterPreconditionType,KnowledgeBase> ucenterPreconditionRoles = Maps.newConcurrentMap();

    private UcenterRuleDao ucenterRuleDao;

    public StatelessKnowledgeSession getSessionByUcenterPreconditionType(UcenterPreconditionType type){
        KnowledgeBase knowledgeBase = ucenterPreconditionRoles.get(type);
        if (knowledgeBase==null){
            throw new NullPointerException("不支持此类型");
        }
        return knowledgeBase.newStatelessKnowledgeSession();
    }

    public void initUcenterPreconditionRole(UcenterPreconditionType type){
        ucenterPreconditionRoles.put(type,ucenterRuleDao.getUcenterPreconditionRuleByType(type));
    }

    public void initUcenterPreconditionRole(){
        ucenterPreconditionRoles.putAll(ucenterRuleDao.getAllUcenterPreconditionRule());
    }
}
