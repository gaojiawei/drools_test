package org.precondition.service.impl;

import org.drools.KnowledgeBase;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.StatelessKnowledgeSession;
import org.precondition.model.Result;
import org.precondition.model.UcenterPreconditionObject;
import org.precondition.model.wrapper.UcenterPreconditionObjectWrapper;
import org.precondition.service.PreconditionService;

/**
 * .
 * User: jiawei.gao
 * Date: 14-8-10
 * qunar.com
 */
public class UcenterPreconditionServiceImpl extends UcenterAbstractDroolsImpl implements PreconditionService {
    @Override public Result preProcess(UcenterPreconditionObject riskObject) {
        StatelessKnowledgeSession session = this
                .getSessionByUcenterPreconditionType(riskObject.getEvent());
        UcenterPreconditionObjectWrapper wrapper = new UcenterPreconditionObjectWrapper(riskObject);
        session.execute(wrapper);
        return wrapper.getResult()==null? new Result(0) : wrapper.getResult();
    }

    @Override public void postProcess(UcenterPreconditionObject riskObject) {
        KnowledgeBase knowledgeBase = getUcenterPreconditionRoles().get(riskObject.getEvent());
        StatefulKnowledgeSession session = knowledgeBase.newStatefulKnowledgeSession();
        session.setGlobal("limit", getLimiter());
        session.insert(riskObject);
    }

}
