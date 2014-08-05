package org.precondition.service.impl;

import com.google.common.collect.Maps;
import org.precondition.dao.UcenterRuleDao;
import org.precondition.limit.Limiter;
import org.precondition.model.UcenterPreconditionEvent;
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
    private Map<UcenterPreconditionEvent,KnowledgeBase> ucenterPreconditionRoles = Maps.newConcurrentMap();

    private UcenterRuleDao ucenterRuleDao;

    private Limiter limiter;

    public StatelessKnowledgeSession getSessionByUcenterPreconditionType(UcenterPreconditionEvent type){
        KnowledgeBase knowledgeBase = ucenterPreconditionRoles.get(type);
        if (knowledgeBase==null){
            throw new NullPointerException("不支持此类型");
        }
        StatelessKnowledgeSession session = knowledgeBase.newStatelessKnowledgeSession();
        initSession(session);
        return session;
    }

    public Map<UcenterPreconditionEvent, KnowledgeBase> getUcenterPreconditionRoles() {
        return ucenterPreconditionRoles;
    }

    private void initSession(StatelessKnowledgeSession session) {
        session.setGlobal("limit",limiter);
    }


    public void initUcenterPreconditionRole(UcenterPreconditionEvent type){
        ucenterPreconditionRoles.put(type,ucenterRuleDao.getUcenterPreconditionRuleByType(type));
    }

    public void initUcenterPreconditionRole(){
        ucenterPreconditionRoles.putAll(ucenterRuleDao.getAllUcenterPreconditionRule());
    }

    public void setUcenterRuleDao(UcenterRuleDao ucenterRuleDao) {
        this.ucenterRuleDao = ucenterRuleDao;
    }

    public void setLimiter(Limiter limiter) {
        this.limiter = limiter;
    }

    public UcenterRuleDao getUcenterRuleDao() {
        return ucenterRuleDao;
    }

    public Limiter getLimiter() {
        return limiter;
    }
}
